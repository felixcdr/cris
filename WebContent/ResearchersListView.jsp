<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CRIS Researchers List View</title>
</head>
<body>
<%@ include file="Header.jsp"%>

<table>
<tr>
<th>Id</th><th>Name</th><th>Last name</th>
</tr>
<c:forEach items="${researcherslist}" var="ri">
	<tr>
	    <td> <a href="ResearcherServlet?id=${ri.id}"> ${ri.id}</a></td>
		<td>${ri.name}</td>
		<td>${ri.lastname}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>