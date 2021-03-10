
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


Check the below link for more details<br>
 <a href="UserController">click here to check DB details</a><br><br>

<c:forEach var="user" items="${mylist }">

<c:out value="${user }"></c:out>

</c:forEach>






</body>
</html>