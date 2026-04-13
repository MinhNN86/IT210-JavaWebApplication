<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết món ăn - Ex04</title>
</head>
<body>

<h2>Chi tiết món ăn</h2>

<table border="1" cellpadding="8" cellspacing="0">
  <tr>
    <td><strong>Tên món</strong></td>
    <td>${food.name}</td>
  </tr>
  <tr>
    <td><strong>Danh mục</strong></td>
    <td>${food.category}</td>
  </tr>
  <tr>
    <td><strong>Giá</strong></td>
    <td>${food.price} VNĐ</td>
  </tr>
  <tr>
    <td><strong>Ảnh</strong></td>
    <td>
      <img src="${imageUrl}" alt="${food.name}" style="max-width:300px; max-height:300px;"/>
    </td>
  </tr>
  <tr>
    <td><strong>Đường dẫn vật lý</strong></td>
    <td>${food.imagePath}</td>
  </tr>
</table>

<br>
<a href="/ex04/food/add">Thêm món khác</a>

</body>
</html>
