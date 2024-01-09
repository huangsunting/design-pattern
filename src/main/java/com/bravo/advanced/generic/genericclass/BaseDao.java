package com.bravo.advanced.generic.genericclass;

/**
 * 泛型类
 *
 * @param <T> 类型
 */
public class BaseDao<T> {// <T>表示类型声明

    public Long insert(T entity) { // 上面声明过了，所以这里可以使用T
        System.out.println("插入数据：" + entity);
        return null;
    }

    public T getById(Long id) {
        System.out.println("查询数据，id=" + id);
        return null;
    }

}