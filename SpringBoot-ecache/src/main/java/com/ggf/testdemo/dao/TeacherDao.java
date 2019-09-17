package com.ggf.testdemo.dao;

import com.ggf.testdemo.entity.Teacher;
import java.util.List;

public interface TeacherDao {

  int deleteByPrimaryKey(Integer id);

  int insert(Teacher record);

  Teacher selectByPrimaryKey(Integer id);

  List<Teacher> selectAll();

  int updateByPrimaryKey(Teacher record);
}