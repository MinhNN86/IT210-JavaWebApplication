<%--
  Created by IntelliJ IDEA.
  User: nguyennhatminh
  Date: 6/4/26
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .login-box { width: 320px; margin: 60px auto; border: 1px solid #ccc; padding: 24px; border-radius: 8px; }
        .error { color: red; margin-bottom: 10px; }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Đăng nhập hệ thống</h2>
    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>
    <form method="post" action="login">
        <label>Tài khoản:</label><br>
        <input type="text" name="username" required><br><br>
        <label>Mật khẩu:</label><br>
        <input type="password" name="password" required><br><br>
        <button type="submit">Đăng nhập</button>
    </form>
</div>
</body>
</html>
