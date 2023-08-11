package com.qianya.mapper;

import com.qianya.entity.PullConfig;
import com.qianya.entity.PullConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PullConfigMapper {
    long countByExample(PullConfigCriteria example);

    int deleteByExample(PullConfigCriteria example);

    int deleteByPrimaryKey(Integer pullConfigId);

    int insert(PullConfig record);

    int insertSelective(PullConfig record);

    List<PullConfig> selectByExample(PullConfigCriteria example);

    PullConfig selectByPrimaryKey(Integer pullConfigId);

    int updateByExampleSelective(@Param("record") PullConfig record, @Param("example") PullConfigCriteria example);

    int updateByExample(@Param("record") PullConfig record, @Param("example") PullConfigCriteria example);

    int updateByPrimaryKeySelective(PullConfig record);

    int updateByPrimaryKey(PullConfig record);

    int insertBatch(@Param("recordColl") java.util.Collection<PullConfig> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<PullConfig> recordColl);

    PullConfig selectByExampleForOne(PullConfigCriteria example);
}