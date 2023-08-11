package com.qianya.task.websocket;

import com.qianya.util.IpUtils;
import com.qianya.util.LogUtil;
import com.qianya.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.server.ServerEndpoint;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/****
 * socket服务客户端监听
 * @Description
 * @Author lhl
 * @Date 2023-05-22 22:08
 */
@ServerEndpoint(value = "/websocket/inside/{userId}")
@Component
public class WebSocketClientServer {
    @Autowired
    private MongoTemplate mongoTemplate;

    public static WebSocketClient client;
    //初始化次数
    private static int count=19;


    @PostConstruct
    public void connnet() {
        try {
            client = new WebSocketClient(new URI("ws://39.106.133.60/congbao?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1VHlwZSI6NiwiZXhwIjoyMDAwNDc1MzQ3LCJ1c2VySWQiOjYsInVzZXJuYW1lIjoibmV0dHkifQ.HVGd7df2xsiu-dfyjvEEe5r_AzJrynjOsge_TXvIvqw"), new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    count=19;
                    LogUtil.info(getClass(),"握手成功");
                    //client.send("{\"token\":\"\",\"msg\":\"1\"}");
                }

                @Override
                public void onMessage(String msg) {
                    //业务处理
                    LogUtil.info(getClass(),"收到服务端消息->"+msg);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    LogUtil.info(getClass(),"连接已关闭");
                }

                @Override
                public void onError(Exception e) {
                    count++;
                    e.printStackTrace();
                    LogUtil.info(getClass(),"发生错误已关闭");
                    //每20次，发送一次邮件
                    if (count%20==0){
                        MailUtil.sendEmail(mongoTemplate,"netty服务掉线:"+IpUtils.getServiceIp(),"netty服务器掉线，请及时查看，count:"+count);
                    }
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        /**
         * 重连机制
         * 使用 ScheduledExecutorService   不要使用timer  timer不支持多线程,挂在timer下的任务都是单线程，如果任务运行时间过长影响其他任务运行
         *
         * ScheduledThreadPoolExecutor支持多线程。同一时候在线程中对异常进行了捕获。
         *
         * */
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{
                    if(client.getReadyState()!= ReadyState.OPEN) {
                        if(client.getReadyState()== ReadyState.NOT_YET_CONNECTED) {
                            if(client.isClosed()) {
                                LogUtil.info(getClass(),"连接关闭,正在重新连接中……");
                                client.reconnect();
                            }else{
                                LogUtil.info(getClass(),"建立连接中……");
                                client.connect();
                            }
                        }else if( client.getReadyState() == ReadyState.CLOSED){
                            LogUtil.info(getClass(),"连接关闭,正在重新连接中……");
                            client.reconnect();
                        }
                    }
                }catch(Exception e) {
                    LogUtil.info(getClass(),"连接异常,正在重新连接中……");
                    client.reconnect();
                }
            }
        },0,5000, TimeUnit.MILLISECONDS);
    }
}