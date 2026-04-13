<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Sinh Viên - @ModelAttribute Demo</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 120px; font-weight: bold; }
        input, select { padding: 8px; width: 300px; border: 1px solid #ccc; border-radius: 4px; }
        button { padding: 10px 20px; background: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #45a049; }
        .info-box { background: #e7f3fe; border-left: 4px solid #2196F3; padding: 15px; margin-bottom: 20px; }
        .back-link { margin-top: 20px; display: inline-block; }
    </style>
</head>
<body>

<h1>📝 Thêm Sinh Viên Mới</h1>

<div class="info-box">
    <strong>💡 @ModelAttribute Demo:</strong>
    <ul>
        <li><strong>universities</strong> và <strong>majors</strong> dropdown được populate tự động bởi
            <code>@ModelAttribute("universities")</code> và <code>@ModelAttribute("majors")</code> ở method level.</li>
        <li>Khi submit, Spring tự động bind form fields vào <code>Student</code> object
            thông qua <code>@ModelAttribute("student")</code> ở parameter level.</li>
    </ul>
</div>

<%-- Form sẽ bind vào model attribute "student" --%>
<form action="save" method="post">

    <div class="form-group">
        <label for="name">Họ và tên:</label>
        <input type="text" id="name" name="name" placeholder="Nhập họ tên..." required/>
    </div>

    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Nhập email..." required/>
    </div>

    <div class="form-group">
        <label for="age">Tuổi:</label>
        <input type="number" id="age" name="age" placeholder="Nhập tuổi..." required/>
    </div>

    <div class="form-group">
        <label for="major">Ngành học:</label>
        <%-- Danh sách majors được populate bởi @ModelAttribute("majors") method --%>
        <select id="major" name="major" required>
            <option value="">-- Chọn ngành học --</option>
            <c:forEach items="${majors}" var="major">
                <option value="${major}">${major}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label>Trường đại học:</label>
        <%-- Danh sách universities được populate bởi @ModelAttribute("universities") method --%>
        <select name="university" required>
            <option value="">-- Chọn trường --</option>
            <c:forEach items="${universities}" var="uni">
                <option value="${uni}">${uni}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit">💾 Lưu Sinh Viên</button>
</form>

<a href="${pageContext.request.contextPath}/" class="back-link">⬅ Quay về trang chủ</a>

</body>
</html>
