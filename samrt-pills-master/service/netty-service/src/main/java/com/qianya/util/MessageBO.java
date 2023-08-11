package com.qianya.util;


import lombok.Builder;
import lombok.experimental.FieldNameConstants;

import java.util.List;

/**
 * @author hl.Wu
 * @date 2022/7/14
 **/
@FieldNameConstants
public class MessageBO extends BaseBO{

    /**
     * 请求唯一标识id
     */
    private String requestUid;

    private String token;

    private Boolean heartbeat;

    private List<VerificationEmsBO> data;

    public String getRequestUid() {
        return requestUid;
    }

    public void setRequestUid(String requestUid) {
        this.requestUid = requestUid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Boolean heartbeat) {
        this.heartbeat = heartbeat;
    }

    public List<VerificationEmsBO> getData() {
        return data;
    }

    public void setData(List<VerificationEmsBO> data) {
        this.data = data;
    }
}