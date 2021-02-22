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
         <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Student List</a>

	<div class="float-right">
		<a href="${pageContext.request.contextPath}/AdminLogout.jsp">Logout</a>
	</div>
	<div class="container">
	
	
	<p>${message}</p>
		<button class="btn btn-primary" onclick="window.location.href='views/Lecturer_add.jsp'">Add Lecturer </button>
		<table border="1" class="table table-striped table-bordered">
		<tr class="thead-dark">
		
			<th>Title</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Course Code</th>
			<th>Course Title</th>
			<th>Actions</th>
			
		</tr>
		<c:forEach items="${lecturerList}" var ="lecturer">
			<tr>
				<td>${lecturer.lecturerTitle}</td>
				<td>${lecturer.lecturerFirstName}</td>
				<td>${lecturer.lecturerLastName}</td>
				<td>${lecturer.lecturerEmail}</td>
				<td>${lecturer.lecturerCourseCode}</td>
				<td>${lecturer.lecturerCourseTitle}</td>
				
				
				<td>
					<a href="${pageContext.request.contextPath}/LecturerController?action=EDIT&id=${lecturer.lecturerId}">Edit</a>
					<a href="${pageContext.request.contextPath}/LecturerController?action=DELETE&id=${lecturer.lecturerId}">Delete</a>
				</td>
				
				
			</tr>
		</c:forEach>
	</table>
	</div>

</body>
</html>