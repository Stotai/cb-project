package com.qianya.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianya.common.JsonResultT;
import com.qianya.entity.CricleDetail;
import com.qianya.entity.CricleDetailCriteria;
import com.qianya.entity.CricleFriends;
import com.qianya.entity.PullGroup;
import com.qianya.mapper.CricleDetailMapper;
import com.qianya.mapper.CricleFriendsMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.CricleFriendsDetailDtoIn;
import com.qianya.model.in.CricleFriendsDtoIn;
import com.qianya.model.out.CircleFriendsDtoOut;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.util.GrainBeanUtils;
import com.qianya.util.StringUtil;
import com.qianya.web.mapper.CricleFriendsExMapper;
import com.qianya.web.service.CricleFriendsService;
import com.qianya.web.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-16  16:44
 * @Description: TODO
 */
@Service
public class CricleFriendsServiceImpl implements CricleFriendsService {


    @Autowired
    private LoginService loginService;
    @Autowired
    private CricleFriendsMapper cricleFriendsMapper;
    @Autowired
    private CricleFriendsExMapper cricleFriendsExMapper;
    @Autowired
    private CricleDetailMapper cricleDetailMapper;

    @Override
    public JsonResultT<?> addCricle(CricleFriendsDtoIn cricleFriendsDtoIn) {
        //获取登录对象
        IUserDo iUserDo = loginService.selectUser();

        List<String> exriseWxIds = new ArrayList<>();

        if (StringUtil.isEmpty(cricleFriendsDtoIn.getExriseWxIds())) {
            exriseWxIds.add(iUserDo.getExriseWxId());
        } else {
            exriseWxIds.addAll(Arrays.stream(cricleFriendsDtoIn.getExriseWxIds().split(",")).collect(Collectors.toList()));
        }
        String nowTime = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        for (String wxId : exriseWxIds) {
            CricleFriends cricleFriends = GrainBeanUtils.convert(cricleFriendsDtoIn, CricleFriends.class);
            cricleFriends.setUserId(iUserDo.getUserId());
            if(cricleFriendsDtoIn.getSendType()==1){
                cricleFriends.setSendNum(1);
            }
            cricleFriends.setExriseWxIds(wxId);
            cricleFriends.setStatus(0);
            cricleFriends.setExecuteTimes(0);
            cricleFriends.setCreateTime(nowTime);
            StringBuilder sb = new StringBuilder();
            for (CricleFriendsDetailDtoIn x : cricleFriendsDtoIn.getDetailDtoInList()) {
                if (x.getItemType() == 1) {
                    sb.append(x.getItemContent()).append(",");
                } else if (x.getItemType() == 2) {
                    sb.append("图片").append(",");
                } else if (x.getItemType() == 3) {
                    sb.append("视频").append(",");
                } else {
                    sb.append("卡片").append(",");
                }
            }
            String content = sb.toString();
            cricleFriends.setContent(content.substring(0, content.length() - 1));
            cricleFriendsMapper.insertSelective(cricleFriends);
            List<CricleDetail> cricleDetailList = GrainBeanUtils.convertList(cricleFriendsDtoIn.getDetailDtoInList(), CricleDetail.class, x -> {
                x.setCricleId(cricleFriends.getCircleId());

            });
            //获取明细
            cricleFriendsExMapper.batchInsertCricleDetail(cricleDetailList);
        }

       return JsonResultT.ok();
    }

    @Override
    public JsonResultT<CommonPage<SchemeDraftDtoOut>> draftList(String content, Integer pageNum, Integer pageSize) {
        IUserDo iUserDo = loginService.selectUser();
        List<SchemeDraftDtoOut> schemeDraftDtoOutList = cricleFriendsExMapper.getMassDraftDtoOutList(iUserDo.getUserId(), content);
        return JsonResultT.ok(CommonPage.restPage(schemeDraftDtoOutList));
    }

    @Override
    public JsonResultT<?> getDrafDetail(Integer circleId) {

        CricleFriends cricleFriends=cricleFriendsMapper.selectByPrimaryKey(circleId);
        if(cricleFriends==null){
            return JsonResultT.error("模板内容不存在");
        }
        //获取内容
        CricleDetailCriteria cricleDetailCriteria=new CricleDetailCriteria();
        cricleDetailCriteria.createCriteria().andCricleIdEqualTo(circleId);
        List<CricleDetail> cricleDetailList=cricleDetailMapper.selectByExample(cricleDetailCriteria);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("cricleFriends",cricleFriends);
        resultMap.put("cricleDetailList",cricleDetailList);
        return JsonResultT.ok(resultMap);
    }

    @Override
    public JsonResultT<CommonPage<CircleFriendsDtoOut>> searchCircleFriends(String content, String exriseWxIds, Integer pageNum, Integer pageSize) {
        // 解析多选的关联企业微信id
        List<String> epriseWxIdList = null;
        if (StringUtils.isNotEmpty(exriseWxIds)) {
            String[] epriseWxIdArr = exriseWxIds.split(",");
            epriseWxIdList= Arrays.asList(epriseWxIdArr);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<CircleFriendsDtoOut> circleFriendsDtoOutList=cricleFriendsExMapper.searchCircleFriends(content,epriseWxIdList);
        return JsonResultT.ok(CommonPage.restPage(circleFriendsDtoOutList));

    }

    @Override
    public JsonResultT<?> deleteCircle(Integer circleId) {
         cricleFriendsMapper.deleteByPrimaryKey(circleId);
         return JsonResultT.ok();
    }


}
