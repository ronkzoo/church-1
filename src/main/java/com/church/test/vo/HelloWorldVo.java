package com.church.test.vo;

/**
 * Created by com on 2015. 7. 16..
 */
public class HelloWorldVo {

    String name = "";
    String id   = "";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HelloWorldVo{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}



