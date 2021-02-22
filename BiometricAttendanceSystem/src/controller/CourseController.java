package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.CourseDaoImpl;
import entity.Course;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	//create reference variable for course dao
	CourseDao courseDao = null;
	
	//create constructor and initialize dao
	public CourseController(){	
		courseDao = new CourseDaoImpl();
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action==null) {
			action="LIST";
			
		}
		switch(action) {
		case "LIST":
			listCourses(request, response);
			break;
		case "EDIT":
			getSingleCourse(request, response);
			break;
		case "DELETE":
			deleteCourse(request, response);
			break;
		default:
			listCourses(request, response);
			break;
		}
	
	}

	


	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseCode = request.getParameter("courseCode");
		String courseTitle = request.getParameter("courseTitle");
		String id = request.getParameter("id");
		Course course = new Course();
		course.setCourseCode(courseCode);
		course.setCourseTitle(courseTitle);
		
		if((courseCode.isEmpty() || courseCode==null) || (courseTitle.isEmpty() || courseTitle==null) ) {
			
				
			
		}else {
			
			if(id.isEmpty() || id==null) {
				  //save operation
				if(courseDao.save(course)) {
					request.setAttribute("message", "Saved successful!");
				}
			} else {

				//update operation
				course.setId(Integer.parseInt(id));
				if(courseDao.update(course)) {
					request.setAttribute("message", "Updated successful!");
				}	
			}
		}
		
		
		listCourses(request, response);
		
		}
	
	
	
	//method to get list of courses and send to jsp file
	public void listCourses(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//call dao method to get list of courses
				List<Course> courseList = courseDao.get();	
				
				//add courses to request object
				request.setAttribute("courseList", courseList);
			
				//get the request dispatcher
	             dispatcher = request.getRequestDispatcher("/views/Course_list.jsp");
				
				//forward the request and response
				dispatcher.forward(request, response);
	}
	
	//method to get a single course
public void getSingleCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Course course = courseDao.getCourse(Integer.parseInt(id));
		//add courses to request object
		request.setAttribute("course", course);
	
		//get the request dispatcher
         dispatcher = request.getRequestDispatcher("/views/Course_add.jsp");
		
		//forward the request and response
		dispatcher.forward(request, response);
	
	}


private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	if(courseDao.delete(Integer.parseInt(id))) {
		request.setAttribute("message", "Course Deleted Successfully!");
	}
	listCourses(request, response);
	
}

}

