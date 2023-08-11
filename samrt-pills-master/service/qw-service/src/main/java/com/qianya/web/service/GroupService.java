package com.qianya.web.service;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.GroupCust;
import com.qianya.entity.Groupping;
import com.qianya.model.in.*;
import com.qianya.util.CommonPage;

import java.util.List;

/***
 * @Description:群管理service
 * @Author: Wangxin
 * @date 2023-06-12 17:16
**/
public interface GroupService  {

      /***
       * @Description: 新增群分组
       * @Author: Wangxin
       * @date 2023-06-12 17:17
       * @Param name: 分组名称
       * @return: com.qianya.common.JsonResult
      **/
      JsonResult editGrouping(Integer grouppingId,String name);

      List<Groupping> grouppingList();

      JsonResult deleteGrouppping(Integer grouppingId );


      JsonResult refreshGroup(List<GroupDtoIn> groupDtoIns);



      JsonResult refreshGroupCust(List<GroupCustDtoIn> groupCustList);


      JsonResult groupByPing(String groupId,Integer groupingId);


      JsonResult queryGroupList(GroupParamsDtoIn groupParamsDtoIn);


      JsonResultT<CommonPage<GroupCust>> queryGroupCustList(GroupCustParamsDtoIn paramsDtoIn);


      JsonResult addGroupInviteTimes(String groupWxId,String userId);


      JsonResultT<?> saveGroupInviteConfig(GroupInviteConfigDtoIn groupInviteConfigDtoIn);


      JsonResultT<?> getGroupInviteConfig();
}
