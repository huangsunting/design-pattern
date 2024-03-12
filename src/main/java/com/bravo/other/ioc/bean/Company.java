package com.bravo.other.ioc.bean;


import com.bravo.other.ioc.container.annotation.Autowired;
import com.bravo.other.ioc.container.annotation.Component;

@Component
public class Company {

    @Autowired
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
