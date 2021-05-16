package com.cg.app.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.app.beans.Instructor;
import com.cg.app.dto.InstructorLocationCountDTO;
import com.cg.app.exception.InstructorNotFoundException;

public interface InstructorService {
	
	public boolean insertInstructor(Instructor instructor)throws SQLException;
	public List<Instructor> getInstructorByCode(int code)throws InstructorNotFoundException, SQLException;  // 1
	public List<Instructor> getInstructors()throws SQLException;
	
	
	public List<Instructor> getInstructorsByLocation(String location)throws SQLException;   // 2
	public List<InstructorLocationCountDTO> getInstructorsCountByLocation()throws SQLException; // group by
	public List<Instructor> getInstructorsBySalary(); // order by ASC 
	
	
	public boolean delteInstructorByCode(int code)throws InstructorNotFoundException, SQLException; // 3
	public Instructor updateInstructor(Instructor oldInfoInstructor);

}