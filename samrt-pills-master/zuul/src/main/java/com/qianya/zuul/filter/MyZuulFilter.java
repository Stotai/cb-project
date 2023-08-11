package com.qianya.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.qianya.common.JWTUtil;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.model.Do.IUserDo;
import com.qianya.zuul.feign.QwServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
@RefreshScope
public class MyZuulFilter extends ZuulFilter {    //过滤器类型
    @Value("${outUrl}")
    private String outUrl;
    @Autowired
    private QwServiceFeign qwServiceFeign;
    @Override
    public String filterType() {
        return "pre";
    }
    //zuul-core中的FilterLoader.java的getFilterByType中按类型pre、route、post取Filter后，再按照FilterOrder进行排序。    //先执行pre>routing>post 然后再在同类型的过滤器按照order大小执行，越小的越先被执行    @Override
    public int filterOrder() {
        return 0;
    }
    //过滤器是否执行，false不执行
    @Override
    public boolean shouldFilter() {
        //判断是否可以请求接口
        return true;
    }
    //自定义执行逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpServletResponse response = currentContext.getResponse();
        // 这些是对请求头的匹配，网上有很多解释
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods","GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token,Appid,Secret,Authorization,token");
        response.setHeader("Access-Control-Expose-Headers","X-forwared-port, X-forwarded-host");
        response.setHeader("Vary","Origin,Access-Control-Request-Method,Access-Control-Request-Headers");

        // 跨域请求一共会进行两次请求 先发送options 是否可以请求
        // 调试可发现一共拦截两次 第一次请求为options，第二次为正常的请求 eg：get请求
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())){
            currentContext.setSendZuulResponse(false); //验证请求不进行路由
            currentContext.setResponseStatusCode(HttpStatus.OK.value());//返回验证成功的状态码
            currentContext.set("isSuccess", true);
            return null;
        }
        String requestUrl = request.getRequestURI();
        String[] urlArray = outUrl.split(",");
        //如果这个请求在需放行的url中，直接放行
        for (String str:urlArray) {
            if(requestUrl.endsWith(str)){
                return null;
            }
        }
        //如果是前端请求
        if (requestUrl.startsWith("/front/")){
            String newUrl = requestUrl.split("/front")[1];
            currentContext.put(FilterConstants.REQUEST_URI_KEY, newUrl); // 将替换掉的url set进去,在对应的转发请求的url就会使用这个url
            String token = request.getHeader("token");
            //如果没有token
            if (token == null){
                currentContext.setSendZuulResponse(false);
                responseError("token不能为空",currentContext,JsonResult.CODE_401);
                return null;
            }else {
                String userName = JWTUtil.getUsername(token);
                if(userName==null||!JWTUtil.verify(token,userName)){
                    responseError("token认证失败",currentContext,JsonResult.CODE_401);
                    return null;
                }
                Integer userId = JWTUtil.getUserId(token);
                JsonResultT<IUserDo> res = qwServiceFeign.findUserWithId(userId);
                if (!res.getSuccess() || res.getData()==null){
                    responseError("获取当前用户消息失败",currentContext,JsonResult.CODE_401);
                    return null;
                }else {
                    //
                    IUserDo user=res.getData();
                    if (user.getUseSystemFlag()!=null){
                        if (user.getUseSystemFlag()==1){
                            responseError("授权到期",currentContext,JsonResult.CODE_402);
                            return null;
                        }else if (user.getUseSystemFlag()==2){
                            responseError("未授权微信",currentContext,JsonResult.CODE_403);
                            return null;
                        }
                    }
                }

            }
        }
        return null;
    }
    /***
     * 响应异常
     * @Description
     * @Author lhl
     * @Date 2023-05-18 23:15
     */
    public void responseError(String msg,RequestContext currentContext,Integer code){
        Map<String, Object> resp = new HashMap<>(4);
        resp.put("success", false);
        resp.put("status", code);
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseStatusCode(code);
        resp.put("msg", msg);
        currentContext.setResponseBody(JSONObject.toJSONString(resp));
        currentContext.getResponse().setContentType("application/json; charset=utf-8");
    }
}