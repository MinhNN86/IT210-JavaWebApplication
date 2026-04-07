package com.example.service;

import com.example.model.DashboardSummary;
import com.example.model.Student;
import com.example.model.StudentStatus;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(String search, String faculty, String sortBy) {
        List<Student> filtered = studentRepository.filterBySearchAndFaculty(search, faculty);
        return studentRepository.sort(filtered, sortBy);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public DashboardSummary getDashboardSummary() {
        List<Student> students = studentRepository.findAll();
        int total = students.size();

        double averageGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        Student topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);

        Map<String, Double> statusPercentages = new LinkedHashMap<>();
        for (StudentStatus status : StudentStatus.values()) {
            long count = students.stream().filter(student -> student.getStatus() == status).count();
            double percent = total == 0 ? 0.0 : (count * 100.0) / total;
            statusPercentages.put(status.getLabel(), percent);
        }

        return new DashboardSummary(total, averageGpa, topStudent, statusPercentages);
    }
}

