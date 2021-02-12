<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
	<div class="container">
	
	<form action="${pageContext.request.contextPath}/CourseController" method="post">
		Enter Course code: <input type="text" name="courseCode" value="${course.courseCode}"/></br>
		Enter Course title: <input type="text" name="courseTitle" value="${course.courseTitle}"/></br>
		<input type="hidden" value="${course.id}" name="id">
		<button class="btn btn-primary" type="submit">Save Course</button>
	</form>
		
	</div>
</body>
</html>