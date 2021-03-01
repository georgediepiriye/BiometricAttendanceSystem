<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	  .center {
margin: auto;
margin-top:100px;
  width: 50%;
}

.block{
width: 100%;

}

.admin{
 position:fixed;
  margin-left: 823px;
  z-index:1;
  
  
}
body {
    background-image: url("background.jprg");
}
</style>
</head>
 <link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>

<%
	String adminEmail = (String)session.getAttribute("admin_email");
	if(adminEmail !=null){
	response.sendRedirect("views/AdminHomePage.jsp");
	}
	%>

		 <button class="btn btn-primary admin" onclick="window.location.href='Admin_login.jsp'">Admin</button>
	<div class="container center col-md-4">
		
		

		
		<form action="LecturerLoginProcess" method="post">
		<div class="card">
			<div class="card-header">
			    
				<h2 align="center">LOGIN</h2>
			</div>
			<div class="card-body">
				
					<input type="text" name="adminEmail" placeholder="Enter Email" class="form-control"><br/>
					<input type="password" name="adminPassword" placeholder="Enter Password" class="form-control"><br/>
			
				
			</div>
			<div class="card-footer">
				<input type="submit" value="Login" class="btn btn-primary block">
				
			</div>
			
		</div>

	 </form>
	</div>
	
</body>
</html>