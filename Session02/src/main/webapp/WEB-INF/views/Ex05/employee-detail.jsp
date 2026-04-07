<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="layout/header.jsp" %>

<h2>${emp.name}</h2>

<p>Phòng: ${emp.department}</p>

<p>
    Lương:
    <c:choose>
        <c:when test="${sessionScope.role=='hr_manager'}">
            ${emp.salary}
        </c:when>
        <c:otherwise>***</c:otherwise>
    </c:choose>
</p>

<a href="<c:url value='/employees'/>">Quay lại</a>

<%@ include file="layout/footer.jsp" %>