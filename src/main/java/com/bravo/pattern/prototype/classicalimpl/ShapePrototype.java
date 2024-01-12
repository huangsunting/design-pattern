package com.bravo.pattern.prototype.classicalimpl;

public interface ShapePrototype {

    /**
     * 要求子类支持拷贝。
     * 所谓拷贝，类型一定与原来一致，所以返回值类型也是ShapePrototype
     */
    ShapePrototype copy();

}