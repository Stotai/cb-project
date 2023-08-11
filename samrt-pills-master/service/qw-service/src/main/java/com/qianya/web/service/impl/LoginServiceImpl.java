package com.qianya.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qianya.common.JWTUtil;
import com.qianya.common.JsonResult;
import com.qianya.constant.MgConstant;
import com.qianya.entity.ExriseUser;
import com.qianya.entity.ExriseUserCriteria;
import com.qianya.entity.SysLogin;
import com.qianya.entity.User;
import com.qianya.entity.mongo.NettyChannelMoEntity;
import com.qianya.exception.CustomException;
import com.qianya.mapper.ExriseUserMapper;
import com.qianya.mapper.SysLoginMapper;
import com.qianya.mapper.UserMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.util.*;
import com.qianya.util.SyslogUtil.SysLoginUtil;
import com.qianya.util.password.PasswordUtil;
import com.qianya.web.mapper.UserExMapper;
import com.qianya.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户服务实现类
 * </p>
 *
 * @author lhl
 * @since 2020-07-02
 */
@Service
public class LoginServiceImpl  implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExMapper userExMapper;
    @Autowired
    private SysLoginMapper sysLoginMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ExriseUserMapper exriseUserMapper;

    /**
     * 注册 用户
     *
     * @author wy
     * @since 2020-07-02
     */
    @Transactional
    @Override
    public JsonResult create(String phone,String password) {
        //验证手机号是否存在
        User user = find(phone);
        if (user!=null){
            return JsonResult.error("该账号已存在");
        }
        //new一个loginUsers对象
        User loginUsers = new User();
        //写入用户加入密码
        loginUsers.setPassword(PasswordUtil.encodePassword(password));
        loginUsers.setPhone(phone);
        loginUsers.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        userMapper.insertSelective(loginUsers);
        //生成token
        String token = JWTUtil.createToken(loginUsers.getPhone(),loginUsers.getUserId(),1);
        SysLogin loginInfo = SysLoginUtil.insertSysLogin(loginUsers, token);
        sysLoginMapper.insertSelective(loginInfo);

        //新增netty用户关联管道数据
        NettyChannelMoEntity channelMoEntity=new NettyChannelMoEntity();
        channelMoEntity.setRecordId(idWorker.nextId());
        channelMoEntity.setUserId(loginUsers.getUserId());
        channelMoEntity.setCreateTime(loginUsers.getCreateTime());
        mongoTemplate.insert(channelMoEntity, MgConstant.NETTY_CHANNEL);
        //返回token
        return JsonResult.ok(new JSONObject().fluentPut("token",token).fluentPut("userId",loginUsers.getUserId()).fluentPut("phone",loginUsers.getPhone()));

    }

    @Override
    @Transactional
    public JsonResult login(String phone, String password) {
        //对修改的密码加密
        String str = PasswordUtil.encodePassword(password);
        //获取用户
        User user = find(phone);
        //如果没有获取到用户，表示用户名或密码错误
        if (user == null) {
            return JsonResult.error("账号不存在");
        }
        if (!user.getPassword().equals(str)){
            return JsonResult.error("密码错误");
        }
        //生成token
        String token = JWTUtil.createToken(user.getPhone(),user.getUserId(),1);
        SysLogin loginInfo = SysLoginUtil.insertSysLogin(user, token);
        sysLoginMapper.insertSelective(loginInfo);
        //返回token
        return JsonResult.ok(new JSONObject().fluentPut("token",token).fluentPut("userId",user.getUserId()).fluentPut("phone",user.getPhone()));
    }


    @Override
    public IUserDo selectUser() {
        BaseCommon baseCommon = new BaseCommon();
        HttpServletRequest request = baseCommon.getRequest();
        String token = request.getHeader("token");
        if (StringUtil.isEmpty(token)){
            throw new CustomException("请登录后操作");
        }
        Integer userId = JWTUtil.getUserId(token);
        //获得用户消息
        IUserDo users = findUserWithId(userId);
        return  users;
    }

    @Override
    public User find(String phone) {
        User users = userExMapper.findUserByName(phone);
        return  users;
    }

    @Override
    public JsonResult updateStatus(Integer userId, Integer statue) {
        //int   b =loginUsersMapper.updateStatus(loginUsersQO);
        return  JsonResult.ok();
    }
    /**
     *  用户id查询
     * @author lhl
     * @date 2022-06-14 下午 04:20
     * @param userId
     */
    public IUserDo findUserWithId(Integer userId){
        String userKey="user:"+userId+":detail";
        IUserDo userDo = (IUserDo)redisTemplate.boundValueOps(userKey).get();
        if(userDo==null){
            //查询优惠券返回
            User user = userMapper.selectByPrimaryKey(userId);
            //查询正在授权企业微信
            ExriseUserCriteria exriseUserCriteria=new ExriseUserCriteria();
            exriseUserCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andLoginStatusEqualTo(1);
            List<ExriseUser> exriseUserList=exriseUserMapper.selectByExample(exriseUserCriteria);
            IUserDo iUserDo=GrainBeanUtils.convert(user,IUserDo.class);
            iUserDo.setUseSystemFlag(0);
            String nowTime=DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
            if(!CollectionUtils.isEmpty(exriseUserList)){
                ExriseUser exriseUser = exriseUserList.get(0);
                iUserDo.setExriseWxId(exriseUser.getExriseWxId());
                iUserDo.setExriseWxName(exriseUser.getExriseWxName());
                iUserDo.setAuthorizationTime(exriseUser.getAuthorizationTime());
                if(iUserDo.getAuthorizationTime().compareTo(nowTime)<=0){
                    iUserDo.setUseSystemFlag(1);
                }
            }else {
                iUserDo.setUseSystemFlag(2);
            }
            redisTemplate.boundValueOps(userKey).set(iUserDo,72, TimeUnit.HOURS);
            return iUserDo;
        }
        userDo.setUseSystemFlag(0);
        if(userDo.getExriseWxId()==null){
            userDo.setUseSystemFlag(2);
            return userDo;
        }else {
            String nowTime=DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
            if(userDo.getAuthorizationTime().compareTo(nowTime)<=0){
                userDo.setUseSystemFlag(1);
            }
            return userDo;
        }
    }

}

