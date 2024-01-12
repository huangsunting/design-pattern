package com.bravo.pattern.prototype.classicalimpl;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Rectangle implements ShapePrototype {

    private final Integer length;
    private final Integer width;
    private final Integer pointX;
    private final Integer pointY;

    public Rectangle(Integer length, Integer width, Integer pointX, Integer pointY) {
        this.length = length;
        this.width = width;
        this.pointX = pointX;
        this.pointY = pointY;
    }

    @Override
    public ShapePrototype copy() {
        // 创建一个新对象，并拷贝属性
        return new Rectangle(length, width, pointX, pointY);
    }
}