package com.sxh.pojo;

import lombok.Data;

/**
 * @Name: Admin
 * @Description:
 * @Time: 2021/6/9 15:47
 * @Author-Email: 1175166781@qq.com
 */

public class Admin {
    private String name;
    private String password;

    public Admin() {
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
