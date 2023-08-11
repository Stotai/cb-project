package com.qianya.web.service.impl;


import com.qianya.common.JsonResultT;
import com.qianya.exception.CustomException;
import com.qianya.util.IdWorker;
import com.qianya.web.service.TestService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;



/**
* <p>
*  test
* </p>
*
* @author lhl
* @since 2020-09-28
*/
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private IdWorker idWorker;

    @Override
    public JsonResultT getTest(Integer type) {
       /* XpHouseWorkRecordMoEntity xpHouse=new XpHouseWorkRecordMoEntity();
        xpHouse.setRecordId(idWorker.nextId());
        xpHouse.setXpHouseId(2);
        xpHouse.setHouseId(3);
        xpHouse.setRecordType(4);
        xpHouse.setWorkId(5);
        xpHouse.setWorkTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        xpHouse.setFuTypeCode(6);
        xpHouse.setFuContent("7");
        xpHouse.setFuSource(8);
        xpHouse.setTalkTime(9);
        xpHouse.setTalkResult(10);
        xpHouse.setAudioPath("11");
        xpHouse.setCreateId(12);
        xpHouse.setCreateName("15");
        xpHouse.setDeptId(16);
        xpHouse.setDeptName("48");
        xpHouse.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD));
        xpHouse.setScore(new BigDecimal(99));
        xpHouse.setRelevanceId(77);
        mongoTemplate.insert(xpHouse,"xp_house_work_record");*/
        redisTemplate.opsForValue().set("lhl","redis部署成功");
        /*LogUtil.info(getClass(),"val:"+redisTemplate.opsForValue().get("lhl"));
        String str1="发送时间:"+ DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_new_exchange, MqConstant.routeKey.test_new_key, str1);
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.test_wait_key, str1, message -> {
            //设置发送消息的延迟时间
            message.getMessageProperties().setDelay(5000);
            return message;
        });*/
        if (type!=null){
            if (type==1){
                throw new CustomException("抱异常了",false);
            }
        }
        return JsonResultT.ok("hello world");
    }
}
