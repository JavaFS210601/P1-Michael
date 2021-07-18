package com.revature.DTO;

public class ManagerDTO {

	private String userId;

	
	//Constructors etc below
	public ManagerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerDTO(String userId) {
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
