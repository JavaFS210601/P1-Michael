package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class TypeDAO implements TypeDAOInterface{


	@Override
	public ReimbursementType getType(int id) {
		//open a new sesssion
		Session ses = HibernateUtil.getSession();
				//get the type code based on the id
		ReimbursementType type = ses.get(ReimbursementType.class, id);
				//close the session
			//ses.close();
		HibernateUtil.closeSession();
				//return the type object
		return type;
	}

	@Override
	public List<ReimbursementType> getAllType() {
		//open a new session
		Session ses = HibernateUtil.getSession();
		//get a list of types
		List<ReimbursementType> typeList = ses.createQuery("from ReimbursementType").list();
		//close the session
		HibernateUtil.closeSession();
		//return the list of types
		return typeList;
	}

	@Override
	public void insertType(ReimbursementType newType) {
		//open a new session
		Session ses = HibernateUtil.getSession();
		//insert the new type into the table
		ses.save(newType);
		//close the session
		HibernateUtil.closeSession();
		
	}

	@Override
	public void updateType(ReimbursementType type) {
		//open a new session
		Session ses = HibernateUtil.getSession();
		//update the type in the table
		ses.merge(type);
		//close the session
		HibernateUtil.closeSession();
		
	}

	@Override
	public void deleteType(ReimbursementType type) {
		Session ses = HibernateUtil.getSession();
		//update the type in the table
		ses.delete(type);
		//close the session
		HibernateUtil.closeSession();
		
	}
}
