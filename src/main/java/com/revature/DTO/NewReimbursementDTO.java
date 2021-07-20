package com.revature.DTO;

public class NewReimbursementDTO {

	private String username;
	private String amount;
	private String type;
	private String desc;
	private String date;
	
	
	public NewReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewReimbursementDTO(String username, String amount, String type, String desc, String date) {
		super();
		this.username = username;
		this.amount = amount;
		this.type = type;
		this.desc = desc;
		this.date = date;
	}
	@Override
	public String toString() {
		return "NewReimbursementDTO [username=" + username + ", amount=" + amount + ", type=" + type + ", desc=" + desc
				+ ", date=" + date + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
