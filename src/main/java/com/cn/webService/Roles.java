package com.cn.webService;


import java.io.Serializable;

/**
 * webService
 *
 * @author guowy
 * @create 2017-07-03 10:11
 **/

public class Roles implements Serializable {

    private static final long serialVersionUID = -5939599230753662529L;

    private Long id;

    private String rolename;

    private String resourceIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }
}
