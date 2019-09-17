package com.ggf.testdemo.service;

import com.ggf.testdemo.entity.Teacher;

/**
 * @description: 教师service接口
 * @author: guoqiangfeng
 * @create: 2019-09-12 16:00
 */
public interface TeacherService {

  Teacher selectTeaherById(int id);

  Teacher updateTeacher(Teacher teacher);

  Integer deleteById(int id);
}
