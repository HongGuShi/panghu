package com.panghu.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panghu.common.utils.IDUtils;
import com.panghu.study.dao.StudentMapper;
import com.panghu.study.dto.StudentDTO;
import com.panghu.study.entity.Student;
import com.panghu.study.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> pageStudentInfo(StudentDTO studentDTO) {
        PageHelper.startPage(studentDTO.getPageNum(), studentDTO.getPageSize());
        List<Student> students = studentMapper.pageStudentInfo(studentDTO);
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
