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
	<div class="container">
		<form action="AdminLoginProcess" method="post">
		<div class="card">
			<div class="card-header">
				Login
			</div>
			<div class="card-header">
				
					<input type="text" name="adminEmail" placeholder="Enter Email" class="form-control"></br>
			
				
					<input type="password" name="adminPassword" placeholder="Enter Password" class="form-control"></br>
			
				
			</div>
			<div class="card-footer">
				<input type="submit" value="login" class="btn btn-primary">
			</div>
			
		</div>

	 </form>
	</div>
	
</body>
</html>