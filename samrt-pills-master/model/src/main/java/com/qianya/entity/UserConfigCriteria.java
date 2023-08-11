package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class UserConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UserConfigCriteria() {
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

        public Criteria andWorkStartTimeIsNull() {
            addCriterion("work_start_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIsNotNull() {
            addCriterion("work_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeEqualTo(Integer value) {
            addCriterion("work_start_time =", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotEqualTo(Integer value) {
            addCriterion("work_start_time <>", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeGreaterThan(Integer value) {
            addCriterion("work_start_time >", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_start_time >=", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeLessThan(Integer value) {
            addCriterion("work_start_time <", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("work_start_time <=", value, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeIn(List<Integer> values) {
            addCriterion("work_start_time in", values, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotIn(List<Integer> values) {
            addCriterion("work_start_time not in", values, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("work_start_time between", value1, value2, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("work_start_time not between", value1, value2, "workStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNull() {
            addCriterion("work_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIsNotNull() {
            addCriterion("work_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeEqualTo(Integer value) {
            addCriterion("work_end_time =", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotEqualTo(Integer value) {
            addCriterion("work_end_time <>", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThan(Integer value) {
            addCriterion("work_end_time >", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_end_time >=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThan(Integer value) {
            addCriterion("work_end_time <", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("work_end_time <=", value, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeIn(List<Integer> values) {
            addCriterion("work_end_time in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotIn(List<Integer> values) {
            addCriterion("work_end_time not in", values, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("work_end_time between", value1, value2, "workEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("work_end_time not between", value1, value2, "workEndTime");
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

        public Criteria andWaitSecondsIsNull() {
            addCriterion("wait_seconds is null");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsIsNotNull() {
            addCriterion("wait_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsEqualTo(String value) {
            addCriterion("wait_seconds =", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotEqualTo(String value) {
            addCriterion("wait_seconds <>", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsGreaterThan(String value) {
            addCriterion("wait_seconds >", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsGreaterThanOrEqualTo(String value) {
            addCriterion("wait_seconds >=", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsLessThan(String value) {
            addCriterion("wait_seconds <", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsLessThanOrEqualTo(String value) {
            addCriterion("wait_seconds <=", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsLike(String value) {
            addCriterion("wait_seconds like", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotLike(String value) {
            addCriterion("wait_seconds not like", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsIn(List<String> values) {
            addCriterion("wait_seconds in", values, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotIn(List<String> values) {
            addCriterion("wait_seconds not in", values, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsBetween(String value1, String value2) {
            addCriterion("wait_seconds between", value1, value2, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotBetween(String value1, String value2) {
            addCriterion("wait_seconds not between", value1, value2, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsIsNull() {
            addCriterion("msg_wait_seconds is null");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsIsNotNull() {
            addCriterion("msg_wait_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsEqualTo(String value) {
            addCriterion("msg_wait_seconds =", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsNotEqualTo(String value) {
            addCriterion("msg_wait_seconds <>", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsGreaterThan(String value) {
            addCriterion("msg_wait_seconds >", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsGreaterThanOrEqualTo(String value) {
            addCriterion("msg_wait_seconds >=", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsLessThan(String value) {
            addCriterion("msg_wait_seconds <", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsLessThanOrEqualTo(String value) {
            addCriterion("msg_wait_seconds <=", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsLike(String value) {
            addCriterion("msg_wait_seconds like", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsNotLike(String value) {
            addCriterion("msg_wait_seconds not like", value, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsIn(List<String> values) {
            addCriterion("msg_wait_seconds in", values, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsNotIn(List<String> values) {
            addCriterion("msg_wait_seconds not in", values, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsBetween(String value1, String value2) {
            addCriterion("msg_wait_seconds between", value1, value2, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andMsgWaitSecondsNotBetween(String value1, String value2) {
            addCriterion("msg_wait_seconds not between", value1, value2, "msgWaitSeconds");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsIsNull() {
            addCriterion("verify_keywords is null");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsIsNotNull() {
            addCriterion("verify_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsEqualTo(String value) {
            addCriterion("verify_keywords =", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsNotEqualTo(String value) {
            addCriterion("verify_keywords <>", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsGreaterThan(String value) {
            addCriterion("verify_keywords >", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("verify_keywords >=", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsLessThan(String value) {
            addCriterion("verify_keywords <", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsLessThanOrEqualTo(String value) {
            addCriterion("verify_keywords <=", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsLike(String value) {
            addCriterion("verify_keywords like", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsNotLike(String value) {
            addCriterion("verify_keywords not like", value, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsIn(List<String> values) {
            addCriterion("verify_keywords in", values, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsNotIn(List<String> values) {
            addCriterion("verify_keywords not in", values, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsBetween(String value1, String value2) {
            addCriterion("verify_keywords between", value1, value2, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyKeywordsNotBetween(String value1, String value2) {
            addCriterion("verify_keywords not between", value1, value2, "verifyKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsIsNull() {
            addCriterion("verify_no_keywords is null");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsIsNotNull() {
            addCriterion("verify_no_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsEqualTo(String value) {
            addCriterion("verify_no_keywords =", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsNotEqualTo(String value) {
            addCriterion("verify_no_keywords <>", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsGreaterThan(String value) {
            addCriterion("verify_no_keywords >", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("verify_no_keywords >=", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsLessThan(String value) {
            addCriterion("verify_no_keywords <", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsLessThanOrEqualTo(String value) {
            addCriterion("verify_no_keywords <=", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsLike(String value) {
            addCriterion("verify_no_keywords like", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsNotLike(String value) {
            addCriterion("verify_no_keywords not like", value, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsIn(List<String> values) {
            addCriterion("verify_no_keywords in", values, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsNotIn(List<String> values) {
            addCriterion("verify_no_keywords not in", values, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsBetween(String value1, String value2) {
            addCriterion("verify_no_keywords between", value1, value2, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andVerifyNoKeywordsNotBetween(String value1, String value2) {
            addCriterion("verify_no_keywords not between", value1, value2, "verifyNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsIsNull() {
            addCriterion("nick_name_no_keywords is null");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsIsNotNull() {
            addCriterion("nick_name_no_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsEqualTo(String value) {
            addCriterion("nick_name_no_keywords =", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsNotEqualTo(String value) {
            addCriterion("nick_name_no_keywords <>", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsGreaterThan(String value) {
            addCriterion("nick_name_no_keywords >", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name_no_keywords >=", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsLessThan(String value) {
            addCriterion("nick_name_no_keywords <", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsLessThanOrEqualTo(String value) {
            addCriterion("nick_name_no_keywords <=", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsLike(String value) {
            addCriterion("nick_name_no_keywords like", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsNotLike(String value) {
            addCriterion("nick_name_no_keywords not like", value, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsIn(List<String> values) {
            addCriterion("nick_name_no_keywords in", values, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsNotIn(List<String> values) {
            addCriterion("nick_name_no_keywords not in", values, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsBetween(String value1, String value2) {
            addCriterion("nick_name_no_keywords between", value1, value2, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andNickNameNoKeywordsNotBetween(String value1, String value2) {
            addCriterion("nick_name_no_keywords not between", value1, value2, "nickNameNoKeywords");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusIsNull() {
            addCriterion("exrise_auto_status is null");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusIsNotNull() {
            addCriterion("exrise_auto_status is not null");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusEqualTo(Integer value) {
            addCriterion("exrise_auto_status =", value, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusNotEqualTo(Integer value) {
            addCriterion("exrise_auto_status <>", value, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusGreaterThan(Integer value) {
            addCriterion("exrise_auto_status >", value, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("exrise_auto_status >=", value, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusLessThan(Integer value) {
            addCriterion("exrise_auto_status <", value, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("exrise_auto_status <=", value, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusIn(List<Integer> values) {
            addCriterion("exrise_auto_status in", values, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusNotIn(List<Integer> values) {
            addCriterion("exrise_auto_status not in", values, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusBetween(Integer value1, Integer value2) {
            addCriterion("exrise_auto_status between", value1, value2, "exriseAutoStatus");
            return (Criteria) this;
        }

        public Criteria andExriseAutoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("exrise_auto_status not between", value1, value2, "exriseAutoStatus");
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