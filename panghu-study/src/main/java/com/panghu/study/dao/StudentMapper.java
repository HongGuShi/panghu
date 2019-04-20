package com.panghu.study.dao;


import com.panghu.study.dto.StudentDTO;
import com.panghu.study.entity.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 分页查询学生信息
     *
     * @param studentDTO 学生输入实体
     * @return 学生集合
     */
    List<Student> pageStudentInfo(StudentDTO studentDTO);
}