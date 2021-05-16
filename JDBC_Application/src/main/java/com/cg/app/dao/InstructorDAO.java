package com.cg.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.app.beans.Instructor;
import com.cg.app.dto.InstructorLocationCountDTO;
import com.cg.app.exception.InstructorNotFoundException;

public interface InstructorDAO {
	
	public boolean insertInstructor(Instructor instructor)throws SQLException;
	public List<Instructor> getInstructorByCode(int code)throws InstructorNotFoundException, SQLException;
	public List<Instructor> getInstructors()throws SQLException;
	
	
	public List<Instructor> getInstructorsByLocation(String location)throws SQLException;
	public List<InstructorLocationCountDTO> getInstructorsCountByLocation() throws SQLException; // group by
	public List<Instructor> getInstructorsBySalary(); // order by ASC 
	
	
	public boolean delteInstructorByCode(int code)throws InstructorNotFoundException, SQLException;
	public Instructor updateInstructor(Instructor oldInfoInstructor);
	

}