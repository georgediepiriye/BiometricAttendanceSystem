package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.AdminLoginDaoImpl;
import entity.Login;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao loginDao = null;
	
	
       
	public AdminLoginController() {
		loginDao = new AdminLoginDaoImpl();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login adminLogin = new Login();
		adminLogin.setEmail(request.getParameter("adminEmail"));
		adminLogin.setAdminPassword(request.getParameter("adminPassword"));
		
		String status = loginDao.authenticate(adminLogin);
		
		if(status.equals("true")) {
			session.setAttribute("admin_email", adminLogin.getEmail());
			response.sendRedirect("views/AdminHomePage.jsp");
			
		}
		if(status.equals("false")) {
			response.sendRedirect("Admin_login.jsp?status=false");
			
		}
		if(status.equals("error")) {
			response.sendRedirect("Admin_login.jsp?status=error");
		}
		

	}

}
 