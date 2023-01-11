<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>


</head>
<body>

<div class="container">


    <form action="/PaymentSystem/src/main/java/com/mahhis/controller/Controller" method="post">

        <input type="hidden" name="command" value="SignIn">
        Login
        <input type="text" name="login" value=""/>
        <br/>
        Password
        <input type="password" name="password" value=""/>
        <br/>
        <input type="submit" value="Press me"/>
    </form>
    <br/>
    <a href="Controller?command=GoToSignUpPage">Reg</a>

</div>

</body>
</html>