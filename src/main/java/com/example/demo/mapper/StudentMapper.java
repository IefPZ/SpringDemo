package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("insert into student(student_id, name, age, sex, birthday) values(#{studentId}, #{name}, #{age}, #{sex}, #{birthday}) ")
    int insert(Student student);

    @Select("SELECT * FROM student")
    List<Student> findAll();

    @Select("SELECT * FROM student where id=#{id}")
    Student getStudentById(Integer id);

    //@Update("update student set student_id=#{studentId}, name=#{name}, age=#{age}, sex=#{sex},birthday=#{birthday} where id=#{id}")
    @UpdateProvider(type=StudentSqlBuilder.class, method = "updateStudent")
    int update(@Param("id") Integer id, @Param("student") Student student);

    @Delete("delete from student where id=#{id}")
    int delete(Integer id);
}
