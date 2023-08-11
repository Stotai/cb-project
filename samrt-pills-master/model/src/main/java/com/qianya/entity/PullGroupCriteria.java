package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class PullGroupCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public PullGroupCriteria() {
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

        public Criteria andPullIdIsNull() {
            addCriterion("pull_id is null");
            return (Criteria) this;
        }

        public Criteria andPullIdIsNotNull() {
            addCriterion("pull_id is not null");
            return (Criteria) this;
        }

        public Criteria andPullIdEqualTo(Integer value) {
            addCriterion("pull_id =", value, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdNotEqualTo(Integer value) {
            addCriterion("pull_id <>", value, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdGreaterThan(Integer value) {
            addCriterion("pull_id >", value, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pull_id >=", value, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdLessThan(Integer value) {
            addCriterion("pull_id <", value, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdLessThanOrEqualTo(Integer value) {
            addCriterion("pull_id <=", value, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdIn(List<Integer> values) {
            addCriterion("pull_id in", values, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdNotIn(List<Integer> values) {
            addCriterion("pull_id not in", values, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdBetween(Integer value1, Integer value2) {
            addCriterion("pull_id between", value1, value2, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pull_id not between", value1, value2, "pullId");
            return (Criteria) this;
        }

        public Criteria andPullNameIsNull() {
            addCriterion("pull_name is null");
            return (Criteria) this;
        }

        public Criteria andPullNameIsNotNull() {
            addCriterion("pull_name is not null");
            return (Criteria) this;
        }

        public Criteria andPullNameEqualTo(String value) {
            addCriterion("pull_name =", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameNotEqualTo(String value) {
            addCriterion("pull_name <>", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameGreaterThan(String value) {
            addCriterion("pull_name >", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameGreaterThanOrEqualTo(String value) {
            addCriterion("pull_name >=", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameLessThan(String value) {
            addCriterion("pull_name <", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameLessThanOrEqualTo(String value) {
            addCriterion("pull_name <=", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameLike(String value) {
            addCriterion("pull_name like", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameNotLike(String value) {
            addCriterion("pull_name not like", value, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameIn(List<String> values) {
            addCriterion("pull_name in", values, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameNotIn(List<String> values) {
            addCriterion("pull_name not in", values, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameBetween(String value1, String value2) {
            addCriterion("pull_name between", value1, value2, "pullName");
            return (Criteria) this;
        }

        public Criteria andPullNameNotBetween(String value1, String value2) {
            addCriterion("pull_name not between", value1, value2, "pullName");
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

        public Criteria andExriseWxIdIsNull() {
            addCriterion("exrise_wx_id is null");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdIsNotNull() {
            addCriterion("exrise_wx_id is not null");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdEqualTo(String value) {
            addCriterion("exrise_wx_id =", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdNotEqualTo(String value) {
            addCriterion("exrise_wx_id <>", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdGreaterThan(String value) {
            addCriterion("exrise_wx_id >", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdGreaterThanOrEqualTo(String value) {
            addCriterion("exrise_wx_id >=", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdLessThan(String value) {
            addCriterion("exrise_wx_id <", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdLessThanOrEqualTo(String value) {
            addCriterion("exrise_wx_id <=", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdLike(String value) {
            addCriterion("exrise_wx_id like", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdNotLike(String value) {
            addCriterion("exrise_wx_id not like", value, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdIn(List<String> values) {
            addCriterion("exrise_wx_id in", values, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdNotIn(List<String> values) {
            addCriterion("exrise_wx_id not in", values, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdBetween(String value1, String value2) {
            addCriterion("exrise_wx_id between", value1, value2, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxIdNotBetween(String value1, String value2) {
            addCriterion("exrise_wx_id not between", value1, value2, "exriseWxId");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameIsNull() {
            addCriterion("exrise_wx_name is null");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameIsNotNull() {
            addCriterion("exrise_wx_name is not null");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameEqualTo(String value) {
            addCriterion("exrise_wx_name =", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameNotEqualTo(String value) {
            addCriterion("exrise_wx_name <>", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameGreaterThan(String value) {
            addCriterion("exrise_wx_name >", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameGreaterThanOrEqualTo(String value) {
            addCriterion("exrise_wx_name >=", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameLessThan(String value) {
            addCriterion("exrise_wx_name <", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameLessThanOrEqualTo(String value) {
            addCriterion("exrise_wx_name <=", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameLike(String value) {
            addCriterion("exrise_wx_name like", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameNotLike(String value) {
            addCriterion("exrise_wx_name not like", value, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameIn(List<String> values) {
            addCriterion("exrise_wx_name in", values, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameNotIn(List<String> values) {
            addCriterion("exrise_wx_name not in", values, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameBetween(String value1, String value2) {
            addCriterion("exrise_wx_name between", value1, value2, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andExriseWxNameNotBetween(String value1, String value2) {
            addCriterion("exrise_wx_name not between", value1, value2, "exriseWxName");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNull() {
            addCriterion("max_num is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNotNull() {
            addCriterion("max_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumEqualTo(Integer value) {
            addCriterion("max_num =", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotEqualTo(Integer value) {
            addCriterion("max_num <>", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThan(Integer value) {
            addCriterion("max_num >", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_num >=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThan(Integer value) {
            addCriterion("max_num <", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThanOrEqualTo(Integer value) {
            addCriterion("max_num <=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumIn(List<Integer> values) {
            addCriterion("max_num in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotIn(List<Integer> values) {
            addCriterion("max_num not in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumBetween(Integer value1, Integer value2) {
            addCriterion("max_num between", value1, value2, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotBetween(Integer value1, Integer value2) {
            addCriterion("max_num not between", value1, value2, "maxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumIsNull() {
            addCriterion("day_max_num is null");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumIsNotNull() {
            addCriterion("day_max_num is not null");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumEqualTo(Integer value) {
            addCriterion("day_max_num =", value, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumNotEqualTo(Integer value) {
            addCriterion("day_max_num <>", value, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumGreaterThan(Integer value) {
            addCriterion("day_max_num >", value, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_max_num >=", value, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumLessThan(Integer value) {
            addCriterion("day_max_num <", value, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumLessThanOrEqualTo(Integer value) {
            addCriterion("day_max_num <=", value, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumIn(List<Integer> values) {
            addCriterion("day_max_num in", values, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumNotIn(List<Integer> values) {
            addCriterion("day_max_num not in", values, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumBetween(Integer value1, Integer value2) {
            addCriterion("day_max_num between", value1, value2, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andDayMaxNumNotBetween(Integer value1, Integer value2) {
            addCriterion("day_max_num not between", value1, value2, "dayMaxNum");
            return (Criteria) this;
        }

        public Criteria andSendCountIsNull() {
            addCriterion("send_count is null");
            return (Criteria) this;
        }

        public Criteria andSendCountIsNotNull() {
            addCriterion("send_count is not null");
            return (Criteria) this;
        }

        public Criteria andSendCountEqualTo(Integer value) {
            addCriterion("send_count =", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountNotEqualTo(Integer value) {
            addCriterion("send_count <>", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountGreaterThan(Integer value) {
            addCriterion("send_count >", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_count >=", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountLessThan(Integer value) {
            addCriterion("send_count <", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountLessThanOrEqualTo(Integer value) {
            addCriterion("send_count <=", value, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountIn(List<Integer> values) {
            addCriterion("send_count in", values, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountNotIn(List<Integer> values) {
            addCriterion("send_count not in", values, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountBetween(Integer value1, Integer value2) {
            addCriterion("send_count between", value1, value2, "sendCount");
            return (Criteria) this;
        }

        public Criteria andSendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("send_count not between", value1, value2, "sendCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountIsNull() {
            addCriterion("complete_count is null");
            return (Criteria) this;
        }

        public Criteria andCompleteCountIsNotNull() {
            addCriterion("complete_count is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteCountEqualTo(Integer value) {
            addCriterion("complete_count =", value, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountNotEqualTo(Integer value) {
            addCriterion("complete_count <>", value, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountGreaterThan(Integer value) {
            addCriterion("complete_count >", value, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("complete_count >=", value, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountLessThan(Integer value) {
            addCriterion("complete_count <", value, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountLessThanOrEqualTo(Integer value) {
            addCriterion("complete_count <=", value, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountIn(List<Integer> values) {
            addCriterion("complete_count in", values, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountNotIn(List<Integer> values) {
            addCriterion("complete_count not in", values, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountBetween(Integer value1, Integer value2) {
            addCriterion("complete_count between", value1, value2, "completeCount");
            return (Criteria) this;
        }

        public Criteria andCompleteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("complete_count not between", value1, value2, "completeCount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andCompleteTimeIsNull() {
            addCriterion("complete_time is null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIsNotNull() {
            addCriterion("complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeEqualTo(String value) {
            addCriterion("complete_time =", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotEqualTo(String value) {
            addCriterion("complete_time <>", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThan(String value) {
            addCriterion("complete_time >", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeGreaterThanOrEqualTo(String value) {
            addCriterion("complete_time >=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThan(String value) {
            addCriterion("complete_time <", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLessThanOrEqualTo(String value) {
            addCriterion("complete_time <=", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeLike(String value) {
            addCriterion("complete_time like", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotLike(String value) {
            addCriterion("complete_time not like", value, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeIn(List<String> values) {
            addCriterion("complete_time in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotIn(List<String> values) {
            addCriterion("complete_time not in", values, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeBetween(String value1, String value2) {
            addCriterion("complete_time between", value1, value2, "completeTime");
            return (Criteria) this;
        }

        public Criteria andCompleteTimeNotBetween(String value1, String value2) {
            addCriterion("complete_time not between", value1, value2, "completeTime");
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