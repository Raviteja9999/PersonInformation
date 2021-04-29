<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<h1>List Employees</h1>
<h3><a href="add.htm">Add More Employee</a></h3>

<c:if test="${!empty employees}">
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>UserName</th>
			<th>SchoolCode</th>
			<th>Standard</th>
			<th>Section</th>
			<th>Medium</th>
			<th>Type</th>
			<th>Address</th>
			<th>State</th>
			<th>District</th>
			<th>Mandal</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.studentid}"/></td>
				<td><c:out value="${employee.username}"/></td>
				<td><c:out value="${employee.schoolcode}"/></td>
				<td><c:out value="${employee.standard}"/></td>
				<td><c:out value="${employee.section}"/></td>
				<td><c:out value="${employee.medium}"/></td>
				<td><c:out value="${employee.type}"/></td>
				<td><c:out value="${employee.address}"/></td>
				<td><c:out value="${employee.mandal}"/></td>
				<td><c:out value="${employee.district}"/></td>
				<td><c:out value="${employee.state}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>