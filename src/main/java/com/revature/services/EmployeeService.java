package com.revature.services;

import com.revature.DTO.EmployeeSubmissionDTO;
import com.revature.DTO.LoginDTO;
import com.revature.daos.UserDAO;
import com.revature.models.Users;

public class EmployeeService {

	public boolean submissionRequest(EmployeeSubmissionDTO employeeDTO) {
	
		return false;
	}
	
private UserDAO uDao = new UserDAO();
	
	
	public boolean login(LoginDTO user) {

		if(uDao.validateLogin(user)) {
			return true;
			}
			return false;
	}
	
	
	public Users getUsers(String username) {
		return uDao.getUserByName(username);
	}

}
