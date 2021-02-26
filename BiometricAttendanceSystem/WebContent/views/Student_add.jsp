<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
         <a href="${pageContext.request.contextPath}/StudentControllerController?action=LIST" class="btn btn-primary">Student List</a>
	  
		<div class="float-right">
		<a href="${pageContext.request.contextPath}/AdminLogout.jsp">Logout</a>
		</div>
	<div class="container">
	 
		
			<div class="row">
				<div class="col-md-4">
				 <h2>Add Student</h2>
					<form action="${pageContext.request.contextPath}/StudentController" method="post" enctype="multipart/form-data">
					<input type="text" name="studentMatNum" value="${student.studentMatNum}" placeholder="Enter Matric Number" class="form-control"/></br>
					<input type="text" name="studentFirstName" value="${student.studentFirstName}" placeholder="Enter First Name" class="form-control"/></br>
					<input type="text" name="studentLastName" value="${student.studentLastName}" placeholder="Enter Last Name" class="form-control"/></br>
					<input type="text" name="studentEmail" value="${student.studentEmail}" placeholder="Enter Email" class="form-control"/><br>
					<label>Sex</label><br>
					Male <input type="radio" name="studentSex" value="male"/><br>
					Female <input type="radio" name="studentSex" value="female"/><br>
					
					
					Image <input type="file" name="studentImagePath" value="${student.studentImagePath}"/><br>
					<input type="hidden" value="${course.id}" name="studentId"><br>
					<button class="btn btn-primary" type="submit">Submit</button>
					</form>
				</div>
				
		 
			</div>
	
	</div>
</body>
</html>