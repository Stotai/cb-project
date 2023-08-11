package com.qianya.file.config;


import com.qianya.util.SystemConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class ProjecStartUpConfig implements ApplicationRunner {

    /**
     * @desc  创建文件夹
     * @author lhl
     * @date 2020-07-01 15:51
     * @return
    */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*创建本地文件夹*/
        String filePath = SystemConfig.filePath();
        File f = new File(filePath);
        if(!f.exists()) {
            f.mkdirs();
        }
    }
}
