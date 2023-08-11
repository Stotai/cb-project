package com.qianya.entity;

import java.util.ArrayList;
import java.util.List;

public class CricleDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CricleDetailCriteria() {
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

        public Criteria andCricleDetailIdIsNull() {
            addCriterion("cricle_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdIsNotNull() {
            addCriterion("cricle_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdEqualTo(Integer value) {
            addCriterion("cricle_detail_id =", value, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdNotEqualTo(Integer value) {
            addCriterion("cricle_detail_id <>", value, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdGreaterThan(Integer value) {
            addCriterion("cricle_detail_id >", value, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cricle_detail_id >=", value, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdLessThan(Integer value) {
            addCriterion("cricle_detail_id <", value, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("cricle_detail_id <=", value, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdIn(List<Integer> values) {
            addCriterion("cricle_detail_id in", values, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdNotIn(List<Integer> values) {
            addCriterion("cricle_detail_id not in", values, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("cricle_detail_id between", value1, value2, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andCricleDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cricle_detail_id not between", value1, value2, "cricleDetailId");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIsNull() {
            addCriterion("detail_type is null");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIsNotNull() {
            addCriterion("detail_type is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTypeEqualTo(Integer value) {
            addCriterion("detail_type =", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotEqualTo(Integer value) {
            addCriterion("detail_type <>", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeGreaterThan(Integer value) {
            addCriterion("detail_type >", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_type >=", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeLessThan(Integer value) {
            addCriterion("detail_type <", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeLessThanOrEqualTo(Integer value) {
            addCriterion("detail_type <=", value, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeIn(List<Integer> values) {
            addCriterion("detail_type in", values, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotIn(List<Integer> values) {
            addCriterion("detail_type not in", values, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeBetween(Integer value1, Integer value2) {
            addCriterion("detail_type between", value1, value2, "detailType");
            return (Criteria) this;
        }

        public Criteria andDetailTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_type not between", value1, value2, "detailType");
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

        public Criteria andCricleIdIsNull() {
            addCriterion("cricle_id is null");
            return (Criteria) this;
        }

        public Criteria andCricleIdIsNotNull() {
            addCriterion("cricle_id is not null");
            return (Criteria) this;
        }

        public Criteria andCricleIdEqualTo(Integer value) {
            addCriterion("cricle_id =", value, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdNotEqualTo(Integer value) {
            addCriterion("cricle_id <>", value, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdGreaterThan(Integer value) {
            addCriterion("cricle_id >", value, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cricle_id >=", value, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdLessThan(Integer value) {
            addCriterion("cricle_id <", value, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdLessThanOrEqualTo(Integer value) {
            addCriterion("cricle_id <=", value, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdIn(List<Integer> values) {
            addCriterion("cricle_id in", values, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdNotIn(List<Integer> values) {
            addCriterion("cricle_id not in", values, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdBetween(Integer value1, Integer value2) {
            addCriterion("cricle_id between", value1, value2, "cricleId");
            return (Criteria) this;
        }

        public Criteria andCricleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cricle_id not between", value1, value2, "cricleId");
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