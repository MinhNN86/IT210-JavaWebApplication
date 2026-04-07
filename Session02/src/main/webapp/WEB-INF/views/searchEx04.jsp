<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Tìm kiếm sự kiện</title>
</head>
<body>

<!-- HEADER -->
<h2>
    Kết quả tìm kiếm cho:
    <c:out value="${keyword}" />
</h2>

<p>Tìm thấy ${fn:length(events)} sự kiện</p>

<c:if test="${empty events}">
    <p style="color:red">Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<!-- TABLE -->
<c:if test="${not empty events}">
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày</th>
            <th>Giá</th>
            <th>Vé còn</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach var="event" items="${events}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>

                <!-- chống XSS -->
                <td><c:out value="${event.name}" /></td>

                <td>${event.date}</td>

                <!-- GIÁ -->
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            MIỄN PHÍ
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number"/>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- VÉ -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:red">HẾT VÉ</span>
                        </c:when>

                        <c:when test="${event.remainingTickets < 10}">
                        <span style="color:orange">
                            Sắp hết (còn ${event.remainingTickets} vé)
                        </span>
                        </c:when>

                        <c:otherwise>
                        <span style="color:green">
                                ${event.remainingTickets}
                        </span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- ACTION -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <button disabled>Đặt vé</button>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/events/${event.id}/book'/>">
                                Đặt vé
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>

            </tr>
        </c:forEach>

    </table>
</c:if>

<!-- FOOTER -->
<c:if test="${not empty events}">
    <p>
        Sự kiện đầu tiên:
            ${fn:toUpperCase(events[0].name)}
    </p>
</c:if>

<p>
    Độ dài từ khóa: ${fn:length(keyword)} ký tự
</p>

</body>
</html>