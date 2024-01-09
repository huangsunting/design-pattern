package com.bravo.advanced.reflection.frameworktest;

import com.bravo.advanced.reflection.framework.TableField;
import com.bravo.advanced.reflection.framework.TableName;
import lombok.Builder;

import java.util.Date;

//CREATE TABLE `dt_user` (
//  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
//  `name` varchar(50) DEFAULT '' COMMENT '名字',
//  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
//  `birthdate` datetime DEFAULT NULL COMMENT '生日',
//  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
//  PRIMARY KEY (`id`) USING BTREE
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
@Builder
@TableName("dt_user")
public class UserDO {
    @TableField("name")
    private final String userName;
    private final Integer age;
    @TableField("birthdate")
    private final Date birthDate;
    private final Date createTime;
    private final Date updateTime;
}