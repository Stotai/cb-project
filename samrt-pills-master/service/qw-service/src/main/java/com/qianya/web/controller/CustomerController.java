package com.qianya.web.controller;

import com.qianya.annotations.Log;
import com.qianya.cbEnum.BusinessType;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.model.in.AddCustomerDelay;
import com.qianya.util.CommonPage;
import com.qianya.util.StringUtil;
import com.qianya.web.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.qianya.model.in.CustomerDtoIn;
import com.qianya.model.out.CustomerListDtoOut;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-07  17:20
 * @Description: 企业客户层
 */
@RestController
@Api(value = "CustomerController", tags = "企业客户")
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "查询企业客户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "epriseWxIds", value = "关联企业微信id，多选时以逗号分隔", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "serachContent", value = "客户微信昵称/验证内容，支持模糊搜索", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态(0:待接受;1:已接受;2:已忽略)", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "addType", value = "添加类型(1:软件添加;2:其他)", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "isAll", value = "是否查询包含僵尸粉(不传则查正常客户，1查所有)", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "isContain", value = "包含昵称(0包含;1:不包含) 空默认", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "sex", value = "性别（1:男;2:女）", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "addStartTime", value = "添加开始时间", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "addEndTime", value = "添加结束时间", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "accountType", value = "账号类型(1:个人号;2:企业号)", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "containContent", value = "(不)包含昵称支持个,以逗号分割", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "serachContent", value = "客户微信昵称/验证内容，支持模糊搜索", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页码，默认为1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量，默认为10", dataType = "int", paramType = "query")
    })
    @PostMapping("/list")
    public JsonResultT<CommonPage<CustomerListDtoOut>> listCustomers(
            @RequestParam(value = "epriseWxIds", required = false) String epriseWxIds,
            @RequestParam(value = "serachContent", required = false) String serachContent,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "isAll", required = false) Integer isAll,
            @RequestParam(value = "isContain", required = false) Integer isContain,
            @RequestParam(value = "containContent", required = false) String containContent,
            @RequestParam(value = "sex", required = false) Integer sex,
            @RequestParam(value = "addStartTime", required = false) String addStartTime,
            @RequestParam(value = "addEndTime", required = false) String addEndTime,
            @RequestParam(value = "accountType", required = false) Integer accountType,
            @RequestParam(value = "addType", required = false) Integer addType,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

           return customerService.listCustomers(epriseWxIds,serachContent,pageNum,pageSize,status,addType,isAll,isContain,containContent,sex,addStartTime,addEndTime,accountType);
    }

    /**
     *  列表头部数据
     * @return
     */
    @PostMapping("/listheadCount")
    @ApiOperation("列表列表顶部数据")
    public JsonResultT<?>  listheadCount(){
         return JsonResultT.ok(customerService.listHeadCount());
    }


    @ApiOperation("新增企业客户信息")
    @PostMapping("/addCustomer")
    public JsonResult addCustomer(@RequestBody  CustomerDtoIn customerDtoIn) {

        String custWxId = customerDtoIn.getCustWxId();
        String custWxName = customerDtoIn.getCustWxName();
        String verifyContent = customerDtoIn.getVerifyContent();
        String custWxHeadUrl= customerDtoIn.getCustWxHeadUrl();
        Integer sex = customerDtoIn.getSex();

        if (StringUtils.isEmpty(custWxHeadUrl)) {
            return JsonResult.error("客户头像不能为空");
        }
        if (StringUtils.isEmpty(custWxId)) {
            return JsonResult.error("客户企业微信ID不能为空");
        }
        if (StringUtils.isEmpty(custWxName)) {
            return JsonResult.error("客户企业微信名称不能为空");
        }
        if (StringUtils.isEmpty(verifyContent)) {
            return JsonResult.error("验证内容不能为空");
        }

        if (sex == null) {
            return JsonResult.error("性别不能为空");
        }
        return customerService.addCustomer(customerDtoIn);
    }


    @ApiOperation("初始化客户数据")
    @PostMapping("/initCustomer")
    public JsonResult initCustomer(@RequestBody List<CustomerDtoIn> customerDtoInList) {
        if(CollectionUtils.isEmpty(customerDtoInList)){
            return JsonResult.ok();
        }
        return customerService.initCustomer(customerDtoInList);
    }

    @ApiOperation("批量删除客户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "客户ID，多个ID以逗号分隔(返回的数据库主键id)", required = true, dataType = "String")
    })
    @PostMapping("/deleteCustomers")
    @Log(service = "批量删除客户信息", businessType = BusinessType.DELETE)
    public JsonResult deleteCustomers(@RequestParam("ids") String ids) {
        return customerService.deleteCustomers(ids);
    }




    @ApiOperation("修改客户状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "custIds", value = "客户ids(以逗号拼接)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "1:已接受;2:已忽略", required = true, dataType = "int")
    })
    @PostMapping("/updateCustomerStatus")
    public JsonResult updateCustomerStatus(@RequestParam("custIds") String custIds,@RequestParam("status")Integer status) {
        if(StringUtil.isEmpty(custIds)){
            return JsonResult.error("请传入要修改的客户id");
        }
        if(status==null){
            return JsonResult.error("请传入要修改的状态");
        }
        return customerService.updateCustomerStatus(custIds,status);
    }

    @ApiOperation("新增好友延迟")
    @PostMapping("/addCustomerDelay")
    public JsonResult addCustomerDelay(@RequestBody AddCustomerDelay customerDelay) {

        return customerService.addCustomerDelay(customerDelay);
    }

    /***
     * @Description: 好友通过后修改好友状态
     * @Author: Wangxin
     * @date 2023-06-21 15:50
     * @Param customerWxId:
     * @return: com.qianya.common.JsonResult
    **/
    @ApiOperation("custAfterPassing")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerWxId", value = "客户微信id", required = true, dataType = "String")
    })
    @PostMapping("/custAfterPassing")
    JsonResult custAfterPassing(@RequestParam("customerWxId") String customerWxId){
        return customerService.custAfterPassing(customerWxId);
    }


}
