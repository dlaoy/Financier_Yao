package com.financier.system.entity.domain;

import org.apache.ibatis.type.Alias;

@Alias(value = "user")
public class User {
    /**
     * 主键
     */
    private Long id = null;
    /**
     * 角色 ID
     */
    private Integer roleId = null;
    /**
     * 密码
     */
    private String passwd = null;
    /**
     * 用户名
     */
    private String userName = null;
    /**
     * 头像
     */
    // 【待优化】

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
