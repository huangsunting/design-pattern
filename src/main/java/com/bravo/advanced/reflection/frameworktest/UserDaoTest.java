package com.bravo.advanced.reflection.frameworktest;

import java.util.Date;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDO user = UserDO.builder().userName("bravo1988").age(18).birthDate(new Date()).build();
        userDao.add(user);
    }
}