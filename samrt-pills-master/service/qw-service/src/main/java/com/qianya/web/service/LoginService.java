package com.qianya.web.service;

import com.qianya.common.JsonResult;
import com.qianya.entity.User;
import com.qianya.model.Do.IUserDo;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author lhl
 * @since 2020-07-02
 */
public interface LoginService {

    JsonResult create(String phone,String password);

    JsonResult login(String phone,String password);

    JsonResult updateStatus(Integer userId, Integer statue);

    IUserDo selectUser();
    IUserDo findUserWithId(Integer userId);

    User find(String phone);
}
