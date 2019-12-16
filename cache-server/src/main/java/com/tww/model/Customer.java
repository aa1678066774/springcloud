package com.tww.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-16 14:12
 */
@Data
@AllArgsConstructor
public class Customer {

    private Integer id;

    private String name;

    private Integer age;

    private Boolean isUse;
}
