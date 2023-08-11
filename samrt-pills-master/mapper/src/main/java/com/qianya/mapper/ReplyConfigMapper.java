package com.qianya.mapper;

import com.qianya.entity.ReplyConfig;
import com.qianya.entity.ReplyConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyConfigMapper {
    long countByExample(ReplyConfigCriteria example);

    int deleteByExample(ReplyConfigCriteria example);

    int deleteByPrimaryKey(Integer configId);

    int insert(ReplyConfig record);

    int insertSelective(ReplyConfig record);

    List<ReplyConfig> selectByExample(ReplyConfigCriteria example);

    ReplyConfig selectByPrimaryKey(Integer configId);

    int updateByExampleSelective(@Param("record") ReplyConfig record, @Param("example") ReplyConfigCriteria example);

    int updateByExample(@Param("record") ReplyConfig record, @Param("example") ReplyConfigCriteria example);

    int updateByPrimaryKeySelective(ReplyConfig record);

    int updateByPrimaryKey(ReplyConfig record);

    int insertBatch(@Param("recordColl") java.util.Collection<ReplyConfig> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<ReplyConfig> recordColl);

    ReplyConfig selectByExampleForOne(ReplyConfigCriteria example);
}