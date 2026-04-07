<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentHub - Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/assets/css/app.css' />">
</head>
<body class="app-body">
<div class="page page-narrow">
    <header class="page-header">
        <h1>Dashboard tong quan</h1>
        <p class="muted">Tong hop nhanh thong tin hoc tap cua sinh vien.</p>
    </header>

    <section class="card">
        <h2 class="section-title">Chi so chinh</h2>
        <div class="metrics-grid">
            <div class="metric-box">
                <span class="metric-label">Tong so sinh vien</span>
                <strong class="metric-value">${summary.totalStudents}</strong>
            </div>
            <div class="metric-box">
                <span class="metric-label">GPA trung binh</span>
                <strong class="metric-value"><fmt:formatNumber value="${summary.averageGpa}" minFractionDigits="2" maxFractionDigits="2" /></strong>
            </div>
            <c:if test="${not empty summary.topStudent}">
                <div class="metric-box metric-box-wide">
                    <span class="metric-label">Thu khoa</span>
                    <strong class="metric-value">${summary.topStudent.fullName}</strong>
                    <span class="muted">${summary.topStudent.studentCode} - GPA ${summary.topStudent.gpa}</span>
                </div>
            </c:if>
        </div>
    </section>

    <section class="card">
        <h2 class="section-title">Ty le theo trang thai</h2>
        <div class="stack-list">
            <c:forEach items="${summary.statusPercentages}" var="entry">
                <div class="stack-item">
                    <span>${entry.key}</span>
                    <strong><fmt:formatNumber value="${entry.value}" minFractionDigits="2" maxFractionDigits="2" />%</strong>
                </div>
            </c:forEach>
        </div>
    </section>

    <div class="actions-row">
        <a class="btn" href="<c:url value='/index.jsp' />">Trang chu</a>
        <a class="btn btn-primary" href="<c:url value='/students' />">Quay lai danh sach</a>
    </div>
</div>
</body>
</html>
