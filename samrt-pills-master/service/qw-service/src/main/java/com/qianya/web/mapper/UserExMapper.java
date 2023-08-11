package com.qianya.web.mapper;

import com.qianya.entity.ProductUseRecord;
import com.qianya.entity.User;
import com.qianya.model.out.ProductUseRecordDtoOut;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserExMapper {
    /***
     *  查询用户by姓名
     * @param phone
     * @return
     */
    User findUserByName(@Param("phone") String phone);


    @Update("UPDATE exrise_user  SET is_delete = 1,login_status= 0 WHERE exrise_user_id = #{exriseUserId}")
    int deleteByExriseUserId(@Param("exriseUserId") Integer exriseUserId);

    List<ProductUseRecordDtoOut> searchProductUseRecords(@Param("keyword") String keyword);

    List<ProductUseRecordDtoOut> searchByCarmi(@Param("carmis") List<String> carmis);



}