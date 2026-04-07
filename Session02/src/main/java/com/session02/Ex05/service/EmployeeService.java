package com.session02.Ex05.service;

import com.session02.Ex05.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    public List<Employee> getAll() {
        return List.of(
                new Employee("NV001","Nguyễn Thị Lan","Kế toán",15000000,new Date(),"Đang làm"),
                new Employee("NV002","Trần Văn Hùng","Kỹ thuật",25000000,new Date(),"Đang làm"),
                new Employee("NV003","Lê Minh Đức","Kinh doanh",18500000,new Date(),"Nghỉ phép"),
                new Employee("NV004","Phạm Thu Hương","Kỹ thuật",22000000,new Date(),"Đang làm"),
                new Employee("NV005","Hoàng Văn Nam","Kế toán",12000000,new Date(),"Thử việc")
        );
    }

    public Employee findByCode(String code) {
        return getAll().stream()
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nhân viên " + code + " không tồn tại"));
    }

    public double totalSalaryIT() {
        return getAll().stream()
                .filter(e -> e.getDepartment().equals("Kỹ thuật"))
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
