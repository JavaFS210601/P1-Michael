package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.UserRoles;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class LoginDAO implements LoginDAOInterface {

	@Override
	public UserRoles getRole(Users user, Session roles) {
		
		Session session = HibernateUtil.getSession();
		
		UserRoles role = (UserRoles) roles.createQuery("FROM UserRoles WHERE ers_user_role_id = ?").setParameter(1,  user.getId()).uniqueResult();
		
		HibernateUtil.closeSession();
		
		return role;
	}

	@Override
	public Users getUserPass(String username, String password) {
		
		Session session = HibernateUtil.getSession();

		Users user = (Users) session.createQuery("FROM Users WHERE ers_username = ? AND ers_password = ?")
				.setParameter(1, username).setParameter(2, password).uniqueResult();
		
		HibernateUtil.closeSession();
		
		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}

	

}
