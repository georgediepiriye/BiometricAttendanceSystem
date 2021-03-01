package dao;

import entity.Login;

public interface LoginDao {
	String authenticate(Login login);

}
