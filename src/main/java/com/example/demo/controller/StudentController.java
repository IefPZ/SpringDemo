package com.example.demo.controller;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Greeting;
import com.example.demo.pojo.ResponseModel;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    StudentMapper studentMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> listStudent() {
        ResponseModel responseModel = new ResponseModel();
        try {
            List<Student> students = studentMapper.findAll();
            responseModel.setResult(students);
            responseModel.setStatus("ok");
        } catch (Exception e) {
            responseModel.setResult(e.getClass().getName() + ":" + e.getMessage());
            responseModel.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getStudentById(@PathVariable("id") int id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            Student student = studentMapper.getStudentById(id);
            responseModel.setResult(student);
            responseModel.setStatus("ok");
        } catch (Exception e) {
            responseModel.setResult(e.getClass().getName() + ":" + e.getMessage());
            responseModel.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> addStudent(@RequestBody Student student) {
        ResponseModel responseModel = new ResponseModel();
        try {
            int id = studentMapper.insert(student);
            if (id < 0) {
                responseModel.setResult(id);
            } else {
                responseModel.setResult(id);
                responseModel.setStatus("ok");
            }
        } catch (Exception e) {
            responseModel.setResult(e.getClass().getName() + ":" + e.getMessage());
            responseModel.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModel> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        ResponseModel responseModel = new ResponseModel();

        try {
            int index = studentMapper.update(id, student);
            if (index < 0) {
                responseModel.setResult(index);
                responseModel.setStatus("fail");
            } else {
                responseModel.setResult(index);
                responseModel.setStatus("ok");
            }
        } catch (Exception e) {
            responseModel.setResult(e.getClass().getName() + ":" + e.getMessage());
            responseModel.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModel> deleteStudent(@PathVariable Integer id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            int ret = studentMapper.delete(id);
            if (ret < 0) {
                responseModel.setStatus("fail");
                responseModel.setResult(ret);
            } else {
                responseModel.setStatus("ok");
                responseModel.setResult(ret);
            }
        } catch (Exception e) {
            responseModel.setResult(e.getClass().getName() + ":" + e.getMessage());
            responseModel.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(responseModel);
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
