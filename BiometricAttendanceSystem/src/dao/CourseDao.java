package dao;

import java.util.List;

import entity.Course;



public interface CourseDao {
	List<Course> get();
	
	boolean save(Course c);
	
	Course getCourse(int id);
	
	boolean update(Course c);
	
	boolean delete(int id);

}
