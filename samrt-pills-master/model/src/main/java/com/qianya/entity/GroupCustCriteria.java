package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class GroupCustCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public GroupCustCriteria() {
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

        public Criteria andJoinTimeIsNull() {
            addCriterion("join_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("join_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(String value) {
            addCriterion("join_time =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(String value) {
            addCriterion("join_time <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(String value) {
            addCriterion("join_time >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(String value) {
            addCriterion("join_time >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(String value) {
            addCriterion("join_time <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(String value) {
            addCriterion("join_time <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLike(String value) {
            addCriterion("join_time like", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotLike(String value) {
            addCriterion("join_time not like", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<String> values) {
            addCriterion("join_time in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<String> values) {
            addCriterion("join_time not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(String value1, String value2) {
            addCriterion("join_time between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(String value1, String value2) {
            addCriterion("join_time not between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNull() {
            addCriterion("is_admin is null");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNotNull() {
            addCriterion("is_admin is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdminEqualTo(Integer value) {
            addCriterion("is_admin =", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotEqualTo(Integer value) {
            addCriterion("is_admin <>", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThan(Integer value) {
            addCriterion("is_admin >", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_admin >=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThan(Integer value) {
            addCriterion("is_admin <", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThanOrEqualTo(Integer value) {
            addCriterion("is_admin <=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminIn(List<Integer> values) {
            addCriterion("is_admin in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotIn(List<Integer> values) {
            addCriterion("is_admin not in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminBetween(Integer value1, Integer value2) {
            addCriterion("is_admin between", value1, value2, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("is_admin not between", value1, value2, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesIsNull() {
            addCriterion("invitations_times is null");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesIsNotNull() {
            addCriterion("invitations_times is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesEqualTo(Integer value) {
            addCriterion("invitations_times =", value, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesNotEqualTo(Integer value) {
            addCriterion("invitations_times <>", value, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesGreaterThan(Integer value) {
            addCriterion("invitations_times >", value, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("invitations_times >=", value, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesLessThan(Integer value) {
            addCriterion("invitations_times <", value, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesLessThanOrEqualTo(Integer value) {
            addCriterion("invitations_times <=", value, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesIn(List<Integer> values) {
            addCriterion("invitations_times in", values, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesNotIn(List<Integer> values) {
            addCriterion("invitations_times not in", values, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesBetween(Integer value1, Integer value2) {
            addCriterion("invitations_times between", value1, value2, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitationsTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("invitations_times not between", value1, value2, "invitationsTimes");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdIsNull() {
            addCriterion("invita_user_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdIsNotNull() {
            addCriterion("invita_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdEqualTo(String value) {
            addCriterion("invita_user_id =", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdNotEqualTo(String value) {
            addCriterion("invita_user_id <>", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdGreaterThan(String value) {
            addCriterion("invita_user_id >", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("invita_user_id >=", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdLessThan(String value) {
            addCriterion("invita_user_id <", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdLessThanOrEqualTo(String value) {
            addCriterion("invita_user_id <=", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdLike(String value) {
            addCriterion("invita_user_id like", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdNotLike(String value) {
            addCriterion("invita_user_id not like", value, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdIn(List<String> values) {
            addCriterion("invita_user_id in", values, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdNotIn(List<String> values) {
            addCriterion("invita_user_id not in", values, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdBetween(String value1, String value2) {
            addCriterion("invita_user_id between", value1, value2, "invitaUserId");
            return (Criteria) this;
        }

        public Criteria andInvitaUserIdNotBetween(String value1, String value2) {
            addCriterion("invita_user_id not between", value1, value2, "invitaUserId");
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