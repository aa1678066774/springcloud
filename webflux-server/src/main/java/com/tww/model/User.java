package com.tww.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-25 14:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String phone;

    private String email;

    private String name;

    private Date birthday;
}
