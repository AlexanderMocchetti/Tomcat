<%@ page import="com.example.tomcattest.LoginChecker" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: alexandermocchetti
  Date: 09/04/24
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/login-checker" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    <label for="password">Email:</label>
    <input type="password" id="password" name="password">
    <button type="submit">Submit</button>
  </form>
  <p>
    <%= request.getParameter("message")%>
  </p>
</body>
</html>
