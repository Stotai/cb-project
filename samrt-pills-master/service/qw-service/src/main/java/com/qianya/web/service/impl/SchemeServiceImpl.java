package com.qianya.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qianya.common.JsonResultT;
import com.qianya.entity.*;
import com.qianya.mapper.SchemeItemMapper;
import com.qianya.mapper.SchemeMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.util.GrainBeanUtils;
import com.qianya.web.mapper.SchemeExMapper;
import com.qianya.web.service.LoginService;
import com.qianya.web.service.SchemeService;
import com.qianya.model.in.AddSchemeParamDtoIn;
import com.qianya.model.in.SchemeItemDtoIn;
import com.qianya.model.out.SchemeDtoOut;
import com.qianya.model.out.SchemeItemDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-15  19:40
 * @Description: 方案管理
 */
@Service
public class SchemeServiceImpl implements SchemeService {


    @Autowired
    private SchemeMapper schemeMapper;
    @Autowired
    private SchemeExMapper schemeExMapper;
    @Autowired
    private SchemeItemMapper schemeItemMapper;
    @Autowired
    private LoginService loginService;


    @Override
    @Transactional
    public JsonResultT<?> addScheme(AddSchemeParamDtoIn addSchemeParamDtoIn) {
        Integer schemeId = addSchemeParamDtoIn.getSchemeId();
        if (addSchemeParamDtoIn.getOperationType() == 1) {
            //修改先删除
            if (addSchemeParamDtoIn.getSchemeId() == null) {
                return JsonResultT.error("请传入修改方案id");
            }
            Scheme updateScheme = GrainBeanUtils.convert(addSchemeParamDtoIn, Scheme.class);
            schemeMapper.updateByPrimaryKeySelective(updateScheme);
            //删除明细记录
            SchemeItemCriteria schemeItemCriteria = new SchemeItemCriteria();
            schemeItemCriteria.createCriteria().andSchemeIdEqualTo(schemeId);
            schemeItemMapper.deleteByExample(schemeItemCriteria);
        } else {
            //获取登录用户
            IUserDo user = loginService.selectUser();
            Scheme scheme = GrainBeanUtils.convert(addSchemeParamDtoIn, Scheme.class);
            scheme.setUserId(user.getUserId());
            scheme.setIsDelete(0);
            scheme.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
            schemeMapper.insertSelective(scheme);
            schemeId = scheme.getSchemeId();
        }
        List<SchemeItemDtoIn> schemeItemEntityList = addSchemeParamDtoIn.getItemList();
        for (SchemeItemDtoIn schemeItem : schemeItemEntityList) {
            schemeItem.setSchemeId(schemeId);
            schemeItem.setIsDelete(0);
        }
        schemeExMapper.batchInsertSchemeItems(schemeItemEntityList);
        return JsonResultT.ok("保存成功");
    }

    @Override
    @Transactional
    public JsonResultT<?> deleteScheme(Integer schemeId) {
        // 根据方案ID删除明细表中的记录
         schemeExMapper.deleteItemsBySchemeId(schemeId);
        // 删除主表中的方案记录
        int mainRowsAffected = schemeExMapper.deleteSchemeById(schemeId);
        if (mainRowsAffected > 0) {
            return JsonResultT.ok("方案及明细记录删除成功");
        } else {
            return JsonResultT.error("删除方案及明细记录失败");
        }
    }

