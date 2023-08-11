package com.qianya.mapper;

import com.qianya.entity.MassSending;
import com.qianya.entity.MassSendingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MassSendingMapper {
    long countByExample(MassSendingCriteria example);

    int deleteByExample(MassSendingCriteria example);

    int deleteByPrimaryKey(Integer massId);

    int insert(MassSending record);

    int insertSelective(MassSending record);

    List<MassSending> selectByExample(MassSendingCriteria example);

    MassSending selectByPrimaryKey(Integer massId);

    int updateByExampleSelective(@Param("record") MassSending record, @Param("example") MassSendingCriteria example);

    int updateByExample(@Param("record") MassSending record, @Param("example") MassSendingCriteria example);

    int updateByPrimaryKeySelective(MassSending record);

    int updateByPrimaryKey(MassSending record);

    int insertBatch(@Param("recordColl") java.util.Collection<MassSending> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<MassSending> recordColl);

    MassSending selectByExampleForOne(MassSendingCriteria example);
}