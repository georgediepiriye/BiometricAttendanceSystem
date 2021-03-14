<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="util.DBConnectionUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.course{
	   float: right;
	}
		.head{
	margin: 10px;
	
}
.submit{
    float: center;
    width: 100%;
}

  .center {
margin: auto;
  width: 50%;
  border: 2px solid grey;
  padding: 10px;
}

.submit{
 
    width: 50%;
}



</style>
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>

<div class="head">
		<button class="btn btn-primary admin" onclick="window.location.href='MarkAttendance.jsp'">Mark Attendance</button>
         <a href="${pageContext.request.contextPath}/ViewAttendanceController?action=LIST" class="btn btn-primary">View Attendance</a>
         <a href="${pageContext.request.contextPath}/LecturerStudentController?action=LIST" class="btn btn-primary">Student List</a>
         
      <div class="float-right">
		<a href="${pageContext.request.contextPath}/Logout.jsp">Logout</a>
		</div>
	</div>

 <div class="container center" >

 
 	<h1 align="center"> Mark Attendance</h1>
 
 	<%
  
   try{
	   String lecturerEmail = (String)session.getAttribute("lecturer_email");
	   String sql = "SELECT course_code,course_title FROM lecturers WHERE email=?" ;
	   Connection connection = DBConnectionUtil.openConnection();
	   PreparedStatement preparedStatement = connection.prepareStatement(sql);
	   preparedStatement.setString(1, lecturerEmail);
	   ResultSet resultSet = preparedStatement.executeQuery();
	   while(resultSet.next()){
		   %>
		   <div class="course">
		    	 Course Code: <h5><%=resultSet.getString("course_code") %></h5>
		  	    Course Title<h5><%=resultSet.getString("course_title") %></h5>
		  	    <%
		  	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		  	      Date date = new Date();
		  	      %>
		  	      Date:<h5><%=sdf.format(date)%></h5>
		  	      <img alt="" src="" width="150px" height="150px">-Fingerprint
		  	      <% 
		  	      
		  	      
		  	    %>
		    
		   </div>
		 

		   <% 
	   }	
	   
   }catch(Exception e){
	   e.printStackTrace();
   }
     
   
   
   %>
 <button class="btn btn-primary">Scan Fingerprint</button><br/><br/>
 <form method="post">
 Matriculation Number: <input type="text" ><br/><br/>
 Student Name: <input type="text"><br/><br/>
 Student Image: <img  src="images\placeholder.jpg" width="150px" height="150px"><br/><br/>
<br/><br/>
 <div align="center">
   <button class="btn btn-primary submit">Submit</button>
 </div>
 
 
 
 
 
 </form>
 </div>

</body>
</html>