package com.qianya.mapper;

import com.qianya.entity.Groupping;
import com.qianya.entity.GrouppingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrouppingMapper {
    long countByExample(GrouppingCriteria example);

    int deleteByExample(GrouppingCriteria example);

    int deleteByPrimaryKey(Integer groupingId);

    int insert(Groupping record);

    int insertSelective(Groupping record);

    List<Groupping> selectByExample(GrouppingCriteria example);

    Groupping selectByPrimaryKey(Integer groupingId);

    int updateByExampleSelective(@Param("record") Groupping record, @Param("example") GrouppingCriteria example);

    int updateByExample(@Param("record") Groupping record, @Param("example") GrouppingCriteria example);

    int updateByPrimaryKeySelective(Groupping record);

    int updateByPrimaryKey(Groupping record);

    int insertBatch(@Param("recordColl") java.util.Collection<Groupping> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<Groupping> recordColl);

    Groupping selectByExampleForOne(GrouppingCriteria example);
}