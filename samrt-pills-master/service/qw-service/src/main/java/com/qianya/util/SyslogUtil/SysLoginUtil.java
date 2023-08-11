package com.qianya.util.SyslogUtil;

import com.qianya.entity.SysLogin;
import com.qianya.entity.User;
import com.qianya.util.DateUtil;


public class SysLoginUtil {


    public static SysLogin insertSysLogin(User user,String token) {
        SysLogin login=new SysLogin();
        login.setUserId(user.getUserId());
        login.setUserName(user.getPhone());
        login.setToken(token);
        login.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        return  login;
    }

}
