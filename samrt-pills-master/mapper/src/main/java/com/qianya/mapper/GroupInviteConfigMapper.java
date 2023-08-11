package com.qianya.mapper;

import com.qianya.entity.GroupInviteConfig;
import com.qianya.entity.GroupInviteConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupInviteConfigMapper {
    long countByExample(GroupInviteConfigCriteria example);

    int deleteByExample(GroupInviteConfigCriteria example);

    int deleteByPrimaryKey(Integer configId);

    int insert(GroupInviteConfig record);

    int insertSelective(GroupInviteConfig record);

    List<GroupInviteConfig> selectByExample(GroupInviteConfigCriteria example);

    GroupInviteConfig selectByPrimaryKey(Integer configId);

    int updateByExampleSelective(@Param("record") GroupInviteConfig record, @Param("example") GroupInviteConfigCriteria example);

    int updateByExample(@Param("record") GroupInviteConfig record, @Param("example") GroupInviteConfigCriteria example);

    int updateByPrimaryKeySelective(GroupInviteConfig record);

    int updateByPrimaryKey(GroupInviteConfig record);

    int insertBatch(@Param("recordColl") java.util.Collection<GroupInviteConfig> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<GroupInviteConfig> recordColl);

    GroupInviteConfig selectByExampleForOne(GroupInviteConfigCriteria example);
}