package com.panghu.study.service;

import com.github.pagehelper.PageInfo;
import com.panghu.study.dto.StudentDTO;
import com.panghu.study.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * 新增学生信息
     *
     * @param studentDTO 学生输入实体
     * @return 新增条数
     */
    int insertStudentInfo(StudentDTO studentDTO);

    /**
     * 删除学生信息
     *
     * @param id id
     * @return 删除条数
     */
    int deleteStudentInfo(String id);

    /**
     * 修改学生信息
     *
     * @param studentDTO 学生输入实体
     * @return 修改条数
     */
    int updateStudentInfo(StudentDTO studentDTO);

    /**
     * 分页查询学生信息
     *
     * @param studentDTO 学生输入实体
     * @return 学生集合
     */
    PageInfo<Student> pageStudentInfo(StudentDTO studentDTO);
}
