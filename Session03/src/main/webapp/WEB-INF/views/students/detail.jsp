<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentHub - Chi tiet sinh vien</title>
    <link rel="stylesheet" href="<c:url value='/assets/css/app.css' />">
</head>
<body class="app-body">
<div class="page page-narrow">
    <header class="page-header">
        <h1>Chi tiet sinh vien</h1>
        <p class="muted">Thong tin day du cua sinh vien duoc chon.</p>
    </header>

    <section class="card">
        <div class="detail-grid">
            <div class="detail-item"><span class="detail-label">ID</span><strong>${student.id}</strong></div>
            <div class="detail-item"><span class="detail-label">Ma SV</span><strong>${student.studentCode}</strong></div>
            <div class="detail-item"><span class="detail-label">Ho ten</span><strong>${student.fullName}</strong></div>
            <div class="detail-item"><span class="detail-label">Khoa</span><strong>${student.faculty}</strong></div>
            <div class="detail-item"><span class="detail-label">Nam nhap hoc</span><strong>${student.enrollmentYear}</strong></div>
            <div class="detail-item"><span class="detail-label">GPA</span><strong>${student.gpa}</strong></div>
            <div class="detail-item"><span class="detail-label">Trang thai</span><span class="status-pill ${student.statusCssClass}">${student.statusLabel}</span></div>
        </div>
    </section>

    <div class="actions-row">
        <a class="btn btn-primary" href="<c:url value='/students' />">Quay lai danh sach</a>
    </div>
</div>
</body>
</html>
