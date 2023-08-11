package com.qianya.mapper;

import com.qianya.entity.PullCustRelation;
import com.qianya.entity.PullCustRelationCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PullCustRelationMapper {
    long countByExample(PullCustRelationCriteria example);

    int deleteByExample(PullCustRelationCriteria example);

    int deleteByPrimaryKey(Integer pullCustId);

    int insert(PullCustRelation record);

    int insertSelective(PullCustRelation record);

    List<PullCustRelation> selectByExample(PullCustRelationCriteria example);

    PullCustRelation selectByPrimaryKey(Integer pullCustId);

    int updateByExampleSelective(@Param("record") PullCustRelation record, @Param("example") PullCustRelationCriteria example);

    int updateByExample(@Param("record") PullCustRelation record, @Param("example") PullCustRelationCriteria example);

    int updateByPrimaryKeySelective(PullCustRelation record);

    int updateByPrimaryKey(PullCustRelation record);

    int insertBatch(@Param("recordColl") java.util.Collection<PullCustRelation> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<PullCustRelation> recordColl);

    PullCustRelation selectByExampleForOne(PullCustRelationCriteria example);
}