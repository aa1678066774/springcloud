package com.tww.stream.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * @program: root
 * @description: 学生测试类
 * @author: weiweiTang
 * @create: 2019-09-26 15:11
 */
@Data
public class Student {
    int no;
    String name;
    String sex;
    float height;

    public Student(int no, String name, String sex, float height) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
