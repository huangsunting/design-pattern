package com.bravo.advanced.generic.genericclass;

/**
 * 严格来说，UserDao本身并没有直接声明泛型参数，所以它不能被称为 泛型类（Generic Class）。
 * 泛型类通常是指直接在类的声明中使用泛型参数的类。在这个例子中，BaseDao 是泛型类，而 UserDao 是对其的特定实例化。
 */
public class UserDao extends BaseDao<User> { // 给BaseDao的T“赋值”：User，确定类型参数

    /**
     * 确定类型参数的两种常见方式：
     * 1.继承一个泛型类，在子类中指定类型参数
     * 2.创建一个泛型类实例，在实例化时指定类型参数
     */
    public static void main(String[] args) {
        // 直接使用UserDao，类型参数已经在类上指定
        UserDao userDao = new UserDao();

        // BaseDao是泛型类，我们创建实例时指定类型（正常来说BaseDao会被声明为抽象类，这里仅做演示）
        BaseDao<String> stringDao = new BaseDao<>();
    }
}