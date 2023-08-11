package com.qianya.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import sun.rmi.runtime.Log;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Document(collection = "xp_house_work_record")
public class XpHouseWorkRecordMoEntity implements Serializable {
    /**
     * <pre>
     * 记录id
     * 表字段 : xp_house_work_record.record_id
     * </pre>
     */
    @Id
    private Long recordId;

    /**
     * <pre>
     * 洗盘id
     * 表字段 : xp_house_work_record.xp_house_id
     * </pre>
     */

    @Field("xp_house_id")
    private Integer xpHouseId;

    /**
     * <pre>
     * 房源id
     * 表字段 : xp_house_work_record.house_id
     * </pre>
     */
    @Field("house_id")
    private Integer houseId;

    /**
     * <pre>
     * 记录类型(0:录音;1:跟进)
     * 表字段 : xp_house_work_record.record_type
     * </pre>
     */
    @Field("record_type")
    private Integer recordType;

    /**
     * <pre>
     * 业务id
     * 表字段 : xp_house_work_record.work_id
     * </pre>
     */
    @Field("work_id")
    private Integer workId;

    /**
     * <pre>
     * 业务时间
     * 表字段 : xp_house_work_record.work_time
     * </pre>
     */
    @Field("work_time")
    private String workTime;

    /**
     * <pre>
     * 跟进类型code
     * 表字段 : xp_house_work_record.fu_type_code
     * </pre>
     */
    @Field("fu_type_code")
    private Integer fuTypeCode;

    /**
     * <pre>
     * 跟进内容
     * 表字段 : xp_house_work_record.fu_content
     * </pre>
     */
    @Field("fu_content")
    private String fuContent;

    /**
     * <pre>
     * 跟进来源(0:探索跟进;1:销售跟进)
     * 表字段 : xp_house_work_record.fu_source
     * </pre>
     */
    @Field("fu_source")
    private Integer fuSource;

    /**
     * <pre>
     * 通话时长
     * 表字段 : xp_house_work_record.talk_time
     * </pre>
     */
    @Field("talk_time")
    private Integer talkTime;

    /**
     * <pre>
     * 通话结果( 0:未接通;1:正常接通;2:用户忙;3:拒接;4:关机;5:空号;6:语音信箱)
     * 表字段 : xp_house_work_record.talk_result
     * </pre>
     */
    @Field("talk_result")
    private Integer talkResult;

    /**
     * <pre>
     * 通话录音地址
     * 表字段 : xp_house_work_record.audio_path
     * </pre>
     */
    @Field("audio_path")
    private String audioPath;

    /**
     * <pre>
     * 创建人id
     * 表字段 : xp_house_work_record.create_id
     * </pre>
     */
    @Field("create_id")
    private Integer createId;

    /**
     * <pre>
     * 创建人姓名
     * 表字段 : xp_house_work_record.create_name
     * </pre>
     */
    @Field("create_name")
    private String createName;

    /**
     * <pre>
     * 创建人部门id
     * 表字段 : xp_house_work_record.dept_id
     * </pre>
     */
    @Field("dept_id")
    private Integer deptId;

    /**
     * <pre>
     * 创建人部门名称
     * 表字段 : xp_house_work_record.dept_name
     * </pre>
     */
    @Field("dept_name")
    private String deptName;

    /**
     * <pre>
     * 创建时间
     * 表字段 : xp_house_work_record.create_time
     * </pre>
     */
    @Field("create_time")
    private String createTime;

    /**
     *
     */
    @Field("score")
    private BigDecimal score;

    /**
     *  关联id
     */
    @Field("relevance_id")
    private Integer relevanceId;

    private static final long serialVersionUID = 1L;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    /**
     * <pre>
     * 获取：洗盘id
     * 表字段：xp_house_work_record.xp_house_id
     * </pre>
     *
     * @return xp_house_work_record.xp_house_id：洗盘id
     */
    public Integer getXpHouseId() {
        return xpHouseId;
    }

