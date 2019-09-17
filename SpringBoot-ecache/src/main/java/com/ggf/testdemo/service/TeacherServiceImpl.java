package com.ggf.testdemo.service;

import com.ggf.testdemo.dao.TeacherDao;
import com.ggf.testdemo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @description: 教师逻辑接口的实现
 * @author: guoqiangfeng
 * @create: 2019-09-12 16:04
 */
@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  private TeacherDao teacherDao;

  @Override
  @Cacheable(cacheNames = "teacher", key = "1")
  public Teacher selectTeaherById(int id) {
    Teacher teacher = teacherDao.selectByPrimaryKey(id);
    System.out.println(teacher);
    return teacher;
  }

  @Override
  @CachePut(cacheNames = "teacher", key = "'2'")
  public Teacher updateTeacher(Teacher teacher) {
    int i = teacherDao.updateByPrimaryKey(teacher);
    return teacherDao.selectByPrimaryKey(teacher.getId());
  }

  @Override
  @CacheEvict(cacheNames = "teacher", beforeInvocation = false, allEntries = false, key = "1")
  public Integer deleteById(int id) {
    int result = teacherDao.deleteByPrimaryKey(id);
//    int i = 1 / 0;
    return result;
  }
}
