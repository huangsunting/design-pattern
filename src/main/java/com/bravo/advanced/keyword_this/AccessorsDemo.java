package com.bravo.advanced.keyword_this;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class AccessorsDemo {

    public static void main(String[] args) {
        new Son().setSonName("").setFatherName("");
        // new Father().setFatherName("").setSonName("");
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    static class Father {
        private String fatherName;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    static class Son extends Father {
        private String sonName;
    }
}