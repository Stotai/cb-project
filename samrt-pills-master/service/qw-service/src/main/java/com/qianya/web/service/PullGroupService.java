package com.qianya.web.service;

import com.qianya.common.JsonResultT;
import com.qianya.entity.PullGroup;
import com.qianya.model.in.PullConfigDtoIn;
import com.qianya.model.in.PullGroupDtoIn;
import com.qianya.util.CommonPage;

import java.util.List;

/**
 * 拉取相关
 */
public interface PullGroupService {



     JsonResultT<?> addPull(PullGroupDtoIn pullGroupDtoIn);


     JsonResultT<CommonPage<PullGroup>>  findByExriseWxIdsAndPullName(List<String> exriseWxIds, String pullName, Integer status, Integer pageNum, Integer pageSize);


     JsonResultT<?>  savePullConfig(PullConfigDtoIn pullConfigDtoIn);

     JsonResultT<?> updateSendState(Integer pullId,Integer customerId,Integer state,String failMsg);

     JsonResultT<?> getPullConfig();
}
