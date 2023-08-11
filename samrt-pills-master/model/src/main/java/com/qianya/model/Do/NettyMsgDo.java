package com.qianya.model.Do;


import java.io.Serializable;

/***
 * @Title netty消息通知
 * @Description
 * @Author lhl
 * @Date 2023-05-27 14:55
 */
public class NettyMsgDo implements Serializable {
    private static final long serialVersionUID = 1L;
    //通知类型 需要创建个枚举
    private Integer msgType;
    //发送内容
    private String content;

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
