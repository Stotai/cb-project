package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class ReplyConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ReplyConfigCriteria() {
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

        public Criteria andExriseUserTypeIsNull() {
            addCriterion("exrise_user_type is null");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeIsNotNull() {
            addCriterion("exrise_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeEqualTo(Integer value) {
            addCriterion("exrise_user_type =", value, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeNotEqualTo(Integer value) {
            addCriterion("exrise_user_type <>", value, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeGreaterThan(Integer value) {
            addCriterion("exrise_user_type >", value, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("exrise_user_type >=", value, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeLessThan(Integer value) {
            addCriterion("exrise_user_type <", value, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("exrise_user_type <=", value, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeIn(List<Integer> values) {
            addCriterion("exrise_user_type in", values, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeNotIn(List<Integer> values) {
            addCriterion("exrise_user_type not in", values, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("exrise_user_type between", value1, value2, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("exrise_user_type not between", value1, value2, "exriseUserType");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsIsNull() {
            addCriterion("exrise_user_ids is null");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsIsNotNull() {
            addCriterion("exrise_user_ids is not null");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsEqualTo(String value) {
            addCriterion("exrise_user_ids =", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsNotEqualTo(String value) {
            addCriterion("exrise_user_ids <>", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsGreaterThan(String value) {
            addCriterion("exrise_user_ids >", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsGreaterThanOrEqualTo(String value) {
            addCriterion("exrise_user_ids >=", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsLessThan(String value) {
            addCriterion("exrise_user_ids <", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsLessThanOrEqualTo(String value) {
            addCriterion("exrise_user_ids <=", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsLike(String value) {
            addCriterion("exrise_user_ids like", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsNotLike(String value) {
            addCriterion("exrise_user_ids not like", value, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsIn(List<String> values) {
            addCriterion("exrise_user_ids in", values, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsNotIn(List<String> values) {
            addCriterion("exrise_user_ids not in", values, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsBetween(String value1, String value2) {
            addCriterion("exrise_user_ids between", value1, value2, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdsNotBetween(String value1, String value2) {
            addCriterion("exrise_user_ids not between", value1, value2, "exriseUserIds");
            return (Criteria) this;
        }

        public Criteria andCronyStautsIsNull() {
            addCriterion("crony_stauts is null");
            return (Criteria) this;
        }

        public Criteria andCronyStautsIsNotNull() {
            addCriterion("crony_stauts is not null");
            return (Criteria) this;
        }

        public Criteria andCronyStautsEqualTo(Integer value) {
            addCriterion("crony_stauts =", value, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsNotEqualTo(Integer value) {
            addCriterion("crony_stauts <>", value, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsGreaterThan(Integer value) {
            addCriterion("crony_stauts >", value, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsGreaterThanOrEqualTo(Integer value) {
            addCriterion("crony_stauts >=", value, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsLessThan(Integer value) {
            addCriterion("crony_stauts <", value, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsLessThanOrEqualTo(Integer value) {
            addCriterion("crony_stauts <=", value, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsIn(List<Integer> values) {
            addCriterion("crony_stauts in", values, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsNotIn(List<Integer> values) {
            addCriterion("crony_stauts not in", values, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsBetween(Integer value1, Integer value2) {
            addCriterion("crony_stauts between", value1, value2, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andCronyStautsNotBetween(Integer value1, Integer value2) {
            addCriterion("crony_stauts not between", value1, value2, "cronyStauts");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIsNull() {
            addCriterion("group_status is null");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIsNotNull() {
            addCriterion("group_status is not null");
            return (Criteria) this;
        }

        public Criteria andGroupStatusEqualTo(Integer value) {
            addCriterion("group_status =", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotEqualTo(Integer value) {
            addCriterion("group_status <>", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusGreaterThan(Integer value) {
            addCriterion("group_status >", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_status >=", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusLessThan(Integer value) {
            addCriterion("group_status <", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusLessThanOrEqualTo(Integer value) {
            addCriterion("group_status <=", value, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusIn(List<Integer> values) {
            addCriterion("group_status in", values, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotIn(List<Integer> values) {
            addCriterion("group_status not in", values, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusBetween(Integer value1, Integer value2) {
            addCriterion("group_status between", value1, value2, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andGroupStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("group_status not between", value1, value2, "groupStatus");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyIsNull() {
            addCriterion("reply_frequency is null");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyIsNotNull() {
            addCriterion("reply_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyEqualTo(Integer value) {
            addCriterion("reply_frequency =", value, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyNotEqualTo(Integer value) {
            addCriterion("reply_frequency <>", value, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyGreaterThan(Integer value) {
            addCriterion("reply_frequency >", value, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_frequency >=", value, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyLessThan(Integer value) {
            addCriterion("reply_frequency <", value, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("reply_frequency <=", value, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyIn(List<Integer> values) {
            addCriterion("reply_frequency in", values, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyNotIn(List<Integer> values) {
            addCriterion("reply_frequency not in", values, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("reply_frequency between", value1, value2, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andReplyFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_frequency not between", value1, value2, "replyFrequency");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusIsNull() {
            addCriterion("keywords_status is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusIsNotNull() {
            addCriterion("keywords_status is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusEqualTo(Integer value) {
            addCriterion("keywords_status =", value, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusNotEqualTo(Integer value) {
            addCriterion("keywords_status <>", value, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusGreaterThan(Integer value) {
            addCriterion("keywords_status >", value, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("keywords_status >=", value, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusLessThan(Integer value) {
            addCriterion("keywords_status <", value, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("keywords_status <=", value, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusIn(List<Integer> values) {
            addCriterion("keywords_status in", values, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusNotIn(List<Integer> values) {
            addCriterion("keywords_status not in", values, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusBetween(Integer value1, Integer value2) {
            addCriterion("keywords_status between", value1, value2, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andKeywordsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("keywords_status not between", value1, value2, "keywordsStatus");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsIsNull() {
            addCriterion("eq_keywords is null");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsIsNotNull() {
            addCriterion("eq_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsEqualTo(String value) {
            addCriterion("eq_keywords =", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsNotEqualTo(String value) {
            addCriterion("eq_keywords <>", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsGreaterThan(String value) {
            addCriterion("eq_keywords >", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("eq_keywords >=", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsLessThan(String value) {
            addCriterion("eq_keywords <", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsLessThanOrEqualTo(String value) {
            addCriterion("eq_keywords <=", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsLike(String value) {
            addCriterion("eq_keywords like", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsNotLike(String value) {
            addCriterion("eq_keywords not like", value, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsIn(List<String> values) {
            addCriterion("eq_keywords in", values, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsNotIn(List<String> values) {
            addCriterion("eq_keywords not in", values, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsBetween(String value1, String value2) {
            addCriterion("eq_keywords between", value1, value2, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andEqKeywordsNotBetween(String value1, String value2) {
            addCriterion("eq_keywords not between", value1, value2, "eqKeywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNull() {
            addCriterion("trigger_type is null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIsNotNull() {
            addCriterion("trigger_type is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeEqualTo(String value) {
            addCriterion("trigger_type =", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotEqualTo(String value) {
            addCriterion("trigger_type <>", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThan(String value) {
            addCriterion("trigger_type >", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_type >=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThan(String value) {
            addCriterion("trigger_type <", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLessThanOrEqualTo(String value) {
            addCriterion("trigger_type <=", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeLike(String value) {
            addCriterion("trigger_type like", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotLike(String value) {
            addCriterion("trigger_type not like", value, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeIn(List<String> values) {
            addCriterion("trigger_type in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotIn(List<String> values) {
            addCriterion("trigger_type not in", values, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeBetween(String value1, String value2) {
            addCriterion("trigger_type between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andTriggerTypeNotBetween(String value1, String value2) {
            addCriterion("trigger_type not between", value1, value2, "triggerType");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andCronyGroupSelfStautsIsNull() {
            addCriterion("crony_group_self_stauts is null");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsIsNotNull() {
            addCriterion("crony_group_self_stauts is not null");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsEqualTo(Integer value) {
            addCriterion("crony_group_self_stauts =", value, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsNotEqualTo(Integer value) {
            addCriterion("crony_group_self_stauts <>", value, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsGreaterThan(Integer value) {
            addCriterion("crony_group_self_stauts >", value, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsGreaterThanOrEqualTo(Integer value) {
            addCriterion("crony_group_self_stauts >=", value, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsLessThan(Integer value) {
            addCriterion("crony_group_self_stauts <", value, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsLessThanOrEqualTo(Integer value) {
            addCriterion("crony_group_self_stauts <=", value, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsIn(List<Integer> values) {
            addCriterion("crony_group_self_stauts in", values, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsNotIn(List<Integer> values) {
            addCriterion("crony_group_self_stauts not in", values, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsBetween(Integer value1, Integer value2) {
            addCriterion("crony_group_self_stauts between", value1, value2, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andCronyGroupSelfStautsNotBetween(Integer value1, Integer value2) {
            addCriterion("crony_group_self_stauts not between", value1, value2, "cronyGroupSelfStauts");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNull() {
            addCriterion("reply_type is null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNotNull() {
            addCriterion("reply_type is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeEqualTo(Integer value) {
            addCriterion("reply_type =", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotEqualTo(Integer value) {
            addCriterion("reply_type <>", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThan(Integer value) {
            addCriterion("reply_type >", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_type >=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThan(Integer value) {
            addCriterion("reply_type <", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reply_type <=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIn(List<Integer> values) {
            addCriterion("reply_type in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotIn(List<Integer> values) {
            addCriterion("reply_type not in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeBetween(Integer value1, Integer value2) {
            addCriterion("reply_type between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_type not between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNull() {
            addCriterion("reply_content is null");
            return (Criteria) this;
        }

        public Criteria andReplyContentIsNotNull() {
            addCriterion("reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andReplyContentEqualTo(String value) {
            addCriterion("reply_content =", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotEqualTo(String value) {
            addCriterion("reply_content <>", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThan(String value) {
            addCriterion("reply_content >", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("reply_content >=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThan(String value) {
            addCriterion("reply_content <", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLessThanOrEqualTo(String value) {
            addCriterion("reply_content <=", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentLike(String value) {
            addCriterion("reply_content like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotLike(String value) {
            addCriterion("reply_content not like", value, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentIn(List<String> values) {
            addCriterion("reply_content in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotIn(List<String> values) {
            addCriterion("reply_content not in", values, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentBetween(String value1, String value2) {
            addCriterion("reply_content between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyContentNotBetween(String value1, String value2) {
            addCriterion("reply_content not between", value1, value2, "replyContent");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNull() {
            addCriterion("reply_status is null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIsNotNull() {
            addCriterion("reply_status is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStatusEqualTo(Integer value) {
            addCriterion("reply_status =", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotEqualTo(Integer value) {
            addCriterion("reply_status <>", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThan(Integer value) {
            addCriterion("reply_status >", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_status >=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThan(Integer value) {
            addCriterion("reply_status <", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("reply_status <=", value, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusIn(List<Integer> values) {
            addCriterion("reply_status in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotIn(List<Integer> values) {
            addCriterion("reply_status not in", values, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusBetween(Integer value1, Integer value2) {
            addCriterion("reply_status between", value1, value2, "replyStatus");
            return (Criteria) this;
        }

        public Criteria andReplyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_status not between", value1, value2, "replyStatus");
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