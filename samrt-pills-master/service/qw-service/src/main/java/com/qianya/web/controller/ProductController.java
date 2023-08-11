package com.qianya.web.controller;



import com.qianya.common.JsonResultT;
import com.qianya.entity.Product;
import com.qianya.entity.ProductUseRecord;
import com.qianya.util.CommonPage;
import com.qianya.web.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: wangxin
 * @CreateTime: 2023-06-06  18:20
 * @Description: 卡密管理
 */
@RestController
@Api(value = "ProductController", tags = "卡密管理")
@RequestMapping("/product")
public class ProductController  {


    @Autowired
    private ProductService productService;


    @PostMapping("/getAllProducts")
    @ApiOperation("获取所有卡密产品列表")
    public JsonResultT<List<Product>> getAllProducts() {
        // TODO: 实现获取所有产品列表的逻辑
        return productService.getAllProducts();
    }



    @PostMapping("/generate")
    @ApiOperation("生成待使用卡密")
    public JsonResultT<String> generateCard(@ApiParam(value = "卡密商品id")@RequestParam("productId") Integer productId) {
        if(productId==null){
            return JsonResultT.error("请传入商品id");
        }
       return productService.generateCard(productId);
    }

    @PostMapping("/getProductUseRecords")
    @ApiOperation("分页查询卡密使用记录")
    public JsonResultT<CommonPage<ProductUseRecord>> getProductUseRecords(
            @RequestParam(value = "status", required = false)
            @ApiParam(value = "卡密状态 (0:未使用; 1:已使用;2:作废)", example = "0") Integer status,
            @RequestParam(value = "productType", required = false)
            @ApiParam(value = "卡密类型 (1:周卡; 2:月卡; 3:季卡; 4:年卡)", example = "1") Integer productType,
            @RequestParam(value = "exriseWxName", required = false)
            @ApiParam(value = "使用人姓名", example = "外卖小猪") String exriseWxName,
            @RequestParam(value = "pageNum", defaultValue = "1")
            @ApiParam(value = "页码", example = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10")
            @ApiParam(value = "每页数量", example = "10") Integer pageSize) {

        return productService.getProductUseRecords(status,productType,exriseWxName,pageNum,pageSize);
    }


    @PostMapping("/deleteCard")
    @ApiOperation("作废卡密记录")
    public JsonResultT<?> deleteCard(@RequestParam(value = "recordId")Integer recordId) {
        if(recordId==null){
            return JsonResultT.error("请传入要作废的卡密记录");
        }
        return productService.deletCard(recordId);
    }







}
