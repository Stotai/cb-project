package com.qianya.web.service.impl;

import com.qianya.cbEnum.CustomerStatusEnum;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.*;
import com.qianya.mapper.*;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.out.ProductUseRecordDtoOut;
import com.qianya.util.DateUtil;
import com.qianya.util.GrainBeanUtils;
import com.qianya.util.RedisUtils;
import com.qianya.util.StringUtil;
import com.qianya.web.mapper.UserExMapper;
import com.qianya.web.service.LoginService;
import com.qianya.web.service.UserService;
import com.qianya.model.in.ExriseUserDtoIn;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-08  15:35
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ExriseUserMapper exriseUserMapper;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserExMapper userExMapper;
    @Autowired
    private ExGroupMapper exGroupMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ProductUseRecordMapper productUseRecordMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;



    @Override
    public JsonResult getExriseUserByUserId() {

        IUserDo user = loginService.selectUser();
        //查询关联企业客户
        ExriseUserCriteria exriseUserCriteria=new ExriseUserCriteria();
        exriseUserCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andIsDeleteEqualTo(0);
        List<ExriseUser>  exriseUserList=exriseUserMapper.selectByExample(exriseUserCriteria);
        return JsonResult.ok(exriseUserList);
    }

    @Override
    public int deleltUser(Integer userId) {
        IUserDo iUserDo = loginService.selectUser();
        removeUserCache(iUserDo.getUserId());
        return userExMapper.deleteByExriseUserId(userId);
    }

    @Override
    public JsonResult editUser(ExriseUserDtoIn exriseUserDtoIn) {

        String nowTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        IUserDo user = loginService.selectUser();
        //查询是否存在
        ExriseUserCriteria exriseUserCriteria=new ExriseUserCriteria();
        exriseUserCriteria.createCriteria().andExriseWxIdEqualTo(exriseUserDtoIn.getExriseWxId());
        ExriseUser selectExriseUser=exriseUserMapper.selectByExampleForOne(exriseUserCriteria);
        if(selectExriseUser==null){
            if (StringUtil.isEmpty(exriseUserDtoIn.getExriseWxId())) {
                return JsonResult.error("请传入企业微信ID");
            }

            if (StringUtil.isEmpty(exriseUserDtoIn.getCompanyId())) {
                return JsonResult.error("请传入主体ID");
            }

            if (StringUtil.isEmpty(exriseUserDtoIn.getCompanyName())) {
                return JsonResult.error("请传入主体名称");
            }

            if (StringUtil.isEmpty(exriseUserDtoIn.getExriseWxName())) {
                return JsonResult.error("请传入企业微信名称");
            }

            if (StringUtil.isEmpty(exriseUserDtoIn.getExriseWxUrl())) {
                return JsonResult.error("请传入企业微信头像URL");
            }

            if (exriseUserDtoIn.getCustomerNum() == null) {
                return JsonResult.error("请传入好友数量");
            }

            if (exriseUserDtoIn.getGroupNum() == null) {
                return JsonResult.error("请传入群组数量");
            }
            //赠送三天体验期
            ExriseUser exriseUser = GrainBeanUtils.convert(exriseUserDtoIn, ExriseUser.class);
            exriseUser.setIsDelete(0);
            exriseUser.setUserId(user.getUserId());
            exriseUser.setLoginStatus(1);
            exriseUser.setLoginTime(nowTime);
            exriseUser.setAuthorizationTime(LocalDateTime.now().plusDays(3).format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)));
            exriseUserMapper.insertSelective(exriseUser);
            ExriseUserCriteria userCriteria=new ExriseUserCriteria();
            userCriteria.createCriteria().andLoginStatusEqualTo(1).andExriseWxIdNotEqualTo(exriseUser.getExriseWxId()).andUserIdEqualTo(user.getUserId());
            ExriseUser updUser=new ExriseUser();
            updUser.setLoginStatus(0);
            exriseUserMapper.updateByExampleSelective(updUser,userCriteria);
            //清除用户redis 缓存
            removeUserCache(user.getUserId());
            return JsonResult.ok();

        }else {
            ExriseUser newExriseUser = GrainBeanUtils.convert(exriseUserDtoIn, ExriseUser.class);
            newExriseUser.setUserId(user.getUserId());
            newExriseUser.setExriseUserId(selectExriseUser.getExriseUserId());
            newExriseUser.setLoginStatus(1);
            newExriseUser.setLoginTime(nowTime);
            exriseUserMapper.updateByPrimaryKeySelective(newExriseUser);
            ExriseUserCriteria userCriteria=new ExriseUserCriteria();
            userCriteria.createCriteria().andLoginStatusEqualTo(1).andUserIdEqualTo(user.getUserId()).andExriseWxIdNotEqualTo(selectExriseUser.getExriseWxId());
            ExriseUser updUser=new ExriseUser();
            updUser.setLoginStatus(0);
            exriseUserMapper.updateByExampleSelective(updUser,userCriteria);
            //清除用户redis 缓存
            removeUserCache(user.getUserId());

            return JsonResult.ok();
        }
    }

    @Override
    public JsonResult countCust() {
        IUserDo user = loginService.selectUser();
        //统计群数量
        ExGroupCriteria exGroupCriteria=new ExGroupCriteria();
        exGroupCriteria.createCriteria().andExriseUserIdEqualTo(user.getExriseWxId());
        long exCount = exGroupMapper.countByExample(exGroupCriteria);
        //统计好友数量
        CustomerCriteria customerCriteria=new CustomerCriteria();
        customerCriteria.createCriteria().andEpriseWxIdEqualTo(user.getExriseWxId()).andZombieFlagEqualTo(0).andIsDelEqualTo(0).andStatusEqualTo(CustomerStatusEnum.ACCEPTED.getCode());
        long custCount = customerMapper.countByExample(customerCriteria);
        ExriseUser exriseUser=new ExriseUser();
        exriseUser.setGroupNum((int)exCount);
        exriseUser.setCustomerNum((int)custCount);
        ExriseUserCriteria exriseUserCriteria=new ExriseUserCriteria();
        exriseUserCriteria.createCriteria().andExriseWxIdEqualTo(user.getExriseWxId());
        exriseUserMapper.updateByExampleSelective(exriseUser,exriseUserCriteria);
        return JsonResult.ok();
    }

    @Override
    public JsonResultT<?> activationCard(String carMi) {
        //根据卡密查询卡
        ProductUseRecordCriteria productUseRecordCriteria=new ProductUseRecordCriteria();
        productUseRecordCriteria.createCriteria().andCarmiEqualTo(carMi).andStatusEqualTo(0);
        ProductUseRecord productUseRecord = productUseRecordMapper.selectByExampleForOne(productUseRecordCriteria);
        if(productUseRecord==null){
            return JsonResultT.error("卡密信息不存在或已被使用,无法激活");
        }
        IUserDo iUserDo = loginService.selectUser();
        //延长授权视线
        ExriseUser exriseUser=new ExriseUser();
        String authorizationTime=iUserDo.getAuthorizationTime();
        String addTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        //到期时间在当前时间之后 延续时间增加
        if(authorizationTime.compareTo(addTime)>0){
            addTime=authorizationTime;
        }
        //小于时间 从当前时间增加
        exriseUser.setAuthorizationTime(DateUtil.addDaysToTime(addTime,getProductDay(productUseRecord.getProductType())));
        ExriseUserCriteria criteria=new ExriseUserCriteria();
        criteria.createCriteria().andExriseWxIdEqualTo(iUserDo.getExriseWxId());
        exriseUserMapper.updateByExampleSelective(exriseUser,criteria);
        //修改卡密使用记录
        ProductUseRecord updateUserRecord=new ProductUseRecord();
        updateUserRecord.setRecordId(productUseRecord.getRecordId());
        updateUserRecord.setUserId(iUserDo.getUserId());
        updateUserRecord.setPayUserId(iUserDo.getUserId());
        updateUserRecord.setPayUserPhone(iUserDo.getPhone());
        updateUserRecord.setUserPhone(iUserDo.getPhone());
        updateUserRecord.setExriseUserId(iUserDo.getExriseWxId());
        updateUserRecord.setExriseWxName(iUserDo.getExriseWxName());
        updateUserRecord.setUseTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        productUseRecordMapper.updateByPrimaryKeySelective(productUseRecord);
        removeUserCache(exriseUser.getUserId());
        return JsonResultT.ok();
    }

    @Override
    public JsonResultT<?> exriseWxNameRemark(String exriseUserId, String remark) {
            ExriseUserCriteria exriseUserCriteria=new ExriseUserCriteria();
            exriseUserCriteria.createCriteria().andExriseWxIdEqualTo(exriseUserId);
            ExriseUser exriseUser=exriseUserMapper.selectByExampleForOne(exriseUserCriteria);
            if(exriseUser==null){
                return JsonResultT.error("要修改的企业微信不存在");
            }
            ExriseUser updateUser=new ExriseUser();
            updateUser.setExriseUserId(exriseUser.getExriseUserId());
            updateUser.setWxRemark(remark);
            exriseUserMapper.updateByPrimaryKeySelective(updateUser);
            return JsonResultT.ok();
    }

    @Override
    public List<ProductUseRecordDtoOut> searchCardRecords(String keyWord) {
        return userExMapper.searchProductUseRecords(keyWord);
    }

    @Override
    public List<ProductUseRecordDtoOut> searchRecordsByCarmi(String carmis) {
        // 解析多选的关联企业微信id
        List<String> carmiList = null;
        if (StringUtils.isNotEmpty(carmis)) {
            String[] carStringArr = carmis.split(",");
            carmiList = Arrays.asList(carStringArr);
        }
        return userExMapper.searchByCarmi(carmiList);
    }

    @Override
    public JsonResultT<?> transferCard(Integer recordId, String exriseUserId, String remark) {
        // 根据记录ID查询卡密记录
        ProductUseRecord productUseRecord = productUseRecordMapper.selectByPrimaryKey(recordId);
        if (productUseRecord == null) {
            // 卡密记录不存在，抛出异常或进行相应处理
            return JsonResultT.error("卡密记录不存在");
        }
        // 获取卡密商品信息
        Product product=productMapper.selectByPrimaryKey(productUseRecord.getProductId());

        // 判断卡密是否过期
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expirationTime = LocalDateTime.parse(productUseRecord.getUseTime(), DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        expirationTime = expirationTime.plusDays(getProductDay(product.getProductType()));  // 计算卡密过期时间
        if (currentTime.isAfter(expirationTime)) {
            // 卡密已过期，不能进行转移，抛出异常或进行相应处理
            return JsonResultT.error("卡密已过期不能进行转移");
        }
        //获取要转移的微信
        ExriseUserCriteria exriseUserCriteria=new ExriseUserCriteria();
        ExriseUserCriteria.Criteria criteria=exriseUserCriteria.createCriteria();
        criteria.andExriseWxIdEqualTo(exriseUserId);
        if(StringUtil.isNotEmpty(remark)){
            criteria.andWxRemarkEqualTo(remark);
        }
        ExriseUser exriseUser=exriseUserMapper.selectByExampleForOne(exriseUserCriteria);

        ProductUseRecord updateRecord=new ProductUseRecord();
        // 更新卡密记录的使用人信息
        updateRecord.setExriseUserId(exriseUserId);
        updateRecord.setExriseWxName(remark);
        updateRecord.setUserId(exriseUser.getUserId());
        //查询用户信息
        User user=userMapper.selectByPrimaryKey(exriseUser.getUserId());
        if(user==null){
            return JsonResultT.error("用户不存在，转移失败");
        }
        updateRecord.setUserPhone(user.getPhone());

        // 计算剩余天数
        long remainingDays = getProductDay(product.getProductType()) - ChronoUnit.DAYS.between(expirationTime.toLocalDate(), LocalDate.now());

        ExriseUser updateUser = new ExriseUser();
        updateUser.setExriseUserId(exriseUser.getExriseUserId());
        String nowTime = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);

       // 判断授权时间
        String authorizationTime = exriseUser.getAuthorizationTime();
        if (authorizationTime.compareTo(nowTime) <= 0) {
            // 授权时间小于等于当前时间，从当前时间开始计算剩余时间
            LocalDateTime currentPlusRemaining = LocalDateTime.now().plusDays(remainingDays);
            authorizationTime = currentPlusRemaining.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        } else {
            // 授权时间大于当前时间，从授权时间开始计算剩余时间
            LocalDateTime addTime = LocalDateTime.parse(authorizationTime, DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
            LocalDateTime localDateTime = addTime.plusDays(remainingDays);
            authorizationTime = localDateTime.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        }
        updateUser.setAuthorizationTime(authorizationTime);
        exriseUserMapper.updateByPrimaryKeySelective(updateUser);
        // 更新卡密记录
        productUseRecordMapper.updateByPrimaryKeySelective(updateRecord);
        return JsonResultT.ok();
    }


    private Integer getProductDay(Integer productType){
           Integer days=7;
           if(productType==2){
               days=30;
           }else if(productType==3){
               days=90;
           }else {
               days=365;
           }
           return days;
    }




    /**
     *  删除用户redis缓存
     * @author lhl
     * @date 2022-06-14 下午 04:36
     * @param
     */
    public void removeUserCache(Integer userId){
        String userKey="user:"+userId+":*";
        Set<String> keySet = RedisUtils.scanMatch(redisTemplate, userKey);
        if (keySet.size() > 0) {
            redisTemplate.delete(keySet);
        }
    }
}
