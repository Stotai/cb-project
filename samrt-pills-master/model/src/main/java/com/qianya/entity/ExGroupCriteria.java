package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class ExGroupCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ExGroupCriteria() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdIsNull() {
            addCriterion("group_wx_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdIsNotNull() {
            addCriterion("group_wx_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdEqualTo(String value) {
            addCriterion("group_wx_id =", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdNotEqualTo(String value) {
            addCriterion("group_wx_id <>", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdGreaterThan(String value) {
            addCriterion("group_wx_id >", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_wx_id >=", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdLessThan(String value) {
            addCriterion("group_wx_id <", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdLessThanOrEqualTo(String value) {
            addCriterion("group_wx_id <=", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdLike(String value) {
            addCriterion("group_wx_id like", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdNotLike(String value) {
            addCriterion("group_wx_id not like", value, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdIn(List<String> values) {
            addCriterion("group_wx_id in", values, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdNotIn(List<String> values) {
            addCriterion("group_wx_id not in", values, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdBetween(String value1, String value2) {
            addCriterion("group_wx_id between", value1, value2, "groupWxId");
            return (Criteria) this;
        }

        public Criteria andGroupWxIdNotBetween(String value1, String value2) {
            addCriterion("group_wx_id not between", value1, value2, "groupWxId");
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

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupImgIsNull() {
            addCriterion("group_img is null");
            return (Criteria) this;
        }

        public Criteria andGroupImgIsNotNull() {
            addCriterion("group_img is not null");
            return (Criteria) this;
        }

        public Criteria andGroupImgEqualTo(String value) {
            addCriterion("group_img =", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgNotEqualTo(String value) {
            addCriterion("group_img <>", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgGreaterThan(String value) {
            addCriterion("group_img >", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgGreaterThanOrEqualTo(String value) {
            addCriterion("group_img >=", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgLessThan(String value) {
            addCriterion("group_img <", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgLessThanOrEqualTo(String value) {
            addCriterion("group_img <=", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgLike(String value) {
            addCriterion("group_img like", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgNotLike(String value) {
            addCriterion("group_img not like", value, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgIn(List<String> values) {
            addCriterion("group_img in", values, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgNotIn(List<String> values) {
            addCriterion("group_img not in", values, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgBetween(String value1, String value2) {
            addCriterion("group_img between", value1, value2, "groupImg");
            return (Criteria) this;
        }

        public Criteria andGroupImgNotBetween(String value1, String value2) {
            addCriterion("group_img not between", value1, value2, "groupImg");
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

        public Criteria andGroupTypeIsNull() {
            addCriterion("group_type is null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNotNull() {
            addCriterion("group_type is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeEqualTo(Integer value) {
            addCriterion("group_type =", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotEqualTo(Integer value) {
            addCriterion("group_type <>", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThan(Integer value) {
            addCriterion("group_type >", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_type >=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThan(Integer value) {
            addCriterion("group_type <", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThanOrEqualTo(Integer value) {
            addCriterion("group_type <=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIn(List<Integer> values) {
            addCriterion("group_type in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotIn(List<Integer> values) {
            addCriterion("group_type not in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeBetween(Integer value1, Integer value2) {
            addCriterion("group_type between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("group_type not between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andCustNumIsNull() {
            addCriterion("cust_num is null");
            return (Criteria) this;
        }

        public Criteria andCustNumIsNotNull() {
            addCriterion("cust_num is not null");
            return (Criteria) this;
        }

        public Criteria andCustNumEqualTo(Integer value) {
            addCriterion("cust_num =", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumNotEqualTo(Integer value) {
            addCriterion("cust_num <>", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumGreaterThan(Integer value) {
            addCriterion("cust_num >", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_num >=", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumLessThan(Integer value) {
            addCriterion("cust_num <", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumLessThanOrEqualTo(Integer value) {
            addCriterion("cust_num <=", value, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumIn(List<Integer> values) {
            addCriterion("cust_num in", values, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumNotIn(List<Integer> values) {
            addCriterion("cust_num not in", values, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumBetween(Integer value1, Integer value2) {
            addCriterion("cust_num between", value1, value2, "custNum");
            return (Criteria) this;
        }

        public Criteria andCustNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_num not between", value1, value2, "custNum");
            return (Criteria) this;
        }

        public Criteria andGroupingIdIsNull() {
            addCriterion("grouping_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupingIdIsNotNull() {
            addCriterion("grouping_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupingIdEqualTo(Integer value) {
            addCriterion("grouping_id =", value, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdNotEqualTo(Integer value) {
            addCriterion("grouping_id <>", value, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdGreaterThan(Integer value) {
            addCriterion("grouping_id >", value, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grouping_id >=", value, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdLessThan(Integer value) {
            addCriterion("grouping_id <", value, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdLessThanOrEqualTo(Integer value) {
            addCriterion("grouping_id <=", value, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdIn(List<Integer> values) {
            addCriterion("grouping_id in", values, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdNotIn(List<Integer> values) {
            addCriterion("grouping_id not in", values, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdBetween(Integer value1, Integer value2) {
            addCriterion("grouping_id between", value1, value2, "groupingId");
            return (Criteria) this;
        }

        public Criteria andGroupingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grouping_id not between", value1, value2, "groupingId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
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

        public Criteria andGroupQrCodeIsNull() {
            addCriterion("group_qr_code is null");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeIsNotNull() {
            addCriterion("group_qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeEqualTo(String value) {
            addCriterion("group_qr_code =", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeNotEqualTo(String value) {
            addCriterion("group_qr_code <>", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeGreaterThan(String value) {
            addCriterion("group_qr_code >", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("group_qr_code >=", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeLessThan(String value) {
            addCriterion("group_qr_code <", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeLessThanOrEqualTo(String value) {
            addCriterion("group_qr_code <=", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeLike(String value) {
            addCriterion("group_qr_code like", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeNotLike(String value) {
            addCriterion("group_qr_code not like", value, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeIn(List<String> values) {
            addCriterion("group_qr_code in", values, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeNotIn(List<String> values) {
            addCriterion("group_qr_code not in", values, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeBetween(String value1, String value2) {
            addCriterion("group_qr_code between", value1, value2, "groupQrCode");
            return (Criteria) this;
        }

        public Criteria andGroupQrCodeNotBetween(String value1, String value2) {
            addCriterion("group_qr_code not between", value1, value2, "groupQrCode");
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