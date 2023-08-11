package com.qianya.web.mapper;

import com.qianya.entity.PullCustRelation;
import com.qianya.entity.PullGroup;
import com.qianya.entity.PullGroupOpDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PullGroupExMapper {

    void batchInsertDetail(@Param("list") List<PullGroupOpDetail> pullGroupOpDetails);


    void batchInsertRelation(@Param("list") List<PullCustRelation> pullCustRelations);


    /**
     * 根据企业微信id列表、拉群名称模糊查询分页数据
     *
     * @param exriseWxIds  企业微信id列表
     * @param pullName     拉群名称（模糊查询）
     * @param status       状态
     * @param userId       用户id
     * @return 分页数据
     */
    List<PullGroup> findByExriseWxIdsAndPullName(
            @Param("exriseWxIds") List<String> exriseWxIds,
            @Param("pullName") String pullName,
            @Param("status") Integer status,
            @Param("userId") Integer userId
    );

}
