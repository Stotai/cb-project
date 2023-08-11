package com.qianya.zuul.fallback;

import com.qianya.common.JsonResult;
import com.qianya.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Component
@RefreshScope
public class ProducerFallback implements FallbackProvider {

    @Autowired
    private HttpServletRequest request;

    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable e) {

        RequestUtils.printClientInfo(request, "当前服务【"+route+"】不可用，请求地址：【" + request.getRequestURI() + "】");
        RequestUtils.printParams(request);

        return new ClientHttpResponse() {

            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() {
                return new ByteArrayInputStream(JsonResult.error("网络开小差了，请刷新重试下").toString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.add("Access-Control-Allow-Origin", "*");
                headers.add("Access-Control-Allow-Credentials", "true");
                headers.add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
                headers.add("Access-Control-Allow-Headers", "Content-Type,*");
                return headers;
            }
        };
    }
}
