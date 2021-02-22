package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import util.DBConnectionUtil;

public class CourseDaoImpl implements CourseDao {
	Connection connection=null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	

	@Override
	public List<Course> get() {
		
		//create reference variables
		List<Course> courseList = null;
		Course course = null;
		
		try {
			courseList = new ArrayList<Course>();
		   //create sql query
			String sql = "SELECT * FROM courses";
		   //get the database connection
			connection = DBConnectionUtil.openConnection();
			//create statement
			statement = connection.createStatement();
			//execute the sql query
			resultSet = statement.executeQuery(sql);
			//process the result set
			while(resultSet.next()) {
				course = new Course();
				course.setId(resultSet.getInt("id"));
				course.setCourseCode(resultSet.getString("course_code"));
				course.setCourseTitle(resultSet.getString("course_title"));
				//add course to list
				courseList.add(course);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//return list
		return courseList;
	
	}


	@Override
	public boolean save(Course c) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO courses(course_code,course_title) VALUES('"+c.getCourseCode()+"','"+c.getCourseTitle()+"')";
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
	public Course getCourse(int id) {
		Course course = null;
		try {
			course = new Course();
			String sql = "SELECT * FROM courses WHERE id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet  =  statement.executeQuery(sql);
			while(resultSet.next()) {
				course.setId(resultSet.getInt("id"));
				course.setCourseCode(resultSet.getString("course_code"));
				course.setCourseTitle(resultSet.getString("course_title"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return course;
	}


	@Override
	public boolean update(Course c) {
		boolean flag = false;
		try {
			String sql = "UPDATE courses SET course_code='"+c.getCourseCode()+"', course_title='"+c.getCourseTitle()+"' WHERE id="+c.getId();
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
			String sql = "DELETE FROM courses WHERE id="+id;
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
