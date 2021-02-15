package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.AdminLogin;
import util.DBConnectionUtil;

public class AdminLoginDaoImpl implements AdminLoginDao{

	@Override
	public String authenticate(AdminLogin adminLogin) {
		String sql = "SELECT * FROM admin_login WHERE email=? AND password=? ";
		try {
			
		   Connection connection = DBConnectionUtil.openConnection();
		   PreparedStatement preparedStatement =  connection.prepareStatement(sql);
		   preparedStatement.setString(1, adminLogin.getAdminEmail());
		   preparedStatement.setString(2, adminLogin.getAdminPassword());
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
