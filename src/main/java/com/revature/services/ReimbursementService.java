package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;

public class ReimbursementService {

	private static StatusDAO sDao = new StatusDAO();
	private static ReimbursementDAO rDao = new ReimbursementDAO();
	
	public List<Reimbursement> getAllReimbursements()
	{
		return rDao.getReimbursements();
	}
	
	public List<Reimbursement> getReimbursementById(){
		return (List<Reimbursement>) rDao.getReimbursementById(1);
	}
	
	
	public List<Reimbursement> getCompletedReimbursements()
	{
		return rDao.getCompleteReimbursement(2);
	}
	
	
	public List<Reimbursement> getPendingReimbursements()
	{
		return rDao.getPendingReimbursements(1);
	}
	
	
	public boolean approveReimbursement(int id)
	{
		Reimbursement targetReimbursement = rDao.getReimbursementById(id);
		boolean success = false;
		//check if the reimbursement is approved or denied
		if((targetReimbursement.getStatus().getId() == 2) || (targetReimbursement.getStatus().getId() == 3))
		{
			
		}
		else
		{
			//get a status object of approval
			ReimbursementStatus status = sDao.getStatus(2);
			//set the reimb's status to approved
			targetReimbursement.setStatus(status);
			//push the reimb to the database
			rDao.updateReimbursement(targetReimbursement);
			success = true;
		}

		
		return success;
	}
	
	public void addReimbursement(Reimbursement reimbursement) {
		rDao.addReimbursement(reimbursement);
	}
}
