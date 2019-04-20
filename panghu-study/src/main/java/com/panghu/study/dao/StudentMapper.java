package com.panghu.study.dao;


import com.panghu.study.dto.StudentDTO;
import com.panghu.study.entity.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> pageStudentInfo(StudentDTO studentDTO);
}