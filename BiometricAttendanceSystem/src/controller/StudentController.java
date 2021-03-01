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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;
import util.DBConnectionUtil;


@WebServlet("/StudentController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50)

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  public static final String UPLOAD_DIR = "images";
	  public String dbFileName = "";
	RequestDispatcher dispatcher = null;
	StudentDao studentDao = null;
	Connection connection = null;
	PreparedStatement pst = null;
	Statement statement = null;
	ResultSet resultSet =null;
	
 
	
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
	
		
		if(id.isEmpty()) {
			  //save operation
			    save(studentMatNum, studentFirstName, studentLastName, studentSex, studentEmail, part);
				request.setAttribute("message", "Saved successful!");
			
		} else {

			/*
			//update operation
			student.setStudentId(Integer.parseInt(id));
			if(studentDao.update(student)) {
				request.setAttribute("message", "Updated successful!");
			}	
			*/
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
				dispatcher = request.getRequestDispatcher("/views/Student_list.jsp");
				dispatcher.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(studentDao.delete(Integer.parseInt(id))) {
			request.setAttribute("message", "Student Deleted Successfully!");
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
	
	private void save (String matNum,String firstName,String lastName,String sex,String email,Part part) throws IOException {
		String fileName = extractFileName(part);
		
		/**
         * *** Get The Absolute Path Of The Web Application ****
         */
        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
     
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String savePath = uploadPath + File.separator + fileName;
        dbFileName = UPLOAD_DIR + File.separator + fileName;
   
        part.write(savePath + File.separator);
      
        
        try {
            String sql = "insert into students(matric_number,first_name,last_name,sex,email,filename,path) values(?,?,?,?,?,?,?)";
            connection = DBConnectionUtil.openConnection();
            pst = connection.prepareStatement(sql);
            pst.setString(1, matNum);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, sex);
            pst.setString(5, email);
            pst.setString(6, dbFileName);
            pst.setString(7, savePath);
            pst.executeUpdate();
            
        } catch (Exception e) {
          e.printStackTrace();
        }

		
	}


	

}
