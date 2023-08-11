package com.qianya.zuul.feign;

import com.qianya.common.JsonResultT;
import com.qianya.model.Do.IUserDo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * 远程调用
 * @Description
 * @Author lhl
 * @Date 2023-05-18 23:09
 */
@FeignClient(name="qw-service")
@Component
public interface QwServiceFeign {
    @RequestMapping(value = "/logins/findUserWithId",method = RequestMethod.POST)
    JsonResultT<IUserDo> findUserWithId(@RequestParam("userId") Integer userId);
}
