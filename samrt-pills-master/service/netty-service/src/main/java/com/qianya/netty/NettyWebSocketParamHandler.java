package com.qianya.netty;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.URLUtil;
import com.qianya.util.LogUtil;
import com.qianya.util.StringUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Map;


/****
 * @title
 * @Description    URL参数处理程序，这时候连接还是个http请求，没有升级成webSocket协议，此处SimpleChannelInboundHandler泛型使用FullHttpRequest
 * @Author lhl
 * @Date 2023/6/6 16:19
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class NettyWebSocketParamHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    /**
     * 此处进行url参数提取，重定向URL，访问webSocket的url不支持带参数的，带参数会抛异常，这里先提取参数，将参数放入通道中传递下去，重新设置一个不带参数的url
     *
     * @param ctx     the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *                belongs to
     * @param request the message to handle
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        String uri = request.uri();
        LogUtil.info(getClass(),"连接url->"+uri);
        Map<CharSequence, CharSequence> queryMap = UrlBuilder.ofHttp(uri, Charset.defaultCharset()).getQuery().getQueryMap();
        if(queryMap==null){
            LogUtil.info(getClass(),"无参数,关闭连接->"+uri);
            ctx.close();
        }else {
            CharSequence token = queryMap.get("token");
            if (StringUtil.isEmpty(token)){
                LogUtil.info(getClass(),"获取token失败,关闭连接->"+uri);
                ctx.close();
                return;
            }
            //将参数放入通道中传递下去
            AttributeKey<String> tokenKey = AttributeKey.valueOf("token");
            ctx.channel().attr(tokenKey).setIfAbsent(token.toString());
            request.setUri(URLUtil.getPath(uri));
            ctx.fireChannelRead(request.retain());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LogUtil.error(getClass(),"netty连接异常...",cause);
        ctx.close();
    }

}
