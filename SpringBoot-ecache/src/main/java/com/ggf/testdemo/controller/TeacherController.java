package com.ggf.testdemo.controller;

import com.ggf.testdemo.entity.Teacher;
import com.ggf.testdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 教师接口
 * @author: guoqiangfeng
 * @create: 2019-09-12 15:57
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {

  @Autowired
  private TeacherService teacherService;

  @GetMapping("/getTeacherById/{id}")
  public Teacher getTeacherById(@PathVariable int id) {
     Teacher teacher = teacherService.selectTeaherById(id);
    return teacher;
  }

  @PutMapping("/updateTeacher")
  public Teacher updateTeacher(@RequestBody Teacher teacher) {
    return teacherService.updateTeacher(teacher);
  }

  @DeleteMapping("/deleteTeacher/{id}")
  public int deleteTeacher(@PathVariable int id) {
    return teacherService.deleteById(id);
  }

}
