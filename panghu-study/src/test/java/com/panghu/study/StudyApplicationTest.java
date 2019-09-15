package com.panghu.study;

import com.panghu.study.dao.StudentMapper;
import com.panghu.study.entity.Student;
import com.panghu.study.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudyApplicationTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentServiceImpl studentService;

    @Transactional
    public void contextLoad1() {
        Student student = new Student();
        student.setId("1");
        student.setAge(999);
        int updateTimes = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println(updateTimes);
        int i = 1 / 0;
    }


    @Test
    public void contextLoad2() {
        //contextLoad1();
       // studentService.contextLoad1();
        studentService.select("1");
    }


}
