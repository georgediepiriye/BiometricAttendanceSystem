package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Login;

import util.DBConnectionUtil;

public class AdminLoginDaoImpl implements LoginDao{

	@Override
	public String authenticate(Login adminLogin) {
		String sql = "SELECT * FROM admin_login WHERE email=? AND password=? ";
		try {
			
		   Connection connection = DBConnectionUtil.openConnection();
		   PreparedStatement preparedStatement =  connection.prepareStatement(sql);
		   preparedStatement.setString(1, adminLogin.getEmail());
		   preparedStatement.setString(2, adminLogin.getPassword());
		   ResultSet resultSet = preparedStatement.executeQuery();
		   if(resultSet.next()) {
			   return "true";
		   }else {
			   return "false";
		   }
	
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return "error";

}

	
}
