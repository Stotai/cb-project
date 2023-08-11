package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class PullCustRelationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public PullCustRelationCriteria() {
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

        public Criteria andPullCustIdIsNull() {
            addCriterion("pull_cust_id is null");
            return (Criteria) this;
        }

        public Criteria andPullCustIdIsNotNull() {
            addCriterion("pull_cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andPullCustIdEqualTo(Integer value) {
            addCriterion("pull_cust_id =", value, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdNotEqualTo(Integer value) {
            addCriterion("pull_cust_id <>", value, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdGreaterThan(Integer value) {
            addCriterion("pull_cust_id >", value, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pull_cust_id >=", value, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdLessThan(Integer value) {
            addCriterion("pull_cust_id <", value, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("pull_cust_id <=", value, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdIn(List<Integer> values) {
            addCriterion("pull_cust_id in", values, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdNotIn(List<Integer> values) {
            addCriterion("pull_cust_id not in", values, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdBetween(Integer value1, Integer value2) {
            addCriterion("pull_cust_id between", value1, value2, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andPullCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pull_cust_id not between", value1, value2, "pullCustId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdIsNull() {
            addCriterion("cust_wx_id is null");
            return (Criteria) this;
        }

        public Criteria andCustWxIdIsNotNull() {
            addCriterion("cust_wx_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustWxIdEqualTo(String value) {
            addCriterion("cust_wx_id =", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdNotEqualTo(String value) {
            addCriterion("cust_wx_id <>", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdGreaterThan(String value) {
            addCriterion("cust_wx_id >", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdGreaterThanOrEqualTo(String value) {
            addCriterion("cust_wx_id >=", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdLessThan(String value) {
            addCriterion("cust_wx_id <", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdLessThanOrEqualTo(String value) {
            addCriterion("cust_wx_id <=", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdLike(String value) {
            addCriterion("cust_wx_id like", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdNotLike(String value) {
            addCriterion("cust_wx_id not like", value, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdIn(List<String> values) {
            addCriterion("cust_wx_id in", values, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdNotIn(List<String> values) {
            addCriterion("cust_wx_id not in", values, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdBetween(String value1, String value2) {
            addCriterion("cust_wx_id between", value1, value2, "custWxId");
            return (Criteria) this;
        }

        public Criteria andCustWxIdNotBetween(String value1, String value2) {
            addCriterion("cust_wx_id not between", value1, value2, "custWxId");
            return (Criteria) this;
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

        public Criteria andFailMsgIsNull() {
            addCriterion("fail_msg is null");
            return (Criteria) this;
        }

        public Criteria andFailMsgIsNotNull() {
            addCriterion("fail_msg is not null");
            return (Criteria) this;
        }

        public Criteria andFailMsgEqualTo(String value) {
            addCriterion("fail_msg =", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgNotEqualTo(String value) {
            addCriterion("fail_msg <>", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgGreaterThan(String value) {
            addCriterion("fail_msg >", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgGreaterThanOrEqualTo(String value) {
            addCriterion("fail_msg >=", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgLessThan(String value) {
            addCriterion("fail_msg <", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgLessThanOrEqualTo(String value) {
            addCriterion("fail_msg <=", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgLike(String value) {
            addCriterion("fail_msg like", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgNotLike(String value) {
            addCriterion("fail_msg not like", value, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgIn(List<String> values) {
            addCriterion("fail_msg in", values, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgNotIn(List<String> values) {
            addCriterion("fail_msg not in", values, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgBetween(String value1, String value2) {
            addCriterion("fail_msg between", value1, value2, "failMsg");
            return (Criteria) this;
        }

        public Criteria andFailMsgNotBetween(String value1, String value2) {
            addCriterion("fail_msg not between", value1, value2, "failMsg");
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

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(String value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(String value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(String value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(String value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(String value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLike(String value) {
            addCriterion("send_time like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotLike(String value) {
            addCriterion("send_time not like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<String> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<String> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(String value1, String value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(String value1, String value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
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