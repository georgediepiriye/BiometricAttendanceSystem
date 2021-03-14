<%@page import="util.DBConnectionUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	.head{
	margin: 10px;
	
}
.center{
margin-top: 100px;
}
.course{
float:right;
border-style: groove;
font-size: xx-small;
}

</style>
</head>
  <link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>

   

	<div class="head">
		<button class="btn btn-primary" onclick="window.location.href='MarkAttendance.jsp'">Mark Attendance</button>
         <a href="${pageContext.request.contextPath}/ViewAttendanceController?action=LIST" class="btn btn-primary">View Attendance</a>
         <a href="${pageContext.request.contextPath}/LecturerStudentController?action=LIST" class="btn btn-primary">Student List</a>
         
      <div class="float-right">
		<a href="${pageContext.request.contextPath}/Logout.jsp">Logout</a>
		</div>
	</div>
    
		   
    <div class="container">
      
        
      
  <%
  
   try{
	   String lecturerEmail = (String)session.getAttribute("lecturer_email");
	   String sql = "SELECT title,first_name,last_name,course_code,course_title FROM lecturers WHERE email=?" ;
	   Connection connection = DBConnectionUtil.openConnection();
	   PreparedStatement preparedStatement = connection.prepareStatement(sql);
	   preparedStatement.setString(1, lecturerEmail);
	   ResultSet resultSet = preparedStatement.executeQuery();
	   while(resultSet.next()){
		   %>
		   
		  	 <h5><%=resultSet.getString("course_code") %></h5>
		  	 <h5><%=resultSet.getString("course_title") %></h5>
		   
		   <h1 class="center " align="center">Welcome!</h1><br/>
		   <h2 align="center"><%=resultSet.getString("title")%> <%=resultSet.getString("first_name")%> <%=resultSet.getString("last_name")%></h2>
		   <% 
	   }
	   
   }catch(Exception e){
	   e.printStackTrace();
   }
     
   
   
   %>
    
      
    
    
    </div>

</body>
</html>