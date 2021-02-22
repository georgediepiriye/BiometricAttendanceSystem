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
			String adminEmail =  (String)session.getAttribute("admin_email");
		
		//if admin is already logged in,redirect to admin home page
		    if(adminEmail != null){
		    	response.sendRedirect("views/AdminHomePage.jsp");
		    }
	
		String status = request.getParameter("status");
		if(status != null){
			if(status.equals("false")){
				out.print("Wrong Email or Password");
			}else if(status.equals("error")){
				out.print("An error occured!");
			}
		}
		
		%>


	<div class="container">
		<form action="AdminLoginProcess" method="post">
		<div class="card">
			<div class="card-header">
				Admin Login
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