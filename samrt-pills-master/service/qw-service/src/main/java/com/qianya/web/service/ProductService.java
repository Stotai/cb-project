package com.qianya.web.service;

import com.qianya.common.JsonResultT;
import com.qianya.entity.Product;
import com.qianya.entity.ProductUseRecord;
import com.qianya.util.CommonPage;

import java.util.List;

public interface ProductService {



    JsonResultT<List<Product>> getAllProducts();


    JsonResultT<String> generateCard(Integer productId);


    JsonResultT<CommonPage<ProductUseRecord>> getProductUseRecords(Integer status, Integer productType, String exriseWxName, Integer pageNum, Integer pageSize);

    JsonResultT<?> deletCard(Integer recordId);

}
