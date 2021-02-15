package dao;

import entity.AdminLogin;

public interface AdminLoginDao {
	String authenticate(AdminLogin adminLogin);

}
