package com.revature.DTO;

public class ReimbursementDTO {

	private String reimbursementId;

	public ReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementDTO(String reimbursementId) {
		super();
		this.reimbursementId = reimbursementId;
	}
	
	public String getreimbursementId () {
		return reimbursementId;
	}
}
