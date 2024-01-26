package com.bravo.advanced.keyword_static_final;

public class InitializationTest {

    public static void main(String[] args) {
        // 0：发现要new Zi，而此时内存中没有Zi这个类，而Zi又继承了Fu，所以会先加载 Fu、再加载 Zi（注意，此时只是类加载！）
        // 5：【类加载并初始化】完毕，开始【对象创建和初始化】
        Zi zi = new Zi();
    }

    static class Fu {
        // 类加载1：加载Fu，给Fu的静态字段默认初始化
        static int FU_STATIC_A = 10;

        static {
            // 类加载2：调用static代码块，给Fu静态字段初始化
            FU_STATIC_A = 11;
        }

        // 对象初始化7：初始化fu普通字段
        int a = 10;

        public void printA() {
            System.out.println("Fu PrintA:" + a);
        }

        public Fu() {
            // 对象初始化8：调用fu构造器
            printA();
        }
    }

    static class Zi extends Fu {
        // 类加载3：加载Zi，给Zi的静态字段默认初始化
        static int ZI_STATIC_A = 20;

        static {
            // 类加载4：调用static代码块，给Zi静态字段初始化
            ZI_STATIC_A = 21;
        }

        // 对象初始化9：初始化zi普通字段
        int a = 20;

        @Override
        public void printA() {
            System.out.println("Zi PrintA:" + a);
        }

        public Zi() {
            // 对象初始化6：优先初始化父对象
            super();
            // 对象初始化9：zi构造器执行完毕
            printA();
        }
    }
}