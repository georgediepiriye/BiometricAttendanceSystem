<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.DBConnectionUtil"%>
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
</head>
<link href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<a href="${pageContext.request.contextPath}/CourseController?action=LIST" class="btn btn-primary">Course List</a>
         <a href="${pageContext.request.contextPath}/LecturerController?action=LIST" class="btn btn-primary">Lecturer List</a>
         <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Student List</a>
	 
	  
		<div class="float-right">
		<a href="${pageContext.request.contextPath}/AdminLogout.jsp">Logout</a>
		</div>


	<div class="container">
	
			<div class="row">
				<div class="col-md-4">
				 <h2>Add Lecturer</h2>
					<form action="${pageContext.request.contextPath}/LecturerController" method="post">
					<input type="text" name="lecturerTitle" value="${lecturer.lecturerTitle}" placeholder="Enter Title" class="form-control"/></br>
					<input type="text" name="lecturerFirstName" value="${lecturer.lecturerFirstName}" placeholder="Enter Firstname" class="form-control"/></br>
					<input type="text" name="lecturerLastName" value="${lecturer.lecturerLastName}" placeholder="Enter Lastname" class="form-control"/></br>
					<input type="text" name="lecturerEmail" value="${lecturer.lecturerEmail}" placeholder="Enter Email" class="form-control"/></br>
					<input type="text" name="lecturerPassword" value="${lecturer.lecturerPassword}" placeholder="Enter Password" class="form-control"/></br>
					
						
					<label>Assign Course</label><br>
					
					<select name="lecturerCourseCode" id="lecturerCourseCode">
					<option>Select Course Code</option>
					<%
					
					try{
						String sql = "SELECT course_code FROM courses";
					   Connection	connection = DBConnectionUtil.openConnection();
					   PreparedStatement preparedStatement = connection.prepareStatement(sql);
					   ResultSet rs =  preparedStatement.executeQuery();
					   while(rs.next()){
						   %>
						    <option value="<%=rs.getString("course_code")%>"><%=rs.getString("course_code")%></option>
						   <% 
					   }
					
						
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					%>
					
					
					</select></br></br>
						<select name="lecturerCourseTitle" id="lecturerCourseTitle">
						<option>Select Course Title</option>
						<%
     try{
    	  
    	 
    
    	 String sql = "SELECT course_title FROM courses";
    	 Connection connection = DBConnectionUtil.openConnection();
    	 Statement statement = connection.createStatement();
    	 ResultSet resultset = statement.executeQuery(sql);
    	 while(resultset.next()){
    		 
    		 
    		%>
    		<option value="<%=resultset.getString("course_title")%>"><%=resultset.getString("course_title")%></option>
    		<% 
    	 }
    	 
     }catch(Exception e){
    	 e.printStackTrace();
     }
		
%>
						 
						</select></br>
					<input type="hidden" value="${lecturer.lecturerId}" name="lecturerId"></br>
					<button class="btn btn-primary" type="submit">Save</button>
					</form>
				</div>
				
		 
			</div>
	
	</div>
</body>
</html>