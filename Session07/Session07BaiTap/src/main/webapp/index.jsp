<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session 07 - Bài Tập</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 600px; margin: 30px auto; padding: 20px; }
        h1 { color: #2c3e50; }
        ul { list-style: none; padding: 0; }
        li { margin: 10px 0; }
        a { color: #3498db; text-decoration: none; font-size: 16px; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<h1>Session 07 - Danh Sách Bài Tập</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/restaurant/form">Ex01 - Restaurant Profile</a></li>
    <li><a href="${pageContext.request.contextPath}/dish/add">Ex02 - Dish (Thymeleaf)</a></li>
    <li><a href="${pageContext.request.contextPath}/ex03/food/add">Ex03 - Food Upload</a></li>
    <li><a href="${pageContext.request.contextPath}/ex04/food/add">Ex04 - Food Detail</a></li>
    <li><a href="${pageContext.request.contextPath}/ex05/combo/add">Ex05 - Siêu Combo & Global Exception</a></li>
</ul>
</body>
</html>
