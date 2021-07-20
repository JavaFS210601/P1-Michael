package com.revature;

import java.time.LocalDateTime;

import com.revature.daos.ReimbursementDAO;

import com.revature.daos.StatusDAO;
import com.revature.daos.TypeDAO;
import com.revature.daos.UserDAO;
import com.revature.daos.UserRoleDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.UserRoles;
import com.revature.models.Users;

public class Launcher {

	private static UserDAO uDAO = new UserDAO();
	private static UserRoleDAO urDAO = new UserRoleDAO();
	private static StatusDAO rsDAO = new StatusDAO(); 
	private static TypeDAO rtDAO = new TypeDAO();
	private static ReimbursementDAO rDAO = new ReimbursementDAO();
	
	public static void main(String[] args) {
		
		
		
		
		//add a new user 
		Users u =new Users();
		u.setUsername(null);
		
		UserRoles employee = new UserRoles(2, "Employee");
		UserRoles manager = new UserRoles(1, "Finance Manager");
		
		
		//create the user object
		Users u1 = new Users(1, "Regina_Rich", "Rich2021", "Regina", "Rich", "Regina_Rich_@revature.com", null);
		
		Users u2 = new Users(2, "John_Doe", "John2021", "John", "Doe", "John_Doe_@yahoo.com", null );
		
		Users u3 = new Users(3, "Mary_Jane", "Mary2021", "Mary", "Jane", "Mary_Jane_@gmail.com", null);
		
		Users u4 = new Users(4, "Mike_Larry", "Mike2021", "Mike", "Larry", "Mike_Larry_@hotmail.com", null);
		
		//this doesnt work cant figure out how to set the ids
//			u1.setUser_role(new UserRole("Finance Manager"));
//			u2.setUser_role(new UserRole("Employee"));
	//		u3.setUser_role(new UserRole("Employee"));
//			u4.setUser_role(new UserRole("Employee"));
		
		//set user using the dao methods
		
		uDAO.addUser(u1);
		uDAO.addUser(u2);
		uDAO.addUser(u3);
		uDAO.addUser(u4);
		
		
		//create user role objects
		UserRoles ur1 = new UserRoles("Finance Manager");
		UserRoles ur2 = new UserRoles("Employee");
		
		//add roles
		urDAO.addRole(ur1);
		urDAO.addRole(ur2);
	
		ReimbursementType rt1 = new ReimbursementType("Food");
		ReimbursementType rt2 = new ReimbursementType("Lodging");
		ReimbursementType rt3 = new ReimbursementType("Travel");
		ReimbursementType rt4 = new ReimbursementType("Other");
		
		rtDAO.insertType(rt1);
		rtDAO.insertType(rt2);
		rtDAO.insertType(rt3);
		rtDAO.insertType(rt4);
		
		
		ReimbursementStatus rs1 = new ReimbursementStatus("Pending");
	ReimbursementStatus rs2 = new ReimbursementStatus("Approved");
		ReimbursementStatus rs3 = new ReimbursementStatus("Denied");
		
		rsDAO.insertStatus(rs1);
		rsDAO.insertStatus(rs2);
		rsDAO.insertStatus(rs3);
		
		Reimbursement r1 = new Reimbursement(1, 200,  LocalDateTime.now(), LocalDateTime.now() , "Travel expenses to go to training in Georiga",  null , null, null, null);
		Reimbursement r2 = new Reimbursement(2, 200,  LocalDateTime.now(), LocalDateTime.now() , "Hotel expenses to go to training in New York", null , null, null, null);
		Reimbursement r3 = new Reimbursement(3, 200, LocalDateTime.now(), LocalDateTime.now(), "Food expenses for fourth of July party" , null, null, null, null);
		
		rDAO.addReimbursement(r1);
		rDAO.addReimbursement(r2);
		rDAO.addReimbursement(r3);
	}
}
