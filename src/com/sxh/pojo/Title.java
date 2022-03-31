package com.sxh.pojo;

import lombok.Data;

/**
 * @Name: Title
 * @Description:
 * @Time: 2021/6/9 15:55
 * @Author-Email: 1175166781@qq.com
 */
@Data
public class Title {
    private int titleId;
    private String type;
    private String name;
    private String teacherId;
    private String src;
    private String studentId;

    public Title() {
    }

    public Title(int titleId, String type, String name, String teacherId, String src, String studentId) {
        this.titleId = titleId;
        this.type = type;
        this.name = name;
        this.teacherId = teacherId;
        this.src = src;
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
