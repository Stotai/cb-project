package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class MassSendingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MassSendingCriteria() {
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

        public Criteria andMassIdIsNull() {
            addCriterion("mass_id is null");
            return (Criteria) this;
        }

        public Criteria andMassIdIsNotNull() {
            addCriterion("mass_id is not null");
            return (Criteria) this;
        }

        public Criteria andMassIdEqualTo(Integer value) {
            addCriterion("mass_id =", value, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdNotEqualTo(Integer value) {
            addCriterion("mass_id <>", value, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdGreaterThan(Integer value) {
            addCriterion("mass_id >", value, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mass_id >=", value, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdLessThan(Integer value) {
            addCriterion("mass_id <", value, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdLessThanOrEqualTo(Integer value) {
            addCriterion("mass_id <=", value, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdIn(List<Integer> values) {
            addCriterion("mass_id in", values, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdNotIn(List<Integer> values) {
            addCriterion("mass_id not in", values, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdBetween(Integer value1, Integer value2) {
            addCriterion("mass_id between", value1, value2, "massId");
            return (Criteria) this;
        }

        public Criteria andMassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mass_id not between", value1, value2, "massId");
            return (Criteria) this;
        }

        public Criteria andMassNameIsNull() {
            addCriterion("mass_name is null");
            return (Criteria) this;
        }

        public Criteria andMassNameIsNotNull() {
            addCriterion("mass_name is not null");
            return (Criteria) this;
        }

        public Criteria andMassNameEqualTo(String value) {
            addCriterion("mass_name =", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameNotEqualTo(String value) {
            addCriterion("mass_name <>", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameGreaterThan(String value) {
            addCriterion("mass_name >", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameGreaterThanOrEqualTo(String value) {
            addCriterion("mass_name >=", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameLessThan(String value) {
            addCriterion("mass_name <", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameLessThanOrEqualTo(String value) {
            addCriterion("mass_name <=", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameLike(String value) {
            addCriterion("mass_name like", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameNotLike(String value) {
            addCriterion("mass_name not like", value, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameIn(List<String> values) {
            addCriterion("mass_name in", values, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameNotIn(List<String> values) {
            addCriterion("mass_name not in", values, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameBetween(String value1, String value2) {
            addCriterion("mass_name between", value1, value2, "massName");
            return (Criteria) this;
        }

        public Criteria andMassNameNotBetween(String value1, String value2) {
            addCriterion("mass_name not between", value1, value2, "massName");
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

        public Criteria andExexriseUserIdIsNull() {
            addCriterion("exexrise_user_id is null");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdIsNotNull() {
            addCriterion("exexrise_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdEqualTo(String value) {
            addCriterion("exexrise_user_id =", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdNotEqualTo(String value) {
            addCriterion("exexrise_user_id <>", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdGreaterThan(String value) {
            addCriterion("exexrise_user_id >", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("exexrise_user_id >=", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdLessThan(String value) {
            addCriterion("exexrise_user_id <", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdLessThanOrEqualTo(String value) {
            addCriterion("exexrise_user_id <=", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdLike(String value) {
            addCriterion("exexrise_user_id like", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdNotLike(String value) {
            addCriterion("exexrise_user_id not like", value, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdIn(List<String> values) {
            addCriterion("exexrise_user_id in", values, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdNotIn(List<String> values) {
            addCriterion("exexrise_user_id not in", values, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdBetween(String value1, String value2) {
            addCriterion("exexrise_user_id between", value1, value2, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andExexriseUserIdNotBetween(String value1, String value2) {
            addCriterion("exexrise_user_id not between", value1, value2, "exexriseUserId");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeIsNull() {
            addCriterion("mass_common_type is null");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeIsNotNull() {
            addCriterion("mass_common_type is not null");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeEqualTo(Integer value) {
            addCriterion("mass_common_type =", value, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeNotEqualTo(Integer value) {
            addCriterion("mass_common_type <>", value, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeGreaterThan(Integer value) {
            addCriterion("mass_common_type >", value, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mass_common_type >=", value, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeLessThan(Integer value) {
            addCriterion("mass_common_type <", value, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeLessThanOrEqualTo(Integer value) {
            addCriterion("mass_common_type <=", value, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeIn(List<Integer> values) {
            addCriterion("mass_common_type in", values, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeNotIn(List<Integer> values) {
            addCriterion("mass_common_type not in", values, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeBetween(Integer value1, Integer value2) {
            addCriterion("mass_common_type between", value1, value2, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andMassCommonTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mass_common_type not between", value1, value2, "massCommonType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("send_type is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("send_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(Integer value) {
            addCriterion("send_type =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(Integer value) {
            addCriterion("send_type <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(Integer value) {
            addCriterion("send_type >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_type >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(Integer value) {
            addCriterion("send_type <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("send_type <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<Integer> values) {
            addCriterion("send_type in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<Integer> values) {
            addCriterion("send_type not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(Integer value1, Integer value2) {
            addCriterion("send_type between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("send_type not between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeIsNull() {
            addCriterion("unit_send_time is null");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeIsNotNull() {
            addCriterion("unit_send_time is not null");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeEqualTo(String value) {
            addCriterion("unit_send_time =", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeNotEqualTo(String value) {
            addCriterion("unit_send_time <>", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeGreaterThan(String value) {
            addCriterion("unit_send_time >", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_send_time >=", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeLessThan(String value) {
            addCriterion("unit_send_time <", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeLessThanOrEqualTo(String value) {
            addCriterion("unit_send_time <=", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeLike(String value) {
            addCriterion("unit_send_time like", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeNotLike(String value) {
            addCriterion("unit_send_time not like", value, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeIn(List<String> values) {
            addCriterion("unit_send_time in", values, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeNotIn(List<String> values) {
            addCriterion("unit_send_time not in", values, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeBetween(String value1, String value2) {
            addCriterion("unit_send_time between", value1, value2, "unitSendTime");
            return (Criteria) this;
        }

        public Criteria andUnitSendTimeNotBetween(String value1, String value2) {
            addCriterion("unit_send_time not between", value1, value2, "unitSendTime");
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

        public Criteria andMassContentIsNull() {
            addCriterion("mass_content is null");
            return (Criteria) this;
        }

        public Criteria andMassContentIsNotNull() {
            addCriterion("mass_content is not null");
            return (Criteria) this;
        }

        public Criteria andMassContentEqualTo(String value) {
            addCriterion("mass_content =", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentNotEqualTo(String value) {
            addCriterion("mass_content <>", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentGreaterThan(String value) {
            addCriterion("mass_content >", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentGreaterThanOrEqualTo(String value) {
            addCriterion("mass_content >=", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentLessThan(String value) {
            addCriterion("mass_content <", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentLessThanOrEqualTo(String value) {
            addCriterion("mass_content <=", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentLike(String value) {
            addCriterion("mass_content like", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentNotLike(String value) {
            addCriterion("mass_content not like", value, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentIn(List<String> values) {
            addCriterion("mass_content in", values, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentNotIn(List<String> values) {
            addCriterion("mass_content not in", values, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentBetween(String value1, String value2) {
            addCriterion("mass_content between", value1, value2, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassContentNotBetween(String value1, String value2) {
            addCriterion("mass_content not between", value1, value2, "massContent");
            return (Criteria) this;
        }

        public Criteria andMassTimeIsNull() {
            addCriterion("mass_time is null");
            return (Criteria) this;
        }

        public Criteria andMassTimeIsNotNull() {
            addCriterion("mass_time is not null");
            return (Criteria) this;
        }

        public Criteria andMassTimeEqualTo(String value) {
            addCriterion("mass_time =", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeNotEqualTo(String value) {
            addCriterion("mass_time <>", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeGreaterThan(String value) {
            addCriterion("mass_time >", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeGreaterThanOrEqualTo(String value) {
            addCriterion("mass_time >=", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeLessThan(String value) {
            addCriterion("mass_time <", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeLessThanOrEqualTo(String value) {
            addCriterion("mass_time <=", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeLike(String value) {
            addCriterion("mass_time like", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeNotLike(String value) {
            addCriterion("mass_time not like", value, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeIn(List<String> values) {
            addCriterion("mass_time in", values, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeNotIn(List<String> values) {
            addCriterion("mass_time not in", values, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeBetween(String value1, String value2) {
            addCriterion("mass_time between", value1, value2, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTimeNotBetween(String value1, String value2) {
            addCriterion("mass_time not between", value1, value2, "massTime");
            return (Criteria) this;
        }

        public Criteria andMassTypeIsNull() {
            addCriterion("mass_type is null");
            return (Criteria) this;
        }

        public Criteria andMassTypeIsNotNull() {
            addCriterion("mass_type is not null");
            return (Criteria) this;
        }

        public Criteria andMassTypeEqualTo(Integer value) {
            addCriterion("mass_type =", value, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeNotEqualTo(Integer value) {
            addCriterion("mass_type <>", value, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeGreaterThan(Integer value) {
            addCriterion("mass_type >", value, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mass_type >=", value, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeLessThan(Integer value) {
            addCriterion("mass_type <", value, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeLessThanOrEqualTo(Integer value) {
            addCriterion("mass_type <=", value, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeIn(List<Integer> values) {
            addCriterion("mass_type in", values, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeNotIn(List<Integer> values) {
            addCriterion("mass_type not in", values, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeBetween(Integer value1, Integer value2) {
            addCriterion("mass_type between", value1, value2, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mass_type not between", value1, value2, "massType");
            return (Criteria) this;
        }

        public Criteria andMassTimesIsNull() {
            addCriterion("mass_times is null");
            return (Criteria) this;
        }

        public Criteria andMassTimesIsNotNull() {
            addCriterion("mass_times is not null");
            return (Criteria) this;
        }

        public Criteria andMassTimesEqualTo(String value) {
            addCriterion("mass_times =", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesNotEqualTo(String value) {
            addCriterion("mass_times <>", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesGreaterThan(String value) {
            addCriterion("mass_times >", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesGreaterThanOrEqualTo(String value) {
            addCriterion("mass_times >=", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesLessThan(String value) {
            addCriterion("mass_times <", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesLessThanOrEqualTo(String value) {
            addCriterion("mass_times <=", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesLike(String value) {
            addCriterion("mass_times like", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesNotLike(String value) {
            addCriterion("mass_times not like", value, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesIn(List<String> values) {
            addCriterion("mass_times in", values, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesNotIn(List<String> values) {
            addCriterion("mass_times not in", values, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesBetween(String value1, String value2) {
            addCriterion("mass_times between", value1, value2, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassTimesNotBetween(String value1, String value2) {
            addCriterion("mass_times not between", value1, value2, "massTimes");
            return (Criteria) this;
        }

        public Criteria andMassIntervalIsNull() {
            addCriterion("mass_interval is null");
            return (Criteria) this;
        }

        public Criteria andMassIntervalIsNotNull() {
            addCriterion("mass_interval is not null");
            return (Criteria) this;
        }

        public Criteria andMassIntervalEqualTo(Integer value) {
            addCriterion("mass_interval =", value, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalNotEqualTo(Integer value) {
            addCriterion("mass_interval <>", value, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalGreaterThan(Integer value) {
            addCriterion("mass_interval >", value, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("mass_interval >=", value, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalLessThan(Integer value) {
            addCriterion("mass_interval <", value, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("mass_interval <=", value, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalIn(List<Integer> values) {
            addCriterion("mass_interval in", values, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalNotIn(List<Integer> values) {
            addCriterion("mass_interval not in", values, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalBetween(Integer value1, Integer value2) {
            addCriterion("mass_interval between", value1, value2, "massInterval");
            return (Criteria) this;
        }

        public Criteria andMassIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("mass_interval not between", value1, value2, "massInterval");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitIsNull() {
            addCriterion("interval_unit is null");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitIsNotNull() {
            addCriterion("interval_unit is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitEqualTo(Integer value) {
            addCriterion("interval_unit =", value, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitNotEqualTo(Integer value) {
            addCriterion("interval_unit <>", value, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitGreaterThan(Integer value) {
            addCriterion("interval_unit >", value, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("interval_unit >=", value, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitLessThan(Integer value) {
            addCriterion("interval_unit <", value, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitLessThanOrEqualTo(Integer value) {
            addCriterion("interval_unit <=", value, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitIn(List<Integer> values) {
            addCriterion("interval_unit in", values, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitNotIn(List<Integer> values) {
            addCriterion("interval_unit not in", values, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitBetween(Integer value1, Integer value2) {
            addCriterion("interval_unit between", value1, value2, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andIntervalUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("interval_unit not between", value1, value2, "intervalUnit");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalIsNull() {
            addCriterion("customer_interval is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalIsNotNull() {
            addCriterion("customer_interval is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalEqualTo(String value) {
            addCriterion("customer_interval =", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalNotEqualTo(String value) {
            addCriterion("customer_interval <>", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalGreaterThan(String value) {
            addCriterion("customer_interval >", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalGreaterThanOrEqualTo(String value) {
            addCriterion("customer_interval >=", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalLessThan(String value) {
            addCriterion("customer_interval <", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalLessThanOrEqualTo(String value) {
            addCriterion("customer_interval <=", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalLike(String value) {
            addCriterion("customer_interval like", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalNotLike(String value) {
            addCriterion("customer_interval not like", value, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalIn(List<String> values) {
            addCriterion("customer_interval in", values, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalNotIn(List<String> values) {
            addCriterion("customer_interval not in", values, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalBetween(String value1, String value2) {
            addCriterion("customer_interval between", value1, value2, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andCustomerIntervalNotBetween(String value1, String value2) {
            addCriterion("customer_interval not between", value1, value2, "customerInterval");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusIsNull() {
            addCriterion("stop_time_status is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusIsNotNull() {
            addCriterion("stop_time_status is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusEqualTo(Integer value) {
            addCriterion("stop_time_status =", value, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusNotEqualTo(Integer value) {
            addCriterion("stop_time_status <>", value, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusGreaterThan(Integer value) {
            addCriterion("stop_time_status >", value, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("stop_time_status >=", value, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusLessThan(Integer value) {
            addCriterion("stop_time_status <", value, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("stop_time_status <=", value, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusIn(List<Integer> values) {
            addCriterion("stop_time_status in", values, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusNotIn(List<Integer> values) {
            addCriterion("stop_time_status not in", values, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusBetween(Integer value1, Integer value2) {
            addCriterion("stop_time_status between", value1, value2, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("stop_time_status not between", value1, value2, "stopTimeStatus");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(String value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(String value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(String value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(String value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(String value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(String value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLike(String value) {
            addCriterion("stop_time like", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotLike(String value) {
            addCriterion("stop_time not like", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(List<String> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(List<String> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(String value1, String value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(String value1, String value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalIsNull() {
            addCriterion("mass_batch_interval is null");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalIsNotNull() {
            addCriterion("mass_batch_interval is not null");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalEqualTo(String value) {
            addCriterion("mass_batch_interval =", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalNotEqualTo(String value) {
            addCriterion("mass_batch_interval <>", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalGreaterThan(String value) {
            addCriterion("mass_batch_interval >", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalGreaterThanOrEqualTo(String value) {
            addCriterion("mass_batch_interval >=", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalLessThan(String value) {
            addCriterion("mass_batch_interval <", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalLessThanOrEqualTo(String value) {
            addCriterion("mass_batch_interval <=", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalLike(String value) {
            addCriterion("mass_batch_interval like", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalNotLike(String value) {
            addCriterion("mass_batch_interval not like", value, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalIn(List<String> values) {
            addCriterion("mass_batch_interval in", values, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalNotIn(List<String> values) {
            addCriterion("mass_batch_interval not in", values, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalBetween(String value1, String value2) {
            addCriterion("mass_batch_interval between", value1, value2, "massBatchInterval");
            return (Criteria) this;
        }

        public Criteria andMassBatchIntervalNotBetween(String value1, String value2) {
            addCriterion("mass_batch_interval not between", value1, value2, "massBatchInterval");
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

        public Criteria andMassNumIsNull() {
            addCriterion("mass_num is null");
            return (Criteria) this;
        }

        public Criteria andMassNumIsNotNull() {
            addCriterion("mass_num is not null");
            return (Criteria) this;
        }

        public Criteria andMassNumEqualTo(Integer value) {
            addCriterion("mass_num =", value, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumNotEqualTo(Integer value) {
            addCriterion("mass_num <>", value, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumGreaterThan(Integer value) {
            addCriterion("mass_num >", value, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("mass_num >=", value, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumLessThan(Integer value) {
            addCriterion("mass_num <", value, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumLessThanOrEqualTo(Integer value) {
            addCriterion("mass_num <=", value, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumIn(List<Integer> values) {
            addCriterion("mass_num in", values, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumNotIn(List<Integer> values) {
            addCriterion("mass_num not in", values, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumBetween(Integer value1, Integer value2) {
            addCriterion("mass_num between", value1, value2, "massNum");
            return (Criteria) this;
        }

        public Criteria andMassNumNotBetween(Integer value1, Integer value2) {
            addCriterion("mass_num not between", value1, value2, "massNum");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIsNull() {
            addCriterion("execute_times is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIsNotNull() {
            addCriterion("execute_times is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesEqualTo(Integer value) {
            addCriterion("execute_times =", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotEqualTo(Integer value) {
            addCriterion("execute_times <>", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesGreaterThan(Integer value) {
            addCriterion("execute_times >", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("execute_times >=", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesLessThan(Integer value) {
            addCriterion("execute_times <", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("execute_times <=", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIn(List<Integer> values) {
            addCriterion("execute_times in", values, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotIn(List<Integer> values) {
            addCriterion("execute_times not in", values, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesBetween(Integer value1, Integer value2) {
            addCriterion("execute_times between", value1, value2, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("execute_times not between", value1, value2, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIsNull() {
            addCriterion("save_type is null");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIsNotNull() {
            addCriterion("save_type is not null");
            return (Criteria) this;
        }

        public Criteria andSaveTypeEqualTo(Integer value) {
            addCriterion("save_type =", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotEqualTo(Integer value) {
            addCriterion("save_type <>", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeGreaterThan(Integer value) {
            addCriterion("save_type >", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("save_type >=", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLessThan(Integer value) {
            addCriterion("save_type <", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLessThanOrEqualTo(Integer value) {
            addCriterion("save_type <=", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIn(List<Integer> values) {
            addCriterion("save_type in", values, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotIn(List<Integer> values) {
            addCriterion("save_type not in", values, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeBetween(Integer value1, Integer value2) {
            addCriterion("save_type between", value1, value2, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("save_type not between", value1, value2, "saveType");
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