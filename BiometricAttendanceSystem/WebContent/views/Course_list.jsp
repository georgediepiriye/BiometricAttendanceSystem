<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  .center {
position: absolute;
align-content: center;
left: 50%;
top: 50%;
transform: translate(-50%, -50%);
padding: 10px;
}

.head{
	margin: 10px;
	
}
</style>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>

<div class="head">
	<a href="${pageContext.request.contextPath}/CourseController?action=LIST" class="btn btn-primary">Course List</a>
         <a href="${pageContext.request.contextPath}/LecturerController?action=LIST" class="btn btn-primary">Lecturer List</a>
           <a href="${pageContext.request.contextPath}/StudentController?action=LIST" class="btn btn-primary">Student List</a>
	  
		<div class="float-right">
		<a href="${pageContext.request.contextPath}/Logout.jsp">Logout</a>
		</div>
</div>
	
	<div class="container">
	
	
	<p>${message}</p>
		<button class="btn btn-primary" onclick="window.location.href='views/Course_add.jsp'">Add Course </button>
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
</html>