package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {
	List<Student> get();
	
	boolean save(Student student);
	
	Student getStudent(int id);
	
	boolean update(Student student);
	
	boolean delete(int id);
	
	

}
