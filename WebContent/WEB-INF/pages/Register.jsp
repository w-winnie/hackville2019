<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div class="header"><jsp:include page="/WEB-INF/snippets/Header.jsp" /></div>
	<form method=post action="RegisterController">
		First name <input type="text" name="fname" value=""><br>
		Last name <input type="text" name="lname" value=""> <br>
		Gender <select name="gender">
			<option name="gender" value="male">Male</option>
			<option name="gender" value="female">Female</option>
			<option name="gender" value="other">Other</option>
		</select> <br> 
		Age <input type="number" name="age" value=""> <br>
		email <input type="email" name="email" value=""> <br>
		password <input type="password" name="pass" value=""> <br>
		type <input type="text" name="type" value=""> <br> 
		skype <input type="text" name="skype" value=""> <br> 
		phone <input type="text" name="phone" value=""> <br> 
		street number <input type="number" name="streetNumber" value=""> <br> 
		street name <input type="text" name="streetName" value=""> <br>
		city <input type="text" name="city" value=""> <br> 
		postal code <input type="text" name="postalCode" value=""> <br>
		
		dietary restriction 
		<c:forEach var="diet" items="${alldiets}">
			<input type="checkbox" name="dres" value="${diet.restriction_name}">${diet.restriction_name}<br>
		</c:forEach>
		
		language 
		<c:forEach var="lang" items="${alllanguages}">
			<input type="checkbox" name="language" value=${lang.language}>${lang.language}<br>
		</c:forEach>
		
		<input type=hidden name=actionval2 value=Register> 
		<input type=submit value=Register>
	</form>
	<div class="footer"><jsp:include page="/WEB-INF/snippets/Footer.jsp" /></div>
</body>
</html>