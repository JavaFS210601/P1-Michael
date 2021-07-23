package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.utils.HibernateUtil;

public class StatusDAO implements StatusDAOInterface {

	@Override
	public ReimbursementStatus getStatus(int id) {
		//open a new sesssion
				Session ses = HibernateUtil.getSession();
				//get the status code based on the id
				ReimbursementStatus status = ses.get(ReimbursementStatus.class, id);
				//close the session
//				ses.close();
				HibernateUtil.closeSession();
				//return the status object
				return status;
	}

	@Override
	public List<ReimbursementStatus> getAllStatus() {
		//open a new session
				Session ses = HibernateUtil.getSession();
				//geta list of statuses
				List<ReimbursementStatus> statusList = ses.createQuery("from ReimbursementStatus").list();
				//close the session
				HibernateUtil.closeSession();
				//return the list of statuses
				return statusList;
	}

	@Override
	public void insertStatus(ReimbursementStatus newStatus) {
		//open a new session
				Session ses = HibernateUtil.getSession();
				//insert the new status into the table
				ses.save(newStatus);
				//close the session
				HibernateUtil.closeSession();
		
	}

	@Override
	public void updateStatus(ReimbursementStatus status) {
		//open a new session
				Session ses = HibernateUtil.getSession();
				//update the status in the table
				ses.merge(status);
				//close the session
				HibernateUtil.closeSession();
		
	}

	@Override
	public void deleteStatus(ReimbursementStatus status) {
		Session ses = HibernateUtil.getSession();
		//update the status in the table
		ses.delete(status);
		//close the session
		HibernateUtil.closeSession();
		
	}


}
