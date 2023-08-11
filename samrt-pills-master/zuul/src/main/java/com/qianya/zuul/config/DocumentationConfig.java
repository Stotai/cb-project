package com.qianya.zuul.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 通过配置资源文档，在首页下拉框选择订单系统时，会请求 http://localhost:8070/order/v2/api-docs 获取文档详情，zuul 根据路由配置，会将 /order/** 请求转发到路由 serviceId 为 order-server 系统上
 **/

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("企微系统", "/front/qw-service/v2/api-docs", "2.0"));
        resources.add(swaggerResource("文件系统", "/front/system-file/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}