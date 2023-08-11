package com.qianya.web.controller;

import com.qianya.common.JWTUtil;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.User;
import com.qianya.model.Do.IUserDo;
import com.qianya.web.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description  登录相关
 * @Author lhl
 * @Date 2023-05-06 22:29
 */
@RestController
@Api(value = "LoginController", tags = "登录接口")
@RequestMapping("/logins")
public class LoginController {

    /**
     * 引入用户服务
     */
    @Autowired
    private LoginService loginService;


    /**
     * @Description  注册
     * @param: phone
     * @param: password
     * @return: com.qianya.common.JsonResult
     * @Author lhl
     * @Date 2023-05-06 22:56
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册",notes = "用户注册API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "用户手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType = "query")
    })
    public JsonResult create(@RequestParam("phone")String phone, @RequestParam("password")String password) {

        return loginService.create(phone,password);
    }
    /**
     * @Description  登录
     * @param: phone
     * @param: password
     * @return: com.qianya.common.JsonResult
     * @Author lhl
     * @Date 2023-05-06 22:56
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录",notes = "用户登录API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "用户手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType = "query")
    })
    public JsonResult login(@RequestParam("phone")String phone, @RequestParam("password")String password) {

        return loginService.login(phone,password);
    }

    @PostMapping("/refreshToken")
    @ApiOperation(value = "刷新Token")
    public JsonResult refreshToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = JWTUtil.refreshToken(request.getHeader("token"));
        return JsonResult.ok(token);
    }
    /***
     * 获得用户信息
     * @Description
     * @return: com.qianya.common.JsonResultT<com.qianya.entity.User>
     * @Author lhl
     * @Date 2023-05-18 23:11
     */
    @PostMapping("/findUserWithId")
    public JsonResultT<IUserDo> findUserWithId(@RequestParam("userId") Integer userId) {
        return JsonResultT.ok(loginService.findUserWithId(userId));
    }
}
