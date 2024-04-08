<%@ page language="java" contentType="text/html; charset=ISO-8859-1" session="false"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="login" method="post">
  <label for="fname">Email:</label><br>
  <input type="text" id="fname" name="email" placeholder="Email" ><br>
  
  <label for="fname">Password:</label><br>
  <input type="text" id="pname" name="password" placeholder="Password" ><br>

  <input type="submit" value="login">
</form>
<p>${errerr}</p>
</body>
</html>