package com.bravo.pattern.templatemethod.pattern;

public abstract class AbstractCodeTestTemplate {

    // 模板方法：算法骨架
    public final void templateMethod() {
        long start = System.currentTimeMillis();

        // 抽象方法：差异的部分，下推到子类实现
        executeCode();

        long end = System.currentTimeMillis();
        System.out.println("总耗时:" + (end - start));
    }

    // 延迟到子类实现
    protected abstract void executeCode();
}