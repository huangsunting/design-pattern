package com.bravo.advanced.generics.typeerasure;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * GenericSuperClassTest用于论述以下观点：
 * - Java确实存在泛型擦除
 * - 但Java也支持通过继承的形式保留泛型信息，并提供了与之配套地API用于获取类型信息
 * - 只能通过GenericSuperClass获取泛型父类的类型信息，因此要想获取当前类的泛型信息，只能向下拓展一个子类，再反过来通过GenericSuperClass
 */
public class GenericSuperClassTest {

    /**
     * 直接实例化
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



    // ======== BaseDAO<T>之所以成立的原因 =======

    @Test
    public void testBaseDAO() {
        // UserDAO userDAO = new UserDAO();                 // 继承
        BaseDAO<User> userDAO = new BaseDAO<User>() {       // 匿名对象
        };
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

// 思考题：观察test1/2/3的打印结果，你发现了什么？

// 答案：
// StringArrayList（继承）和 ArrayList匿名对象，虽然本质上都是继承，但层级有点区别
// AbstractList
//  - ArrayList
//      - 匿名类，new ArrayList<String>(){}是在ArrayList继承上继承
//  - StringArrayList
