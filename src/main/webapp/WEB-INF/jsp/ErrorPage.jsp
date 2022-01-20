<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Error</title>
</head>
<body>


<%

    String regInf = (String) request.getAttribute("registrationInf");

    if(regInf != null){
%>
<h2>
<%
        out.println(regInf);
    }
%>
</h2>


<h1>!!!!!!!!!!!!!!</h1>

</body>
</html>
