package com.qianya.web.service;

import com.qianya.common.JsonResultT;
import com.qianya.model.in.CricleFriendsDtoIn;
import com.qianya.model.out.CircleFriendsDtoOut;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.util.CommonPage;



/**
 * @Author: wangxin
 * @CreateTime: 2023-07-16  16:43
 * @Description: 朋友圈相关
 */
public interface CricleFriendsService {



      JsonResultT<?> addCricle(CricleFriendsDtoIn cricleFriendsDtoIn);


      /***
       * @Description: 获取模板列表
       * @Author: Wangxin
       * @date 2023-07-02 13:40
       * @Param addSchemeParamDtoIn:
       * @return: com.qianya.common.JsonResultT<?>
       **/
      JsonResultT<CommonPage<SchemeDraftDtoOut>> draftList(String content, Integer pageNum, Integer pageSize);


      JsonResultT<?> getDrafDetail(Integer pullId);


      JsonResultT<CommonPage<CircleFriendsDtoOut>> searchCircleFriends(String content, String exriseWxIds, Integer pageNum, Integer pageSize);


      JsonResultT<?> deleteCircle(Integer circleId);



}
