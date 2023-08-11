//package com.qianya.netty;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.qianya.common.JWTUtil;
//import com.qianya.util.LogUtil;
//import com.qianya.util.StringUtil;
//import com.qianya.web.service.NettyUtil;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//import io.netty.channel.group.ChannelGroup;
//import io.netty.channel.group.DefaultChannelGroup;
//import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
//import io.netty.util.AttributeKey;
//import io.netty.util.concurrent.GlobalEventExecutor;
//import org.springframework.stereotype.Component;
//
///**
// * WebSocket 长连接下 文本帧的处理器
// * 实现浏览器发送文本回写
// * 浏览器连接状态监控
// *
// * @author makeDoBetter
// * @version 1.0
// * @date 2021/4/29 16:30
// * @since JDK 1.8
// */
//@Component
//public class FrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
//    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
//    AttributeKey<String> attributeKey = AttributeKey.valueOf("thisUserId");//参数key
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
//        //使用msg.text()获得帧中文本
//        String content=msg.text();
//        JSONObject json = JSONObject.parseObject(content);
//        //获得管道
//        Channel channel = ctx.channel();
//        //获得token
//        String token = json.getString("token");
//        if (StringUtil.isEmpty(token)){
//            //回写，需要封装成TextWebSocketFrame 对象写入到通道中
//            channel.writeAndFlush(new TextWebSocketFrame( "token不能为空"));
//            return;
//        }
//        String userName = JWTUtil.getUsername(token);
//        if(userName==null||!JWTUtil.verify(token,userName)){
//            channel.writeAndFlush(new TextWebSocketFrame( "token认证失败"));
//            return;
//
//        }
//        //获得用户id
//        Integer userId = JWTUtil.getUserId(token);
//        //绑定channelId
//        NettyUtil.setUserInfo(userId,channel.id().asLongText());
//        //设置参数
//        channel.attr(attributeKey).set(userId.toString());
//        //回写，需要封装成TextWebSocketFrame 对象写入到通道中
//        NettyUtil.handleMsg(userId,"收到");
//        //channel.writeAndFlush(new TextWebSocketFrame("【服务端】" + DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)+"-" + msg.text()));
//    }
//
//    /**
//     * 出现异常的处理 打印报错日志
//     *
//     * @param ctx   the ctx
//     * @param cause the cause
//     * @throws Exception the Exception
//     */
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        LogUtil.info(getClass(),cause.getMessage());
//        //关闭上下文
//        ctx.close();
//    }
//
//    /**
//     * 监控浏览器上线
//     *
//     * @param ctx the ctx
//     * @throws Exception the Exception
//     */
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        Channel channel = ctx.channel();
//        FrameHandler.channelGroup.add(channel);
//        LogUtil.info(getClass(), channel.id().asShortText() + "连接");
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        Channel channel = ctx.channel();
//        FrameHandler.channelGroup.remove(channel);
//        String str = channel.attr(attributeKey).get();
//        //如果存在，则下线这个用户
//        if (StringUtil.isNotEmpty(str)){
//            NettyUtil.offLine(Integer.valueOf(str));
//        }
//        LogUtil.info(getClass(), channel.id().asShortText() + "断开连接");
//    }
//}
//
