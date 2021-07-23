package com.revature.daos;

import org.hibernate.Session;


import com.revature.models.UserRoles;
import com.revature.models.Users;

public interface LoginDAOInterface {

	public UserRoles getRole(Users user, Session roles);
	
	public Users getUserPass(String username, String password);
	
}
