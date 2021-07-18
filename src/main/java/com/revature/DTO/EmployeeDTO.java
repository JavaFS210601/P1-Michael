package com.revature.DTO;

public class EmployeeDTO {

	private String userId;

	
	
	//Constructors, getter & setter below
	public EmployeeDTO() {
		super();
		
	}

	public EmployeeDTO(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
