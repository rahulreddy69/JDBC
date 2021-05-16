package com.cg.app.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.app.beans.Instructor;
import com.cg.app.dao.InstructorDAO;
import com.cg.app.dao.InstructorDAOImpl;
import com.cg.app.dto.InstructorLocationCountDTO;
import com.cg.app.exception.InstructorNotFoundException;

public class InstructorServiceImpl implements InstructorService{

	InstructorDAO dao;
	
	public InstructorServiceImpl() {
		dao = new InstructorDAOImpl();
	}
	
	public boolean insertInstructor(Instructor instructor) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean isQueryExecuted = false;
		
		isQueryExecuted = dao.insertInstructor(instructor);
		return isQueryExecuted;
	}

	public List<Instructor> getInstructorByCode(int code) throws InstructorNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.getInstructorByCode(code);
	}

	public List<Instructor> getInstructors() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getInstructors();
	}

	public List<Instructor> getInstructorsByLocation(String location)throws SQLException{
		// TODO Auto-generated method stub
		return dao.getInstructorsByLocation(location);
	}

	public List<InstructorLocationCountDTO> getInstructorsCountByLocation() throws SQLException{
		// TODO Auto-generated method stub
		return dao.getInstructorsCountByLocation();
	}

	public List<Instructor> getInstructorsBySalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delteInstructorByCode(int code) throws InstructorNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.delteInstructorByCode(code);
	}

	public Instructor updateInstructor(Instructor oldInfoInstructor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}