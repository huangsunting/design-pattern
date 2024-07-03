package com.bravo.pattern.builder.builder.nested;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Address {

    private final String province;
    private final String city;
    private final String area;

    private Address(AddressBuilder builder) {
        this.province = builder.province;
        this.city = builder.city;
        this.area = builder.area;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private String province;
        private String city;
        private String area;

        private AddressBuilder() {
        }

        public AddressBuilder province(String province) {
            this.province = province;
            return this;
        }

        public AddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder area(String area) {
            this.area = area;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
