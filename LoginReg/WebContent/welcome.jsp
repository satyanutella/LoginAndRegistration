<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate" );	

	if(session.getAttribute("myuser") == null)
		{
			response.sendRedirect("login.jsp");
		}
%>

<h3>Welcome ${ myuser }</h3>
<br>
<div class="container">

  <a  href="home.jsp">Home</a>
  <a href="userDetails.jsp">User Details</a>
  <a href="about.jsp">About Us</a>
    <a href="admin.jsp">Admin</a>
  
  </div>
  <br>
  
  <form action="Logout">
  <input type="submit" value="Logout">
  </form>

</body>
</html>