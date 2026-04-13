<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Sinh Viên - @ModelAttribute Demo</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; margin-top: 15px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .info-box { background: #e7f3fe; border-left: 4px solid #2196F3; padding: 15px; margin-bottom: 20px; }
        .sidebar { background: #f0f0f0; padding: 15px; border-radius: 8px; margin-top: 20px; }
    </style>
</head>
<body>

<h1>📋 Danh Sách Sinh Viên</h1>

<div class="info-box">
    <strong>💡 Dữ liệu "universities" và "majors" dưới đây được thêm tự động vào Model</strong>
    bởi các method <code>@ModelAttribute("universities")</code> và <code>@ModelAttribute("majors")</code>
    chạy trước MỌI request handler trong controller.
</div>

<table>
    <thead>
        <tr>
            <th>#</th>
            <th>Họ và tên</th>
            <th>Email</th>
            <th>Tuổi</th>
            <th>Ngành học</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.age}</td>
                <td>${student.major}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div style="display: flex; gap: 20px; margin-top: 20px;">
    <div class="sidebar">
        <h4>🏫 Trường Đại Học (từ @ModelAttribute)</h4>
        <ul>
            <c:forEach items="${universities}" var="uni">
                <li>${uni}</li>
            </c:forEach>
        </ul>
    </div>
    <div class="sidebar">
        <h4>📚 Ngành Học (từ @ModelAttribute)</h4>
        <ul>
            <c:forEach items="${majors}" var="major">
                <li>${major}</li>
            </c:forEach>
        </ul>
    </div>
</div>

<br/>
<a href="${pageContext.request.contextPath}/student/form">📝 Thêm sinh viên mới</a> |
<a href="${pageContext.request.contextPath}/">🏠 Trang chủ</a>

</body>
</html>
