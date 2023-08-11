package com.qianya.web.mapper;

import com.qianya.model.in.SchemeItemDtoIn;
import com.qianya.model.out.SchemeDraftDtoOut;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SchemeExMapper {



     void batchInsertSchemeItems(@Param("items") List<SchemeItemDtoIn> items);

     @Update("UPDATE  scheme set is_delete = 1   WHERE scheme_id = #{schemeId}")
     int deleteSchemeById(@Param("schemeId") Integer schemeId);

     @Update("UPDATE  scheme_item set is_delete = 1 where scheme_id = #{schemeId}")
     int deleteItemsBySchemeId(@Param("schemeId") Integer schemeId);

     @Select("SELECT COUNT(*) FROM scheme WHERE status = 1 AND scheme_id != #{schemeId} and user_id= #{userId}")
     int countOpenSchemesExceptCurrent(@Param("schemeId") Integer schemeId,@Param("userId") Integer userId);



     List<SchemeDraftDtoOut> getSchemeDraftDtoOutList(@Param("userId")Integer userId,@Param("content")String content);

}
