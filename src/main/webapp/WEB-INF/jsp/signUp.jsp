<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>Sign up</h1>

  <form action="Controller" method ="post">

      <input type="hidden" name="command" value="registration">
  Email
     <input type="text" name="email" value=""/>
     <br/>
    Login
     <input type="text" name="login" value=""/>
     <br/>
  Password
     <input type="password" name="password" value="" />
     <br/>
     <input type="submit" value="Press me" />
</form>

</body>
</html>