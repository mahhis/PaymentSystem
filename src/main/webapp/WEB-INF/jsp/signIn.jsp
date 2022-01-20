<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Sign in</h1>

<form action="Controller" method ="post">

    <input type="hidden" name="command" value="logination">
    Login
    <input type="text" name="login" value=""/>
    <br/>
    Password
    <input type="password" name="password" value="" />
    <br/>
    <input type="submit" value="Press me" />
</form>

<br/>
<a href="Controller?command=GoToSignUpPage">Reg</a>

</body>
</html>