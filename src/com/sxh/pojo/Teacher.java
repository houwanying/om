package com.sxh.pojo;

import lombok.Data;

/**
 * @Name: Teacher
 * @Description:
 * @Time: 2021/6/9 15:53
 * @Author-Email: 1175166781@qq.com
 */

public class Teacher {
    private String teacherId;
    private String tname;
    private String password;
    private int tage;
    private String tsex;
    private String tdept;
    private String tel;
    private String QQ;
    private String professional;

    public Teacher() {
    }

    public Teacher(String teacherId, String tname, String password, int tage, String tsex, String tdept, String tel, String QQ, String professional) {
        this.teacherId = teacherId;
        this.tname = tname;
        this.password = password;
        this.tage = tage;
        this.tsex = tsex;
        this.tdept = tdept;
        this.tel = tel;
        this.QQ = QQ;
        this.professional = professional;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTdept() {
        return tdept;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
}
