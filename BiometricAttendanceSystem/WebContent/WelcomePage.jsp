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
<%
	String adminEmail = (String)session.getAttribute("admin_email");
	if(adminEmail !=null){
	response.sendRedirect("views/AdminHomePage.jsp");
	}
	%>

	<div class="container">
		<div class="float-right">
		<button class="btn btn-primary" onclick="window.location.href='Admin_login.jsp'">Admin</button>
		</div>
		

		<form action="LecturerLoginProcess" method="post">
		<div class="card">
			<div class="card-header">
				Lecturer Login
			</div>
			<div class="card-body">
				
					<input type="text" name="adminEmail" placeholder="Enter Email" class="form-control"></br>
					<input type="password" name="adminPassword" placeholder="Enter Password" class="form-control"></br>
			
				
			</div>
			<div class="card-footer">
				<input type="submit" value="Login" class="btn btn-primary">
				
			</div>
			
		</div>

	 </form>
	</div>
</body>
</html>