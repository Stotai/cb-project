package com.qianya.mapper;

import com.qianya.entity.PullGroup;
import com.qianya.entity.PullGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PullGroupMapper {
    long countByExample(PullGroupCriteria example);

    int deleteByExample(PullGroupCriteria example);

    int deleteByPrimaryKey(Integer pullId);

    int insert(PullGroup record);

    int insertSelective(PullGroup record);

    List<PullGroup> selectByExample(PullGroupCriteria example);

    PullGroup selectByPrimaryKey(Integer pullId);

    int updateByExampleSelective(@Param("record") PullGroup record, @Param("example") PullGroupCriteria example);

    int updateByExample(@Param("record") PullGroup record, @Param("example") PullGroupCriteria example);

    int updateByPrimaryKeySelective(PullGroup record);

    int updateByPrimaryKey(PullGroup record);

    int insertBatch(@Param("recordColl") java.util.Collection<PullGroup> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<PullGroup> recordColl);

    PullGroup selectByExampleForOne(PullGroupCriteria example);
}