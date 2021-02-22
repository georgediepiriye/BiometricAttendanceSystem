package dao;

import java.util.List;


import entity.Lecturer;

public interface LecturerDao {
List<Lecturer> getLecturersList();
	
	boolean save(Lecturer lecturer);
	
	Lecturer getLecturer(int id);
	
	boolean update(Lecturer lecturer);
	
	boolean delete(int id);

}
