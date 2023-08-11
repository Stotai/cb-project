package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class ZombieConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ZombieConfigCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andConfigIdIsNull() {
            addCriterion("config_id is null");
            return (Criteria) this;
        }

        public Criteria andConfigIdIsNotNull() {
            addCriterion("config_id is not null");
            return (Criteria) this;
        }

        public Criteria andConfigIdEqualTo(Integer value) {
            addCriterion("config_id =", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdNotEqualTo(Integer value) {
            addCriterion("config_id <>", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdGreaterThan(Integer value) {
            addCriterion("config_id >", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("config_id >=", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdLessThan(Integer value) {
            addCriterion("config_id <", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("config_id <=", value, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdIn(List<Integer> values) {
            addCriterion("config_id in", values, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdNotIn(List<Integer> values) {
            addCriterion("config_id not in", values, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("config_id between", value1, value2, "configId");
            return (Criteria) this;
        }

        public Criteria andConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("config_id not between", value1, value2, "configId");
            return (Criteria) this;
        }

        public Criteria andAutoStatusIsNull() {
            addCriterion("auto_status is null");
            return (Criteria) this;
        }

        public Criteria andAutoStatusIsNotNull() {
            addCriterion("auto_status is not null");
            return (Criteria) this;
        }

        public Criteria andAutoStatusEqualTo(Integer value) {
            addCriterion("auto_status =", value, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusNotEqualTo(Integer value) {
            addCriterion("auto_status <>", value, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusGreaterThan(Integer value) {
            addCriterion("auto_status >", value, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_status >=", value, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusLessThan(Integer value) {
            addCriterion("auto_status <", value, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("auto_status <=", value, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusIn(List<Integer> values) {
            addCriterion("auto_status in", values, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusNotIn(List<Integer> values) {
            addCriterion("auto_status not in", values, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusBetween(Integer value1, Integer value2) {
            addCriterion("auto_status between", value1, value2, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andAutoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_status not between", value1, value2, "autoStatus");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNull() {
            addCriterion("last_time is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNotNull() {
            addCriterion("last_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeEqualTo(String value) {
            addCriterion("last_time =", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotEqualTo(String value) {
            addCriterion("last_time <>", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThan(String value) {
            addCriterion("last_time >", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(String value) {
            addCriterion("last_time >=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThan(String value) {
            addCriterion("last_time <", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(String value) {
            addCriterion("last_time <=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLike(String value) {
            addCriterion("last_time like", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotLike(String value) {
            addCriterion("last_time not like", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIn(List<String> values) {
            addCriterion("last_time in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotIn(List<String> values) {
            addCriterion("last_time not in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeBetween(String value1, String value2) {
            addCriterion("last_time between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotBetween(String value1, String value2) {
            addCriterion("last_time not between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIsNull() {
            addCriterion("msg_status is null");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIsNotNull() {
            addCriterion("msg_status is not null");
            return (Criteria) this;
        }

        public Criteria andMsgStatusEqualTo(Integer value) {
            addCriterion("msg_status =", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotEqualTo(Integer value) {
            addCriterion("msg_status <>", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusGreaterThan(Integer value) {
            addCriterion("msg_status >", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_status >=", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusLessThan(Integer value) {
            addCriterion("msg_status <", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusLessThanOrEqualTo(Integer value) {
            addCriterion("msg_status <=", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIn(List<Integer> values) {
            addCriterion("msg_status in", values, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotIn(List<Integer> values) {
            addCriterion("msg_status not in", values, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusBetween(Integer value1, Integer value2) {
            addCriterion("msg_status between", value1, value2, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_status not between", value1, value2, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSIsNull() {
            addCriterion("delete_unit_s is null");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSIsNotNull() {
            addCriterion("delete_unit_s is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSEqualTo(Integer value) {
            addCriterion("delete_unit_s =", value, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSNotEqualTo(Integer value) {
            addCriterion("delete_unit_s <>", value, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSGreaterThan(Integer value) {
            addCriterion("delete_unit_s >", value, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_unit_s >=", value, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSLessThan(Integer value) {
            addCriterion("delete_unit_s <", value, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSLessThanOrEqualTo(Integer value) {
            addCriterion("delete_unit_s <=", value, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSIn(List<Integer> values) {
            addCriterion("delete_unit_s in", values, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSNotIn(List<Integer> values) {
            addCriterion("delete_unit_s not in", values, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSBetween(Integer value1, Integer value2) {
            addCriterion("delete_unit_s between", value1, value2, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitSNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_unit_s not between", value1, value2, "deleteUnitS");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitEIsNull() {
            addCriterion("delete_unit_e is null");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitEIsNotNull() {
            addCriterion("delete_unit_e is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitEEqualTo(Integer value) {
            addCriterion("delete_unit_e =", value, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitENotEqualTo(Integer value) {
            addCriterion("delete_unit_e <>", value, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitEGreaterThan(Integer value) {
            addCriterion("delete_unit_e >", value, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitEGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_unit_e >=", value, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitELessThan(Integer value) {
            addCriterion("delete_unit_e <", value, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitELessThanOrEqualTo(Integer value) {
            addCriterion("delete_unit_e <=", value, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitEIn(List<Integer> values) {
            addCriterion("delete_unit_e in", values, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitENotIn(List<Integer> values) {
            addCriterion("delete_unit_e not in", values, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitEBetween(Integer value1, Integer value2) {
            addCriterion("delete_unit_e between", value1, value2, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andDeleteUnitENotBetween(Integer value1, Integer value2) {
            addCriterion("delete_unit_e not between", value1, value2, "deleteUnitE");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAddContentIsNull() {
            addCriterion("add_content is null");
            return (Criteria) this;
        }

        public Criteria andAddContentIsNotNull() {
            addCriterion("add_content is not null");
            return (Criteria) this;
        }

        public Criteria andAddContentEqualTo(String value) {
            addCriterion("add_content =", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentNotEqualTo(String value) {
            addCriterion("add_content <>", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentGreaterThan(String value) {
            addCriterion("add_content >", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentGreaterThanOrEqualTo(String value) {
            addCriterion("add_content >=", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentLessThan(String value) {
            addCriterion("add_content <", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentLessThanOrEqualTo(String value) {
            addCriterion("add_content <=", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentLike(String value) {
            addCriterion("add_content like", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentNotLike(String value) {
            addCriterion("add_content not like", value, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentIn(List<String> values) {
            addCriterion("add_content in", values, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentNotIn(List<String> values) {
            addCriterion("add_content not in", values, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentBetween(String value1, String value2) {
            addCriterion("add_content between", value1, value2, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddContentNotBetween(String value1, String value2) {
            addCriterion("add_content not between", value1, value2, "addContent");
            return (Criteria) this;
        }

        public Criteria andAddUnitSIsNull() {
            addCriterion("add_unit_s is null");
            return (Criteria) this;
        }

        public Criteria andAddUnitSIsNotNull() {
            addCriterion("add_unit_s is not null");
            return (Criteria) this;
        }

        public Criteria andAddUnitSEqualTo(Integer value) {
            addCriterion("add_unit_s =", value, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSNotEqualTo(Integer value) {
            addCriterion("add_unit_s <>", value, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSGreaterThan(Integer value) {
            addCriterion("add_unit_s >", value, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_unit_s >=", value, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSLessThan(Integer value) {
            addCriterion("add_unit_s <", value, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSLessThanOrEqualTo(Integer value) {
            addCriterion("add_unit_s <=", value, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSIn(List<Integer> values) {
            addCriterion("add_unit_s in", values, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSNotIn(List<Integer> values) {
            addCriterion("add_unit_s not in", values, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSBetween(Integer value1, Integer value2) {
            addCriterion("add_unit_s between", value1, value2, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitSNotBetween(Integer value1, Integer value2) {
            addCriterion("add_unit_s not between", value1, value2, "addUnitS");
            return (Criteria) this;
        }

        public Criteria andAddUnitEIsNull() {
            addCriterion("add_unit_e is null");
            return (Criteria) this;
        }

        public Criteria andAddUnitEIsNotNull() {
            addCriterion("add_unit_e is not null");
            return (Criteria) this;
        }

        public Criteria andAddUnitEEqualTo(Integer value) {
            addCriterion("add_unit_e =", value, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitENotEqualTo(Integer value) {
            addCriterion("add_unit_e <>", value, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitEGreaterThan(Integer value) {
            addCriterion("add_unit_e >", value, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitEGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_unit_e >=", value, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitELessThan(Integer value) {
            addCriterion("add_unit_e <", value, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitELessThanOrEqualTo(Integer value) {
            addCriterion("add_unit_e <=", value, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitEIn(List<Integer> values) {
            addCriterion("add_unit_e in", values, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitENotIn(List<Integer> values) {
            addCriterion("add_unit_e not in", values, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitEBetween(Integer value1, Integer value2) {
            addCriterion("add_unit_e between", value1, value2, "addUnitE");
            return (Criteria) this;
        }

        public Criteria andAddUnitENotBetween(Integer value1, Integer value2) {
            addCriterion("add_unit_e not between", value1, value2, "addUnitE");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}