    /**
     * <pre>
     * 设置：洗盘id
     * 表字段：xp_house_work_record.xp_house_id
     * </pre>
     *
     * @param xpHouseId
     *            xp_house_work_record.xp_house_id：洗盘id
     */
    public void setXpHouseId(Integer xpHouseId) {
        this.xpHouseId = xpHouseId;
    }

    /**
     * <pre>
     * 获取：房源id
     * 表字段：xp_house_work_record.house_id
     * </pre>
     *
     * @return xp_house_work_record.house_id：房源id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     * <pre>
     * 设置：房源id
     * 表字段：xp_house_work_record.house_id
     * </pre>
     *
     * @param houseId
     *            xp_house_work_record.house_id：房源id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     * <pre>
     * 获取：记录类型(0:录音;1:跟进)
     * 表字段：xp_house_work_record.record_type
     * </pre>
     *
     * @return xp_house_work_record.record_type：记录类型(0:录音;1:跟进)
     */
    public Integer getRecordType() {
        return recordType;
    }

    /**
     * <pre>
     * 设置：记录类型(0:录音;1:跟进)
     * 表字段：xp_house_work_record.record_type
     * </pre>
     *
     * @param recordType
     *            xp_house_work_record.record_type：记录类型(0:录音;1:跟进)
     */
    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    /**
     * <pre>
     * 获取：业务id
     * 表字段：xp_house_work_record.work_id
     * </pre>
     *
     * @return xp_house_work_record.work_id：业务id
     */
    public Integer getWorkId() {
        return workId;
    }

    /**
     * <pre>
     * 设置：业务id
     * 表字段：xp_house_work_record.work_id
     * </pre>
     *
     * @param workId
     *            xp_house_work_record.work_id：业务id
     */
    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    /**
     * <pre>
     * 获取：业务时间
     * 表字段：xp_house_work_record.work_time
     * </pre>
     *
     * @return xp_house_work_record.work_time：业务时间
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * <pre>
     * 设置：业务时间
     * 表字段：xp_house_work_record.work_time
     * </pre>
     *
     * @param workTime
     *            xp_house_work_record.work_time：业务时间
     */
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    /**
     * <pre>
     * 获取：跟进类型code
     * 表字段：xp_house_work_record.fu_type_code
     * </pre>
     *
     * @return xp_house_work_record.fu_type_code：跟进类型code
     */
    public Integer getFuTypeCode() {
        return fuTypeCode;
    }

    /**
     * <pre>
     * 设置：跟进类型code
     * 表字段：xp_house_work_record.fu_type_code
     * </pre>
     *
     * @param fuTypeCode
     *            xp_house_work_record.fu_type_code：跟进类型code
     */
    public void setFuTypeCode(Integer fuTypeCode) {
        this.fuTypeCode = fuTypeCode;
    }

    /**
     * <pre>
     * 获取：跟进内容
     * 表字段：xp_house_work_record.fu_content
     * </pre>
     *
     * @return xp_house_work_record.fu_content：跟进内容
     */
    public String getFuContent() {
        return fuContent;
    }

    /**
     * <pre>
     * 设置：跟进内容
     * 表字段：xp_house_work_record.fu_content
     * </pre>
     *
     * @param fuContent
     *            xp_house_work_record.fu_content：跟进内容
     */
    public void setFuContent(String fuContent) {
        this.fuContent = fuContent;
    }

    /**
     * <pre>
     * 获取：跟进来源(0:探索跟进;1:销售跟进)
     * 表字段：xp_house_work_record.fu_source
     * </pre>
     *
     * @return xp_house_work_record.fu_source：跟进来源(0:探索跟进;1:销售跟进)
     */
    public Integer getFuSource() {
        return fuSource;
    }

    /**
     * <pre>
     * 设置：跟进来源(0:探索跟进;1:销售跟进)
     * 表字段：xp_house_work_record.fu_source
     * </pre>
     *
     * @param fuSource
     *            xp_house_work_record.fu_source：跟进来源(0:探索跟进;1:销售跟进)
     */
    public void setFuSource(Integer fuSource) {
        this.fuSource = fuSource;
    }

