<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentHub - Danh sach sinh vien</title>
    <link rel="stylesheet" href="<c:url value='/assets/css/app.css' />">
</head>
<body class="app-body">
<div class="page">
    <header class="page-header">
        <h1>StudentHub - Danh sach sinh vien</h1>
        <p class="muted">Quan ly, tim kiem va theo doi ket qua hoc tap sinh vien.</p>
    </header>

    <section class="card">
        <div class="toolbar-stack">
            <div class="toolbar toolbar-nav">
                <a class="btn" href="<c:url value='/index.jsp' />">Trang chu</a>
                <a class="btn btn-primary" href="<c:url value='/dashboard' />">Xem Dashboard</a>
            </div>
            <div class="toolbar toolbar-filters">
                <a class="btn" href="<c:url value='/students?sortBy=name' />">Sap xep ten A-Z</a>
                <a class="btn" href="<c:url value='/students?sortBy=gpa' />">Sap xep GPA giam dan</a>
                <a class="btn" href="<c:url value='/students?faculty=CNTT' />">Loc khoa CNTT</a>
            </div>
        </div>

        <form class="search-box" method="get" action="<c:url value='/students' />">
            <input type="text" name="search" value="${search}" placeholder="Nhap ten sinh vien can tim..." />
            <c:if test="${not empty faculty}">
                <input type="hidden" name="faculty" value="${faculty}" />
            </c:if>
            <c:if test="${not empty sortBy}">
                <input type="hidden" name="sortBy" value="${sortBy}" />
            </c:if>
            <button class="btn btn-primary" type="submit">Tim kiem</button>
            <a class="btn" href="<c:url value='/students' />">Xoa loc</a>
        </form>

        <p class="muted">Tim thay <strong>${resultCount}</strong> sinh vien phu hop.</p>

        <div class="table-wrap">
            <table>
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Ma SV</th>
                    <th>Ho ten</th>
                    <th>Khoa</th>
                    <th>Nam nhap hoc</th>
                    <th>GPA</th>
                    <th>Trang thai</th>
                    <th>Chi tiet</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${student.studentCode}</td>
                        <td>${student.fullName}</td>
                        <td>${student.faculty}</td>
                        <td>${student.enrollmentYear}</td>
                        <td>${student.gpa}</td>
                        <td><span class="status-pill ${student.statusCssClass}">${student.statusLabel}</span></td>
                        <td><a class="table-link" href="<c:url value='/students/detail?id=${student.id}'/>">Xem</a></td>
                    </tr>
                </c:forEach>
                <c:if test="${empty students}">
                    <tr>
                        <td colspan="8" class="empty-row">Khong co sinh vien nao.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </section>
</div>
</body>
</html>

