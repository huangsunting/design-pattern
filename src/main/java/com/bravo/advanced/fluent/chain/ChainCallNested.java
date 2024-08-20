package com.bravo.advanced.fluent.chain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class ChainCallNested {
    public static void main(String[] args) {
        RussianDollBig russianDoll = queryRussianDoll();
        // 这也是一种链式调用，而且每次调用返回的对象类型不同
        RussianDollSmall small = russianDoll.getMedium().getSmall();
        System.out.println(small);
    }

    private static RussianDollBig queryRussianDoll() {
        return new RussianDollBig(new RussianDollMedium(new RussianDollSmall("RussianDollSmall")));
    }

    @Getter
    @ToString
    @AllArgsConstructor
    static class RussianDollBig {
        private RussianDollMedium medium;
    }

    @Getter
    @ToString
    @AllArgsConstructor
    static class RussianDollMedium {
        private RussianDollSmall small;
    }

    @Getter
    @ToString
    @AllArgsConstructor
    static class RussianDollSmall {
        private final String name;
    }
}

