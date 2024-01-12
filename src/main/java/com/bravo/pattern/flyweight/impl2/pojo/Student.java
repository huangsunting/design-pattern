package com.bravo.pattern.flyweight.impl2.pojo;

import com.bravo.pattern.flyweight.impl2.FlyweightFactory;
import lombok.Data;

@Data
public class Student {

    private Long id;

    private String name;

    private String studentNumber;

    // 共享的学校信息
    private SchoolInfo schoolInfo;

    public Student(Long id, String name, String studentNumber, String schoolName, String schoolAddress, String schoolSlogan) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.schoolInfo = FlyweightFactory.getSchoolInfo(schoolName, schoolAddress, schoolSlogan);
    }
}