    /**
     * <pre>
     * 获取：通话时长
     * 表字段：xp_house_work_record.talk_time
     * </pre>
     *
     * @return xp_house_work_record.talk_time：通话时长
     */
    public Integer getTalkTime() {
        return talkTime;
    }

    /**
     * <pre>
     * 设置：通话时长
     * 表字段：xp_house_work_record.talk_time
     * </pre>
     *
     * @param talkTime
     *            xp_house_work_record.talk_time：通话时长
     */
    public void setTalkTime(Integer talkTime) {
        this.talkTime = talkTime;
    }

    /**
     * <pre>
     * 获取：通话结果( 0:未接通;1:正常接通;2:用户忙;3:拒接;4:关机;5:空号;6:语音信箱)
     * 表字段：xp_house_work_record.talk_result
     * </pre>
     *
     * @return xp_house_work_record.talk_result：通话结果( 0:未接通;1:正常接通;2:用户忙;3:拒接;4:关机;5:空号;6:语音信箱)
     */
    public Integer getTalkResult() {
        return talkResult;
    }

    /**
     * <pre>
     * 设置：通话结果( 0:未接通;1:正常接通;2:用户忙;3:拒接;4:关机;5:空号;6:语音信箱)
     * 表字段：xp_house_work_record.talk_result
     * </pre>
     *
     * @param talkResult
     *            xp_house_work_record.talk_result：通话结果( 0:未接通;1:正常接通;2:用户忙;3:拒接;4:关机;5:空号;6:语音信箱)
     */
    public void setTalkResult(Integer talkResult) {
        this.talkResult = talkResult;
    }

    /**
     * <pre>
     * 获取：通话录音地址
     * 表字段：xp_house_work_record.audio_path
     * </pre>
     *
     * @return xp_house_work_record.audio_path：通话录音地址
     */
    public String getAudioPath() {
        return audioPath;
    }

    /**
     * <pre>
     * 设置：通话录音地址
     * 表字段：xp_house_work_record.audio_path
     * </pre>
     *
     * @param audioPath
     *            xp_house_work_record.audio_path：通话录音地址
     */
    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    /**
     * <pre>
     * 获取：创建人id
     * 表字段：xp_house_work_record.create_id
     * </pre>
     *
     * @return xp_house_work_record.create_id：创建人id
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * <pre>
     * 设置：创建人id
     * 表字段：xp_house_work_record.create_id
     * </pre>
     *
     * @param createId
     *            xp_house_work_record.create_id：创建人id
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * <pre>
     * 获取：创建人姓名
     * 表字段：xp_house_work_record.create_name
     * </pre>
     *
     * @return xp_house_work_record.create_name：创建人姓名
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * <pre>
     * 设置：创建人姓名
     * 表字段：xp_house_work_record.create_name
     * </pre>
     *
     * @param createName
     *            xp_house_work_record.create_name：创建人姓名
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * <pre>
     * 获取：创建人部门id
     * 表字段：xp_house_work_record.dept_id
     * </pre>
     *
     * @return xp_house_work_record.dept_id：创建人部门id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * <pre>
     * 设置：创建人部门id
     * 表字段：xp_house_work_record.dept_id
     * </pre>
     *
     * @param deptId
     *            xp_house_work_record.dept_id：创建人部门id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * <pre>
     * 获取：创建人部门名称
     * 表字段：xp_house_work_record.dept_name
     * </pre>
     *
     * @return xp_house_work_record.dept_name：创建人部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * <pre>
     * 设置：创建人部门名称
     * 表字段：xp_house_work_record.dept_name
     * </pre>
     *
     * @param deptName
     *            xp_house_work_record.dept_name：创建人部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：xp_house_work_record.create_time
     * </pre>
     *
     * @return xp_house_work_record.create_time：创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：xp_house_work_record.create_time
     * </pre>
     *
     * @param createTime
     *            xp_house_work_record.create_time：创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getRelevanceId() {
        return relevanceId;
    }

    public void setRelevanceId(Integer relevanceId) {
        this.relevanceId = relevanceId;
    }
}