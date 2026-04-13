<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ex05 - Lỗi Hệ Thống</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 50px auto; padding: 20px; text-align: center; }
        .error-box { background: #ffeaea; border: 2px solid #e74c3c; border-radius: 8px; padding: 30px; margin-top: 20px; }
        h1 { color: #e74c3c; }
        .error-message { font-size: 18px; color: #c0392b; margin: 15px 0; }
        .back-link { display: inline-block; margin-top: 20px; padding: 10px 20px; background: #3498db; color: white; text-decoration: none; border-radius: 4px; }
        .back-link:hover { background: #2980b9; }
    </style>
</head>
<body>

<div class="error-box">
    <h1>⚠️ Lỗi Hệ Thống</h1>
    <p class="error-message">${error}</p>
    <a href="${pageContext.request.contextPath}/ex05/combo/add" class="back-link">← Thử lại</a>
</div>

</body>
</html>
