package com.cg.app.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.app.beans.Instructor;
import com.cg.app.dto.InstructorLocationCountDTO;
import com.cg.app.service.InstructorService;
import com.cg.app.service.InstructorServiceImpl;

public class MainClass {
	
	InstructorService service;
	
	public MainClass() {
		service = new InstructorServiceImpl();
	}
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainClass obj = new MainClass();
		while(true) {
			System.out.println("1. Insert");
			System.out.println("2. Show All");
			System.out.println("3. search instructor by id");
			System.out.println("4. search instructors by location");
			System.out.println("5. Display count of instructors by location");
			System.out.println("0. EXIT");
			
			int opt = new Scanner(System.in).nextInt();
			if(opt == 1) {
				obj.insertInstructorDetailsFromUser();
			}
			if(opt == 2) {
				obj.readInstructorDetails();
			}
			if(opt == 3) {
				
				obj.printInstructorByCode();
			}
			if(opt == 4) {
				obj.printInstructionByLocation();
			}
			if(opt == 5) {
				obj.printLocationCount();
			}
			if(opt == 6) {
				obj.DeleteInstructorDetailsFromUser();
			}
			if(opt == 0) {
				System.exit(0);
			}
		}
		
		

	}
	
	public void insertInstructorDetailsFromUser()
	{
		
		// ... write code to read data hope 
		Instructor instructor = new Instructor(130, "X", 7000, 2000, "x@x.com", "B");
		try {
			boolean result = service.insertInstructor(instructor);
			
			if(result) System.out.println(" Instructor Added");
			else System.out.println("Contact Admin ...");
		} catch (Exception e) {
			showErr(e);
		}
		
		
	}
	public void DeleteInstructorDetailsFromUser()
	{
		int code = Integer.parseInt(sc.nextLine());
		try {
			boolean result = service.delteInstructorByCode(code);
			
			if(result) System.out.println(" Instructor deleted");
			else System.out.println("Contact Admin ...");
		} catch (Exception e) {
			showErr(e);
		}
		
		
	}
	public void printInstructorByCode() {
		int code = Integer.parseInt(sc.nextLine());
		
		try {
			List<Instructor> list = service.getInstructorByCode(code);
			list.stream().forEach(Instructor->displayInstructor(Instructor));
		}
		catch (Exception e) {
			// TODO: handle exception
			showErr(e);
		}
	}
	
	public void printInstructionByLocation() {
		String location = sc.nextLine();
		try {
			List<Instructor> list = service.getInstructorsByLocation(location);
			list.stream().forEach(Instructor->displayInstructor(Instructor));
		}
		catch (Exception e) {
			// TODO: handle exception
			showErr(e);
		}
	}
	public void printLocationCount() {
		try {
			List<InstructorLocationCountDTO> list = service.getInstructorsCountByLocation();
			list.stream().forEach(InstructorLocationCountDTO->displayInstructorCount(InstructorLocationCountDTO));
		}
		catch (Exception e) {
			// TODO: handle exception
			
			showErr(e);
		}
		
	}
	
	public void readInstructorDetails()
	{
		
		try
		{
			List<Instructor> list = service.getInstructors() ;
			
			list.stream().forEach(instructor->displayInstructor(instructor));
		}
		catch(Exception e)
		{
			showErr(e);
		}
	
	}
	
	public void displayInstructor(Instructor instructor)
	{
		
		System.out.println(instructor);
		System.out.println("-------------------------------------------------------");
	}
	public void showErr(Exception e)
	{
		System.out.println("====>> "+e);
	}
	
	public void displayInstructorCount(InstructorLocationCountDTO instructor)
	{
		
		System.out.println(instructor);
		System.out.println("-------------------------------------------------------");
	}
	

}