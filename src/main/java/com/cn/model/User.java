package com.cn.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User_Model
 *
 * @author guowy
 * @create 2017-05-26 17:14
 **/
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private Long id = null;
    @JsonProperty("name")
    private String name = null;
    @JsonProperty("age")
    private Integer age = null;

    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @ApiModelProperty(value = "唯一标示")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ApiModelProperty(value = "用户名")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty("用户年龄")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
