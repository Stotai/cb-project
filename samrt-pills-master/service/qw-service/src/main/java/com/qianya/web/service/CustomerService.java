package com.qianya.web.service;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.model.in.AddCustomerDelay;
import com.qianya.util.CommonPage;
import com.qianya.model.in.CustomerDtoIn;
import com.qianya.model.out.CustomerListDtoOut;

import java.util.List;
import java.util.Map;

public interface CustomerService  {

    /***
     * @Description: 查询企业客户列表
     * @Author: Wangxin
     * @date 2023-05-08 15:38
     * @Param epriseWxIds: 关联企业微信id
     * @Param custWxName:  企业客户昵称
     * @Param verifyContent:  验证内容
     * @Param pageNum:  页码
     * @Param pageSize: 页大小
     * @return: com.qianya.common.JsonResultT<com.github.pagehelper.PageInfo<com.qianya.model.out.CustomerListDtoOut>>
    **/
    JsonResultT<CommonPage<CustomerListDtoOut>>  listCustomers(String epriseWxIds, String serachContent, Integer pageNum, Integer pageSize,Integer status,Integer addType,Integer isAll,Integer isContain,String containContent
    ,Integer sex,String addStartTime,String addEndTime,Integer accountType);

    /***
     * @Description: 新增客户
     * @Author: Wangxin
     * @date 2023-05-08 15:41
     * @Param customerDtoIn:
     * @return: com.qianya.common.JsonResult
    **/
    JsonResult addCustomer(CustomerDtoIn customerDtoIn);




    /***
     * @Description: 批量删除客户信息
     * @Author: Wangxin
     * @date 2023-05-08 18:17
     * @Param ids:  客户ID，多个ID以逗号分隔(返回的数据库主键id)
     * @return: com.qianya.common.JsonResult
    **/
    JsonResult deleteCustomers( String ids);

    /***
     * @Description: 列表头部好友数据
     * @Author: Wangxin
     * @date 2023-05-08 18:17
     * @Param
     * @return: com.qianya.common.JsonResult
     **/
    Map<String,Long> listHeadCount();

    /***
     * @Description: 修改客户
     * @Author: Wangxin
     * @date 2023-05-26 9:25
     * @Param custId:
     * @Param status:
     * @return: com.qianya.common.JsonResult
    **/
    JsonResult updateCustomerStatus(String custIds,Integer status);

    /***
     * @Title 新增好友延迟
     * @Description
     * @param: customerDelay
     * @return: com.qianya.common.JsonResult
     * @Author lhl
     * @Date 2023-06-18 12:40
     */
    JsonResult addCustomerDelay(AddCustomerDelay customerDelay);




    /***
     * @Description: 初始化好友数据
     * @Author: Wangxin
     * @date 2023-06-21 11:46
     * @Param customerDtoInList:
     * @return: com.qianya.common.JsonResult
    **/
    JsonResult initCustomer(List<CustomerDtoIn> customerDtoInList);


    JsonResult custAfterPassing(String customerWxId);
}
