<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="header"><jsp:include page="/WEB-INF/snippets/Header.jsp"/></div>

<h3>${guest.hostid}</h3>
<h3>${guest.notes}</h3>
<h3>${guest.userBean.first_name}</h3>
<h3>${guest.userBean.last_name}</h3>
<h3>${guest.userBean.gender}</h3>
<h3>${guest.userBean.age}</h3>
<h3>${guest.userBean.email}</h3>
<h3>${guest.userBean.password}</h3>
<h3>${guest.userBean.type}</h3>
<h3>${guest.userBean.skype_name}</h3>
<h3>${guest.userBean.street_num}</h3>
<h3>${guest.userBean.street_name}</h3>
<h3>${guest.userBean.city}</h3>
<h3>${guest.userBean.postal_code}</h3>
<h3>${guest.userBean.phone}</h3>

<form method=post>
<input type=hidden name=actionn value=CommitChange>
 <input type=submit value=Submit>
</form>
<div class="footer"><jsp:include page="/WEB-INF/snippets/Footer.jsp"/></div>
</body>
</html>