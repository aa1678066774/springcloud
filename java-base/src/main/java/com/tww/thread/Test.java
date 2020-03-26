package com.tww.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2020-01-15 11:10
 */
public class Test {

    public static void main(String[] args) {

    }
    public Record  listToTree(List<Record> menuList){
        Map<Integer,Record> map=new HashMap<>(menuList.size());
        menuList.forEach(item->map.put(item.getId(),item));
        menuList.forEach(item->{
            Integer pid=item.getPid();
            Record record=map.get(pid);
            if(record.getChildren()==null){
                record.setChildren(new ArrayList<>());
            }
            record.getChildren().add(item);
        });
        return map.get(0);
    }
}

class Record{
    Integer id;
    String  value;
    Integer pid;
    List<Record> children;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Record> getChildren() {
        return children;
    }

    public void setChildren(List<Record> children) {
        this.children = children;
    }
}