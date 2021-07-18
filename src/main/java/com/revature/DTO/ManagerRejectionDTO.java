package com.revature.DTO;

public class ManagerRejectionDTO {

	private String reimbId;
	private String status;
	private String userId;
	
	
	//Constructors etc below
	public ManagerRejectionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerRejectionDTO(String reimbId, String status, String userId) {
		super();
		this.reimbId = reimbId;
		this.status = status;
		this.userId = userId;
	}
	public String getReimbId() {
		return reimbId;
	}
	public void setReimbId(String reimbId) {
		this.reimbId = reimbId;
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
}
