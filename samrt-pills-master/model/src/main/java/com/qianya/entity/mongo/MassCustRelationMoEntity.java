package com.qianya.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *  群发用户关联记录
 */
@Document(collection = "mass_cust_relation")
public class MassCustRelationMoEntity {

    @Id
    private Long recordId;

    //群发类型 1 好友 2群聊
    @Field("work_type")
    private Integer workType;

    //群发好友id/群聊id
    @Field("work_id")
    private String workId;
    //群发主键id
    @Field("mass_id")
    private Integer massId;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Integer getMassId() {
        return massId;
    }

    public void setMassId(Integer massId) {
        this.massId = massId;
    }


}
