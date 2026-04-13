<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Profile Form</title>
</head>
<body>
<h2>Thông tin nhà hàng</h2>

<form:form modelAttribute="restaurant" action="/restaurant/update" method="post">

    <!-- Tên cửa hàng -->
    <label>Tên cửa hàng:</label>
    <form:input path="restaurantName" />
    <br/><br/>

    <!-- Số điện thoại -->
    <label>Số điện thoại:</label>
    <form:input path="phoneNumber" />
    <br/><br/>

    <!-- Trạng thái -->
    <label>Đang mở cửa:</label>
    <!-- hidden để xử lý false khi không check -->
    <form:checkbox path="active" value="true" />
    <br/><br/>

    <button type="submit">Lưu</button>

</form:form>

</body>
</html>
