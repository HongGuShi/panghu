package com.panghu.study.service;

import com.github.pagehelper.PageInfo;
import com.panghu.study.dto.StudentDTO;
import com.panghu.study.entity.Student;

import java.util.List;

public interface StudentService {

    PageInfo<Student> pageStudentInfo(StudentDTO studentDTO);

    int insertStudentInfo(StudentDTO studentDTO);
}
