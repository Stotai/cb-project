package com.qianya.mapper;

import com.qianya.entity.CricleFriends;
import com.qianya.entity.CricleFriendsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CricleFriendsMapper {
    long countByExample(CricleFriendsCriteria example);

    int deleteByExample(CricleFriendsCriteria example);

    int deleteByPrimaryKey(Integer circleId);

    int insert(CricleFriends record);

    int insertSelective(CricleFriends record);

    List<CricleFriends> selectByExample(CricleFriendsCriteria example);

    CricleFriends selectByPrimaryKey(Integer circleId);

    int updateByExampleSelective(@Param("record") CricleFriends record, @Param("example") CricleFriendsCriteria example);

    int updateByExample(@Param("record") CricleFriends record, @Param("example") CricleFriendsCriteria example);

    int updateByPrimaryKeySelective(CricleFriends record);

    int updateByPrimaryKey(CricleFriends record);

    int insertBatch(@Param("recordColl") java.util.Collection<CricleFriends> recordColl);

    int insertBatchSel(@Param("recordColl") java.util.Collection<CricleFriends> recordColl);

    CricleFriends selectByExampleForOne(CricleFriendsCriteria example);
}