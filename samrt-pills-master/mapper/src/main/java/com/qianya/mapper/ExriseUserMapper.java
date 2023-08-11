package com.qianya.mapper;

import com.qianya.entity.ExriseUser;
import com.qianya.entity.ExriseUserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExriseUserMapper {
    long countByExample(ExriseUserCriteria example);

    int deleteByExample(ExriseUserCriteria example);

    int deleteByPrimaryKey(Integer exriseUserId);

    int insert(ExriseUser record);

    int insertSelective(ExriseUser record);

    List<ExriseUser> selectByExample(ExriseUserCriteria example);

    ExriseUser selectByPrimaryKey(Integer exriseUserId);

    int updateByExampleSelective(@Param("record") ExriseUser record, @Param("example") ExriseUserCriteria example);

    int updateByExample(@Param("record") ExriseUser record, @Param("example") ExriseUserCriteria example);

    int updateByPrimaryKeySelective(ExriseUser record);

    int updateByPrimaryKey(ExriseUser record);

    int insertBatch(@Param("recordColl") java.util.Collection<ExriseUser> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<ExriseUser> recordColl);

    ExriseUser selectByExampleForOne(ExriseUserCriteria example);
}