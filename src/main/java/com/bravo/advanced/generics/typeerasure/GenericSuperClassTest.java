package com.bravo.advanced.generics.typeerasure;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 思考题：观察test1/2/3的打印结果，你发现了什么？答案放在本类最后面
 */
public class GenericSuperClassTest {

    /**
     * 直接实例化
     * 从ArrayList往上一级，得到GenericSuperClass，也就是 AbstractList
     * 这种情况Java并不会为我们保留类型信息，会在运行时擦除
     */
    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.getClass().getGenericSuperclass()); // AbstractList<T>
    }

    /**
     * 使用继承
     * 由于【继承】时指定了泛型参数，此时Java会保留泛型信息
     */
    @Test
    public void test2() {
        StringArrayList stringArrayList = new StringArrayList();
        System.out.println(stringArrayList.getClass().getGenericSuperclass()); // AbstractList<java.lang.String>
    }

    /**
     * 使用匿名内部类
     * 本质上还是通过构建一个匿名类的方式进行【继承】
     */
    @Test
    public void test3() {
        ArrayList<String> list = new ArrayList<String>() {
        };
        System.out.println(list.getClass().getGenericSuperclass()); // ArrayList<java.lang.String>
    }

    static class StringArrayList extends AbstractList<String> {
    }

    static class ArrayList<T> extends AbstractList<T> {
    }

    static abstract class AbstractList<T> {
    }

    @Test
    public void testBaseDAO() {
        UserDAO userDAO = new UserDAO();
        // userDAO.getClass().getGenericSuperclass()
    }

    static abstract class BaseDAO<T> {
        public BaseDAO() {
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            Type rawType = ((ParameterizedType) genericSuperclass).getRawType();
            Type actualTypeArgument = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];

            System.out.println(rawType);            // BaseDAO
            System.out.println(actualTypeArgument); // User，可以反射得到字段，拼接sql
        }
    }

    // 通过继承指定类型，Java会保留泛型信息
    static class UserDAO extends BaseDAO<User> {
    }

    static class User {
    }
}
// StringArrayList（继承）和 ArrayList匿名对象，虽然本质上都是继承，但层级有点区别
// <p>
// AbstractList
//  - ArrayList
//      - 匿名类
//  - StringArrayList
