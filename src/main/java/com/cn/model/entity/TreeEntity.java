package com.cn.model.entity;

/**
 * 菜单的树形处理
 *
 * @author guowy
 * @create 2017-06-20 11:01
 **/

public class TreeEntity {

    private String id;
    private String pid;
    private String name;
    private Boolean isParent;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}
