package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Login;
import util.DBConnectionUtil;

public class LecturerLoginDaoImpl implements LoginDao{

	@Override
	public String authenticate(Login lecturerLogin) {
		String sql = "select from lecturers where email=? and password=?";
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, lecturerLogin.getEmail());
			preparedStatement.setString(2, lecturerLogin.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
		    if(resultSet.next()) {
		    	return "true";
		    }else {
		    	return "false";
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

}
