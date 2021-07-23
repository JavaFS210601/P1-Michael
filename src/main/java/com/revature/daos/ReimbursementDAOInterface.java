package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {

public void addReimbursement (Reimbursement reimbursement);
	
	
	public List<Reimbursement> selectByStatus();
	
	public boolean removeReimbursementById(int re_id); 

	public List<Reimbursement> getReimbursements();
	
	//create a new ticket in the DB
	public void createReimbursement(Reimbursement reimbursement);
		
	//get all tickets in the database
	public List<Reimbursement> getAllReimbursements();
		
	//get a single ticket by it's id
	public Reimbursement getReimbursementById(int id);
		
		
	//get all tickets submited by a single user
	public List<Reimbursement> getReimbursementByAuthor(int user_id);
		
	//get all tickets of a specific status submitted by a single user
	public List<Reimbursement> getReimbursementByStatus(int status_id);
		
	//get all tickets greater than or less than a specified amount
	public List<Reimbursement> getReimbursementByAmount(int amount, boolean greater);
			
	public List<Reimbursement> getReimbursementByResolver(int user_id);
		
	//update a ticket in the DB
	public void updateReimbursement(Reimbursement reimbursement);
		
	//delete a ticket in the DB
	public void deleteReimbursement(Reimbursement reimbursement);
		/*********************END getTicketsByAuthor*********************/
		List<Reimbursement> getCompleteReimbursement(int status_id);
		/*********************END getCompleteTickets*********************/
		List<Reimbursement> getPendingReimbursements(int status_id);
}
