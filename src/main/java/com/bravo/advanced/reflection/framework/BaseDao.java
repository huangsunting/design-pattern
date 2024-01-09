package com.bravo.advanced.reflection.framework;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseDao<T> {

    /********* 数据库相关初始化（未来可以抽取出去）*********/
    private final static BasicDataSource datasource;

    static {
        datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/demo");
        datasource.setUsername("root");
        datasource.setPassword("123456");
    }

    /********* 使用Spring的JdbcTemplate简化sql操作 *********/
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);

    private final Class<T> entityClass;

    /**
     * 构造器，在初始化时完成对实际类型参数的获取
     * 比如UserDao extends BaseDao<UserDO>，那么在new UserDao时，可以在这获取到UserDO.class对象
     * 核心逻辑：通过反射+注解，获取UserDO对象上的tableName、tableField以及tableFieldValue，拼接得到sql
     */
    @SuppressWarnings("unchecked")
    public BaseDao() {
        entityClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void add(T bean) {
        // 构建column、value、以及实际参数
        StringBuilder columnBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();
        List<Object> paramList = new ArrayList<>();
        try {
            for (Field declaredField : entityClass.getDeclaredFields()) {
                declaredField.setAccessible(true);
                Object fieldValue = declaredField.get(bean);
                // 忽略值为null的字段
                if (fieldValue != null) {
                    columnBuilder.append(this.parseColumnName(declaredField)).append(",");
                    valueBuilder.append("?").append(",");
                    paramList.add(fieldValue);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("实体类字段属性设置错误");
        }
        String columns = columnBuilder.deleteCharAt(columnBuilder.length() - 1).toString();
        String values = valueBuilder.deleteCharAt(valueBuilder.length() - 1).toString();

        // 拼接sql
        String tableName = this.parseTableName(entityClass);
        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        System.out.println("sql: " + sql);

        // 传入sql模板和模板所需的参数，执行sql
        Object[] params = paramList.toArray(new Object[0]);
        System.out.println("params: " + Arrays.toString(params));
        jdbcTemplate.update(sql, params);
    }

    private String parseTableName(Class<T> entityClass) {
        TableName tableNameAnnotation = entityClass.getAnnotation(TableName.class);
        if (tableNameAnnotation != null) {
            return tableNameAnnotation.value();
        } else {
            return StrUtil.toUnderlineCase(entityClass.getSimpleName());
        }
    }

    private String parseColumnName(Field declaredField) {
        // 换一个api玩玩：先判断是否存在@TableField
        if (declaredField.isAnnotationPresent(TableField.class)) {
            return declaredField.getAnnotation(TableField.class).value();
        } else {
            return StrUtil.toUnderlineCase(declaredField.getName());
        }
    }
}