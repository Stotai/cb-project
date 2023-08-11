package com.qianya.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "sys_oper_log")
public class SysOperLogMoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * <pre>
     * 记录id
     * 表字段 : xp_house_work_record.record_id
     * </pre>
     */

    /**
     * 日志主键
     */
    @Id
    private Long operId;

    /**
     * 操作模块
     */
    @Field("oper_service")
    private String operService;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @Field("business_type")
    private Integer businessType;

    /**
     * 请求方法
     */
    @Field("method")
    private String method;

    /**
     * 请求方式
     */
    @Field("request_method")
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @Field("operator_type")
    private Integer operatorType;

    /**
     * 操作人员
     */
    @Field("oper_user_id")
    private Integer operUserId;
     /*
     * 操作人员手机
     */
    @Field("oper_user_name")
    private String operUserName;


    /**
     * 请求url
     */
    @Field("oper_url")
    private String operUrl;

    /**
     * 操作地址
     */
    @Field("oper_ip")
    private String operIp;

    /**
     * 请求参数
     */
    @Field("oper_param")
    private String operParam;

    /**
     * 返回参数
     */
    @Field("json_result")
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    @Field("status")
    private Integer status;

    /**
     * 错误消息
     */
    @Field("error_msg")
    private String errorMsg;

    /**
     * 操作时间
     */
    @Field("oper_time")
    private String operTime;


    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }


    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getOperService() {
        return operService;
    }

    public void setOperService(String operService) {
        this.operService = operService;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public Integer getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(Integer operUserId) {
        this.operUserId = operUserId;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }
}