package com.qianya.mapper;

import com.qianya.entity.GroupCust;
import com.qianya.entity.GroupCustCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupCustMapper {
    long countByExample(GroupCustCriteria example);

    int deleteByExample(GroupCustCriteria example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(GroupCust record);

    int insertSelective(GroupCust record);

    List<GroupCust> selectByExample(GroupCustCriteria example);

    GroupCust selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") GroupCust record, @Param("example") GroupCustCriteria example);

    int updateByExample(@Param("record") GroupCust record, @Param("example") GroupCustCriteria example);

    int updateByPrimaryKeySelective(GroupCust record);

    int updateByPrimaryKey(GroupCust record);

    int insertBatch(@Param("recordColl") java.util.Collection<GroupCust> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<GroupCust> recordColl);

    GroupCust selectByExampleForOne(GroupCustCriteria example);
}