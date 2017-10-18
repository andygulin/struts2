package com.test.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 8028989597226068116L;

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;

    public User() {
        super();
    }

    public User(Integer id, String name, Integer age, Date birthday) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}