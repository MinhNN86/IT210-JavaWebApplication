package com.session07lythuyet.controller;

import com.session07lythuyet.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller minh họa 3 cách sử dụng @ModelAttribute trong Spring MVC:
 *
 * Cách 1: @ModelAttribute ở mức METHOD - Tự động thêm dữ liệu vào Model
 *         cho TẤT C CẢ các request handler trong controller này.
 *
 * Cách 2: @ModelAttribute ở mức PARAMETER - Tự động bind form data
 *         vào object (không cần model.addAttribute() thủ công).
 *
 * Cách 3: @ModelAttribute kết hợp với @PostMapping - Nhận object từ form
 *         và truyền vào method.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    // ============================================================
    // CÁCH 1: @ModelAttribute ở mức METHOD
    // ============================================================
    // Method này sẽ được gọi TỰ ĐỘNG trước MỌI handler method trong
    // controller này. Kết quả trả về sẽ được thêm vào Model với key
    // là tên attribute (ở đây là "universities").

    @ModelAttribute("universities")
    public List<String> populateUniversities() {
        System.out.println(">>> @ModelAttribute method được gọi - populateUniversities()");
        List<String> universities = new ArrayList<>();
        universities.add("ĐH Bách Khoa Hà Nội");
        universities.add("ĐH Công Nghệ Hà Nội");
        universities.add("ĐH FPT");
        universities.add("ĐH Quốc Gia Hà Nội");
        return universities;
    }

    // Method @ModelAttribute thứ 2 - thêm danh sách ngành học
    @ModelAttribute("majors")
    public List<String> populateMajors() {
        System.out.println(">>> @ModelAttribute method được gọi - populateMajors()");
        List<String> majors = new ArrayList<>();
        majors.add("Công nghệ thông tin");
        majors.add("Khoa học máy tính");
        majors.add("An toàn thông tin");
        majors.add("Trí tuệ nhân tạo");
        return majors;
    }

    // ============================================================
    // CÁCH 2 & 3: @ModelAttribute ở mức PARAMETER
    // ============================================================

    /**
     * Hiển thị form thêm sinh viên.
     * Nhờ @ModelAttribute("student"), Spring tự động tạo một Student object rỗng
     * và thêm vào Model (không cần viết model.addAttribute("student", new Student())).
     */
    @GetMapping("/form")
    public String showForm(@ModelAttribute("student") Student student) {
        System.out.println(">>> GET /student/form - Hiển thị form");
        // Spring tự động thêm student vào Model nhờ @ModelAttribute
        // Tương đương: model.addAttribute("student", student);
        return "student-form";
    }

    /**
     * Xử lý submit form.
     * Spring tự động bind tất cả form fields (name, email, age, major)
     * vào Student object thông qua setter methods.
     *
     * QUÁ TRÌNH BIND:
     * 1. Spring tạo mới Student object (hoặc dùng object có sẵn)
     * 2. Spring gọi các setter tương ứng với form field names:
     *    - name="name" -> student.setName(request.getParameter("name"))
     *    - name="email" -> student.setEmail(request.getParameter("email"))
     *    - name="age" -> student.setAge(Integer.parseInt(request.getParameter("age")))
     *    - name="major" -> student.setMajor(request.getParameter("major"))
     * 3. Object đã được populate được truyền vào method parameter
     */
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, Model model) {
        System.out.println(">>> POST /student/save - Lưu sinh viên: " + student);

        // Lúc này student đã được Spring tự động bind data từ form
        // Không cần gọi request.getParameter() thủ công!

        // Thêm thông báo thành công
        model.addAttribute("message", "Đã lưu sinh viên thành công!");
        model.addAttribute("savedStudent", student);

        return "student-result";
    }

    /**
     * Hiển thị danh sách sinh viên (minh họa @ModelAttribute method level).
     * Các attribute "universities" và "majors" đã tự động có trong Model.
     */
    @GetMapping("/list")
    public String listStudents(Model model) {
        System.out.println(">>> GET /student/list - Danh sách sinh viên");

        // Tạo dữ liệu mẫu
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyễn Văn A", "a@email.com", 20, "Công nghệ thông tin"));
        students.add(new Student("Trần Thị B", "b@email.com", 21, "Khoa học máy tính"));
        students.add(new Student("Lê Văn C", "c@email.com", 22, "An toàn thông tin"));

        model.addAttribute("students", students);

        // Lưu ý: "universities" và "majors" ĐÃ TỰ ĐỘNG có trong Model
        // nhờ 2 method @ModelAttribute ở trên!

        return "student-list";
    }
}
