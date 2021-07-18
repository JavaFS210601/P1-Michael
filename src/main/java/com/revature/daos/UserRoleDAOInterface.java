package com.revature.daos;

import java.util.List;

import com.revature.models.UserRoles;
import com.revature.models.Users;

public interface UserRoleDAOInterface {

	//might do a get role by id most likely will have to change models though
		public UserRoles getUser_role_id(int user_role_id);
		
		//to just get the role might not need this
		//public UserRole getUser_role(String user_role);
		
		//might need to get all role dont see why I would need it for this project but just in case id most likely will have to change models though
		public List<UserRoles> getAllRoles();
		
		//insert a new role to the DB
		public void addRole(UserRoles userrole);
		
		//if I wanted to update or change  a role in the database
		public void updateRole(UserRoles user_role);
		
		//delete a role I guess if I mess up or something
		public void deleteRole(UserRoles user_role);
}
