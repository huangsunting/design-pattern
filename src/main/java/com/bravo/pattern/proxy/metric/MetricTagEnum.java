package com.bravo.pattern.proxy.metric;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 标签枚举
@Getter
@AllArgsConstructor
public enum MetricTagEnum {

    /*=============== 通用Tag枚举（最好是拆出去，这里简单点） ===============*/
    /**
     * 请求路径
     */
    PATH("path"),
    /**
     * 服务地址
     */
    HOST("host"),
    /**
     * 租户ID
     */
    UID("uid"),
    /**
     * APP版本
     */
    APP_VERSION("app_version"),
    /**
     * APP平台
     */
    APP_PLATFORM("app_platform"),

    /*=============== 业务Tag枚举 ===============*/

    /**
     * 业务标签
     */
    BIZ_TAG("biz_tag"),
    /**
     * 业务副标签
     */
    BIZ_SUB_TAG("biz_sub_tag"),

    // ...
    ;

    /**
     * 名称
     */
    private final String code;

}
