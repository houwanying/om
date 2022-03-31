package com.sxh.service.impl;

import com.sxh.dao.AdminDao;
import com.sxh.dao.Impl.AdminDaoImpl;
import com.sxh.pojo.Student;
import com.sxh.pojo.Teacher;
import com.sxh.service.AdminService;

/**
 * @Name: AdminServiceImpl
 * @Description:
 * @Time: 2021/6/11 9:24
 * @Author-Email: 1175166781@qq.com
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int AddStudent(Student student) {
        return adminDao.AddStudent(student);
    }

    @Override
    public int AddTeacher(Teacher teacher) {
        return 0;
    }
}
