package com.qianya.web.service;

import com.qianya.common.JsonResultT;
import com.qianya.model.in.AddSchemeParamDtoIn;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.model.out.SchemeDtoOut;
import com.qianya.util.CommonPage;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-15  19:38
 * @Description: 方案管理service
 */
public interface SchemeService {


      /***
       * @Description: 新增方案
       * @Author: Wangxin
       * @date 2023-05-15 19:40
       * @Param addSchemeParamDtoIn:
       * @return: com.qianya.common.JsonResultT<?>
      **/
      JsonResultT<?> addScheme(AddSchemeParamDtoIn addSchemeParamDtoIn);

      /***
       * @Description: 删除方案
       * @Author: Wangxin
       * @date 2023-05-15 19:40
       * @Param addSchemeParamDtoIn:
       * @return: com.qianya.common.JsonResultT<?>
       **/
      JsonResultT<?> deleteScheme(Integer schemeId);


      /***
       * @Description: 获取方案列表
       * @Author: Wangxin
       * @date 2023-05-15 19:40
       * @Param addSchemeParamDtoIn:
       * @return: com.qianya.common.JsonResultT<?>
       **/
      JsonResultT<List<SchemeDtoOut>> list( );



      /***
       * @Description: 获取模板列表
       * @Author: Wangxin
       * @date 2023-07-02 13:40
       * @Param addSchemeParamDtoIn:
       * @return: com.qianya.common.JsonResultT<?>
       **/
      JsonResultT<CommonPage<SchemeDraftDtoOut>> draftList(String content,Integer pageNum,Integer pageSize);


      /***
       * @Description:  开起或关闭状态
       * @Author: Wangxin
       * @date 2023-05-16 19:43
       * @Param schemeId: 方案id
       * @Param status:  0关闭 1开起
       * @return: com.qianya.common.JsonResultT<?>
      **/
      JsonResultT<?>  updateSchemeStatus(Integer schemeId,Integer status);


      JsonResultT<SchemeDtoOut> getDrafDetail(Integer schemeId);



}
