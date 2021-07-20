package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;

public class ReimbursementService {

	private static StatusDAO sDao = new StatusDAO();
	private static ReimbursementDAO rDao = new ReimbursementDAO();
	
	public List<Reimbursement> getAllTickets()
	{
		return rDao.getReimbursements();
	}
	
	public List<Reimbursement> getCompletedReimbursements()
	{
		return rDao.getCompleteReimbursement(2);
	}
	
	public List<Reimbursement> getPendingReimbursements()
	{
		return rDao.getPendingReimbursements(1);
	}
	//returns true if the opperation was completed successfully
	public boolean approveTicket(int id)
	{
		Reimbursement targetReimbursement = rDao.getReimbursementById(id);
		boolean success = false;
		//check if the ticket is approved or denied
		if((targetReimbursement.getStatus().getId() == 2) || (targetReimbursement.getStatus().getId() == 3))
		{
			//ticket was already judged, do nothing to it
		}
		else//ticket is awaiting decision
		{
			//get a status object of approval
			ReimbursementStatus status = sDao.getStatus(2);
			//set the ticket's status to approved
			targetReimbursement.setStatus(status);
			//push the ticket to the DB
			rDao.updateReimbursement(targetReimbursement);
			success = true;
		}

		
		return success;
	}
}
