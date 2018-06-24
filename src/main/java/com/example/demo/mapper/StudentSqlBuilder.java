package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Auther: pavel.zhang
 * @Date: 2018/6/22 16:39
 * @Description:
 */
public class StudentSqlBuilder {

    public String updateStudent(Integer id, Student student) {
        String sql = new SQL() {
            {
                UPDATE("student");
                if (student.getStudentId() != null) {
                    SET("student_id=#{studentId}");
                }
                if (student.getName() != null) {
                    SET("name=#{name}");
                }
                if (student.getAge() != null) {
                    SET("age=#{student.age}");
//                    SET("age=" + student.getAge());
                }
                if (student.getSex() != null) {
                    SET("sex=#{sex}");
                }
                if (student.getBirthday() != null) {
                    SET("birthday=#{birthday}");
                }
                //WHERE("id=" + id);
                WHERE("id=#{id}");
            }
        }.toString();
        return sql;
    }

}
