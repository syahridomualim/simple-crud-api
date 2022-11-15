package com.mualimsyahrido.simplecrud.controller;

import com.mualimsyahrido.simplecrud.entity.Student;
import com.mualimsyahrido.simplecrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student response = studentService.saveStudent(student);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id-student}")
    public ResponseEntity<Student> getStudent(@PathVariable("id-student") String idStudent) throws NoSuchFieldException {
        Student response = studentService.getStudent(idStudent);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit")
    public ResponseEntity<Student> editStudent(@RequestParam("id-student") String idStudent,
                                               @RequestParam("name") String name,
                                               @RequestParam("address") String address) throws NoSuchFieldException {
        Student student = studentService.editStudent(idStudent, name, address);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> response = studentService.getAllStudents();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id-student}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id-student") String idStudent) {
        studentService.deleteStudent(idStudent);
        return ResponseEntity.ok("OK");
    }
}
