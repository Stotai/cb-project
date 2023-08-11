package com.qianya.web.mapper;

import com.qianya.entity.MassSending;
import com.qianya.model.in.MassSendingDetailDtoIn;
import com.qianya.model.out.SchemeDraftDtoOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MassExMapper  {


    /**
     * 批量插入群发详情
     *
     * @param details 群发详情列表
     */
    void batchInsertMassSendingDetail(@Param("details") List<MassSendingDetailDtoIn> details);


    List<MassSending> getMassList(@Param("userId") Integer userId,@Param("massCommonType")Integer massCommonType, @Param("content") String content, @Param("exexriseUserIds") List<String> exexriseUserIds);


    List<SchemeDraftDtoOut> getMassDraftDtoOutList(@Param("userId")Integer userId, @Param("content")String content);

}
