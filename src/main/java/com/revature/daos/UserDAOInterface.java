package com.revature.daos;

import java.util.List;

import com.revature.models.Users;

public interface UserDAOInterface {

public void addUser(Users user);
	
	//public void updateUser(User user);
	
	public Users getUserById(int user_id);
	
	public void deleteUser(Users user);
	
	public List<Users> getAllUsers();
	
	Users getUserByName(String username);
	
	public List<Users> getUsersByRole(int user_role_id);
}
