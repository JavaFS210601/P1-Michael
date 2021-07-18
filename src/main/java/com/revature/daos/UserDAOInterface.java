package com.revature.daos;

import java.util.List;

import com.revature.models.Users;

public interface UserDAOInterface {

public void addUser(Users user);
	
	//public void updateUser(User user);
	
	public Users getUser_Id(int user_id);
	
	public boolean removeUser(int user_id);
	
	public List<Users> getAllUser();
}
