package com.qianya.web.service;

import com.github.pagehelper.PageInfo;
import com.qianya.common.JsonResultT;
import com.qianya.entity.User;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.ZombieFanDtoIn;
import com.qianya.model.out.CustomerListDtoOut;
import com.qianya.model.out.ZombieFanDtoOut;
import com.qianya.util.CommonPage;

import java.util.List;

/**
 *  僵尸粉
 */
public interface ZombieFanService {

    /**
     *  wangxin 分页查询僵尸粉
     * @param pageNo
     * @param pageSize
     * @param exriseUserIds
     * @param status
     * @param custNickName
     * @return
     */
    JsonResultT<CommonPage<ZombieFanDtoOut>> getZombieFansPage(Integer pageNo, Integer pageSize, List<String> exriseUserIds, Integer status, String custNickName);


    /**
     * 批量录入僵尸粉(检测僵尸粉)
     * @param zombieFanDtoIns
     * @return
     */
    JsonResultT<?>  batchInsertZombieFans(List<ZombieFanDtoIn> zombieFanDtoIns, IUserDo user);

     int batchEditZombieFans(List<String> fanIds,Integer opType);


}
