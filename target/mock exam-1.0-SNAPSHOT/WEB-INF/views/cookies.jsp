<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies</title>
</head>
<body>
<c:forEach items="${cookies}" var="myCookie">
    Cookie name: ${myCookie.name}, Cookie value: ${myCookie.value}<br />
</c:forEach>
</body>
</html>
