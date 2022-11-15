package com.mualimsyahrido.simplecrud.repository;

import com.mualimsyahrido.simplecrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
