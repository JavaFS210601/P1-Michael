package com.revature.daos;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class ReimbursementDAO implements ReimbursementDAOInterface{

	@Override
	public void addReimbursement(Reimbursement reimbursement) {
		
				Session ses = HibernateUtil.getSession(); 
				
				ses.save(reimbursement); 
				
				HibernateUtil.closeSession(); 
		
	}

	@Override
	public List<Reimbursement> selectReimByStatus() {
		Session ses = HibernateUtil.getSession();
		
		//used method from get all reimbursements
		List<Reimbursement> allList = getReimbursements();
		
		//make a new list
		List<Reimbursement> returnList = new ArrayList<>();		
		
		//use for loop to go through list 
		for (Reimbursement r : allList)
		{
			//so if the reimbursement status id is 1 which is my pending  are the same, add to this returned list
			if(r.getStatus().getId() == 1)
			{
				returnList.add(r);
			}
		HibernateUtil.closeSession();
		
		}
		return returnList; 

	}
	
	@Override
    public boolean removeReim(int re_id) {
		//get hibernate session
		Session ses = HibernateUtil.getSession();
		
		//use get method to get reimbursement id
		Reimbursement rGone = ses.get(Reimbursement.class,re_id);
        
		//use delete method
		ses.delete(rGone);
		HibernateUtil.closeSession();
		return true;
        
	}
	
	@Override
	public List<Reimbursement> getReimbursements() {
		Session ses = HibernateUtil.getSession();
		
		
		
		
		List<Reimbursement> allList = ses.createQuery("FROM Reimbursement").list(); 
		
		
		HibernateUtil.closeSession();
		
        
		return allList;
	}
}
