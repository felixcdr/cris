<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CRIS Researcher View</title>
</head>
<body>
<%@ include file="Header.jsp"%>

<c:if test="${user.id == 'root'}">
<h2>Update publications of researcher</h2>
<a href="UpdatePublicationsQueueServlet?id=${ri.id}"> ${ri.id}</a>
</c:if>

<h2>Researcher info</h2>
  <table>
	<tr><th>Id</th><th>Name</th><th>Last name</th>
	    <th>URL</th><th>Email</th></tr>
	<tr>
		<td>${ri.id}</td>
		<td>${ri.name}</td>
		<td>${ri.lastname}</td>
		<td><a href="${ri.scopusURL}">Scopus URL</a></td>
		<td>${ri.email}</td>
	</tr>
  </table>

<h2>Publications of researcher</h2>
  <table>
	<tr><th>Title</th><th>Id</th></tr>
	<c:forEach items="${pubs}" var="pi">
	  <tr>
		<td>${pi.title}</td>
	    <td> <a href="PublicationServlet?id=${pi.id}"> ${pi.id}</a></td>
	  </tr>
	</c:forEach>
  </table>
</body>
</html>