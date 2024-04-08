<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/form-checker" method="post">
      <label for="name">Name:</label>
      <input type="text" name="name" id="name">
      <label for="lastname">Lastname:</label>
      <input type="text" name="lastname" id="lastname">
      <label for="email">Email:</label>
      <input type="email" name="email" id="email">
      <label for="password">Password:</label>
      <input type="password" name="password" id="password">
      <button type="submit">Submit</button>
  </form>
</body>
</html>