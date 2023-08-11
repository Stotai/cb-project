package com.qianya.web.service.impl;

import com.qianya.common.JsonResult;
import com.qianya.model.Do.IUserDo;
import com.qianya.web.service.IndexService;
import com.qianya.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-03  19:44
 * @Description: 首页数据
 */
public class IndexServiceImpl implements IndexService {

    @Autowired
    LoginService loginService;

    @Override
    public JsonResult home(String startTime, String endTime) {

        IUserDo iUserDo=loginService.selectUser();
        //今日新增粉丝




        return null;
    }
}
