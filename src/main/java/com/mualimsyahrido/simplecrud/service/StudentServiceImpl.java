package com.mualimsyahrido.simplecrud.service;

import com.mualimsyahrido.simplecrud.entity.Student;
import com.mualimsyahrido.simplecrud.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        log.info("saved new student");
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(String idStudent) throws NoSuchFieldException {
        return studentRepository.findById(idStudent).orElseThrow(() -> {
            log.error("student not found");
            return new NoSuchFieldException("student not found");
        });
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student editStudent(String idStudent, String name, String address) throws NoSuchFieldException {
        Student student = studentRepository.findById(idStudent).orElseThrow(() -> {
            log.error("student not found");
            return new NoSuchFieldException("student not found");
        });
        student.setName(name);
        student.setAddress(address);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String idStudent) {
        studentRepository.deleteById(idStudent);
    }
}
