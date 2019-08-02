package com.tww.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-30 16:18
 */
@Document(indexName = "user_index", type = "user")
@Data
public class UserEntity {
    @Id
    private String id;
    private String name;
    private int sex;
    private int age;
}
