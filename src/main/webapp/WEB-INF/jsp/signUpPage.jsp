<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.mahhis.controller.constants.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>


</head>
<body>

<div class="container">

    <form action="<%=request.getContextPath()%>/Controller" method ="post">

        ${pageContext.request.contextPath}/Controller
        <input type="hidden" name="command" value="SignUp">
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

</div>


</body>
</html>