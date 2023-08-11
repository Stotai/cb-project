package com.qianya.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.qianya.cbEnum.CustomerStatusEnum;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.constant.MqConstant;
import com.qianya.entity.*;
import com.qianya.mapper.CustomerMapper;
import com.qianya.mapper.ExriseUserMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.AddCustomerDelay;
import com.qianya.model.in.GroupCustDtoIn;
import com.qianya.util.*;
import com.qianya.web.mapper.CustomerExMapper;
import com.qianya.web.service.CustomerService;
import com.qianya.web.service.LoginService;
import com.qianya.model.in.CustomerDtoIn;
import com.qianya.model.out.CustomerListDtoOut;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-08  15:35
 * @Description: TODO
 */
@Service
public class CustomerServiceImpl  implements CustomerService {

    @Autowired
    private CustomerExMapper customerExMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private LoginService loginService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public JsonResultT<CommonPage<CustomerListDtoOut>> listCustomers(String epriseWxIds, String serachContent, Integer pageNum, Integer pageSize,Integer status,Integer addType,Integer isAll,Integer isContain,String containContent,
            Integer sex,String addStartTime,String addEndTime,Integer accountType) {
        // 解析多选的关联企业微信id
        List<String> epriseWxIdList = null;
        if (StringUtils.isNotEmpty(epriseWxIds)) {
            String[] epriseWxIdArr = epriseWxIds.split(",");
            epriseWxIdList= Arrays.asList(epriseWxIdArr);
        }
        List<String>  containContentList= null;
        if (StringUtils.isNotEmpty(containContent)) {
            String[] contentArr = containContent.split(",");
            containContentList= Arrays.asList(contentArr);
        }

       IUserDo user=loginService.selectUser();
        // 分页查询客户信息
        PageHelper.startPage(pageNum, pageSize);
        List<CustomerListDtoOut> customerList = customerExMapper.listCustomers(epriseWxIdList, serachContent,user.getUserId(),status,addType,isAll,isContain,containContentList,sex,addStartTime,addEndTime,accountType);
        return JsonResultT.ok(CommonPage.restPage(customerList)) ;

    }

