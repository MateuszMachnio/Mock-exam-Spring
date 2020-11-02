<%--
  Created by IntelliJ IDEA.
  User: machn
  Date: 02.11.2020
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add hero</title>
</head>
<body>
<form method="post">
    <label>Hero name:
        <input type="text" name="name"><br />
    </label>
    <label>Hero power:
        <input type="number" min="0" step="1" name="power"><br />
    </label>
    <label>Date of birth:
        <input type="date" name="date"><br />
    </label>
    <label>Hero phone:
        <input type="text" name="phone"><br />
    </label>
    <input type="submit">
</form>
</body>
</html>
