package com.qianya.web.mapper;

import com.qianya.entity.Customer;
import io.lettuce.core.dynamic.annotation.Param;
import com.qianya.model.out.CustomerListDtoOut;


import java.util.List;

public interface CustomerExMapper {



    /**
     * 分页查询客户信息
     * @param epriseWxIds 关联企业微信id列表
     * @param serachContent
     * @return 客户信息列表
     */
    List<CustomerListDtoOut> listCustomers(@Param("epriseWxIds") List<String> epriseWxIds, @Param("serachContent") String serachContent, @Param("userId")Integer userId,@Param("status")Integer status,@Param("addType")Integer addType,@Param("isAll")Integer isAll,@Param("isContain")Integer isContain,@Param("containContentList") List<String> containContentList,
                                           @Param("sex")Integer sex,@Param("addStartTime")String addStartTime,@Param("addEndTime")String addEndTime,@Param("accountType")Integer accountType);


    /***
     * @Description: 批量删除
     * @Author: Wangxin
     * @date 2023-05-08 18:20
     * @Param idList: 客户id  以逗号拼接
     * @return: int
    **/
    int deleteCustomersSoftly(@Param("idList") List<Integer> idList);


    void insertBatchCustomers(List<Customer> customers);




}
