package com.qianya.mapper;

import com.qianya.entity.SysLogin;
import com.qianya.entity.SysLoginCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginMapper {
    long countByExample(SysLoginCriteria example);

    int deleteByExample(SysLoginCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLogin record);

    int insertSelective(SysLogin record);

    List<SysLogin> selectByExample(SysLoginCriteria example);

    SysLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLogin record, @Param("example") SysLoginCriteria example);

    int updateByExample(@Param("record") SysLogin record, @Param("example") SysLoginCriteria example);

    int updateByPrimaryKeySelective(SysLogin record);

    int updateByPrimaryKey(SysLogin record);

    int insertBatch(@Param("recordColl") java.util.Collection<SysLogin> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<SysLogin> recordColl);

    SysLogin selectByExampleForOne(SysLoginCriteria example);
}