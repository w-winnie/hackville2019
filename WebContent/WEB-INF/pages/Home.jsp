<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<div class="header"><jsp:include page="/WEB-INF/snippets/Header.jsp"/></div>
<form method=post action="HomeController">
<input type=hidden name=actionvaal value=Login>
 <input type=submit value=Login>
</form>
<form method=get action="RegisterController">
<input type=hidden name=actionvaal value=Register>
 <input type=submit value=Register>
</form>

<div class="footer"><jsp:include page="/WEB-INF/snippets/Footer.jsp"/></div>
</body>
</html>