package com.bravo.pattern.singleton.impl6;

public enum PersonEnum {

    STUDENT("孙悟饭", 18) {
        @Override
        public void jump() {
            System.out.println("孙悟饭跳跳");
        }
    };

    private final String name;
    private final Integer age;

    PersonEnum(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 抽象方法
     */
    public abstract void jump();
}