package com.qianya.web.service;

import com.qianya.common.JsonResultT;
import com.qianya.entity.MassSending;
import com.qianya.entity.mongo.MassSendingMainMoEntity;
import com.qianya.model.in.MassSendingDtoIn;
import com.qianya.model.out.MassSendingDraftDetailDtoOut;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.PageResult;

/***
 * @Description:群发service
 * @Author: Wangxin
 * @date 2023-06-08 14:30
**/
public interface MassService  {


    /***
     * @Description: 新增/修改群发
     * @Author: Wangxin
     * @date 2023-05-15 19:40
     * @Param addSchemeParamDtoIn:
     * @return: com.qianya.common.JsonResultT<?>
     **/
    JsonResultT<?> editMass(MassSendingDtoIn massSendingDtoIn);



    /***
     * @Description: 新增/修改群发状态
     * @Author: Wangxin
     * @date 2023-05-15 19:40
     * @Param addSchemeParamDtoIn:
     * @return: com.qianya.common.JsonResultT<?>
     **/
    JsonResultT<?> operateMass(Integer massId,Integer status);



    /***
     * @Description: 获取群发详情
     * @Author: Wangxin
     * @date 2023-05-15 19:40
     * @Param addSchemeParamDtoIn:
     * @return: com.qianya.common.JsonResultT<?>
     **/
    JsonResultT<?> getMassDetail(Integer massId);



    /**
     *  获取群发列表
     * @param massName
     * @param content
     * @param exexriseUserIds
     * @return
     */
    JsonResultT<CommonPage<MassSending>> getMassList(String content, String exexriseUserIds,Integer massCommonType,Integer pageNum,Integer pageSize);

    /***
     * @title  修改发送结果
     * @Description
     * @param: recordId
     * @param: state
     * @param: failMsg
     * @return: com.qianya.common.JsonResultT<?>
     * @Author lhl
     * @Date 2023/6/21 17:22
     */
    JsonResultT<?> updateSendState(Integer massId,String workId, Integer state, String failMsg);


    JsonResultT<PageResult<MassSendingMainMoEntity>> queryMassSendRecord(String content, String exexriseUserIds,Integer massCommonType,Integer pageNum,Integer pageSize);



    /***
     * @Description: 获取模板列表
     * @Author: Wangxin
     * @date 2023-07-02 13:40
     * @Param addSchemeParamDtoIn:
     * @return: com.qianya.common.JsonResultT<?>
     **/
    JsonResultT<CommonPage<SchemeDraftDtoOut>> draftList(String content, Integer pageNum, Integer pageSize);



    JsonResultT<MassSendingDraftDetailDtoOut> getDrafDetail(Integer massId);

    JsonResultT<?> massTask();

}
