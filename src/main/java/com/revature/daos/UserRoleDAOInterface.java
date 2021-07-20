package com.revature.daos;

import java.util.List;

import com.revature.models.UserRoles;
import com.revature.models.Users;

public interface UserRoleDAOInterface {

	
		public UserRoles getUser_role_id(int user_role_id);
		
		
		public List<UserRoles> getAllRoles();
		
		
		public void addRole(UserRoles userrole);
		
		
		public void updateRole(UserRoles user_role);
		
		
		public void deleteRole(UserRoles user_role);
}
