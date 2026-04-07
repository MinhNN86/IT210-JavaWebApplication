<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentHub - Khong tim thay</title>
    <link rel="stylesheet" href="<c:url value='/assets/css/app.css' />">
</head>
<body class="app-body">
<div class="page page-narrow">
    <section class="card empty-state">
        <h1>Khong tim thay sinh vien</h1>
        <p class="muted">${errorMessage}</p>
        <div class="actions-row">
            <a class="btn btn-primary" href="<c:url value='/students' />">Quay lai danh sach</a>
        </div>
    </section>
</div>
</body>
</html>
