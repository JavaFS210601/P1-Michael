package com.revature.daos;

import java.util.List;


import org.hibernate.Session;

import com.revature.DTO.LoginDTO;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class UserDAO implements UserDAOInterface {

	@Override
	public void addUser(Users newUser) {
		//Open a hibernate Session object so that we can connect to the database
		Session ses = HibernateUtil.getSession(); //there is some parallels between ConnectionUtil.getConnection() in JDBC!
		
		ses.save(newUser); //use save method to insert into the data base it's a method for Insert fucntionality
		
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
	public Users getUserById(int user_id) {
		Session ses = HibernateUtil.getSession();
		Users user = ses.get(Users.class, user_id);
		HibernateUtil.closeSession();
		return user;
	}

	@Override
	public void deleteUser(Users user) {
		Session ses = HibernateUtil.getSession();
		
		ses.delete(user);
		
		HibernateUtil.closeSession();		
		}



	@Override
	public List<Users> getAllUsers() {
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language it references the Java class, not the DB table
		//e.g. "Author" in our models package instead of "authors" in our DB
		
		List<Users> userList = ses.createQuery("FROM Users").list(); //at the end, we're turning the Query object into a List
		
		//warning is unimportant, it's complaining about conversion
		//it wants a specific generic but it's not important. We could probably use casting to get rid of it
		
		HibernateUtil.closeSession();
		
		return userList;
		
	}


	@Override
	public Users getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Users> getUsersByRole(int user_role_id) {
		Session ses = HibernateUtil.getSession();
		
		List<Users> userList = ses.createQuery("from Users where user_role_id = " + user_role_id).list();
		
		HibernateUtil.closeSession();
		return userList;
	} 
	
	LoginDTO userCredentials = new LoginDTO();
	
	public boolean validateLogin(LoginDTO user) {
		
		Session session = HibernateUtil.getSession();

		boolean correctCredentials = false;
		
		List<Users> userList = session.createQuery("FROM User").list(); 
		
			for (Users u : userList) {
				
				if(u.getUsername().equals(user.getUsername())) {
					
					u.getPassword();
					
					if (u.getPassword().equals(user.getPassword())) {
						correctCredentials = true;
						return correctCredentials;
					}		
				}	
			}
		HibernateUtil.closeSession();
		return correctCredentials;
	}
}
