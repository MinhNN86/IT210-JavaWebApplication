<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ex05 - Siêu Combo</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 800px; margin: 30px auto; padding: 20px; }
        h1 { color: #e74c3c; }
        h2 { color: #2c3e50; margin-top: 30px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input[type="text"] { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        .checkbox-group { display: grid; grid-template-columns: repeat(3, 1fr); gap: 8px; }
        .checkbox-group label { display: flex; align-items: center; font-weight: normal; cursor: pointer; }
        .checkbox-group input { margin-right: 6px; }
        input[type="file"] { margin-top: 5px; }
        button { background: #e74c3c; color: white; padding: 10px 25px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background: #c0392b; }
        .error { color: red; background: #ffeaea; padding: 10px; border-radius: 4px; margin-bottom: 15px; }
        .success { color: green; background: #eaffea; padding: 10px; border-radius: 4px; margin-bottom: 15px; }
        .combo-card { border: 1px solid #ddd; border-radius: 8px; padding: 15px; margin-bottom: 15px; background: #fafafa; }
        .combo-card img { max-width: 200px; border-radius: 4px; margin-top: 8px; }
        .combo-items { color: #555; }
        .back-link { display: inline-block; margin-top: 15px; color: #3498db; text-decoration: none; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>

<h1>🍔 Module Siêu Combo</h1>

<!-- Hiển thị thông báo lỗi -->
<c:if test="${not empty error}">
    <div class="error">⚠️ ${error}</div>
</c:if>

<!-- Hiển thị thông báo thành công -->
<c:if test="${not empty message}">
    <div class="success">✅ ${message}</div>
</c:if>

<!-- Form tạo Combo -->
<h2>Tạo Combo Mới</h2>
<form action="${pageContext.request.contextPath}/ex05/combo/add" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="name">Tên Combo:</label>
        <input type="text" id="name" name="name" required placeholder="VD: Combo Tiệc Cuối Tuần"/>
    </div>

    <div class="form-group">
        <label>Chọn các món ăn (ít nhất 2 món):</label>
        <div class="checkbox-group">
            <label><input type="checkbox" name="items" value="Burger"/> Burger</label>
            <label><input type="checkbox" name="items" value="Pizza"/> Pizza</label>
            <label><input type="checkbox" name="items" value="Fried Chicken"/> Fried Chicken</label>
            <label><input type="checkbox" name="items" value="French Fries"/> French Fries</label>
            <label><input type="checkbox" name="items" value="Salad"/> Salad</label>
            <label><input type="checkbox" name="items" value="Cola"/> Cola</label>
            <label><input type="checkbox" name="items" value="Ice Cream"/> Ice Cream</label>
            <label><input type="checkbox" name="items" value="Soup"/> Soup</label>
            <label><input type="checkbox" name="items" value="Sandwich"/> Sandwich</label>
        </div>
    </div>

    <div class="form-group">
        <label for="banner">Banner Combo (tối đa 10MB):</label>
        <input type="file" id="banner" name="banner" accept="image/*" required/>
    </div>

    <button type="submit">Tạo Combo</button>
</form>

<!-- Hiển thị Combo vừa tạo -->
<c:if test="${not empty combo}">
    <h2>🎉 Combo Vừa Tạo</h2>
    <div class="combo-card">
        <h3>${combo.name}</h3>
        <p class="combo-items">
            <strong>Các món:</strong>
            <c:forEach var="item" items="${combo.itemList}" varStatus="loop">
                ${item}${not loop.last ? ', ' : ''}
            </c:forEach>
        </p>
        <img src="${pageContext.request.contextPath}${combo.bannerPath}" alt="Banner"/>
    </div>
</c:if>

<!-- Danh sách tất cả Combo -->
<c:if test="${not empty comboList}">
    <h2>📋 Danh Sách Tất Cả Combo</h2>
    <c:forEach var="c" items="${comboList}">
        <div class="combo-card">
            <h3>${c.name}</h3>
            <p class="combo-items">
                <strong>Các món:</strong>
                <c:forEach var="item" items="${c.itemList}" varStatus="loop">
                    ${item}${not loop.last ? ', ' : ''}
                </c:forEach>
            </p>
            <img src="${pageContext.request.contextPath}${c.bannerPath}" alt="Banner"/>
        </div>
    </c:forEach>
</c:if>

<a href="${pageContext.request.contextPath}/" class="back-link">← Quay về trang chủ</a>

</body>
</html>
