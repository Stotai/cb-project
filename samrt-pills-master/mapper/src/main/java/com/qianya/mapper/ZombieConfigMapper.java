package com.qianya.mapper;

import com.qianya.entity.ZombieConfig;
import com.qianya.entity.ZombieConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZombieConfigMapper {
    long countByExample(ZombieConfigCriteria example);

    int deleteByExample(ZombieConfigCriteria example);

    int deleteByPrimaryKey(Integer configId);

    int insert(ZombieConfig record);

    int insertSelective(ZombieConfig record);

    List<ZombieConfig> selectByExample(ZombieConfigCriteria example);

    ZombieConfig selectByPrimaryKey(Integer configId);

    int updateByExampleSelective(@Param("record") ZombieConfig record, @Param("example") ZombieConfigCriteria example);

    int updateByExample(@Param("record") ZombieConfig record, @Param("example") ZombieConfigCriteria example);

    int updateByPrimaryKeySelective(ZombieConfig record);

    int updateByPrimaryKey(ZombieConfig record);

    int insertBatch(@Param("recordColl") java.util.Collection<ZombieConfig> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<ZombieConfig> recordColl);

    ZombieConfig selectByExampleForOne(ZombieConfigCriteria example);
}