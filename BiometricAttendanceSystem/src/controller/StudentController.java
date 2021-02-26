package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Course;
import entity.Student;


@WebServlet("/StudentController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50)

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images";
	RequestDispatcher dispatcher = null;
	StudentDao studentDao = null;
 
	
    public StudentController() {
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
		case "EDIT":
			getSingleStudent(request, response);
			break;
		case "DELETE":
			deleteStudent(request, response);
			break;
		default:
			listStudents(request, response);
			break;
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("studentId");
		String studentMatNum = request.getParameter("studentMatNum");
		String studentFirstName = request.getParameter("studentFirstName");
		String studentLastName = request.getParameter("studentLastName");
		String studentSex = request.getParameter("studentSex");
		String studentEmail = request.getParameter("studentEmail");
		Part part = request.getPart("studentImagePath");
		String filename=extractFileName(part);
		String savePath = "C:\\Users\\HP\\git\\repository\\BiometricAttendanceSystem\\WebContent\\images\\" + File.separator + filename;
		
		Student student = new Student();
		student.setStudentMatNum(studentMatNum);
		student.setStudentFirstName(studentFirstName);
		student.setStudentLastName(studentLastName);
		student.setStudentEmail(studentEmail);
		student.setStudentSex(studentSex);
		student.setStudentImagePath(savePath);
		
		if(id.isEmpty()) {
			  //save operation
			if(studentDao.save(student)) {
				request.setAttribute("message", "Saved successful!");
			}
		} else {

			//update operation
			student.setStudentId(Integer.parseInt(id));
			if(studentDao.update(student)) {
				request.setAttribute("message", "Updated successful!");
			}	
		}
		listStudents(request, response);
	}


	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String [] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
		
	}


	private void viewImage(HttpServletRequest request, HttpServletResponse response) {
		
		
	}


	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(studentDao.delete(Integer.parseInt(id))) {
			request.setAttribute("message", "Course Deleted Successfully!");
		}
		listStudents(request, response);// TODO Auto-generated method stub
		
	}


	private void getSingleStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("studentId");
		Student student = studentDao.getStudent(Integer.parseInt(id));
		//add courses to request object
		request.setAttribute("student", student);
	
		//get the request dispatcher
         dispatcher = request.getRequestDispatcher("/views/Student_add.jsp");
		
		//forward the request and response
		dispatcher.forward(request, response);
		
	}


	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<Student> studentList = studentDao.get();
	  request.setAttribute("studentList", studentList);
	  dispatcher = request.getRequestDispatcher("views/Student_list.jsp");
	  dispatcher.forward(request, response);
		
	}


	

}
