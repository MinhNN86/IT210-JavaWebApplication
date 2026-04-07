package com.example.repository.impl;

import com.example.model.Student;
import com.example.model.StudentStatus;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public StudentRepositoryImpl() {
        students.add(new Student(1L, "Dinh Dinh Thanh", "SV001", "CNTT", 2022, 3.82, StudentStatus.STUDYING));
        students.add(new Student(2L, "Tran Thi Mai", "SV002", "CNTT", 2021, 3.56, StudentStatus.DEFERRED));
        students.add(new Student(3L, "Le Quoc Bao", "SV003", "KTPM", 2020, 3.91, StudentStatus.GRADUATED));
        students.add(new Student(4L, "Pham Gia Huy", "SV004", "HTTT", 2022, 3.42, StudentStatus.STUDYING));
        students.add(new Student(5L, "Hoang Thu Ha", "SV005", "CNTT", 2023, 3.68, StudentStatus.STUDYING));
        students.add(new Student(6L, "Vo Minh Quan", "SV006", "KTPM", 2021, 3.25, StudentStatus.DEFERRED));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> filterBySearchAndFaculty(String search, String faculty) {
        String normalizedSearch = search == null ? "" : search.trim().toLowerCase();
        String normalizedFaculty = faculty == null ? "" : faculty.trim();

        return students.stream()
                .filter(student -> normalizedSearch.isBlank() || student.getFullName().toLowerCase().contains(normalizedSearch))
                .filter(student -> normalizedFaculty.isBlank() || student.getFaculty().equalsIgnoreCase(normalizedFaculty))
                .toList();
    }

    @Override
    public List<Student> sort(List<Student> source, String sortBy) {
        List<Student> sorted = new ArrayList<>(source);
        if ("name".equalsIgnoreCase(sortBy)) {
            sorted.sort(Comparator.comparing(Student::getFullName, String::compareToIgnoreCase));
        } else if ("gpa".equalsIgnoreCase(sortBy)) {
            sorted.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        }
        return sorted;
    }
}
