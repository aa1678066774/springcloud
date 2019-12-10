package com.tww.model;

import lombok.Data;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-04 14:50
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
