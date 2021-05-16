package com.cg.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.app.beans.Instructor;
import com.cg.app.dto.InstructorLocationCountDTO;
import com.cg.app.exception.InstructorNotFoundException;

public class InstructorDAOImpl implements InstructorDAO {

	Connection con;
	PreparedStatement ps;
	
	public InstructorDAOImpl() 
	{
		con = DatabaseUtil.con;
	}
	
	public boolean insertInstructor(Instructor instructor) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean isInserted = false;
		int code = instructor.getInstructorCode();
		String name = instructor.getName();
		String email = instructor.getEmail();
		String location = instructor.getTrainerLocation();
		int salary = instructor.getSalary();
		int jobStartYear = instructor.getJobStartYear();
		
		
		String query = "insert into Instructor values(?,?,?,?,?,?)";
		
		ps = con.prepareStatement(query);
		ps.setInt(1, code);
		ps.setString(2,name);
		ps.setInt(3, salary);
		ps.setInt(4, jobStartYear);
		ps.setString(5,email);
		ps.setString(6,location);
		
		int i = ps.executeUpdate();
		
		if(i == 1) isInserted = true;
		
		return isInserted;
	}

	public List<Instructor> getInstructorByCode(int code) throws InstructorNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String query = "select * from Instructor where instructorcode = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, code);
		ResultSet rs = ps.executeQuery();
		List<Instructor> list = new ArrayList<Instructor>();
		while(rs.next()) {
			int code1 = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("trainerlocation");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");
			
			list.add(new Instructor(code1, name, salary, jobStartYear, email, location));
		}
		
		return list;
	}

	public List<Instructor> getInstructors() throws SQLException {
		// TODO Auto-generated method stub
		
		String sqlQuery = "select * from instructor";
		ps = con.prepareStatement(sqlQuery);
		ResultSet rs = ps.executeQuery();
		List<Instructor> list = new ArrayList<Instructor>();
		
		while(rs.next()) {
			int code = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("trainerlocation");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");
			
			list.add(new Instructor(code, name, salary, jobStartYear, email, location));
			
		}
		return list;
	}

	public List<Instructor> getInstructorsByLocation(String location)throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from Instructor where trainerlocation = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, location);
		ResultSet rs = ps.executeQuery();
		List<Instructor> list = new ArrayList<Instructor>();
		while(rs.next()) {
			int code1 = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String loc = rs.getString("trainerlocation");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");
			
			list.add(new Instructor(code1, name, salary, jobStartYear, email, loc));
		}
		
		return list;
	
	}

	public List<InstructorLocationCountDTO> getInstructorsCountByLocation()throws SQLException {
		// TODO Auto-generated method stub
		String query = "select count(instructorcode) as count, trainerlocation from Instructor group by trainerlocation order by count(Instructorcode) DESC";
		ps = con.prepareStatement(query);
		ResultSet rs  = ps.executeQuery();
		List<InstructorLocationCountDTO> list = new ArrayList<InstructorLocationCountDTO>();
		while(rs.next()) {
			
			String loc = rs.getString("trainerlocation");
			int count = rs.getInt("count");
			
			
			list.add(new InstructorLocationCountDTO(count, loc));
		}
		
		return list;
		
	}

	public List<Instructor> getInstructorsBySalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delteInstructorByCode(int code) throws InstructorNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		String sqlQuery = "delete from Instructor where instructorcode = ?";
		ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, code);
		int i = ps.executeUpdate();
		if(i == 1) isDeleted = true;
		
		return isDeleted;
	}

	public Instructor updateInstructor(Instructor oldInfoInstructor) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}