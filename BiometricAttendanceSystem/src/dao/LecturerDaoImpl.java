package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Lecturer;
import util.DBConnectionUtil;

public class LecturerDaoImpl implements LecturerDao {
	Connection connection=null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	

	@Override
	public List<Lecturer> getLecturersList() {
		
		//create reference variables
		List<Lecturer> lecturerList = null;
		Lecturer lecturer = null;
		
		try {
			lecturerList = new ArrayList<Lecturer>();
		   //create sql query
			String sql = "SELECT * FROM lecturers";
		   //get the database connection
			connection = DBConnectionUtil.openConnection();
			//create statement
			statement = connection.createStatement();
			//execute the sql query
			resultSet = statement.executeQuery(sql);
			//process the result set
			while(resultSet.next()) {
				lecturer = new Lecturer();
				lecturer.setLecturerId(resultSet.getInt("id"));
				lecturer.setLecturerTitle(resultSet.getString("title"));
				lecturer.setLecturerFirstName(resultSet.getString("first_name"));
				lecturer.setLecturerLastName(resultSet.getString("last_name"));
				lecturer.setLecturerEmail(resultSet.getString("email"));
				lecturer.setLecturerCourseCode(resultSet.getString("course_code"));
				lecturer.setLecturerCourseTitle(resultSet.getString("course_title"));
				//add course to list
				lecturerList.add(lecturer);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return list
		return lecturerList;
	
	}


	@Override
	public boolean save(Lecturer lecturer) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO lecturers(title,first_name,last_name,email,password,course_code,course_title) VALUES('"+lecturer.getLecturerCourseTitle()+"','"+lecturer.getLecturerFirstName()+"','"+lecturer.getLecturerLastName()+"','"+lecturer.getLecturerEmail()+"','"+lecturer.getLecturerPassword()+"','"+lecturer.getLecturerCourseCode()+"','"+lecturer.getLecturerCourseTitle()+"')";
		connection =	DBConnectionUtil.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		flag = true;
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}


	@Override
	public Lecturer getLecturer(int id) {
		Lecturer lecturer = null;
		try {
			lecturer = new Lecturer();
			String sql = "SELECT * FROM lecturers WHERE id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet  =  statement.executeQuery(sql);
			while(resultSet.next()) {
				lecturer.setLecturerId(resultSet.getInt("id"));
				lecturer.setLecturerTitle(resultSet.getString("title"));
				lecturer.setLecturerFirstName(resultSet.getString("first_name"));
				lecturer.setLecturerLastName(resultSet.getString("last_name"));
				lecturer.setLecturerEmail(resultSet.getString("email"));
				lecturer.setLecturerCourseCode(resultSet.getString("course_code"));
				lecturer.setLecturerCourseTitle(resultSet.getString("course_title"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lecturer;
	}


	@Override
	public boolean update(Lecturer lecturer) {
		boolean flag = false;
		try {
			String sql = "UPDATE lecturers SET title='"+lecturer.getLecturerTitle()+"', first_name='"+lecturer.getLecturerFirstName()+"',last_name='"+lecturer.getLecturerLastName()+"',email='"+lecturer.getLecturerEmail()+"',password='"+lecturer.getLecturerPassword()+"',course_code='"+lecturer.getLecturerCourseCode()+"',course_title='"+lecturer.getLecturerCourseTitle()+"' WHERE id="+lecturer.getLecturerId();
			connection=DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag= true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	
		return flag;
	}


	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM lecturers WHERE id="+id;
			connection =  DBConnectionUtil.openConnection();
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

}
