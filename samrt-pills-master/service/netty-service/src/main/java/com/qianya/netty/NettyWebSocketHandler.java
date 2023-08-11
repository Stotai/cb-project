package com.qianya.netty;


import com.alibaba.fastjson.JSONObject;
import com.qianya.cbEnum.NettyMsgEnum;
import com.qianya.common.JWTUtil;
import com.qianya.util.LogUtil;
import com.qianya.util.StringUtil;
import com.qianya.web.service.NettyUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

/****
 * @title   自定义WebSocket处理程序
 * @Description  SimpleChannelInboundHandler的泛型需要传递WebSocketFrame
 * @Author lhl
 * @Date 2023/6/6 16:11
 */
@Component
@ChannelHandler.Sharable
public class NettyWebSocketHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    //全局channel集合
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //用户信息
    AttributeKey<String> userIdKey = AttributeKey.valueOf("thisUserId");//参数key
    //用户token
    AttributeKey<String> tokenKey = AttributeKey.valueOf("token");

    /****
     * @title  事件回调
     * @Description
     * @param: ctx
     * @param: evt
     * @Author lhl
     * @Date 2023/6/6 16:11
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            //协议握手成功完成
            LogUtil.info(getClass(),"本地协议握手成功完成");
            //获得channel
            Channel channel = ctx.channel();
            //从通道中获取用户token
            String token = channel.attr(tokenKey).get();

            String userName = JWTUtil.getUsername(token);
            if(userName==null||!JWTUtil.verify(token,userName)){
                channel.writeAndFlush(new TextWebSocketFrame( "token认证失败"));
                ctx.close();
                return;
            }
            //获得用户id
            Integer userId = JWTUtil.getUserId(token);
            //绑定channelId
            NettyUtil.setUserInfo(userId,channel.id().asLongText());
            //设置参数
            channel.attr(userIdKey).set(userId.toString());
            channelGroup.add(channel);
            JSONObject obj=new JSONObject();
            obj.put("msgType", NettyMsgEnum.OK.getCode());
            //回写，需要封装成TextWebSocketFrame 对象写入到通道中
            NettyUtil.handleMsg(userId,obj.toJSONString());
        }
        //通过判断IdleStateEvent的状态来实现自己的读空闲，写空闲，读写空闲处理逻辑
        /*if (evt instanceof IdleStateEvent && ((IdleStateEvent) evt).state() == IdleState.READER_IDLE) {
            //读空闲，关闭通道
            LogUtil.info(LOGGER,"心跳监听...");
            //ctx.close();
        }*/
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, WebSocketFrame textWebSocketFrame) throws Exception {
        TextWebSocketFrame textFrame = (TextWebSocketFrame) textWebSocketFrame;
        String message = textFrame.text();
        LogUtil.info(getClass(),"收到消息.....->"+ JSONObject.toJSONString(message));

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        LogUtil.info(getClass(),"通道关闭了.....");
        //获取用户关闭通道时设置的close code
       /* AttributeKey<Integer> attributeKey = AttributeKey.valueOf("closeCode");
        Attribute<Integer> closeCode = ctx.channel().attr(attributeKey);
        LogUtil.info(LOGGER,".....");*/
        Channel channel = ctx.channel();
        NettyWebSocketHandler.channelGroup.remove(channel);
        String str = getNettyAttr(channel,userIdKey);
        //如果存在，则下线这个用户
        if (StringUtil.isNotEmpty(str)){
            NettyUtil.offLine(Integer.valueOf(str));
        }
        //对closeCode进行区分处理....
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LogUtil.error(getClass(),"通道异常.....",cause);
        ctx.close();
    }
    /****
     * @title   获取channel内容
     * @Description
     * @param: key
     * @return: java.lang.String
     * @Author lhl
     * @Date 2023/6/6 18:58
     */
    public String getNettyAttr(Channel channel, AttributeKey<String> key){
        //获得参数
        return channel.attr(key).get();
    }
    /****
     * @title  设置channel内容
     * @Description
     * @param: key
     * @param: content
     * @return: java.lang.String
     * @Author lhl
     * @Date 2023/6/6 18:58
     */
    public void setNettyAttr(Channel channel, AttributeKey<String> key, String content){
        //设置参数
        channel.attr(key).set(content);
    }
}
