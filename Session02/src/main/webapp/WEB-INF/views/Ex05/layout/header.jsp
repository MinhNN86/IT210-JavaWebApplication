<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h3>Xin chào ${sessionScope.loggedUser}</h3>

<c:if test="${sessionScope.role == 'hr_manager'}">
    <p>Quyền quản lý</p>
</c:if>

<a href="<c:url value='/logout'/>">Logout</a>
<hr>