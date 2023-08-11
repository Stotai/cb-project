package com.qianya.web.mapper;

import com.qianya.model.out.ZombieFanDtoOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZombieFanExMapper {



    int batchEditZombieFans(@Param("fanIds") List<String> fanIds,@Param("opType")Integer opType,@Param("deleteTime")String deleteTime);


    List<ZombieFanDtoOut> selectZombieFans(@Param("exriseUserIds")List<String> exriseUserIds,@Param("status")Integer status,@Param("custNickName")String custNickName,@Param("userId")Integer userId);
}
