package com.qianya.mapper;

import com.qianya.entity.ReplyConfigDetail;
import com.qianya.entity.ReplyConfigDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyConfigDetailMapper {
    long countByExample(ReplyConfigDetailCriteria example);

    int deleteByExample(ReplyConfigDetailCriteria example);

    int deleteByPrimaryKey(Integer detailId);

    int insert(ReplyConfigDetail record);

    int insertSelective(ReplyConfigDetail record);

    List<ReplyConfigDetail> selectByExample(ReplyConfigDetailCriteria example);

    ReplyConfigDetail selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") ReplyConfigDetail record, @Param("example") ReplyConfigDetailCriteria example);

    int updateByExample(@Param("record") ReplyConfigDetail record, @Param("example") ReplyConfigDetailCriteria example);

    int updateByPrimaryKeySelective(ReplyConfigDetail record);

    int updateByPrimaryKey(ReplyConfigDetail record);

    int insertBatch(@Param("recordColl") java.util.Collection<ReplyConfigDetail> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<ReplyConfigDetail> recordColl);

    ReplyConfigDetail selectByExampleForOne(ReplyConfigDetailCriteria example);
}