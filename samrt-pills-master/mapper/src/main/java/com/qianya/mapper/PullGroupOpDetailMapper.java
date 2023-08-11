package com.qianya.mapper;

import com.qianya.entity.PullGroupOpDetail;
import com.qianya.entity.PullGroupOpDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PullGroupOpDetailMapper {
    long countByExample(PullGroupOpDetailCriteria example);

    int deleteByExample(PullGroupOpDetailCriteria example);

    int deleteByPrimaryKey(Integer opDetailId);

    int insert(PullGroupOpDetail record);

    int insertSelective(PullGroupOpDetail record);

    List<PullGroupOpDetail> selectByExample(PullGroupOpDetailCriteria example);

    PullGroupOpDetail selectByPrimaryKey(Integer opDetailId);

    int updateByExampleSelective(@Param("record") PullGroupOpDetail record, @Param("example") PullGroupOpDetailCriteria example);

    int updateByExample(@Param("record") PullGroupOpDetail record, @Param("example") PullGroupOpDetailCriteria example);

    int updateByPrimaryKeySelective(PullGroupOpDetail record);

    int updateByPrimaryKey(PullGroupOpDetail record);

    int insertBatch(@Param("recordColl") java.util.Collection<PullGroupOpDetail> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<PullGroupOpDetail> recordColl);

    PullGroupOpDetail selectByExampleForOne(PullGroupOpDetailCriteria example);
}