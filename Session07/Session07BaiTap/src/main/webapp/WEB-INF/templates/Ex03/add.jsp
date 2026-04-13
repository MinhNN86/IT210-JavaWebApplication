<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

<h2>Thêm món ăn</h2>

<form action="/food/add" method="post" enctype="multipart/form-data">

  Tên món: <input type="text" name="name"/><br><br>

  Danh mục:
  <select name="category">
    <option>Khai vị</option>
    <option>Món chính</option>
    <option>Đồ uống</option>
  </select><br><br>

  Giá: <input type="number" name="price"/><br><br>

  Ảnh: <input type="file" name="image"/><br><br>

  <button type="submit">Thêm</button>

</form>

<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

</body>
</html>