package com.example.repository;

import com.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> findAll();

    Optional<Student> findById(Long id);

    List<Student> filterBySearchAndFaculty(String search, String faculty);

    List<Student> sort(List<Student> source, String sortBy);
}
