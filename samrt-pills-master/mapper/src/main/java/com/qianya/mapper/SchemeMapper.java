package com.qianya.mapper;

import com.qianya.entity.Scheme;
import com.qianya.entity.SchemeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchemeMapper {
    long countByExample(SchemeCriteria example);

    int deleteByExample(SchemeCriteria example);

    int deleteByPrimaryKey(Integer schemeId);

    int insert(Scheme record);

    int insertSelective(Scheme record);

    List<Scheme> selectByExample(SchemeCriteria example);

    Scheme selectByPrimaryKey(Integer schemeId);

    int updateByExampleSelective(@Param("record") Scheme record, @Param("example") SchemeCriteria example);

    int updateByExample(@Param("record") Scheme record, @Param("example") SchemeCriteria example);

    int updateByPrimaryKeySelective(Scheme record);

    int updateByPrimaryKey(Scheme record);

    int insertBatch(@Param("recordColl") java.util.Collection<Scheme> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<Scheme> recordColl);

    Scheme selectByExampleForOne(SchemeCriteria example);
}