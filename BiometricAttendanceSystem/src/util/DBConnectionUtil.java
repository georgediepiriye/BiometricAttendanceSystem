package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	//define the database properties
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static   final String USERNAME = "root";
	private static  final String PASSWORD = "Dboy1155";
	private static final String URL = "jdbc:mysql://localhost:3306/msc_computer_science?useSSL=false";
	private static  java.sql.Connection connection = null;
	
	//define the static method
	public static Connection openConnection() {
		//check the connection
		if(connection != null) {
			return connection;
		}else {
			
			try {
				//load the driver
				Class.forName(DRIVER);
				//get the connection
				connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			

		
				
			
			//return connection
			return connection;
		}
		
	}
	
	
	

}
