package com.bravo.pattern.flyweight.impl2.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SchoolInfo {
    private final String schoolName;

    private final String schoolAddress;

    private final String schoolSlogan;
}