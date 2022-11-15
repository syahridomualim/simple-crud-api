package com.mualimsyahrido.simplecrud.service;

import com.mualimsyahrido.simplecrud.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    Student getStudent(String idStudent) throws NoSuchFieldException;

    List<Student> getAllStudents();

    Student editStudent(String idStudent, String name, String address) throws NoSuchFieldException;

    void deleteStudent(String idStudent);
}
