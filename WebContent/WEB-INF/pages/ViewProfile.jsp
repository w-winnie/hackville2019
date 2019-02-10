<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewProfile</title>
</head>
<body>
	<div class="header"><jsp:include page="/WEB-INF/snippets/Header.jsp"/></div>
		<c:forEach var = "guest" items = "${sessionScope.guests}">
			<h1>Name: ${guest.userBean.first_name} ${guest.userBean.last_name}</h1>
			<p>${guest.userBean.age} Years Old</p>
			<p>${guest.notes}</p>
		</c:forEach>
	<div class="footer"><jsp:include page="/WEB-INF/snippets/Footer.jsp"/></div>
</body>
</html>