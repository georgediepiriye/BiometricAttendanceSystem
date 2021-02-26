<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>

<a href="${pageContext.request.contextPath}/CourseController?action=LIST" class="btn btn-primary">Course List</a>
         <a href="${pageContext.request.contextPath}/LecturerController?action=LIST" class="btn btn-primary">Lecturer List</a>
       <a href="${pageContext.request.contextPath}/StudentController?action=LIST" class="btn btn-primary">Student List</a>
<div class="float-right">
		<a href="${pageContext.request.contextPath}/AdminLogout.jsp">Logout</a>
	</div>
	
	<div class="container">
	
	
	<p>${message}</p>
		<button class="btn btn-primary" onclick="window.location.href='views/Student_add.jsp'">Add Student </button>
		<table border="1" class="table table-striped table-bordered">
		<tr class="thead-dark">
		
			<th>Matriculation Number</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Sex</th>
			<th>Email</th>
			
			<th>Actions</th>
			
		</tr>
		<c:forEach items="${studentList}" var ="student">
			<tr>
				<td>${student.studentMatNum}</td>
				<td>${student.studentFirstName}</td>
				<td>${student.studentLastName}</td>
				<td>${student.studentSex}</td>
				<td>${student.studentEmail}</td>
				<td>
					<a href="${pageContext.request.contextPath}/StudentController?action=VIEW_IMAGE&id=${student.studentId}">Image</a>
					<a href="${pageContext.request.contextPath}/StudentController?action=EDIT&id=${student.studentId}">Edit</a>
					<a href="${pageContext.request.contextPath}/StudentController?action=DELETE&id=${student.studentId}">Delete</a>
				</td>
				
				
			</tr>
		</c:forEach>
	</table>
	</div>

</body>
</html>