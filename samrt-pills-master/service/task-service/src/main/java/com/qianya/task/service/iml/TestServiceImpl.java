package com.qianya.task.service.iml;

import com.qianya.task.service.TestService;
import com.qianya.util.DateUtil;
import com.qianya.util.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class TestServiceImpl implements TestService {
    @Value("${test.val}")
    private String testVal;
    @Override
    public void TestOne() {
        LogUtil.info(getClass(),"输出参数："+testVal+",当前时间"+ DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
    }

}
