package com.qianya.mapper;

import com.qianya.entity.CricleDetail;
import com.qianya.entity.CricleDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CricleDetailMapper {
    long countByExample(CricleDetailCriteria example);

    int deleteByExample(CricleDetailCriteria example);

    int deleteByPrimaryKey(Integer cricleDetailId);

    int insert(CricleDetail record);

    int insertSelective(CricleDetail record);

    List<CricleDetail> selectByExample(CricleDetailCriteria example);

    CricleDetail selectByPrimaryKey(Integer cricleDetailId);

    int updateByExampleSelective(@Param("record") CricleDetail record, @Param("example") CricleDetailCriteria example);

    int updateByExample(@Param("record") CricleDetail record, @Param("example") CricleDetailCriteria example);

    int updateByPrimaryKeySelective(CricleDetail record);

    int updateByPrimaryKey(CricleDetail record);

    int insertBatch(@Param("recordColl") java.util.Collection<CricleDetail> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<CricleDetail> recordColl);

    CricleDetail selectByExampleForOne(CricleDetailCriteria example);
}