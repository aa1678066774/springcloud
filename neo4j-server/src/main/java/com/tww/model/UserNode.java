package com.tww.model;

import org.neo4j.ogm.annotation.*;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-13 10:49
 */
@NodeEntity(label = "User")
public class UserNode {

    @Id
    @GeneratedValue
    private Long nodeId;

    @Property(name = "userId")
    private String userId;

    @Property(name = "name")
    private String name;

    @Property(name = "age")
    private int age;


    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
