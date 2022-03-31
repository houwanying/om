package com.sxh.service.impl;

import com.sxh.dao.Impl.userDaoImpl;
import com.sxh.dao.userDao;
import com.sxh.pojo.Admin;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;
import com.sxh.service.LoginService;

/**
 * @Name: LoginServiceImpl
 * @Description:
 * @Time: 2021/6/9 16:34
 * @Author-Email: 1175166781@qq.com
 */
public class LoginServiceImpl implements LoginService {
    private userDao userDao = new userDaoImpl();

    @Override
    public Admin selectAllAdmin(String name, String password) {
        return userDao.selectAllAdmin(name,password);
    }

    @Override
    public Teacher selectAllTeacher(String name, String password) {
        return userDao.selectAllTeacher(name,password);
    }

    @Override
    public Student selectAllStudent(String name, String password) {
        return userDao.selectAllStudent(name,password);
    }
}
