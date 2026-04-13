<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết Quả - @ModelAttribute Demo</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .success-box { background: #d4edda; border: 1px solid #c3e6cb; color: #155724; padding: 15px; border-radius: 4px; margin-bottom: 20px; }
        .student-info { background: #f8f9fa; padding: 20px; border-radius: 8px; border: 1px solid #ddd; }
        .student-info table { width: 100%; }
        .student-info td { padding: 8px; }
        .student-info td:first-child { font-weight: bold; width: 150px; color: #555; }
        .info-box { background: #fff3cd; border-left: 4px solid #ffc107; padding: 15px; margin-top: 20px; }
        .back-link { margin-top: 20px; display: inline-block; }
    </style>
</head>
<body>

<h1>✅ Kết Quả Lưu Sinh Viên</h1>

<div class="success-box">
    <strong>${message}</strong>
</div>

<div class="student-info">
    <h3>📋 Thông tin sinh viên (được Spring tự động bind qua @ModelAttribute):</h3>
    <table>
        <tr>
            <td>Họ và tên:</td>
            <td>${savedStudent.name}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${savedStudent.email}</td>
        </tr>
        <tr>
            <td>Tuổi:</td>
            <td>${savedStudent.age}</td>
        </tr>
        <tr>
            <td>Ngành học:</td>
            <td>${savedStudent.major}</td>
        </tr>
    </table>
</div>

<div class="info-box">
    <strong>🔍 Điều gì đã xảy ra?</strong>
    <ol>
        <li>User điền form và nhấn <strong>Lưu</strong></li>
        <li>Spring tạo <code>Student</code> object mới</li>
        <li>Spring gọi <code>setName()</code>, <code>setEmail()</code>, <code>setAge()</code>, <code>setMajor()</code>
            với dữ liệu từ form fields</li>
        <li>Object đã được populate truyền vào <code>saveStudent()</code> method
            thông qua <code>@ModelAttribute("student")</code></li>
        <li>Controller xử lý và forward đến view này</li>
    </ol>
</div>

<br/>
<a href="${pageContext.request.contextPath}/student/form">📝 Thêm sinh viên mới</a> |
<a href="${pageContext.request.contextPath}/student/list">📋 Xem danh sách</a> |
<a href="${pageContext.request.contextPath}/">🏠 Trang chủ</a>

</body>
</html>
