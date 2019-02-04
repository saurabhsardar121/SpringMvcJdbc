<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>All Employees</title>
<link type="text/css" rel="stylesheet" href=css/style.css>
</head>
<body>
	<h1>List Employee</h1>
	<c:if test="${!empty employees}">
	
		<table align ="left" border="1">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Address</th>
				<th>Employee Salary</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${employees}" var="emp">
				<tr>
					<td><c:out value="${emp.getId()}" /></td>
					<td><c:out value="${emp.getName()}" /></td>
					<td><c:out value="${emp.getAddress()}" /></td>
					<td><c:out value="${emp.getSalary()}" /></td>

			<td align="center">
			<a href="add.html?id=${emp.getId()}">Add</a>
			<a href="delete.html?id=${emp.getId()}">Delete</a>|
			<a href="edit.html?id=${emp.getId()}&name=${emp.getName()}&address =${emp.getAddress()}&salary=${emp.getSalary()}">Edit</a>
			</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>