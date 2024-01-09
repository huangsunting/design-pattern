package com.bravo.advanced.fluent.chain;

import lombok.Getter;
import lombok.ToString;

public class ChainCallNested {
    public static void main(String[] args) {
        RussianDollSmall small = new RussianDollBig().getMedium().getSmall();
        System.out.println(small);
    }

    @Getter
    @ToString
    static class RussianDollBig {
        public RussianDollMedium getMedium() {
            return new RussianDollMedium();
        }
    }

    @Getter
    @ToString
    static class RussianDollMedium {
        public RussianDollSmall getSmall() {
            return new RussianDollSmall();
        }
    }

    @Getter
    @ToString
    static class RussianDollSmall {
        private final String name = "RussianDollSmall";
    }
}

