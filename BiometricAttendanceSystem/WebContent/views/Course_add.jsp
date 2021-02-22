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

	<a href="${pageContext.request.contextPath}/CourseController?action=LIST" class="btn btn-primary">Course List</a>
         <a href="${pageContext.request.contextPath}/LecturerController?action=LIST" class="btn btn-primary">Lecturer List</a>
         <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Student List</a>
	  
		<div class="float-right">
		<a href="${pageContext.request.contextPath}/AdminLogout.jsp">Logout</a>
		</div>
	<div class="container">
	 
		
			<div class="row">
				<div class="col-md-4">
				 <h2>Add Course</h2>
					<form action="${pageContext.request.contextPath}/CourseController" method="post">
					<input type="text" name="courseCode" value="${course.courseCode}" placeholder="Enter Course Code" class="form-control"/></br>
					<input type="text" name="courseTitle" value="${course.courseTitle}" placeholder="Enter Course Title" class="form-control"/></br>
					<input type="hidden" value="${course.id}" name="id">
					<button class="btn btn-primary" type="submit">Save</button>
					</form>
				</div>
				
		 
			</div>
	
	</div>
</body>
</html>