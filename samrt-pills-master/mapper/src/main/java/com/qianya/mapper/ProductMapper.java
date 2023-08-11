package com.qianya.mapper;

import com.qianya.entity.Product;
import com.qianya.entity.ProductCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductCriteria example);

    int deleteByExample(ProductCriteria example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductCriteria example);

    Product selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int insertBatch(@Param("recordColl") java.util.Collection<Product> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<Product> recordColl);

    Product selectByExampleForOne(ProductCriteria example);
}