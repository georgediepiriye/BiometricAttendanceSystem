<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
  .parent{
      display:flex;
  }
  .child{
  	margin-top: 40px;
  	margin-right: 20px;
 	margin-left: 0px;
  }
  img[src=""] {
   display: none;
}
.head{
margin: 10px;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.css"/>
 


<body>
	
<div class="head">
	<button class="btn btn-primary admin" onclick="window.location.href='views/MarkAttendance.jsp'">Mark Attendance</button>
         <a href="${pageContext.request.contextPath}/ViewAttendanceController?action=LIST" class="btn btn-primary">View Attendance</a>
           <a href="${pageContext.request.contextPath}/LecturerStudentController?action=LIST" class="btn btn-primary">Student List</a>
	  
		<div class="float-right">
		<a href="${pageContext.request.contextPath}/Logout.jsp">Logout</a>
		</div>
</div>
	
	<p>${message}</p>
	<section class="parent">
	
	
	
	<div class="container" >
	
	
		
		<table border="1" class="table table-striped table-bordered" id="datatable">
		
		<thead>
		 <tr class="thead-dark">
		
			<th>Matriculation Number</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Gender</th>
			<th>Email</th>
			
			<th>Action</th>
			
		</tr>
		</thead>
		<tbody>
		 <c:forEach items="${studentList}" var ="student">
			<tr>
			
				<td>${student.studentMatNum}</td>
				<td>${student.studentFirstName}</td>
				<td>${student.studentLastName}</td>
				<td>${student.studentSex}</td>
				<td>${student.studentEmail}</td>
				<td>
					<a href="${pageContext.request.contextPath}/LecturerStudentController?action=VIEW_IMAGE&id=${student.studentId}">Image</a>
		
				</td>
				
				
			</tr>
			
		</c:forEach>
		</tbody>
		
		
		
		
		
		
	</table>
	</div>
	
		<img class="child" src="${filename}" width="150" height="150"/>
</section>
<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.23/datatables.min.js"></script>
<script>
   $(document).ready(function(){
	   $("#datatable").DataTable();
   })
</script>
</body>
</html>