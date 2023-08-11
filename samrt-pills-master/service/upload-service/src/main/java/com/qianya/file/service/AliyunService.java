package com.qianya.file.service;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.User;

import java.util.Map;

/**
 * <p>
 * aliyun 服务类
 * </p>
 *
 * @author lhl
 * @since 2020-07-02
 */
public interface AliyunService {

    JsonResultT<Map<String, Object>> stsAuth();
}