    @Override
    public JsonResultT<List<SchemeDtoOut>> list() {
        //获取登录用户
        IUserDo user = loginService.selectUser();
        //查询未删除的方案
        SchemeCriteria schemeCriteria = new SchemeCriteria();
        schemeCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andIsDeleteEqualTo(0);
        List<Scheme> schemeList = schemeMapper.selectByExample(schemeCriteria);
        if (CollectionUtils.isEmpty(schemeList)) {
            return JsonResultT.ok(Collections.emptyList());
        }
        //根据方案获取明细
        List<Integer> schemeIds = schemeList.stream().map(Scheme::getSchemeId).collect(Collectors.toList());
        //查询明细
        SchemeItemCriteria schemeItemCriteria = new SchemeItemCriteria();
        schemeItemCriteria.createCriteria().andSchemeIdIn(schemeIds).andIsDeleteEqualTo(0);
        List<SchemeItem> schemeItemList = schemeItemMapper.selectByExample(schemeItemCriteria);
        //根据schemeId分组
        Map<Integer, List<SchemeItem>> itemMap = schemeItemList.stream().collect(Collectors.groupingBy(SchemeItem::getSchemeId));

        List<SchemeDtoOut> schemes = new ArrayList<>();
        for (Scheme scheme : schemeList) {
            SchemeDtoOut schemeDtoOut = new SchemeDtoOut();
            schemeDtoOut.setSchemeId(scheme.getSchemeId());
            schemeDtoOut.setSchemeName(scheme.getSchemeName());
            schemeDtoOut.setSex(scheme.getSex());
            schemeDtoOut.setCheckNickName(scheme.getCheckNickName());
            schemeDtoOut.setCheckVerify(scheme.getCheckVerify());
            schemeDtoOut.setRemarks(scheme.getRemarks());
            schemeDtoOut.setStatus(scheme.getStatus());
            List<SchemeItem> itemList = itemMap.get(scheme.getSchemeId());
            List<SchemeItemDtoOut> dtoOuts = GrainBeanUtils.convertList(itemList, SchemeItemDtoOut.class);
            if(!CollectionUtils.isEmpty(dtoOuts)){
                schemeDtoOut.setItemList(dtoOuts);
            }else {
                schemeDtoOut.setItemList(Collections.emptyList());
            }
            schemes.add(schemeDtoOut);
        }

        return JsonResultT.ok(schemes);
    }

    @Override
    public JsonResultT<CommonPage<SchemeDraftDtoOut>> draftList(String content,Integer pageNum,Integer pageSize) {

        IUserDo iUserDo = loginService.selectUser();
        List<SchemeDraftDtoOut> schemeDraftDtoOutList = schemeExMapper.getSchemeDraftDtoOutList(iUserDo.getUserId(), content);
        return JsonResultT.ok(CommonPage.restPage(schemeDraftDtoOutList));
    }

    @Override
    public JsonResultT<?> updateSchemeStatus(Integer schemeId, Integer status) {
        // 判断开启状态，如果要开启方案，则需要先关闭其他方案
        if (status == 1) {
            // 判断是否存在其他开启的方案
            IUserDo user = loginService.selectUser();
            int count = schemeExMapper.countOpenSchemesExceptCurrent(schemeId, user.getUserId());
            if (count > 0) {
                return JsonResultT.error("只能同时开启一个方案，请先关闭其他方案");
            }
        }
        // 判断要更新的方案是否存在
        Scheme scheme = schemeMapper.selectByPrimaryKey(schemeId);
        if (scheme == null) {
            return JsonResultT.error("方案不存在");
        }
        Scheme updateScheme = new Scheme();
        updateScheme.setSchemeId(schemeId);
        updateScheme.setStatus(status);
        schemeMapper.updateByPrimaryKeySelective(updateScheme);
        return JsonResultT.ok();
    }

    @Override
    public JsonResultT<SchemeDtoOut> getDrafDetail(Integer schemeId) {
         Scheme scheme=schemeMapper.selectByPrimaryKey(schemeId);
         if(scheme==null){
             return JsonResultT.error("模板信息不存在");
         }
         //模板明细
        SchemeItemCriteria schemeItemCriteria=new SchemeItemCriteria();
        schemeItemCriteria.createCriteria().andSchemeIdEqualTo(schemeId);
        List<SchemeItem> schemeList =schemeItemMapper.selectByExample(schemeItemCriteria);
        SchemeDtoOut schemeDtoOut=GrainBeanUtils.convert(scheme,SchemeDtoOut.class);
        schemeDtoOut.setItemList(GrainBeanUtils.convertList(schemeList,SchemeItemDtoOut.class));
        return JsonResultT.ok(schemeDtoOut);
    }


}
