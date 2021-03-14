package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;
import util.DBConnectionUtil;


@WebServlet("/LecturerStudentController")
public class LecturerStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  public static final String UPLOAD_DIR = "images";
	  public String dbFileName = "";
	RequestDispatcher dispatcher = null;
	StudentDao studentDao = null;
	Connection connection = null;
	PreparedStatement pst = null;
	Statement statement = null;
	ResultSet resultSet =null;
	
 
	
    public LecturerStudentController() {
       studentDao = new StudentDaoImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
		
		if(action==null) {
			action="LIST";
			
		}
		switch(action) {
		case "LIST":
			listStudents(request, response);
			break;
		case "VIEW_IMAGE":
			viewImage(request, response);
			break;
	
		default:
			listStudents(request, response);
			break;
		}
	
	}



	private void viewImage(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			String sql = "select filename from students where id="+id;
			Connection connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				List<Student> studentList = studentDao.get();
				String filename = resultSet.getString("filename");
				request.setAttribute("filename", filename);
				
				  request.setAttribute("studentList", studentList);
				dispatcher = request.getRequestDispatcher("/views/Lecturer_Student_list.jsp");
				dispatcher.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<Student> studentList = studentDao.get();
	  request.setAttribute("studentList", studentList);
	  dispatcher = request.getRequestDispatcher("views/Lecturer_Student_list.jsp");
	  dispatcher.forward(request, response);
		
	}



	

}
