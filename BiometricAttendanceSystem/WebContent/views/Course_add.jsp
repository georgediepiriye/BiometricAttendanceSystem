<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
<style type="text/css">
  .center {
margin: auto;
margin-top:100px;
  width: 50%;
  border: 1px solid grey;
  padding: 10px;
}

.head{
	margin: 10px;
	
}

.block{
width: 100%;


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
	
	<div class="container" >
	 
		
			<div class="row">
				<div class="col-md-4 center">
				 <h2 align="center">Add Course</h2>
					<form action="${pageContext.request.contextPath}/CourseController" method="post" >
					<input type="text" name="courseCode" value="${course.courseCode}" placeholder="Enter Course Code" class="form-control" required="required"/><br/>
					<input type="text" name="courseTitle" value="${course.courseTitle}" placeholder="Enter Course Title" class="form-control" required="required"/><br/>
					<input type="hidden" value="${course.id}" name="id">
					<button class="btn btn-primary block" type="submit">Submit</button>
					</form>
				</div>
				
		 
			</div>
	
	</div>
</body>
</html>