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
	<div class="container">
	<p>${message}</p>
		<button class="btn btn-primary" onclick="window.location.href='views/course-add.jsp'">Add Course </button>
		<table border="1" class="table table-striped table-bordered">
		<tr class="thead-dark">
		
			<th>Course Code</th>
			<th>Course Title</th>
			<th>Actions</th>
			
		</tr>
		<c:forEach items="${courseList}" var ="course">
			<tr>
				<td>${course.courseCode}</td>
				<td>${course.courseTitle}</td>
				<td>
					<a href="${pageContext.request.contextPath}/CourseController?action=EDIT&id=${course.id}">Edit</a>
					<a href="${pageContext.request.contextPath}/CourseController?action=DELETE&id=${course.id}">Delete</a>
				</td>
				
				
			</tr>
		</c:forEach>
	</table>
	</div>

</body>
</html>ml>