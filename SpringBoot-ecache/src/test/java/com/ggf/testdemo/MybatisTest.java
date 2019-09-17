//package com.ggf.testdemo;
//
//import java.util.List;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @description: mybatis测试
// * @author: guoqiangfeng
// * @create: 2019-08-29 09:33
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestdemoApplication.class)
//@EnableAutoConfiguration
//public class MybatisTest {
//
//  @Autowired
//  private TeacherDao teacherDao;
//
//  /**
//   *
//   * @author guoqiangfeng
//   * @Description: 测试单表查询
//   * @date: 2019/8/29 10:04
//   * @param
//   * @return
//   */
//  @Test
//  public void testSingelSelect(){
//    Teacher teacher = teacherDao.selectTeacherById(1);
//    System.out.println(teacher.toString());
//  }
//
//
//  @Test
//  public void testSingleInsert(){
//    Teacher teacher = new Teacher();
//    teacher.setName("曹操");
//    teacher.setClassName("魏国");
//    teacherDao.insertTeacher(teacher);
//  }
//
//
//  @Test
//  public void testSingleDelete(){
//    teacherDao.deleteTeacher(6);
//  }
//
//  @Test
//  public void testSingleUpdate(){
//    Teacher teacher = new Teacher();
//    teacher.setId(2);
//    teacher.setName("司马懿");
//    teacherDao.updateTeacher(teacher);
//  }
//
//  @Test
//  public void testSelectAllTeacher(){
//    List<Teacher> teachers = teacherDao.selectAllTeacher();
//    for(Teacher teacher : teachers){
//      System.out.println(teacher.toString());
//    }
//  }
//}
