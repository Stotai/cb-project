package com.qianya.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianya.common.JsonResultT;
import com.qianya.entity.Customer;
import com.qianya.entity.CustomerCriteria;
import com.qianya.mapper.CustomerMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.web.mapper.ZombieFanExMapper;
import com.qianya.web.service.LoginService;
import com.qianya.web.service.ZombieFanService;
import com.qianya.model.in.ZombieFanDtoIn;
import com.qianya.model.out.ZombieFanDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ZombieFanServiceImpl implements ZombieFanService {



    @Autowired
    private ZombieFanExMapper zombieFanExMapper;
    @Autowired
    private LoginService loginService;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public JsonResultT<CommonPage<ZombieFanDtoOut>> getZombieFansPage(Integer pageNo, Integer pageSize, List<String> exriseUserIds, Integer status, String custNickName) {

        // 构建查询条件
       IUserDo user = loginService.selectUser();
        // 构建分页参数
        PageHelper.startPage(pageNo, pageSize);
        List<ZombieFanDtoOut> zombieFanDtoOuts = zombieFanExMapper.selectZombieFans(exriseUserIds,status,custNickName,user.getUserId());
        // 获取分页信息
        return JsonResultT.ok(CommonPage.restPage(zombieFanDtoOuts)) ;

    }

    @Override
    public JsonResultT<?> batchInsertZombieFans(List<ZombieFanDtoIn> zombieFanDtoIns, IUserDo user) {
        // 设置默认值
        String currentTime = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        //根据来源分组
        Map<Integer, List<ZombieFanDtoIn>> zombieFanDtoInsMap= zombieFanDtoIns.stream().collect(Collectors.groupingBy(ZombieFanDtoIn::getSource));
        zombieFanDtoInsMap.forEach((x,y)->{
             //获取客户id
            Customer customer=new Customer();
            customer.setZombieFlag(1);
            customer.setZombieStatus(0);
            customer.setZombieDeleteTime(currentTime);
            customer.setSource(y.get(0).getSource());
            List<String> customerIds = y.stream().map(ZombieFanDtoIn::getCustWxId).collect(Collectors.toList());
            //更新
            CustomerCriteria customerCriteria=new CustomerCriteria();
            customerCriteria.createCriteria().andCustWxIdIn(customerIds).andEpriseWxIdEqualTo(user.getExriseWxId());
            customerMapper.updateByExampleSelective(customer,customerCriteria);
        });
        return JsonResultT.ok();

    }

    @Override
    public int batchEditZombieFans(List<String> fanIds, Integer opType) {
        String currentTime = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        return zombieFanExMapper.batchEditZombieFans(fanIds,opType,currentTime);
    }
}
