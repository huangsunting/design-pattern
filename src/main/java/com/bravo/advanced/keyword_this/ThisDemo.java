package com.bravo.advanced.keyword_this;

public class ThisDemo {

    /**
     * 子类实例化时，会隐式调用父类的无参构造
     * 所以Father构造函数中的System.out.println()会执行
     * 猜猜打印的内容是什么？
     */
    public static void main(String[] args) {
        Son son = new Son();
        Daughter daughter = new Daughter();
    }

    static class Father {
        /**
         * 父类构造函数
         */
        public Father() {
            // 打印【当前对象】所属Class的名字
            System.out.println(this.getClass().getName());
        }
    }

    static class Son extends Father {
    }

    static class Daughter extends Father {
    }
}
