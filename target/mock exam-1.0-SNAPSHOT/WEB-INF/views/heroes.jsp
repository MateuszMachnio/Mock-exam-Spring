<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Heroes</title>
</head>
<body>
<c:if test="${heroes != null}">
<c:forEach items="${heroes}" var="hero">
    Hero name: ${hero.getKey()}, hero age: ${hero.getValue()}<br />
</c:forEach>
</c:if>
</body>
</html>
