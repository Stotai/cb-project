package com.qianya.web.service;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.model.in.ExriseUserDtoIn;
import com.qianya.model.out.ProductUseRecordDtoOut;

import java.util.List;

public interface UserService  {



    /***
     * @Description: 查询绑定企业微信
     * @Author: Wangxin
     * @date 2023-05-08 19:06
     * @return: com.qianya.common.JsonResult
    **/
    JsonResult getExriseUserByUserId();


    //删除授权企业微信
    int deleltUser(Integer userId);


    JsonResult editUser(ExriseUserDtoIn exriseUserDtoIn);


    JsonResult countCust();


    JsonResultT<?> activationCard(String carMi);


    JsonResultT<?> exriseWxNameRemark(String exriseUserId,String remark);

    List<ProductUseRecordDtoOut> searchCardRecords(String keyWord);


    List<ProductUseRecordDtoOut> searchRecordsByCarmi(String carmis);


    JsonResultT<?> transferCard(Integer recordId,String exriseUserId,String remark);

}
