package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class TypeDAO {

	public void addType(ReimbursementType reimbursementtype) {
		//open a new hibernate session
		Session ses = HibernateUtil.getSession();
		
		//this is to insert the new role into the table by using the save method
		ses.save(reimbursementtype);
		
		//now close the hibernate session
		HibernateUtil.closeSession();

}
}
