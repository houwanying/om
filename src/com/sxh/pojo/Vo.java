package com.sxh.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Name: Vo
 * @Description:
 * @Time: 2021/6/9 15:56
 * @Author-Email: 1175166781@qq.com
 */

public class Vo {
    int code;
    String msg;
    int count;
    List<Object> data;

    public Vo() {
    }

    public Vo(int code, String msg, int count, List<Object> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
