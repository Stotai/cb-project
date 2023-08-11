package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class CustomerCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CustomerCriteria() {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
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

        public Criteria andEpriseWxIdIsNull() {
            addCriterion("eprise_wx_id is null");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdIsNotNull() {
            addCriterion("eprise_wx_id is not null");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdEqualTo(String value) {
            addCriterion("eprise_wx_id =", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdNotEqualTo(String value) {
            addCriterion("eprise_wx_id <>", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdGreaterThan(String value) {
            addCriterion("eprise_wx_id >", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdGreaterThanOrEqualTo(String value) {
            addCriterion("eprise_wx_id >=", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdLessThan(String value) {
            addCriterion("eprise_wx_id <", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdLessThanOrEqualTo(String value) {
            addCriterion("eprise_wx_id <=", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdLike(String value) {
            addCriterion("eprise_wx_id like", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdNotLike(String value) {
            addCriterion("eprise_wx_id not like", value, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdIn(List<String> values) {
            addCriterion("eprise_wx_id in", values, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdNotIn(List<String> values) {
            addCriterion("eprise_wx_id not in", values, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdBetween(String value1, String value2) {
            addCriterion("eprise_wx_id between", value1, value2, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxIdNotBetween(String value1, String value2) {
            addCriterion("eprise_wx_id not between", value1, value2, "epriseWxId");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameIsNull() {
            addCriterion("eprise_wx_name is null");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameIsNotNull() {
            addCriterion("eprise_wx_name is not null");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameEqualTo(String value) {
            addCriterion("eprise_wx_name =", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameNotEqualTo(String value) {
            addCriterion("eprise_wx_name <>", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameGreaterThan(String value) {
            addCriterion("eprise_wx_name >", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameGreaterThanOrEqualTo(String value) {
            addCriterion("eprise_wx_name >=", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameLessThan(String value) {
            addCriterion("eprise_wx_name <", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameLessThanOrEqualTo(String value) {
            addCriterion("eprise_wx_name <=", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameLike(String value) {
            addCriterion("eprise_wx_name like", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameNotLike(String value) {
            addCriterion("eprise_wx_name not like", value, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameIn(List<String> values) {
            addCriterion("eprise_wx_name in", values, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameNotIn(List<String> values) {
            addCriterion("eprise_wx_name not in", values, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameBetween(String value1, String value2) {
            addCriterion("eprise_wx_name between", value1, value2, "epriseWxName");
            return (Criteria) this;
        }

        public Criteria andEpriseWxNameNotBetween(String value1, String value2) {
            addCriterion("eprise_wx_name not between", value1, value2, "epriseWxName");
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

        public Criteria andCustWxNameIsNull() {
            addCriterion("cust_wx_name is null");
            return (Criteria) this;
        }

        public Criteria andCustWxNameIsNotNull() {
            addCriterion("cust_wx_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustWxNameEqualTo(String value) {
            addCriterion("cust_wx_name =", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameNotEqualTo(String value) {
            addCriterion("cust_wx_name <>", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameGreaterThan(String value) {
            addCriterion("cust_wx_name >", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_wx_name >=", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameLessThan(String value) {
            addCriterion("cust_wx_name <", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameLessThanOrEqualTo(String value) {
            addCriterion("cust_wx_name <=", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameLike(String value) {
            addCriterion("cust_wx_name like", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameNotLike(String value) {
            addCriterion("cust_wx_name not like", value, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameIn(List<String> values) {
            addCriterion("cust_wx_name in", values, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameNotIn(List<String> values) {
            addCriterion("cust_wx_name not in", values, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameBetween(String value1, String value2) {
            addCriterion("cust_wx_name between", value1, value2, "custWxName");
            return (Criteria) this;
        }

        public Criteria andCustWxNameNotBetween(String value1, String value2) {
            addCriterion("cust_wx_name not between", value1, value2, "custWxName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlIsNull() {
            addCriterion("cust_wx_head_url is null");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlIsNotNull() {
            addCriterion("cust_wx_head_url is not null");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlEqualTo(String value) {
            addCriterion("cust_wx_head_url =", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlNotEqualTo(String value) {
            addCriterion("cust_wx_head_url <>", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlGreaterThan(String value) {
            addCriterion("cust_wx_head_url >", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cust_wx_head_url >=", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlLessThan(String value) {
            addCriterion("cust_wx_head_url <", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("cust_wx_head_url <=", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlLike(String value) {
            addCriterion("cust_wx_head_url like", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlNotLike(String value) {
            addCriterion("cust_wx_head_url not like", value, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlIn(List<String> values) {
            addCriterion("cust_wx_head_url in", values, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlNotIn(List<String> values) {
            addCriterion("cust_wx_head_url not in", values, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlBetween(String value1, String value2) {
            addCriterion("cust_wx_head_url between", value1, value2, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andCustWxHeadUrlNotBetween(String value1, String value2) {
            addCriterion("cust_wx_head_url not between", value1, value2, "custWxHeadUrl");
            return (Criteria) this;
        }

        public Criteria andVerifyContentIsNull() {
            addCriterion("verify_content is null");
            return (Criteria) this;
        }

        public Criteria andVerifyContentIsNotNull() {
            addCriterion("verify_content is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyContentEqualTo(String value) {
            addCriterion("verify_content =", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentNotEqualTo(String value) {
            addCriterion("verify_content <>", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentGreaterThan(String value) {
            addCriterion("verify_content >", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentGreaterThanOrEqualTo(String value) {
            addCriterion("verify_content >=", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentLessThan(String value) {
            addCriterion("verify_content <", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentLessThanOrEqualTo(String value) {
            addCriterion("verify_content <=", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentLike(String value) {
            addCriterion("verify_content like", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentNotLike(String value) {
            addCriterion("verify_content not like", value, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentIn(List<String> values) {
            addCriterion("verify_content in", values, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentNotIn(List<String> values) {
            addCriterion("verify_content not in", values, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentBetween(String value1, String value2) {
            addCriterion("verify_content between", value1, value2, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andVerifyContentNotBetween(String value1, String value2) {
            addCriterion("verify_content not between", value1, value2, "verifyContent");
            return (Criteria) this;
        }

        public Criteria andAddTypeIsNull() {
            addCriterion("add_type is null");
            return (Criteria) this;
        }

        public Criteria andAddTypeIsNotNull() {
            addCriterion("add_type is not null");
            return (Criteria) this;
        }

        public Criteria andAddTypeEqualTo(Integer value) {
            addCriterion("add_type =", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotEqualTo(Integer value) {
            addCriterion("add_type <>", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThan(Integer value) {
            addCriterion("add_type >", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_type >=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThan(Integer value) {
            addCriterion("add_type <", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeLessThanOrEqualTo(Integer value) {
            addCriterion("add_type <=", value, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeIn(List<Integer> values) {
            addCriterion("add_type in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotIn(List<Integer> values) {
            addCriterion("add_type not in", values, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeBetween(Integer value1, Integer value2) {
            addCriterion("add_type between", value1, value2, "addType");
            return (Criteria) this;
        }

        public Criteria andAddTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("add_type not between", value1, value2, "addType");
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

        public Criteria andZombieFlagIsNull() {
            addCriterion("zombie_flag is null");
            return (Criteria) this;
        }

        public Criteria andZombieFlagIsNotNull() {
            addCriterion("zombie_flag is not null");
            return (Criteria) this;
        }

        public Criteria andZombieFlagEqualTo(Integer value) {
            addCriterion("zombie_flag =", value, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagNotEqualTo(Integer value) {
            addCriterion("zombie_flag <>", value, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagGreaterThan(Integer value) {
            addCriterion("zombie_flag >", value, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("zombie_flag >=", value, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagLessThan(Integer value) {
            addCriterion("zombie_flag <", value, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagLessThanOrEqualTo(Integer value) {
            addCriterion("zombie_flag <=", value, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagIn(List<Integer> values) {
            addCriterion("zombie_flag in", values, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagNotIn(List<Integer> values) {
            addCriterion("zombie_flag not in", values, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagBetween(Integer value1, Integer value2) {
            addCriterion("zombie_flag between", value1, value2, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("zombie_flag not between", value1, value2, "zombieFlag");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeIsNull() {
            addCriterion("zombie_delete_time is null");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeIsNotNull() {
            addCriterion("zombie_delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeEqualTo(String value) {
            addCriterion("zombie_delete_time =", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeNotEqualTo(String value) {
            addCriterion("zombie_delete_time <>", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeGreaterThan(String value) {
            addCriterion("zombie_delete_time >", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeGreaterThanOrEqualTo(String value) {
            addCriterion("zombie_delete_time >=", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeLessThan(String value) {
            addCriterion("zombie_delete_time <", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeLessThanOrEqualTo(String value) {
            addCriterion("zombie_delete_time <=", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeLike(String value) {
            addCriterion("zombie_delete_time like", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeNotLike(String value) {
            addCriterion("zombie_delete_time not like", value, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeIn(List<String> values) {
            addCriterion("zombie_delete_time in", values, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeNotIn(List<String> values) {
            addCriterion("zombie_delete_time not in", values, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeBetween(String value1, String value2) {
            addCriterion("zombie_delete_time between", value1, value2, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieDeleteTimeNotBetween(String value1, String value2) {
            addCriterion("zombie_delete_time not between", value1, value2, "zombieDeleteTime");
            return (Criteria) this;
        }

        public Criteria andZombieStatusIsNull() {
            addCriterion("zombie_status is null");
            return (Criteria) this;
        }

        public Criteria andZombieStatusIsNotNull() {
            addCriterion("zombie_status is not null");
            return (Criteria) this;
        }

        public Criteria andZombieStatusEqualTo(Integer value) {
            addCriterion("zombie_status =", value, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusNotEqualTo(Integer value) {
            addCriterion("zombie_status <>", value, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusGreaterThan(Integer value) {
            addCriterion("zombie_status >", value, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("zombie_status >=", value, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusLessThan(Integer value) {
            addCriterion("zombie_status <", value, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusLessThanOrEqualTo(Integer value) {
            addCriterion("zombie_status <=", value, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusIn(List<Integer> values) {
            addCriterion("zombie_status in", values, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusNotIn(List<Integer> values) {
            addCriterion("zombie_status not in", values, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusBetween(Integer value1, Integer value2) {
            addCriterion("zombie_status between", value1, value2, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andZombieStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("zombie_status not between", value1, value2, "zombieStatus");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
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