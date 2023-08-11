package com.qianya.mapper;

import com.qianya.entity.UserConfig;
import com.qianya.entity.UserConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserConfigMapper {
    long countByExample(UserConfigCriteria example);

    int deleteByExample(UserConfigCriteria example);

    int deleteByPrimaryKey(Integer configId);

    int insert(UserConfig record);

    int insertSelective(UserConfig record);

    List<UserConfig> selectByExample(UserConfigCriteria example);

    UserConfig selectByPrimaryKey(Integer configId);

    int updateByExampleSelective(@Param("record") UserConfig record, @Param("example") UserConfigCriteria example);

    int updateByExample(@Param("record") UserConfig record, @Param("example") UserConfigCriteria example);

    int updateByPrimaryKeySelective(UserConfig record);

    int updateByPrimaryKey(UserConfig record);

    int insertBatch(@Param("recordColl") java.util.Collection<UserConfig> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<UserConfig> recordColl);

    UserConfig selectByExampleForOne(UserConfigCriteria example);
}