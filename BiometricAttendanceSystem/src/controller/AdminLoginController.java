package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminLoginDao;
import dao.AdminLoginDaoImpl;
import entity.AdminLogin;


public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminLoginDao adminLoginDao = null;
	
	
       
	public AdminLoginController() {
		
		adminLoginDao = new AdminLoginDaoImpl();
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminLogin adminLogin = new AdminLogin();
		adminLogin.setAdminEmail(request.getParameter("adminEmail"));
		adminLogin.setAdminPassword(request.getParameter("adminPassword"));
		
		String status = adminLoginDao.authenticate(adminLogin);
		
		if(status.equals("true")) {
			response.sendRedirect("CourseController?action=LIST");
		}
		if(status.equals("false")) {
			response.sendRedirect("Admin_login.jsp?status=false");
		}
		if(status.equals("error")) {
			response.sendRedirect("Admin_login.jsp?status=error");
		}
		

	}

}
 