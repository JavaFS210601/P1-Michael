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
	public List<Reimbursement> selectByStatus() {
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
    public boolean removeReimbursementById(int re_id) {
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

	
	@Override
	public void createReimbursement(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		
		ses.save(reimbursement);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimbursementList = ses.createQuery("from Reimbursement").list();
		
		HibernateUtil.closeSession();
		
		return reimbursementList;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Reimbursement reimb = ses.get(Reimbursement.class, id);
		
		HibernateUtil.closeSession();
		
		return reimb;
	}

	@Override
	public List<Reimbursement> getReimbursementByAuthor(int user_id) {
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimbList = ses.createQuery("from Reimbursement where " + user_id).list();
		
		HibernateUtil.closeSession();
		
		return reimbList;
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(int status_id) {
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimbList = ses.createQuery("from Reimbursement where " + status_id).list();
		
		HibernateUtil.closeSession();
		
		return reimbList;
		
	}

	@Override
	public List<Reimbursement> getReimbursementByAmount(int amount, boolean greater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByResolver(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReimbursement(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		
		ses.delete(reimbursement);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public List<Reimbursement> getCompleteReimbursement(int status_id) {
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimbList = getAllReimbursements();
		
		List<Reimbursement> returnList = new ArrayList<>();
		
		for(Reimbursement r : reimbList)
		{
			
			if(r.getStatus().getId() > 1)
			{
				returnList.add(r);
			}
		}
		
		HibernateUtil.closeSession();
		
		return returnList;
	}

	@Override
	public List<Reimbursement> getPendingReimbursements(int status_id) {
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimbList = getAllReimbursements();
		
		List<Reimbursement> returnList = new ArrayList<>();
		
		for(Reimbursement r : reimbList)
		{
		
			if(r.getStatus().getId() == 1)
			{
				returnList.add(r);
			}
		}
		
		HibernateUtil.closeSession();
		
		return returnList;
	}
}
