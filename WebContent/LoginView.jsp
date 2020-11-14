<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CRIS Login view</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<h2>Login</h2>
	<form action="LoginServlet" method="post">
		<input type="text" name="email" placeholder="Email"/>
		<input type="password" name="password" placeholder="Password"/>
		<button type="submit">Login</button>
	</form>

</body>
</html>