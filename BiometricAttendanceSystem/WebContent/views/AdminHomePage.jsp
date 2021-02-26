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
         <a href="${pageContext.request.contextPath}/StudentController?action=LIST" class="btn btn-primary">Student List</a>
         
      <div class="float-right">
		<a href="${pageContext.request.contextPath}/AdminLogout.jsp">Logout</a>
		</div>
		   
    <div class="container">
      
        
      
   
      
      
    
    
    </div>

</body>
</html>