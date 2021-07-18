package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.LoginDTO;
import com.revature.models.UserRoles;
import com.revature.models.Users;
import com.revature.services.LoginService;
import com.revature.utils.HibernateUtil;

public class LoginController {
	
	//my object mapper and service provider
		private ObjectMapper om = new ObjectMapper();
		private LoginService ls = new LoginService();
		
		//method first reads JSON to a string 
		//then proceeds to convert JSON to java String
		//placing this parse string into my login Data Transfer Object
		public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
			if(req.getMethod().equals("POST")) {
				//reads the request JSON string into a buffered reader
				//in order to build a JAVA string out of JSON 
				BufferedReader reader = req.getReader();
				StringBuilder sb = new StringBuilder();
				String line = reader.readLine();
				
				//building the JAVA string line by line until null
				while(line != null) {
					sb.append(line);
					line = reader.readLine();
				}
				
				//passing the built JAVA string into a new string
				String sBody = new String(sb);
				
				//mapping the JAVA string to the loginDTO object
				LoginDTO lgDTO = om.readValue(sBody, LoginDTO.class);
				
				Users user = ls.login(lgDTO.getUsername(), lgDTO.getPassword());
				
				if(user != null) {
					
					Session role = HibernateUtil.getSession();
					
					UserRoles roles = ls.getRole(user, role);
					
					HttpSession loginSession = req.getSession();
					
					loginSession.setAttribute("user", lgDTO);
					loginSession.setAttribute("valid", true);
					loginSession.setAttribute("userType", roles.getRole());
					String json = om.writeValueAsString(roles.getRole() + "," + user.getId());
					
					res.setStatus(200);
					res.getWriter().print(json);
				}
				else {
					HttpSession loginSession = req.getSession(false);
					if(loginSession != null) {
						loginSession.invalidate();
					}
					res.setStatus(401);
					res.getWriter().print("Invalid Attempt to login");
				}
			}
		}

}
