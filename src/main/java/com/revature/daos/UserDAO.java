package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class UserDAO implements UserDAOInterface {

	@Override
	public void addUser(Users user) {
		//Open a hibernate Session object so that we can connect to the database
		Session ses = HibernateUtil.getSession(); //there is some parallels between ConnectionUtil.getConnection() in JDBC!
		
		ses.save(user); //use save method to insert into the data base it's a method for Insert fucntionality
		
		HibernateUtil.closeSession(); //Close our Session (not super necessary here, but good practice)
		
	}
	
	
//	@Override
//	public void updateUser(User user) {
//		Session ses = HibernateUtil.getSession();
//		
//		ses.merge(user); //this will update the entire book record in the database, if it exists
//		
//		
//		//update() would throw an error if the book object already existed in Hibernate's cache
//		//hence why  merge() is safer
//		
//		HibernateUtil.closeSession(); //Close our Session (not super necessary here, but good practice)
//	}
	
	@Override
	public Users getUser_Id(int user_id) {
		Session ses = HibernateUtil.getSession();
		Users uID = ses.get(Users.class, user_id);
		HibernateUtil.closeSession();
		return uID;
	}

	@Override
	public boolean removeUser(int user_id) {
		Session ses = HibernateUtil.getSession();
		Users userGone = getUser_Id(user_id); 
		
			ses.delete(userGone);
			HibernateUtil.closeSession();
			return true;
		}



	@Override
	public List<Users> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	} 
}
