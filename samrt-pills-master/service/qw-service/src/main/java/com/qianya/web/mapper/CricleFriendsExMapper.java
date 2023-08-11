package com.qianya.web.mapper;

import com.qianya.entity.CricleDetail;
import com.qianya.model.out.CircleFriendsDtoOut;
import com.qianya.model.out.SchemeDraftDtoOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CricleFriendsExMapper  {

    void batchInsertCricleDetail(@Param("details") List<CricleDetail> details);


    List<SchemeDraftDtoOut> getMassDraftDtoOutList(@Param("userId")Integer userId, @Param("content")String content);



    List<CircleFriendsDtoOut> searchCircleFriends(
            @Param("content") String content,
            @Param("exriseWxIds") List<String> exriseWxIds
    );
}
