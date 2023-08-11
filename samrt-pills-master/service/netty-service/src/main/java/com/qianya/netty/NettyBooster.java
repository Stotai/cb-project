package com.qianya.netty;


import cn.hutool.core.util.ObjectUtil;
import com.qianya.config.ComponentLocator;
import com.qianya.constant.CommConstant;
import com.qianya.util.LogUtil;
import com.qianya.web.service.NettyUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Set;

/****
 * @title  netty启动类
 * @Description
 * @Author lhl
 * @Date 2023/6/6 16:12
 */
@DependsOn("componentLocator")
@Component
public class NettyBooster {


    private final NettyWebSocketParamHandler nettyWebSocketParamHandler;

    private final NettyWebSocketHandler nettyWebSocketHandler;

    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    public NettyBooster(NettyWebSocketParamHandler nettyWebSocketParamHandler, NettyWebSocketHandler nettyWebSocketHandler) {
        this.nettyWebSocketParamHandler = nettyWebSocketParamHandler;
        this.nettyWebSocketHandler = nettyWebSocketHandler;
    }

    @PostConstruct
    public void start() throws InterruptedException {
        //创建BossGroup，这里指定线程数1就够了，bossGroup 就相当于领导，workerGroup 就相当于员工，领导有一个差不多了
        bossGroup = new NioEventLoopGroup(1);
        //创建WorkerGroup
        workerGroup = new NioEventLoopGroup();
        //创建服务器端的启动对象，配置参数
        ServerBootstrap serverBootstrap =
                new ServerBootstrap()
                        .group(bossGroup, workerGroup)
                        //使用NioServerSocketChannel作为服务器的通道实现
                        .channel(NioServerSocketChannel.class)
                        //设置日志处理器
                        .handler(new LoggingHandler(LogLevel.INFO))
                        //设置线程队列得到的连接个数
                        .option(ChannelOption.SO_BACKLOG, 128)
                        //设置保持活动连接的状态
                        .childOption(ChannelOption.SO_KEEPALIVE, true)
                        //给我们的workerGroup的EventLoop对应的管道设置处理器
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            /**
                             * 创建一个通道测试对象（匿名对象）
                             * 给pipeline设置处理器
                             */
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline().addLast(
                                        // 解码器
                                        new HttpServerCodec(),
                                        // http 消息聚合器  512*1024为接收的最大content-length
                                        new HttpObjectAggregator(8192),
                                        // 支持异步发送大的码流(大的文件传输),但不占用过多的内存，防止java内存溢出
                                        new ChunkedWriteHandler(),
                                        //设置一个空闲状态处理程序（心跳机制），读空闲，写空闲，读写空闲
                                        new IdleStateHandler(30, 0, 0),
                                        // 自定义参数处理器，必须放在 new WebSocketServerProtocolHandler() 处理器之前
                                        nettyWebSocketParamHandler,
                                        // websocket支持，前端通过访问IP:端口/web-socket连接,设置路由（这里使用了自己继承WebSocketServerProtocolHandler重写了decode方法的类，目的是为了获取到客户端传递的自定义Close Code）
                                        new MyWebSocketServerProtocolHandler("/congbao"),
                                        //自定义处理程序
                                        nettyWebSocketHandler
                                );
                            }
                        });
        serverBootstrap.bind(8099).sync();
        clearRedisCach();
        LogUtil.info(getClass(),"Netty 启动成功");
    }

    /**
     * Springboot关闭时关闭Netty
     */
    @PreDestroy
    private void destroy() throws InterruptedException {
        LogUtil.info(getClass(),"Netty 服务关闭成功");
        if (ObjectUtil.isNotNull(bossGroup)) {
            bossGroup.shutdownGracefully().sync();
        }
        if (ObjectUtil.isNotNull(workerGroup)) {
            workerGroup.shutdownGracefully().sync();
        }
        LogUtil.info(getClass(),"Netty 线程已全部关闭...");
    }

    private void clearRedisCach(){
        Set<String> keys = ComponentLocator.getRedis().keys(CommConstant.redisKey.netty_user_channel);
        if (keys!=null && keys.size()>0){
            for (String key : keys) {
                ComponentLocator.getRedis().del(key);
                String[] split = key.split(CommConstant.redisKey.netty_user_channel);
                if (split.length>1){
                    try {
                        NettyUtil.sendUserBindChannelQueue(Integer.valueOf(split[1]),"");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
