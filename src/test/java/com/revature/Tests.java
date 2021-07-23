package com.revature;




import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.services.EmployeeService;
import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;

public class Tests {
	//this is a placeholder test class - feel free to delete or rename it
	LoginService ls = new LoginService();
	ReimbursementService rs = new ReimbursementService();
	EmployeeService es = new EmployeeService();
	
	@Test
	public void testValidLogin() {
		System.out.println("TESTING VALID LOGIN");
		
		assertTrue(ls.login2("Macarson", "Mike2021"));
	}
	
	@Test
	public void testInvalidLogin() {
		System.out.println("TESTING INVALID LOGIN");
		
		assertFalse(ls.login2("Nobody", "123"));
	}
	
	
}
