<%--
  Created by IntelliJ IDEA.
  User: nguyennhatminh
  Date: 8/4/26
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h3>Xin chào ${sessionScope.loggedUser}</h3>

<c:if test="${sessionScope.role == 'hr_manager'}">
    <p>Quyền quản lý</p>
</c:if>

<a href="<c:url value='/logout'/>">Logout</a>
<hr>
