package com.qianya.mapper;

import com.qianya.entity.ProductUseRecord;
import com.qianya.entity.ProductUseRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductUseRecordMapper {
    long countByExample(ProductUseRecordCriteria example);

    int deleteByExample(ProductUseRecordCriteria example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(ProductUseRecord record);

    int insertSelective(ProductUseRecord record);

    List<ProductUseRecord> selectByExample(ProductUseRecordCriteria example);

    ProductUseRecord selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") ProductUseRecord record, @Param("example") ProductUseRecordCriteria example);

    int updateByExample(@Param("record") ProductUseRecord record, @Param("example") ProductUseRecordCriteria example);

    int updateByPrimaryKeySelective(ProductUseRecord record);

    int updateByPrimaryKey(ProductUseRecord record);

    int insertBatch(@Param("recordColl") java.util.Collection<ProductUseRecord> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<ProductUseRecord> recordColl);

    ProductUseRecord selectByExampleForOne(ProductUseRecordCriteria example);
}