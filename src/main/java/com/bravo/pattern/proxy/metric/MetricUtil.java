package com.bravo.pattern.proxy.metric;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
public final class MetricUtil {

    private MetricUtil() {
    }

    /**
     * 监控打点
     *
     * @param targetMethod    目标方法
     * @param metricTagSetter 标签设置
     * @param <T>             目标方法结果类型
     * @return 目标方法执行结果
     */
    public static <T> T metric(Supplier<T> targetMethod, MetricTagSetter<T> metricTagSetter) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        T result = targetMethod.get();
        stopWatch.stop();
        try {
            Map<MetricTagEnum, String> tagMap = initTagMap();
            metricTagSetter.apply(result, tagMap);
            doMetric(tagMap, stopWatch.getTotalTimeMillis());
        } catch (MetricException e) {
            log.error("executeMetric打点失败", e);
        }
        return result;
    }

    private static void doMetric(Map<MetricTagEnum, String> tagMap, long totalTimeMillis) throws MetricException {
        // metricClient.send(xxx)：将 接口耗时+接口请求信息 上传数据到TSDB（时序数据库）
        log.info("接口耗时：{}毫秒, 上传打点数据：{}", totalTimeMillis, JSON.toJSONString(tagMap));
    }

    private static Map<MetricTagEnum, String> initTagMap() {
        final Map<MetricTagEnum, String> tag = new HashMap<>();
        try {
            // 请求路径
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) attributes);
                tag.put(MetricTagEnum.PATH, requestAttributes.getRequest().getRequestURI());
            }
            // 服务地址
            tag.put(MetricTagEnum.HOST, "TODO");
            // 租户ID
            tag.put(MetricTagEnum.UID, "TODO");
            // app版本
            tag.put(MetricTagEnum.APP_VERSION, "TODO");
            // app业务平台
            tag.put(MetricTagEnum.APP_PLATFORM, "TODO");
        } catch (Exception e) {
            log.error("MetricUtil#initTagMap error={}", e.getMessage());
        }
        return tag;
    }
}