    @Override
    public JsonResult addCustomer(CustomerDtoIn customerDtoIn) {
        IUserDo user=loginService.selectUser();
        Customer customer=GrainBeanUtils.convert(customerDtoIn,Customer.class);
        customer.setUserId(user.getUserId());
        customer.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)));
        customer.setStatus(1);
        customer.setIsDel(0);
        customer.setAddType(1);
        customer.setZombieFlag(0);
        customer.setAccountType(getAccountType(customer.getCustWxId()));
        customer.setEpriseWxId(user.getExriseWxId());
        customer.setEpriseWxName(user.getExriseWxName());
        customerMapper.insertSelective(customer);
        return JsonResult.ok();

    }


    public Integer getAccountType(String custWxId){
        if(custWxId.startsWith("16")){
            return 2;
        }else {
            return 1;
        }
    }

    @Override
    public JsonResult deleteCustomers(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return JsonResult.error("请传入要删除的客户id");
        }
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        // 执行批量删除操作，将is_del字段设置为1
        int count = customerExMapper.deleteCustomersSoftly(idList);
        if (count > 0) {
            return JsonResult.ok("删除成功");
        } else {
            return JsonResult.error("删除失败");
        }
    }

    @Override
    public Map<String,Long> listHeadCount() {

        String nowTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_TO_START));

        IUserDo user=loginService.selectUser();
        //查询今天已处理客户
        CustomerCriteria customerCriteria=new CustomerCriteria();
        customerCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andCreateTimeGreaterThanOrEqualTo(nowTime).andZombieFlagEqualTo(0);
        List<Customer> customerList=customerMapper.selectByExample(customerCriteria);
        //已添加客户
        Long customerCount=customerList.stream().filter(x->x.getStatus()== CustomerStatusEnum.ACCEPTED.getCode()).count();
        //待接受客户
        Long waitCount=customerList.stream().filter(x->x.getStatus()== CustomerStatusEnum.PENDING.getCode()).count();
        Map<String,Long> reusltMap=new HashMap<>();
        reusltMap.put("customerCount",customerCount);
        reusltMap.put("waitCount",waitCount);
        return reusltMap;
    }

    @Override
    public JsonResult updateCustomerStatus(String custIds, Integer status) {
        List<Integer> custListIds = Arrays.stream(custIds.split(",")).filter(StringUtil::isNotEmpty).map(Integer::valueOf).collect(Collectors.toList());
        CustomerCriteria customerCriteria=new CustomerCriteria();
        customerCriteria.createCriteria().andCustomerIdIn(custListIds);
        Customer updateCustomer =new Customer();
        updateCustomer.setStatus(status);
        customerMapper.updateByExampleSelective(updateCustomer,customerCriteria);
        return JsonResult.ok();
    }

    @Override
    public JsonResult addCustomerDelay(AddCustomerDelay customerDelay) {
        //获得当前用户
        IUserDo user=loginService.selectUser();
        Integer thisUserId = user.getUserId();
        JSONObject object;
        int countNum=0;
        for (String userId : customerDelay.getUserIds()) {
            object=new JSONObject();
            object.put("wxUserId",userId);
            object.put("userId",thisUserId);
            object.put("content",customerDelay.getContent());
            //获得随机值
            int num = RandUtils.getNum(customerDelay.getDelayMin(), customerDelay.getDelayMax());
            countNum=countNum+num;
            int finalCountNum = countNum;
            rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.add_customer_key, object.toJSONString(), message -> {
                //设置发送消息的延迟时间
                message.getMessageProperties().setDelay(finalCountNum *1000);
                return message;
            });
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult initCustomer(List<CustomerDtoIn> customerDtoInList) {

        //查询好友数据
       IUserDo user = loginService.selectUser();
        //查询群成员数据
        CustomerCriteria customerCriteria = new CustomerCriteria();
        customerCriteria.createCriteria().andEpriseWxIdEqualTo(user.getExriseWxId());
        List<Customer> groupCusts = customerMapper.selectByExample(customerCriteria);
        String nowTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        //转换成map
        Map<String, Integer> custMap = groupCusts.stream().collect(Collectors.toMap(Customer::getCustWxId, Customer::getCustomerId));
        //定义新增数据
        List<CustomerDtoIn> addCustDtos = new ArrayList<>();
        //新增数据
        for (CustomerDtoIn customerDtoIn : customerDtoInList) {
            if (custMap.get(customerDtoIn.getCustWxId()) == null) {
                addCustDtos.add(customerDtoIn);
            }
        }
        if (!CollectionUtils.isEmpty(addCustDtos)) {
            List<Customer> customerList = GrainBeanUtils.convertList(addCustDtos, Customer.class
                    , x -> {
                        x.setUserId(user.getUserId());
                        x.setEpriseWxId(user.getExriseWxId());
                        x.setEpriseWxName(user.getExriseWxName());
                        x.setAddType(2);
                        x.setStatus(CustomerStatusEnum.ACCEPTED.getCode());
                        x.setIsDel(0);
                        x.setAccountType(getAccountType(x.getCustWxId()));
                        x.setZombieFlag(0);
                        x.setCreateTime(nowTime);
                    });
            customerExMapper.insertBatchCustomers(customerList);
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult custAfterPassing(String customerWxId) {

        IUserDo iUserDo=loginService.selectUser();
        //查询企业客户
        CustomerCriteria customerCriteria=new CustomerCriteria();
        customerCriteria.createCriteria().andEpriseWxIdEqualTo(iUserDo.getExriseWxId()).andCustWxIdEqualTo(customerWxId);
        List<Customer> customerList=customerMapper.selectByExample(customerCriteria);
        if(CollectionUtils.isEmpty(customerList)){
          return JsonResult.error("未查询到客户信息");
        }
        Customer customer = customerList.get(0);
        Customer updateCustomer=new Customer();
        updateCustomer.setCustomerId(customer.getCustomerId());
        if(customer.getZombieFlag()!=null && customer.getZombieFlag()==1){
          //清除标记等信息
          updateCustomer.setZombieFlag(0);
        }
        updateCustomer.setStatus(CustomerStatusEnum.ACCEPTED.getCode());
        customerMapper.updateByPrimaryKeySelective(updateCustomer);
        return JsonResult.ok();
    }


}
