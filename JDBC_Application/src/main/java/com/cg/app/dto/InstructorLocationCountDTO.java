package com.cg.app.dto;

public class InstructorLocationCountDTO implements Comparable<InstructorLocationCountDTO> {
	private String trainerlocation;
	private int count;
	public InstructorLocationCountDTO(int count, String trainerlocation) {
		super();
		this.trainerlocation = trainerlocation;
		this.count = count;
	}
		

	

	public String getTrainerlocation() {
		return trainerlocation;
	}




	public void setTrainerlocation(String trainerlocation) {
		this.trainerlocation = trainerlocation;
	}




	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		
	}

	public InstructorLocationCountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int compareTo(InstructorLocationCountDTO o) {
		// TODO Auto-generated method stub
		return this.count - o.count;
	}




	@Override
	public String toString() {
		return "InstructorLocationCountDTO [trainerlocation=" + trainerlocation + ", count=" + count + "]";
	}

		
	
}