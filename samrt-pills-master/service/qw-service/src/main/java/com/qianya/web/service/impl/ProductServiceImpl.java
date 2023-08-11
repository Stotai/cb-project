package com.qianya.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianya.common.JsonResultT;
import com.qianya.entity.Product;
import com.qianya.entity.ProductCriteria;
import com.qianya.entity.ProductUseRecord;
import com.qianya.entity.ProductUseRecordCriteria;
import com.qianya.mapper.ProductMapper;
import com.qianya.mapper.ProductUseRecordMapper;
import com.qianya.util.CardGenerator;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.util.StringUtil;
import com.qianya.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: wangxin
 * @CreateTime: 2023-07-13  17:17
 * @Description: 卡密service
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductUseRecordMapper productUseRecordMapper;


    @Override
    public JsonResultT<List<Product>> getAllProducts() {
         return JsonResultT.ok(productMapper.selectByExample(new ProductCriteria()));
    }

    @Override
    public JsonResultT<String> generateCard(Integer productId) {
        Product product=productMapper.selectByPrimaryKey(productId);
        if(product==null){
            return JsonResultT.error("卡密商品信息不存在");
        }
        String nowTime = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        String card = CardGenerator.generateUniqueCard(productId); // 生成唯一卡密
        // TODO: 将卡密和其他字段保存到 "product_use_record" 表中，同时关联对应的商品ID
        ProductUseRecord productUseRecord=new ProductUseRecord();
        productUseRecord.setCarmi(card);
        productUseRecord.setStatus(0);
        productUseRecord.setProductName(product.getProductName());
        productUseRecord.setProductType(product.getProductType());
        productUseRecord.setProductId(productId);
        productUseRecord.setCreateTime(nowTime);
        productUseRecordMapper.insertSelective(productUseRecord);
        return JsonResultT.ok(card);
    }

    @Override
    public JsonResultT<CommonPage<ProductUseRecord>> getProductUseRecords(Integer status, Integer productType, String exriseWxName, Integer pageNum, Integer pageSize) {

        ProductUseRecordCriteria productUseRecordCriteria=new ProductUseRecordCriteria();
        ProductUseRecordCriteria.Criteria criteria=productUseRecordCriteria.createCriteria();
        if(status!=null){
            criteria.andStatusEqualTo(status);
        }
        if(productType!=null){
            criteria.andProductTypeEqualTo(productType);
        }
        if(StringUtil.isNotEmpty(exriseWxName)){
            criteria.andExriseWxNameLike("%" + exriseWxName + "%");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ProductUseRecord> productUseRecordList=productUseRecordMapper.selectByExample(productUseRecordCriteria);
        return JsonResultT.ok(CommonPage.restPage(productUseRecordList));
    }

    @Override
    public JsonResultT<?> deletCard(Integer recordId) {
           ProductUseRecord productUseRecord=new ProductUseRecord();
           productUseRecord.setRecordId(recordId);
           productUseRecord.setStatus(2);
           productUseRecordMapper.updateByPrimaryKeySelective(productUseRecord);
           return JsonResultT.ok();
    }

}
