package com.bravo.pattern.flyweight.impl2.pojo;

import com.bravo.pattern.flyweight.impl2.FlyweightFactory;
import lombok.Data;

@Data
public class Teacher {

    private Long id;

    private String name;

    private String course;

    // 共享的学校信息
    private SchoolInfo schoolInfo;

    public Teacher(Long id, String name, String course, String schoolName, String schoolAddress, String schoolSlogan) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.schoolInfo = FlyweightFactory.getSchoolInfo(schoolName, schoolAddress, schoolSlogan);
    }
}