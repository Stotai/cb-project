package com.qianya.config.offline;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import com.qianya.common.JsonResultT;
import com.qianya.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 上下线处理
 * @author Sunt.
 * @since 2021-12-20 15:02
 */
@RefreshScope
@RestController
@ConditionalOnMissingClass("org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry")
public class OfflineNacos {

    private static final String offlineOnlineToken = "_Offline.Service_";

    @Autowired(required = false)
    private NacosAutoServiceRegistration registration;

    /**
     * @description 下线操作
     * @param offlineToken 访问令牌
     * @return com.gjl.grain.center.toolkit.pojo.JsonResult<?>
     * @author Sunt.
     * @since 2021-12-20 15:02
     */
    @RequestMapping("/offline")
    public JsonResultT<?> offline(@RequestParam("offlineToken") String offlineToken) {
        if (!offlineOnlineToken.equals(offlineToken)) {
            return JsonResultT.error("非法请求，拒绝访问");
        }
        try {
            // 下线nacos
            if (registration != null) {
                registration.stop();
                LogUtil.info(getClass(), "=================== 已从nacos下线 ===================");
            }
            return JsonResultT.ok("下线成功");
        } catch (Exception e) {
            LogUtil.error(getClass(), "下线失败", e);
        }
        return JsonResultT.error("下线失败");
    }
}
