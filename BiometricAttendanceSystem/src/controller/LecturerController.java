package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.LecturerDao;
import dao.LecturerDaoImpl;

import entity.Lecturer;



@WebServlet("/LecturerController")
public class LecturerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	//create reference variable for  dao
	LecturerDao lecturerDao = null;
	
	//create constructor and initialize dao
	public LecturerController(){	
		lecturerDao = new LecturerDaoImpl();
		
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action==null) {
			action="LIST";
			
		}
		switch(action) {
		case "LIST":
			listLecturers(request, response);
			break;
		case "EDIT":
			getSingleLecturer(request, response);
			break;
		case "DELETE":
			deleteLecturer(request, response);
			break;
		default:
			listLecturers(request, response);
			break;
		}
	
	}

	


	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lecturerId = request.getParameter("lecturerId");
		String lecturerTitle = request.getParameter("lecturerTitle");
		String lecturerFirstName = request.getParameter("lecturerFirstName");
		String lecturerLastName = request.getParameter("lecturerLastName");
		String lecturerEmail = request.getParameter("lecturerEmail");
		String lecturerPassword = request.getParameter("lecturerPassword");
		String lecturerCourseCode = request.getParameter("lecturerCourseCode");
		String lecturerCourseTitle = request.getParameter("lecturerCourseTitle");
		
		Lecturer lecturer = new Lecturer();
	
		
		
		lecturer.setLecturerTitle(lecturerTitle);
		lecturer.setLecturerFirstName(lecturerFirstName);
		lecturer.setLecturerLastName(lecturerLastName);
		lecturer.setLecturerEmail(lecturerEmail);
		lecturer.setLecturerPassword(lecturerPassword);
		lecturer.setLecturerCourseCode(lecturerCourseCode);
		lecturer.setLecturerCourseTitle(lecturerCourseTitle);
		
	
			
			if(lecturerId.isEmpty() || lecturerId==null) {
				  //save operation
				if(lecturerDao.save(lecturer)) {
					request.setAttribute("message", "Saved successful!");
				}
			} else {

				//update operation
				lecturer.setLecturerId(Integer.parseInt(lecturerId));
				if(lecturerDao.update(lecturer)) {
					request.setAttribute("message", "Updated successful!");
				}	
			}
		
		
		listLecturers(request, response);
		}
	
	
	
	//method to get list of courses and send to jsp file
	public void listLecturers(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//call dao method to get list of lecturers
				List<Lecturer> lecturerList = lecturerDao.getLecturersList();
				
				//add courses to request object
				request.setAttribute("lecturerList", lecturerList);
			
				//get the request dispatcher
	             dispatcher = request.getRequestDispatcher("/views/Lecturer_list.jsp");
				
				//forward the request and response
				dispatcher.forward(request, response);
	}
	
	//method to get a single lecturer
public void getSingleLecturer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("lecturerId");
		Lecturer lecturer = lecturerDao.getLecturer(Integer.parseInt(id));
		//add lecturer to request object
		request.setAttribute("lecturer", lecturer);
	
		//get the request dispatcher
         dispatcher = request.getRequestDispatcher("/views/Lecturer_add.jsp");
		
		//forward the request and response
		dispatcher.forward(request, response);
	
	}


private void deleteLecturer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	if(lecturerDao.delete(Integer.parseInt(id))) {
		request.setAttribute("message", "Lecturer Deleted Successfully!");
	}
	listLecturers(request, response);
	
}


}

