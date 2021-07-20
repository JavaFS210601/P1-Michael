package com.revature.daos;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.UserRoles;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class LoginDAO implements LoginDAOInterface {


	@Override
	public Users getUserPass(String username, String password) {
		
		Session session = HibernateUtil.getSession();
		
		Users user = (Users) session.createQuery("FROM Users WHERE username = ?1 AND password = ?2").setParameter(1,  username).setParameter(2,  password).getSingleResult();
		
		HibernateUtil.closeSession();
		
		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}
	
	
	@Override
	public UserRoles getRole(Users user, Session roles) {
		
//		Session session = HibernateUtil.getSession();
		
		UserRoles role = (UserRoles) roles.createQuery("FROM UserRoles WHERE id = ?1").setParameter(1,  user.getId()).getSingleResult();
		
		HibernateUtil.closeSession();
		
		return role;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//System.out.println(username);
//	System.out.println(password);
//
//	Query query =  session.createQuery("FROM Users as user WHERE user.username = :username AND user.password = :password");
//	
//	query.setParameter("username", username).setParameter("password", password);
//	
//	System.out.println(query);
//	
//	Users user = (Users) query.getSingleResult();
//	
//
//	System.out.println(query);

}
