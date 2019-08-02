package com.tww.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: root
 * @description: user
 * @author: weiweiTang
 * @create: 2019-07-05 11:02
 */
public class User implements Serializable {

    private String name;

    private Date birthDay;

    public User() {
    }

    public User(String name, Date birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
