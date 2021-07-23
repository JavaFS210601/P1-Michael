package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.UserRoles;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class UserRoleDAO implements UserRoleDAOInterface {

	@Override
	public UserRoles getUser_role_id(int user_role_id) {
			//use this to start a new hibernate sesssion
			Session ses = HibernateUtil.getSession();
				
			//get the role  based on the id for the role by using the get method
			UserRoles role = ses.get(UserRoles.class, user_role_id);
				
			//close the hibernate session
			HibernateUtil.closeSession();
			//return the role object
			return role;
	}

	//this this in the user role class so the method needs to be in the user role dao
	public List<Users> getAllUser(){
			//use this to start a new hibernate sesssion
			Session ses = HibernateUtil.getSession();
			
			//getting the list of roles with a query
			List<Users> allUser = ses.createQuery("from User").list();
			
			//close the hibernate session
			HibernateUtil.closeSession();
			
			//return the list of roles from data base
			return allUser;
		}
	@Override
	public List<UserRoles> getAllRoles() {
			//use this to start a new hibernate sesssion
			Session ses = HibernateUtil.getSession();
				
			//getting the list of roles with a query
			List<UserRoles> roleList = ses.createQuery("from UserRole").list();
				
			//close the hibernate session
			HibernateUtil.closeSession();
				
			//return the list of roles from data base
			return roleList;
	}

	@Override
	public void addRole(UserRoles userrole) {
			//open a new hibernate session
			Session ses = HibernateUtil.getSession();
				
			//this is to insert the new role into the table by using the save method
			ses.save(userrole);
				
			//now close the hibernate session
			HibernateUtil.closeSession();
		
	}

	@Override
	public void updateRole(UserRoles user_role) {
			//open a new hibernate session
			Session ses = HibernateUtil.getSession();
				
			//update the role in the table by using merge method
			ses.merge(user_role);
				
			//close the hibernate session
			HibernateUtil.closeSession();
	}

	@Override
	public void deleteRole(UserRoles user_role) {
			//open a hibernate session
			Session ses = HibernateUtil.getSession();
		
			//remove theuser_role int the tableby using the delete method
			ses.delete(user_role);
		
			//close the hibernate session
			HibernateUtil.closeSession();
		
	}
}
