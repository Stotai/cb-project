package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class ExriseUserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ExriseUserCriteria() {
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

        public Criteria andExriseUserIdIsNull() {
            addCriterion("exrise_user_id is null");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdIsNotNull() {
            addCriterion("exrise_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdEqualTo(Integer value) {
            addCriterion("exrise_user_id =", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdNotEqualTo(Integer value) {
            addCriterion("exrise_user_id <>", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdGreaterThan(Integer value) {
            addCriterion("exrise_user_id >", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("exrise_user_id >=", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdLessThan(Integer value) {
            addCriterion("exrise_user_id <", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("exrise_user_id <=", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdIn(List<Integer> values) {
            addCriterion("exrise_user_id in", values, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdNotIn(List<Integer> values) {
            addCriterion("exrise_user_id not in", values, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdBetween(Integer value1, Integer value2) {
            addCriterion("exrise_user_id between", value1, value2, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("exrise_user_id not between", value1, value2, "exriseUserId");
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
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

        public Criteria andWxRemarkIsNull() {
            addCriterion("wx_remark is null");
            return (Criteria) this;
        }

        public Criteria andWxRemarkIsNotNull() {
            addCriterion("wx_remark is not null");
            return (Criteria) this;
        }

        public Criteria andWxRemarkEqualTo(String value) {
            addCriterion("wx_remark =", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkNotEqualTo(String value) {
            addCriterion("wx_remark <>", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkGreaterThan(String value) {
            addCriterion("wx_remark >", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("wx_remark >=", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkLessThan(String value) {
            addCriterion("wx_remark <", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkLessThanOrEqualTo(String value) {
            addCriterion("wx_remark <=", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkLike(String value) {
            addCriterion("wx_remark like", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkNotLike(String value) {
            addCriterion("wx_remark not like", value, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkIn(List<String> values) {
            addCriterion("wx_remark in", values, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkNotIn(List<String> values) {
            addCriterion("wx_remark not in", values, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkBetween(String value1, String value2) {
            addCriterion("wx_remark between", value1, value2, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andWxRemarkNotBetween(String value1, String value2) {
            addCriterion("wx_remark not between", value1, value2, "wxRemark");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlIsNull() {
            addCriterion("exrise_wx_url is null");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlIsNotNull() {
            addCriterion("exrise_wx_url is not null");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlEqualTo(String value) {
            addCriterion("exrise_wx_url =", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlNotEqualTo(String value) {
            addCriterion("exrise_wx_url <>", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlGreaterThan(String value) {
            addCriterion("exrise_wx_url >", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlGreaterThanOrEqualTo(String value) {
            addCriterion("exrise_wx_url >=", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlLessThan(String value) {
            addCriterion("exrise_wx_url <", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlLessThanOrEqualTo(String value) {
            addCriterion("exrise_wx_url <=", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlLike(String value) {
            addCriterion("exrise_wx_url like", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlNotLike(String value) {
            addCriterion("exrise_wx_url not like", value, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlIn(List<String> values) {
            addCriterion("exrise_wx_url in", values, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlNotIn(List<String> values) {
            addCriterion("exrise_wx_url not in", values, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlBetween(String value1, String value2) {
            addCriterion("exrise_wx_url between", value1, value2, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andExriseWxUrlNotBetween(String value1, String value2) {
            addCriterion("exrise_wx_url not between", value1, value2, "exriseWxUrl");
            return (Criteria) this;
        }

        public Criteria andCustomerNumIsNull() {
            addCriterion("customer_num is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNumIsNotNull() {
            addCriterion("customer_num is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNumEqualTo(Integer value) {
            addCriterion("customer_num =", value, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumNotEqualTo(Integer value) {
            addCriterion("customer_num <>", value, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumGreaterThan(Integer value) {
            addCriterion("customer_num >", value, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_num >=", value, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumLessThan(Integer value) {
            addCriterion("customer_num <", value, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumLessThanOrEqualTo(Integer value) {
            addCriterion("customer_num <=", value, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumIn(List<Integer> values) {
            addCriterion("customer_num in", values, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumNotIn(List<Integer> values) {
            addCriterion("customer_num not in", values, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumBetween(Integer value1, Integer value2) {
            addCriterion("customer_num between", value1, value2, "customerNum");
            return (Criteria) this;
        }

        public Criteria andCustomerNumNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_num not between", value1, value2, "customerNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumIsNull() {
            addCriterion("group_num is null");
            return (Criteria) this;
        }

        public Criteria andGroupNumIsNotNull() {
            addCriterion("group_num is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNumEqualTo(Integer value) {
            addCriterion("group_num =", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotEqualTo(Integer value) {
            addCriterion("group_num <>", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumGreaterThan(Integer value) {
            addCriterion("group_num >", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_num >=", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumLessThan(Integer value) {
            addCriterion("group_num <", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumLessThanOrEqualTo(Integer value) {
            addCriterion("group_num <=", value, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumIn(List<Integer> values) {
            addCriterion("group_num in", values, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotIn(List<Integer> values) {
            addCriterion("group_num not in", values, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumBetween(Integer value1, Integer value2) {
            addCriterion("group_num between", value1, value2, "groupNum");
            return (Criteria) this;
        }

        public Criteria andGroupNumNotBetween(Integer value1, Integer value2) {
            addCriterion("group_num not between", value1, value2, "groupNum");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(String value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(String value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(String value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(String value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(String value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLike(String value) {
            addCriterion("login_time like", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotLike(String value) {
            addCriterion("login_time not like", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<String> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<String> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(String value1, String value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(String value1, String value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeIsNull() {
            addCriterion("authorization_time is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeIsNotNull() {
            addCriterion("authorization_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeEqualTo(String value) {
            addCriterion("authorization_time =", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeNotEqualTo(String value) {
            addCriterion("authorization_time <>", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeGreaterThan(String value) {
            addCriterion("authorization_time >", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("authorization_time >=", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeLessThan(String value) {
            addCriterion("authorization_time <", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeLessThanOrEqualTo(String value) {
            addCriterion("authorization_time <=", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeLike(String value) {
            addCriterion("authorization_time like", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeNotLike(String value) {
            addCriterion("authorization_time not like", value, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeIn(List<String> values) {
            addCriterion("authorization_time in", values, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeNotIn(List<String> values) {
            addCriterion("authorization_time not in", values, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeBetween(String value1, String value2) {
            addCriterion("authorization_time between", value1, value2, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizationTimeNotBetween(String value1, String value2) {
            addCriterion("authorization_time not between", value1, value2, "authorizationTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNull() {
            addCriterion("login_status is null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIsNotNull() {
            addCriterion("login_status is not null");
            return (Criteria) this;
        }

        public Criteria andLoginStatusEqualTo(Integer value) {
            addCriterion("login_status =", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotEqualTo(Integer value) {
            addCriterion("login_status <>", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThan(Integer value) {
            addCriterion("login_status >", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_status >=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThan(Integer value) {
            addCriterion("login_status <", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusLessThanOrEqualTo(Integer value) {
            addCriterion("login_status <=", value, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusIn(List<Integer> values) {
            addCriterion("login_status in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotIn(List<Integer> values) {
            addCriterion("login_status not in", values, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusBetween(Integer value1, Integer value2) {
            addCriterion("login_status between", value1, value2, "loginStatus");
            return (Criteria) this;
        }

        public Criteria andLoginStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("login_status not between", value1, value2, "loginStatus");
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