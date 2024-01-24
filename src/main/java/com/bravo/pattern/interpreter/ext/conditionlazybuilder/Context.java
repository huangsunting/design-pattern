package com.bravo.pattern.interpreter.ext.conditionlazybuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Context {

    private final Map<String, String> variables = new HashMap<>();
    private final Map<String, Supplier<String>> lazyVariables = new HashMap<>();

    public Context value(String field, String value) {
        variables.put(field, value);
        return this;
    }

    public Context lazyValue(String field, Supplier<String> lazyValueSupplier) {
        lazyVariables.put(field, lazyValueSupplier);
        return this;
    }

    public String getValue(String name) {
        // 优先从variables取值
        String value = variables.get(name);
        if (value != null) {
            return value;
        }
        // 如果取不到，尝试惰性求值
        Supplier<String> stringSupplier = lazyVariables.get(name);
        if (stringSupplier != null) {
            return stringSupplier.get();
        }
        return null;
    }
}