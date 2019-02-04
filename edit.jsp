<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editrediect.html">
<input type="hidden" name="id" value="${employee.getId()}" />
<br>
Name <input type ="text" name="name" value="${employee.getName()}"/>
<br>
Address<input type ="text" name="address" value="${employee.getAddress()}"/>
<br>
Salary<input type="text" name="salary" value="${employee.getSalary()}"/>
<br>
<input type ="submit" value ="submit">
</form>
</body>
</html>