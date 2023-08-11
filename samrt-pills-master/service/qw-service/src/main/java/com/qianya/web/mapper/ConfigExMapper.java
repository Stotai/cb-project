package com.qianya.web.mapper;

import com.qianya.entity.ReplyConfigDetail;
import com.qianya.model.out.ReplyConfigDtoOut;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfigExMapper {

    void insertBatch(@Param("details") List<ReplyConfigDetail> details);



    List<ReplyConfigDtoOut> replyConfigList(@Param("userId")Integer userId,@Param("epriseWxIds") List<String>  epriseWxIds,@Param("serachContent") String serachContent);
}
