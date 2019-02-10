<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HostLanding</title>
</head>
<body>
<div class="header"><jsp:include page="/WEB-INF/snippets/Header.jsp"/></div>
<form method=post action="HostLandingController">
<input type=hidden name=actionvalll value=View>
 <input type=submit value=View>
</form>
<div class="footer"><jsp:include page="/WEB-INF/snippets/Footer.jsp"/></div>
</body>
</html>