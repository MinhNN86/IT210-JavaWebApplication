<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>@ModelAttribute Demo - Trang Chủ</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        .card { border: 1px solid #ddd; border-radius: 8px; padding: 20px; margin-bottom: 15px; background: #fafafa; }
        .card h3 { margin-top: 0; color: #333; }
        .card a { color: #2196F3; text-decoration: none; font-weight: bold; }
        .card a:hover { text-decoration: underline; }
        .card code { background: #e8e8e8; padding: 2px 6px; border-radius: 3px; }
        h1 { color: #4CAF50; }
        .explanation { background: #fff3cd; padding: 20px; border-radius: 8px; border-left: 4px solid #ffc107; margin-bottom: 20px; }
    </style>
</head>
<body>

<h1>🎓 @ModelAttribute Demo - Spring MVC</h1>

<div class="explanation">
    <h3>📖 @ModelAttribute là gì?</h3>
    <p><code>@ModelAttribute</code> là annotation trong Spring MVC với 2 cách sử dụng chính:</p>
    <ul>
        <li><strong>Ở mức METHOD:</strong> Tự động thêm dữ liệu vào Model trước mỗi request.
            Thường dùng để populate dropdown lists, reference data.</li>
        <li><strong>Ở mức PARAMETER:</strong> Tự động bind form data vào Java object.
            Thay thế việc gọi <code>request.getParameter()</code> thủ công.</li>
    </ul>
</div>

<div class="card">
    <h3>📝 Demo 1: Form Thêm Sinh Viên</h3>
    <p>Minh họa <code>@ModelAttribute</code> ở parameter level - Spring tự động bind form data vào <code>Student</code> object.</p>
    <p>Minh họa <code>@ModelAttribute</code> ở method level - Dropdown lists được populate tự động.</p>
    <a href="${pageContext.request.contextPath}/student/form">➡ Mở Form Thêm Sinh Viên</a>
</div>

<div class="card">
    <h3>📋 Demo 2: Danh Sách Sinh Viên</h3>
    <p>Minh họa <code>@ModelAttribute</code> method level - Dữ liệu "universities" và "majors"
       tự động có sẵn trong view dù controller không thêm trực tiếp.</p>
    <a href="${pageContext.request.contextPath}/student/list">➡ Xem Danh Sách Sinh Viên</a>
</div>

<div class="card">
    <h3>🔗 Servlet cũ (không dùng Spring MVC)</h3>
    <a href="hello-servlet">➡ Hello Servlet</a>
</div>

</body>
</html>
