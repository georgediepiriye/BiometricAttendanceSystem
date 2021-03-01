package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Student;
import util.DBConnectionUtil;

public class StudentDaoImpl implements StudentDao{
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;

	@Override
	public List<Student> get() {
		List<Student> studentList = null;
		Student student = null;
		try {
			studentList = new ArrayList<Student>();
			String sql = "SELECT * FROM students";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				student = new Student();
				student.setStudentId(resultSet.getInt("id"));
				student.setStudentMatNum(resultSet.getString("matric_number"));
				student.setStudentFirstName(resultSet.getString("first_name"));
				student.setStudentLastName(resultSet.getString("last_name"));
				student.setStudentSex(resultSet.getString("sex"));
				student.setStudentEmail(resultSet.getString("email"));
				student.setStudentImagePath(resultSet.getString("path"));
				studentList.add(student);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
	
	}

	

	@Override
	public Student getStudent(int id) {
		Student student = null;
		try {
			student = new Student();
			String sql = "SELECT * FROM students WHERE id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet  =  statement.executeQuery(sql);
			while(resultSet.next()) {
				
				student.setStudentId(resultSet.getInt("id"));
				student.setStudentMatNum(resultSet.getString("matric_number"));
				student.setStudentFirstName(resultSet.getString("first_name"));
				student.setStudentLastName(resultSet.getString("last_name"));
				student.setStudentSex(resultSet.getString("sex"));
				student.setStudentEmail(resultSet.getString("email"));
				student.setStudentImagePath(resultSet.getString("path"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean update(Student student) {
		boolean flag= false;
		try {
			String sql = "UPDATE students SET mat_number='"+student.getStudentMatNum()+"',first_name='"+student.getStudentMatNum()+"',last_name='"+student.getStudentLastName()+"',sex='"+student.getStudentSex()+"',email='"+student.getStudentEmail()+"',path='"+student.getStudentImagePath()+"'";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM students where id="+id;
			connection=DBConnectionUtil.openConnection();
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
