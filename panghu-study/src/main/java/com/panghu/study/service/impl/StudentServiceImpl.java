package com.panghu.study.service.impl;

import com.github.pagehelper.PageInfo;
import com.panghu.common.enums.ResultEnum;
import com.panghu.common.exception.BusinessException;
import com.panghu.common.utils.IDUtils;
import com.panghu.study.dao.StudentMapper;
import com.panghu.study.dto.StudentDTO;
import com.panghu.study.entity.Student;
import com.panghu.study.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    public void select(String id) {
        System.out.println(studentMapper.selectByPrimaryKey(id));
    }

    private final StudentMapper studentMapper;
    /**
     * 新增学生信息
     *
     * @param studentDTO 学生输入实体
     * @return 新增条数
     */
    @Override
    public int insertStudentInfo(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        student.setId(IDUtils.randomBaseID(16));
        student.setCreateTime(new Date());
        return studentMapper.insertSelective(student);
    }

    /**
     * 删除学生信息
     *
     * @param id id
     * @return 删除条数
     */
    @Override
    public int deleteStudentInfo(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改学生信息
     *
     * @param studentDTO 学生输入实体
     * @return 修改条数
     */
    @Override
    public int updateStudentInfo(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        student.setUpdateTime(new Date());
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    /**
     * 分页查询学生信息
     *
     * @param studentDTO 学生输入实体
     * @return 学生集合
     */
    @Override
    public PageInfo<Student> pageStudentInfo(StudentDTO studentDTO) {
        List<Student> students = studentMapper.pageStudentInfo(studentDTO);
        if (students.size() == 0) {
            throw new BusinessException(ResultEnum.ERROR.getCode());
        }
        return new PageInfo(students);
    }

    @Transactional
    public void contextLoad1() {
        Student student = new Student();
        student.setId("1");
        student.setAge(999);
        int updateTimes = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println(updateTimes);
        int i = 1 / 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩:");
        int score = scanner.nextInt();
        if (score < 60) {
            System.out.println("不及格");
        } else if (score < 70) {
            System.out.println("及格");
        } else if (score < 80) {
            System.out.println("中等");
        } else if (score < 90) {
            System.out.println("良好");
        } else {
            System.out.println("优秀");
        }
    }
}
