package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class PullGroupOpDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public PullGroupOpDetailCriteria() {
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

        public Criteria andOpDetailIdIsNull() {
            addCriterion("op_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdIsNotNull() {
            addCriterion("op_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdEqualTo(Integer value) {
            addCriterion("op_detail_id =", value, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdNotEqualTo(Integer value) {
            addCriterion("op_detail_id <>", value, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdGreaterThan(Integer value) {
            addCriterion("op_detail_id >", value, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("op_detail_id >=", value, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdLessThan(Integer value) {
            addCriterion("op_detail_id <", value, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("op_detail_id <=", value, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdIn(List<Integer> values) {
            addCriterion("op_detail_id in", values, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdNotIn(List<Integer> values) {
            addCriterion("op_detail_id not in", values, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("op_detail_id between", value1, value2, "opDetailId");
            return (Criteria) this;
        }

        public Criteria andOpDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("op_detail_id not between", value1, value2, "opDetailId");
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

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Integer value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Integer value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Integer value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Integer value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Integer value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Integer> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Integer> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Integer value1, Integer value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemContentIsNull() {
            addCriterion("item_content is null");
            return (Criteria) this;
        }

        public Criteria andItemContentIsNotNull() {
            addCriterion("item_content is not null");
            return (Criteria) this;
        }

        public Criteria andItemContentEqualTo(String value) {
            addCriterion("item_content =", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotEqualTo(String value) {
            addCriterion("item_content <>", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentGreaterThan(String value) {
            addCriterion("item_content >", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentGreaterThanOrEqualTo(String value) {
            addCriterion("item_content >=", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentLessThan(String value) {
            addCriterion("item_content <", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentLessThanOrEqualTo(String value) {
            addCriterion("item_content <=", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentLike(String value) {
            addCriterion("item_content like", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotLike(String value) {
            addCriterion("item_content not like", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentIn(List<String> values) {
            addCriterion("item_content in", values, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotIn(List<String> values) {
            addCriterion("item_content not in", values, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentBetween(String value1, String value2) {
            addCriterion("item_content between", value1, value2, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotBetween(String value1, String value2) {
            addCriterion("item_content not between", value1, value2, "itemContent");
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

        public Criteria andWaitSecondsEqualTo(Integer value) {
            addCriterion("wait_seconds =", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotEqualTo(Integer value) {
            addCriterion("wait_seconds <>", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsGreaterThan(Integer value) {
            addCriterion("wait_seconds >", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsGreaterThanOrEqualTo(Integer value) {
            addCriterion("wait_seconds >=", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsLessThan(Integer value) {
            addCriterion("wait_seconds <", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsLessThanOrEqualTo(Integer value) {
            addCriterion("wait_seconds <=", value, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsIn(List<Integer> values) {
            addCriterion("wait_seconds in", values, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotIn(List<Integer> values) {
            addCriterion("wait_seconds not in", values, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsBetween(Integer value1, Integer value2) {
            addCriterion("wait_seconds between", value1, value2, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andWaitSecondsNotBetween(Integer value1, Integer value2) {
            addCriterion("wait_seconds not between", value1, value2, "waitSeconds");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andCardTitleIsNull() {
            addCriterion("card_title is null");
            return (Criteria) this;
        }

        public Criteria andCardTitleIsNotNull() {
            addCriterion("card_title is not null");
            return (Criteria) this;
        }

        public Criteria andCardTitleEqualTo(String value) {
            addCriterion("card_title =", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleNotEqualTo(String value) {
            addCriterion("card_title <>", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleGreaterThan(String value) {
            addCriterion("card_title >", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleGreaterThanOrEqualTo(String value) {
            addCriterion("card_title >=", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleLessThan(String value) {
            addCriterion("card_title <", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleLessThanOrEqualTo(String value) {
            addCriterion("card_title <=", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleLike(String value) {
            addCriterion("card_title like", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleNotLike(String value) {
            addCriterion("card_title not like", value, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleIn(List<String> values) {
            addCriterion("card_title in", values, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleNotIn(List<String> values) {
            addCriterion("card_title not in", values, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleBetween(String value1, String value2) {
            addCriterion("card_title between", value1, value2, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardTitleNotBetween(String value1, String value2) {
            addCriterion("card_title not between", value1, value2, "cardTitle");
            return (Criteria) this;
        }

        public Criteria andCardUrlIsNull() {
            addCriterion("card_url is null");
            return (Criteria) this;
        }

        public Criteria andCardUrlIsNotNull() {
            addCriterion("card_url is not null");
            return (Criteria) this;
        }

        public Criteria andCardUrlEqualTo(String value) {
            addCriterion("card_url =", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlNotEqualTo(String value) {
            addCriterion("card_url <>", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlGreaterThan(String value) {
            addCriterion("card_url >", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlGreaterThanOrEqualTo(String value) {
            addCriterion("card_url >=", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlLessThan(String value) {
            addCriterion("card_url <", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlLessThanOrEqualTo(String value) {
            addCriterion("card_url <=", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlLike(String value) {
            addCriterion("card_url like", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlNotLike(String value) {
            addCriterion("card_url not like", value, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlIn(List<String> values) {
            addCriterion("card_url in", values, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlNotIn(List<String> values) {
            addCriterion("card_url not in", values, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlBetween(String value1, String value2) {
            addCriterion("card_url between", value1, value2, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardUrlNotBetween(String value1, String value2) {
            addCriterion("card_url not between", value1, value2, "cardUrl");
            return (Criteria) this;
        }

        public Criteria andCardContentIsNull() {
            addCriterion("card_content is null");
            return (Criteria) this;
        }

        public Criteria andCardContentIsNotNull() {
            addCriterion("card_content is not null");
            return (Criteria) this;
        }

        public Criteria andCardContentEqualTo(String value) {
            addCriterion("card_content =", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotEqualTo(String value) {
            addCriterion("card_content <>", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentGreaterThan(String value) {
            addCriterion("card_content >", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentGreaterThanOrEqualTo(String value) {
            addCriterion("card_content >=", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLessThan(String value) {
            addCriterion("card_content <", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLessThanOrEqualTo(String value) {
            addCriterion("card_content <=", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentLike(String value) {
            addCriterion("card_content like", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotLike(String value) {
            addCriterion("card_content not like", value, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentIn(List<String> values) {
            addCriterion("card_content in", values, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotIn(List<String> values) {
            addCriterion("card_content not in", values, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentBetween(String value1, String value2) {
            addCriterion("card_content between", value1, value2, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardContentNotBetween(String value1, String value2) {
            addCriterion("card_content not between", value1, value2, "cardContent");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlIsNull() {
            addCriterion("card_img_url is null");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlIsNotNull() {
            addCriterion("card_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlEqualTo(String value) {
            addCriterion("card_img_url =", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlNotEqualTo(String value) {
            addCriterion("card_img_url <>", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlGreaterThan(String value) {
            addCriterion("card_img_url >", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("card_img_url >=", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlLessThan(String value) {
            addCriterion("card_img_url <", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlLessThanOrEqualTo(String value) {
            addCriterion("card_img_url <=", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlLike(String value) {
            addCriterion("card_img_url like", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlNotLike(String value) {
            addCriterion("card_img_url not like", value, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlIn(List<String> values) {
            addCriterion("card_img_url in", values, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlNotIn(List<String> values) {
            addCriterion("card_img_url not in", values, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlBetween(String value1, String value2) {
            addCriterion("card_img_url between", value1, value2, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andCardImgUrlNotBetween(String value1, String value2) {
            addCriterion("card_img_url not between", value1, value2, "cardImgUrl");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPagePathIsNull() {
            addCriterion("page_path is null");
            return (Criteria) this;
        }

        public Criteria andPagePathIsNotNull() {
            addCriterion("page_path is not null");
            return (Criteria) this;
        }

        public Criteria andPagePathEqualTo(String value) {
            addCriterion("page_path =", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotEqualTo(String value) {
            addCriterion("page_path <>", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathGreaterThan(String value) {
            addCriterion("page_path >", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathGreaterThanOrEqualTo(String value) {
            addCriterion("page_path >=", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLessThan(String value) {
            addCriterion("page_path <", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLessThanOrEqualTo(String value) {
            addCriterion("page_path <=", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLike(String value) {
            addCriterion("page_path like", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotLike(String value) {
            addCriterion("page_path not like", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathIn(List<String> values) {
            addCriterion("page_path in", values, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotIn(List<String> values) {
            addCriterion("page_path not in", values, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathBetween(String value1, String value2) {
            addCriterion("page_path between", value1, value2, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotBetween(String value1, String value2) {
            addCriterion("page_path not between", value1, value2, "pagePath");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(String value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(String value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(String value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(String value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(String value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLike(String value) {
            addCriterion("file_id like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotLike(String value) {
            addCriterion("file_id not like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<String> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<String> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(String value1, String value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(String value1, String value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andAesKeyIsNull() {
            addCriterion("aes_key is null");
            return (Criteria) this;
        }

        public Criteria andAesKeyIsNotNull() {
            addCriterion("aes_key is not null");
            return (Criteria) this;
        }

        public Criteria andAesKeyEqualTo(String value) {
            addCriterion("aes_key =", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotEqualTo(String value) {
            addCriterion("aes_key <>", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyGreaterThan(String value) {
            addCriterion("aes_key >", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyGreaterThanOrEqualTo(String value) {
            addCriterion("aes_key >=", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyLessThan(String value) {
            addCriterion("aes_key <", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyLessThanOrEqualTo(String value) {
            addCriterion("aes_key <=", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyLike(String value) {
            addCriterion("aes_key like", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotLike(String value) {
            addCriterion("aes_key not like", value, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyIn(List<String> values) {
            addCriterion("aes_key in", values, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotIn(List<String> values) {
            addCriterion("aes_key not in", values, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyBetween(String value1, String value2) {
            addCriterion("aes_key between", value1, value2, "aesKey");
            return (Criteria) this;
        }

        public Criteria andAesKeyNotBetween(String value1, String value2) {
            addCriterion("aes_key not between", value1, value2, "aesKey");
            return (Criteria) this;
        }

        public Criteria andMd5IsNull() {
            addCriterion("md5 is null");
            return (Criteria) this;
        }

        public Criteria andMd5IsNotNull() {
            addCriterion("md5 is not null");
            return (Criteria) this;
        }

        public Criteria andMd5EqualTo(String value) {
            addCriterion("md5 =", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotEqualTo(String value) {
            addCriterion("md5 <>", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThan(String value) {
            addCriterion("md5 >", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThanOrEqualTo(String value) {
            addCriterion("md5 >=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThan(String value) {
            addCriterion("md5 <", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThanOrEqualTo(String value) {
            addCriterion("md5 <=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Like(String value) {
            addCriterion("md5 like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotLike(String value) {
            addCriterion("md5 not like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5In(List<String> values) {
            addCriterion("md5 in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotIn(List<String> values) {
            addCriterion("md5 not in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Between(String value1, String value2) {
            addCriterion("md5 between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotBetween(String value1, String value2) {
            addCriterion("md5 not between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andXcxSizeIsNull() {
            addCriterion("xcx_size is null");
            return (Criteria) this;
        }

        public Criteria andXcxSizeIsNotNull() {
            addCriterion("xcx_size is not null");
            return (Criteria) this;
        }

        public Criteria andXcxSizeEqualTo(String value) {
            addCriterion("xcx_size =", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeNotEqualTo(String value) {
            addCriterion("xcx_size <>", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeGreaterThan(String value) {
            addCriterion("xcx_size >", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_size >=", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeLessThan(String value) {
            addCriterion("xcx_size <", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeLessThanOrEqualTo(String value) {
            addCriterion("xcx_size <=", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeLike(String value) {
            addCriterion("xcx_size like", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeNotLike(String value) {
            addCriterion("xcx_size not like", value, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeIn(List<String> values) {
            addCriterion("xcx_size in", values, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeNotIn(List<String> values) {
            addCriterion("xcx_size not in", values, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeBetween(String value1, String value2) {
            addCriterion("xcx_size between", value1, value2, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andXcxSizeNotBetween(String value1, String value2) {
            addCriterion("xcx_size not between", value1, value2, "xcxSize");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andVideoDescIsNull() {
            addCriterion("video_desc is null");
            return (Criteria) this;
        }

        public Criteria andVideoDescIsNotNull() {
            addCriterion("video_desc is not null");
            return (Criteria) this;
        }

        public Criteria andVideoDescEqualTo(String value) {
            addCriterion("video_desc =", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotEqualTo(String value) {
            addCriterion("video_desc <>", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescGreaterThan(String value) {
            addCriterion("video_desc >", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescGreaterThanOrEqualTo(String value) {
            addCriterion("video_desc >=", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLessThan(String value) {
            addCriterion("video_desc <", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLessThanOrEqualTo(String value) {
            addCriterion("video_desc <=", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLike(String value) {
            addCriterion("video_desc like", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotLike(String value) {
            addCriterion("video_desc not like", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescIn(List<String> values) {
            addCriterion("video_desc in", values, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotIn(List<String> values) {
            addCriterion("video_desc not in", values, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescBetween(String value1, String value2) {
            addCriterion("video_desc between", value1, value2, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotBetween(String value1, String value2) {
            addCriterion("video_desc not between", value1, value2, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNull() {
            addCriterion("cover_url is null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNotNull() {
            addCriterion("cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlEqualTo(String value) {
            addCriterion("cover_url =", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotEqualTo(String value) {
            addCriterion("cover_url <>", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThan(String value) {
            addCriterion("cover_url >", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cover_url >=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThan(String value) {
            addCriterion("cover_url <", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("cover_url <=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLike(String value) {
            addCriterion("cover_url like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotLike(String value) {
            addCriterion("cover_url not like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIn(List<String> values) {
            addCriterion("cover_url in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotIn(List<String> values) {
            addCriterion("cover_url not in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlBetween(String value1, String value2) {
            addCriterion("cover_url between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotBetween(String value1, String value2) {
            addCriterion("cover_url not between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andFeedTypeIsNull() {
            addCriterion("feed_type is null");
            return (Criteria) this;
        }

        public Criteria andFeedTypeIsNotNull() {
            addCriterion("feed_type is not null");
            return (Criteria) this;
        }

        public Criteria andFeedTypeEqualTo(String value) {
            addCriterion("feed_type =", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeNotEqualTo(String value) {
            addCriterion("feed_type <>", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeGreaterThan(String value) {
            addCriterion("feed_type >", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("feed_type >=", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeLessThan(String value) {
            addCriterion("feed_type <", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeLessThanOrEqualTo(String value) {
            addCriterion("feed_type <=", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeLike(String value) {
            addCriterion("feed_type like", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeNotLike(String value) {
            addCriterion("feed_type not like", value, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeIn(List<String> values) {
            addCriterion("feed_type in", values, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeNotIn(List<String> values) {
            addCriterion("feed_type not in", values, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeBetween(String value1, String value2) {
            addCriterion("feed_type between", value1, value2, "feedType");
            return (Criteria) this;
        }

        public Criteria andFeedTypeNotBetween(String value1, String value2) {
            addCriterion("feed_type not between", value1, value2, "feedType");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIsNull() {
            addCriterion("thumb_url is null");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIsNotNull() {
            addCriterion("thumb_url is not null");
            return (Criteria) this;
        }

        public Criteria andThumbUrlEqualTo(String value) {
            addCriterion("thumb_url =", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotEqualTo(String value) {
            addCriterion("thumb_url <>", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlGreaterThan(String value) {
            addCriterion("thumb_url >", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlGreaterThanOrEqualTo(String value) {
            addCriterion("thumb_url >=", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLessThan(String value) {
            addCriterion("thumb_url <", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLessThanOrEqualTo(String value) {
            addCriterion("thumb_url <=", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLike(String value) {
            addCriterion("thumb_url like", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotLike(String value) {
            addCriterion("thumb_url not like", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIn(List<String> values) {
            addCriterion("thumb_url in", values, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotIn(List<String> values) {
            addCriterion("thumb_url not in", values, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlBetween(String value1, String value2) {
            addCriterion("thumb_url between", value1, value2, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotBetween(String value1, String value2) {
            addCriterion("thumb_url not between", value1, value2, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andExtrasIsNull() {
            addCriterion("extras is null");
            return (Criteria) this;
        }

        public Criteria andExtrasIsNotNull() {
            addCriterion("extras is not null");
            return (Criteria) this;
        }

        public Criteria andExtrasEqualTo(String value) {
            addCriterion("extras =", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotEqualTo(String value) {
            addCriterion("extras <>", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasGreaterThan(String value) {
            addCriterion("extras >", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasGreaterThanOrEqualTo(String value) {
            addCriterion("extras >=", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLessThan(String value) {
            addCriterion("extras <", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLessThanOrEqualTo(String value) {
            addCriterion("extras <=", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasLike(String value) {
            addCriterion("extras like", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotLike(String value) {
            addCriterion("extras not like", value, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasIn(List<String> values) {
            addCriterion("extras in", values, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotIn(List<String> values) {
            addCriterion("extras not in", values, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasBetween(String value1, String value2) {
            addCriterion("extras between", value1, value2, "extras");
            return (Criteria) this;
        }

        public Criteria andExtrasNotBetween(String value1, String value2) {
            addCriterion("extras not between", value1, value2, "extras");
            return (Criteria) this;
        }

        public Criteria andGroupIdsIsNull() {
            addCriterion("group_ids is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdsIsNotNull() {
            addCriterion("group_ids is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdsEqualTo(String value) {
            addCriterion("group_ids =", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotEqualTo(String value) {
            addCriterion("group_ids <>", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsGreaterThan(String value) {
            addCriterion("group_ids >", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsGreaterThanOrEqualTo(String value) {
            addCriterion("group_ids >=", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsLessThan(String value) {
            addCriterion("group_ids <", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsLessThanOrEqualTo(String value) {
            addCriterion("group_ids <=", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsLike(String value) {
            addCriterion("group_ids like", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotLike(String value) {
            addCriterion("group_ids not like", value, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsIn(List<String> values) {
            addCriterion("group_ids in", values, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotIn(List<String> values) {
            addCriterion("group_ids not in", values, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsBetween(String value1, String value2) {
            addCriterion("group_ids between", value1, value2, "groupIds");
            return (Criteria) this;
        }

        public Criteria andGroupIdsNotBetween(String value1, String value2) {
            addCriterion("group_ids not between", value1, value2, "groupIds");
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