package com.qianya.mapper;

import com.qianya.entity.ExGroup;
import com.qianya.entity.ExGroupCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExGroupMapper {
    long countByExample(ExGroupCriteria example);

    int deleteByExample(ExGroupCriteria example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(ExGroup record);

    int insertSelective(ExGroup record);

    List<ExGroup> selectByExample(ExGroupCriteria example);

    ExGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") ExGroup record, @Param("example") ExGroupCriteria example);

    int updateByExample(@Param("record") ExGroup record, @Param("example") ExGroupCriteria example);

    int updateByPrimaryKeySelective(ExGroup record);

    int updateByPrimaryKey(ExGroup record);

    int insertBatch(@Param("recordColl") java.util.Collection<ExGroup> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<ExGroup> recordColl);

    ExGroup selectByExampleForOne(ExGroupCriteria example);
}