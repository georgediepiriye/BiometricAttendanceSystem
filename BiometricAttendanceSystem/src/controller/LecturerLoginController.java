package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LecturerLoginDaoImpl;
import dao.LoginDao;
import entity.Login;


@WebServlet("/LecturerLoginController")
public class LecturerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDao loginDao = null;
       
  
    public LecturerLoginController() {
       loginDao = new LecturerLoginDaoImpl();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Login lecturerLogin = new Login();
		lecturerLogin.setEmail(request.getParameter("lecturerEmail"));
		lecturerLogin.setPassword(request.getParameter("lecturerPassword"));
		
		String status = loginDao.authenticate(lecturerLogin);
		if(status.equals("true")) {
			session.setAttribute("lecturer_email", lecturerLogin.getEmail());
			response.sendRedirect("views/LecturerHomePage.jsp");
			
		}
		if(status.equals("false")) {
			response.sendRedirect("WelcomePage.jsp");
		}
		if(status.equals("error")) {
			response.sendRedirect("WelcomePage.jsp");
		}
	}
}