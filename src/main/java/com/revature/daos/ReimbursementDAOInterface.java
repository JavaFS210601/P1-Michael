package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {

public void addReimbursement (Reimbursement reimbursement);
	
	//need to fix here and in the DAO
	public List<Reimbursement> selectByStatus();
	
	public boolean removeReimbursementById(int re_id);
	
	//update reimbursements for the fianace mangers 

	public List<Reimbursement> getReimbursements();
	
	
	
		//create a new ticket in the DB
		public void createReimbursement(Reimbursement reimbursement);
		
		//get all tickets in the database
		public List<Reimbursement> getAllTickets();
		
		//get a single ticket by it's id
		public Reimbursement getReimbursementById(int id);
		
		
		//get all tickets submited by a single user
		public List<Reimbursement> getReimbursementByAuthor(int user_id);
		
		
		//get all tickets of a specific status
		//THIS WON'T WORK WITH CURRENT IMPLEMENTATION
//		public List<Ticket> getTicketsByStatus(int status_id);
		
		//get all tickets of a specific status submitted by a single user
		public List<Reimbursement> getReimbursementByStatus(int status_id, int user_id);
		
		//get all tickets greater than or less than a specified amount
		public List<Reimbursement> getReimbursementByAmount(int amount, boolean greater);
		
		//get all tickets after a specified date
//		public List<Ticket> getTicketsByDate();//Not sure what to put for the parameter
		//get all tickets by their resolver
		
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
