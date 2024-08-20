package com.bravo.pattern.builder.builder.nested2;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Address {

    private final String province;
    private final String city;
    private final String area;

    public Address(String province, String city, String area) {
        this.province = province;
        this.city = city;
        this.area = area;
    }
}