package com.bravo.pattern.interpreter.pattern;

import java.util.HashMap;
import java.util.Map;

public class Context {
    // 包含变量值，比如a=>3，b=>8
    private final Map<Character, Integer> variables = new HashMap<>();

    public void setValue(Character variable, int value) {
        variables.put(variable, value);
    }

    public int getValue(Character variable) {
        return variables.get(variable);
    }
}