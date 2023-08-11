package com.qianya.web.mapper;

import com.qianya.entity.ExGroup;
import com.qianya.entity.GroupCust;
import com.qianya.model.in.GroupCustParamsDtoIn;
import com.qianya.model.in.GroupParamsDtoIn;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/***
 * @Description: 群管理扩展mapper
 * @Author: Wangxin
 * @date 2023-06-12 18:31
**/
public interface GroupExMapper {


    void batchInsertGroups(@Param("groups") List<ExGroup> groups);


    void insertBatchCust(@Param("groupCustList") List<GroupCust> groupCustList);


    List<ExGroup> queryGroupList(@Param("paramsDtoIn")GroupParamsDtoIn paramsDtoIn);

    List<GroupCust> selectGroupCustByParams(@Param("paramsDtoIn") GroupCustParamsDtoIn paramsDtoIn);

    @Update("UPDATE  ex_group set grouping_id = null   WHERE grouping_id = #{grouppingId}")
    void updateGroupingSetNull(@Param("grouppingId")Integer grouppingId);

}
