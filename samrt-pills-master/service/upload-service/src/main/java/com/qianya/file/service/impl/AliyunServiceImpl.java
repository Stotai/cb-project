package com.qianya.file.service.impl;

import com.qianya.common.JsonResultT;
import com.qianya.file.service.AliyunService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * aliyun服务实现类
 * </p>
 *
 * @author lhl
 * @since 2020-07-02
 */
@Service
public class AliyunServiceImpl implements AliyunService {

    @Override
    public JsonResultT<Map<String, Object>> stsAuth() {
         return null;
    }
}

