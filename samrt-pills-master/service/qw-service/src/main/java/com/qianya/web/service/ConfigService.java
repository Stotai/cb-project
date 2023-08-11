package com.qianya.web.service;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.UserConfig;
import com.qianya.model.in.ReplyConfigDtoIn;
import com.qianya.model.in.UserConfigDtoIn;
import com.qianya.model.in.ZombieConfigDtoIn;
import com.qianya.model.out.ReplyConfigDtoOut;
import com.qianya.model.out.ReplyDtoOut;
import com.qianya.util.CommonPage;

import java.util.List;

/**
 * <p>
 * 配置服务
 * </p>
 *
 * @author wangxin
 * @since 2023-05-24
 */
public interface ConfigService {


     UserConfig getByUserId(Integer userId);


     JsonResultT<?> saveOrUpdateUserConfig(UserConfigDtoIn userConfigDtoIn, Integer userId);


     JsonResult saveOrUpdateReplyConfig(ReplyConfigDtoIn replyConfigDtoIn, Integer userId);


     JsonResult deleteReplyConfig(List<Integer> configIds);


     JsonResultT<CommonPage<ReplyConfigDtoOut>> replyConfigPage(String epriseWxIds, String serachContent, Integer pageNum, Integer pageSize);


     JsonResultT<List<ReplyDtoOut>> getReplyConfig();


     JsonResult saveOrUpdateZombieConfig(ZombieConfigDtoIn zombieConfigDtoIn);


     JsonResult getZombieConfig();

     JsonResult updateZombieConfigLastTime(String executeTime);

     JsonResultT<?> replyConfigSwitch(Integer configId, Integer status);


     JsonResultT<?> getReplyConfigDetail(Integer configId);

}
