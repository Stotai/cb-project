package com.qianya.mapper;

import com.qianya.entity.SchemeItem;
import com.qianya.entity.SchemeItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchemeItemMapper {
    long countByExample(SchemeItemCriteria example);

    int deleteByExample(SchemeItemCriteria example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(SchemeItem record);

    int insertSelective(SchemeItem record);

    List<SchemeItem> selectByExample(SchemeItemCriteria example);

    SchemeItem selectByPrimaryKey(Integer itemId);

    int updateByExampleSelective(@Param("record") SchemeItem record, @Param("example") SchemeItemCriteria example);

    int updateByExample(@Param("record") SchemeItem record, @Param("example") SchemeItemCriteria example);

    int updateByPrimaryKeySelective(SchemeItem record);

    int updateByPrimaryKey(SchemeItem record);

    int insertBatch(@Param("recordColl") java.util.Collection<SchemeItem> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<SchemeItem> recordColl);

    SchemeItem selectByExampleForOne(SchemeItemCriteria example);
}