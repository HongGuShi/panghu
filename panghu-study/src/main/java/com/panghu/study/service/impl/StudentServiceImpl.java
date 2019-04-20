package com.panghu.study.service.impl;

import com.github.pagehelper.PageInfo;
import com.panghu.common.utils.IDUtils;
import com.panghu.study.dao.StudentMapper;
import com.panghu.study.dto.StudentDTO;
import com.panghu.study.entity.Student;
import com.panghu.study.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> pageStudentInfo(StudentDTO studentDTO) {
        log.info("*******************分页方法执行之前*******************");
        List<Student> students = studentMapper.pageStudentInfo(studentDTO);
        log.info("*******************分页方法执行之后*******************");
        return new PageInfo(students);
    }

    @Override
    public int insertStudentInfo(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        student.setId(IDUtils.randomBaseID(16));
        student.setCreateTime(new Date());
        return studentMapper.insertSelective(student);
    }
}
