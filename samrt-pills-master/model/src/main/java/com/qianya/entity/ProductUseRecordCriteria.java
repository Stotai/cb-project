package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductUseRecordCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ProductUseRecordCriteria() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andCarmiIsNull() {
            addCriterion("carmi is null");
            return (Criteria) this;
        }

        public Criteria andCarmiIsNotNull() {
            addCriterion("carmi is not null");
            return (Criteria) this;
        }

        public Criteria andCarmiEqualTo(String value) {
            addCriterion("carmi =", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiNotEqualTo(String value) {
            addCriterion("carmi <>", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiGreaterThan(String value) {
            addCriterion("carmi >", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiGreaterThanOrEqualTo(String value) {
            addCriterion("carmi >=", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiLessThan(String value) {
            addCriterion("carmi <", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiLessThanOrEqualTo(String value) {
            addCriterion("carmi <=", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiLike(String value) {
            addCriterion("carmi like", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiNotLike(String value) {
            addCriterion("carmi not like", value, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiIn(List<String> values) {
            addCriterion("carmi in", values, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiNotIn(List<String> values) {
            addCriterion("carmi not in", values, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiBetween(String value1, String value2) {
            addCriterion("carmi between", value1, value2, "carmi");
            return (Criteria) this;
        }

        public Criteria andCarmiNotBetween(String value1, String value2) {
            addCriterion("carmi not between", value1, value2, "carmi");
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

        public Criteria andPayUserPhoneIsNull() {
            addCriterion("pay_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneIsNotNull() {
            addCriterion("pay_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneEqualTo(String value) {
            addCriterion("pay_user_phone =", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneNotEqualTo(String value) {
            addCriterion("pay_user_phone <>", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneGreaterThan(String value) {
            addCriterion("pay_user_phone >", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pay_user_phone >=", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneLessThan(String value) {
            addCriterion("pay_user_phone <", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("pay_user_phone <=", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneLike(String value) {
            addCriterion("pay_user_phone like", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneNotLike(String value) {
            addCriterion("pay_user_phone not like", value, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneIn(List<String> values) {
            addCriterion("pay_user_phone in", values, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneNotIn(List<String> values) {
            addCriterion("pay_user_phone not in", values, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneBetween(String value1, String value2) {
            addCriterion("pay_user_phone between", value1, value2, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserPhoneNotBetween(String value1, String value2) {
            addCriterion("pay_user_phone not between", value1, value2, "payUserPhone");
            return (Criteria) this;
        }

        public Criteria andPayUserIdIsNull() {
            addCriterion("pay_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPayUserIdIsNotNull() {
            addCriterion("pay_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayUserIdEqualTo(Integer value) {
            addCriterion("pay_user_id =", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdNotEqualTo(Integer value) {
            addCriterion("pay_user_id <>", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdGreaterThan(Integer value) {
            addCriterion("pay_user_id >", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_user_id >=", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdLessThan(Integer value) {
            addCriterion("pay_user_id <", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_user_id <=", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdIn(List<Integer> values) {
            addCriterion("pay_user_id in", values, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdNotIn(List<Integer> values) {
            addCriterion("pay_user_id not in", values, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_user_id between", value1, value2, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_user_id not between", value1, value2, "payUserId");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
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

        public Criteria andExriseUserIdIsNull() {
            addCriterion("exrise_user_id is null");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdIsNotNull() {
            addCriterion("exrise_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdEqualTo(String value) {
            addCriterion("exrise_user_id =", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdNotEqualTo(String value) {
            addCriterion("exrise_user_id <>", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdGreaterThan(String value) {
            addCriterion("exrise_user_id >", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("exrise_user_id >=", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdLessThan(String value) {
            addCriterion("exrise_user_id <", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdLessThanOrEqualTo(String value) {
            addCriterion("exrise_user_id <=", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdLike(String value) {
            addCriterion("exrise_user_id like", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdNotLike(String value) {
            addCriterion("exrise_user_id not like", value, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdIn(List<String> values) {
            addCriterion("exrise_user_id in", values, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdNotIn(List<String> values) {
            addCriterion("exrise_user_id not in", values, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdBetween(String value1, String value2) {
            addCriterion("exrise_user_id between", value1, value2, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andExriseUserIdNotBetween(String value1, String value2) {
            addCriterion("exrise_user_id not between", value1, value2, "exriseUserId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(Integer value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(Integer value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(Integer value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(Integer value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(Integer value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<Integer> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<Integer> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(Integer value1, Integer value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
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

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(String value) {
            addCriterion("use_time =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(String value) {
            addCriterion("use_time <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(String value) {
            addCriterion("use_time >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("use_time >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(String value) {
            addCriterion("use_time <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(String value) {
            addCriterion("use_time <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLike(String value) {
            addCriterion("use_time like", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotLike(String value) {
            addCriterion("use_time not like", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<String> values) {
            addCriterion("use_time in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<String> values) {
            addCriterion("use_time not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(String value1, String value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(String value1, String value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
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