package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {

public void addReimbursement (Reimbursement reimbursement );
	
	//need to fix here and in the DAO
	public List<Reimbursement> selectReimByStatus();
	
	public boolean removeReim(int re_id);
	
	//update reimbursements for the fianace mangers 

	public List<Reimbursement> getReimbursements();
	
}
