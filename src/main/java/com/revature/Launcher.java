package com.revature;

import java.sql.Date;
import java.time.LocalDateTime;

import com.revature.DTO.NewReimbursementDTO;
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
		
//		UserRoles role1 = new UserRoles( "Finance Manager");
//		UserRoles role2 = new UserRoles( "Employee");
		
		//create user role objects
		UserRoles ur1 = new UserRoles("Finance Manager");
		UserRoles ur2 = new UserRoles("Employee");
				
		//add roles
		urDAO.addRole(ur1);
		urDAO.addRole(ur2);
		
		
		//create the user object
		Users u1 = new Users(1, "Overlord_Ben", "revature", "Ben", "Pet", "OverlordBen@revature.com", ur1);
		
		Users u2 = new Users(2, "Shaquille_Oatmeal", "basketball2021", "Shaquille", "Oatmeal", "Shaq2021@yahoo.com", ur2 );
		
		Users u3 = new Users(3, "Baby_Yoda", "Yoda2021", "Grogu", "??", "BabyYoda22@gmail.com", ur2);
		
		Users u4 = new Users(4, "Macarson", "Mike2021", "Michael", "Carson", "Michael.Carson@revature.net", ur2);
		
		
		
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
		
		
		Reimbursement r1 = new Reimbursement(1, 10000, new java.util.Date(System.currentTimeMillis()) , null  , "Travel expenses to go on road trip",  u2 , u1, rs1, rt1);
		Reimbursement r2 = new Reimbursement(2, 3000, new java.util.Date(System.currentTimeMillis()), null , "Hotel expenses during road trip", u3 , u1, rs2, rt2);
		Reimbursement r3 = new Reimbursement(3, 650, new java.util.Date(System.currentTimeMillis()), null, "Food expenses during road trip" , u4, u1, rs1, rt3);
		Reimbursement r4 = new Reimbursement(4, 250, new java.util.Date(System.currentTimeMillis()), null, "Other: Certification expenses" , u4, u1, rs3, rt4);
		
		
		Reimbursement r5 = new Reimbursement(5, 10000, new java.util.Date(System.currentTimeMillis()) , null  , "cookie",  u4 , u1, rs2, rt1);
		Reimbursement r6 = new Reimbursement(6, 10, new java.util.Date(System.currentTimeMillis()), null , "Baby Yoda wants chicken nuggies", u3 , u1, rs2, rt2);
		Reimbursement r7 = new Reimbursement(7, 650, new java.util.Date(System.currentTimeMillis()), null, "Shaq wants to go to the Lakers game" , u2, u1, rs3, rt3);
		Reimbursement r8 = new Reimbursement(8, 999999999, new java.util.Date(System.currentTimeMillis()), null, "Baby Yoda wants to go to Tatooine" , u3, u1, rs1, rt3);
		Reimbursement r9 = new Reimbursement(9, 666, new java.util.Date(System.currentTimeMillis()) , null  , "3 Nights of Stay at the Cabin in the Woods",  u2 , u1, rs2, rt2);
		

		
		rDAO.addReimbursement(r1);
		rDAO.addReimbursement(r2);
		rDAO.addReimbursement(r3);
		rDAO.addReimbursement(r4);
		rDAO.addReimbursement(r5);
		rDAO.addReimbursement(r6);
		rDAO.addReimbursement(r7);
		rDAO.addReimbursement(r8);
		rDAO.addReimbursement(r9);
	}
}
