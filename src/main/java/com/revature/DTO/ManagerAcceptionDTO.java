package com.revature.DTO;

public class ManagerAcceptionDTO {

	private String reimbId;
	private String status;
	private String userId;
	
	
	
	//Constructors etc below
	public ManagerAcceptionDTO(String status, String userId) {
		super();
		this.status = status;
		this.userId = userId;
	}
	public ManagerAcceptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ManagerAcceptionDTO(String reimbId, String status, String userId) {
		super();
		this.reimbId = reimbId;
		this.status = status;
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReimbId() {
		return reimbId;
	}
	public void setReimbId(String reimbId) {
		this.reimbId = reimbId;
	}
}
