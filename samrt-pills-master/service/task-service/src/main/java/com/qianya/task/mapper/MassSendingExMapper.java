package com.qianya.task.mapper;

import com.qianya.entity.MassSending;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MassSendingExMapper {

    List<MassSending> findMassSendList(@Param("time")String time);

    @Update("update mass_sending set execute_times=execute_times+1 where mass_id=#{massId}")
    int updateSendRes(@Param("massId")Integer massId);

}