package com.qianya.mapper;

import com.qianya.entity.MassSendingDetail;
import com.qianya.entity.MassSendingDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MassSendingDetailMapper {
    long countByExample(MassSendingDetailCriteria example);

    int deleteByExample(MassSendingDetailCriteria example);

    int deleteByPrimaryKey(Integer massDetailId);

    int insert(MassSendingDetail record);

    int insertSelective(MassSendingDetail record);

    List<MassSendingDetail> selectByExample(MassSendingDetailCriteria example);

    MassSendingDetail selectByPrimaryKey(Integer massDetailId);

    int updateByExampleSelective(@Param("record") MassSendingDetail record, @Param("example") MassSendingDetailCriteria example);

    int updateByExample(@Param("record") MassSendingDetail record, @Param("example") MassSendingDetailCriteria example);

    int updateByPrimaryKeySelective(MassSendingDetail record);

    int updateByPrimaryKey(MassSendingDetail record);

    int insertBatch(@Param("recordColl") java.util.Collection<MassSendingDetail> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<MassSendingDetail> recordColl);

    MassSendingDetail selectByExampleForOne(MassSendingDetailCriteria example);
}