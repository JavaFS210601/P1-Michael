package com.revature.controllers;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.EmployeeSubmissionDTO;
import com.revature.DTO.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;

public class EmployeeController {

	
	
	private ObjectMapper objMapper = new ObjectMapper();
	private EmployeeService empService = new EmployeeService();
	private ReimbursementService rs = new ReimbursementService();
	
	public void submitRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if(req.getMethod().equals("POST")) {
			
			BufferedReader buffReader = req.getReader();
			StringBuilder sBuilder = new StringBuilder();
			String sLine = buffReader.readLine();
			
			
			while(sLine != null) {
				sBuilder.append(sLine);
				sLine = buffReader.readLine();
			}
			
			
			String sBody = new String(sBuilder);
			
			
			EmployeeSubmissionDTO employeeDTO = objMapper.readValue(sBody, EmployeeSubmissionDTO.class);
			res.getWriter().print("here");
			
			if(empService.submissionRequest(employeeDTO)){
				res.setStatus(200);
			}
			else {
				res.setStatus(500);
			}
		}
	}
	
public void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (request.getMethod().equals("POST")) {
			
			//this process below is to get our JSON string
			BufferedReader bufferedReader = request.getReader();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			String line = bufferedReader.readLine();
			
				while (line != null) {
					
					stringBuilder.append(line);
					line = bufferedReader.readLine();
				}//while
			
			String postBody = new String(stringBuilder);
			
			//we created a LoginDTO using the JSON turned Java "read this JSON(body) into this object (lDTO) and model it after this class (LoginDTO)
			LoginDTO loginDTO = objMapper.readValue(postBody, LoginDTO.class);
			
		
			//control flow to determine what happens in the event of a successful/unsuccessful login
		
				//if the username/password sent to the service are valid...do this...
				if(empService.login(loginDTO)) { 
					
					HttpSession session = request.getSession();
					
					session.setAttribute("user", loginDTO);
					session.setAttribute("loggedin", true);
					
					response.setStatus(200); //successfully retrieved manager
					response.getWriter().print("Hello, " + loginDTO.getUsername() + " is logged in!" );
					
					
				} else {
					
					HttpSession session = request.getSession(false);
					
						if (session != null) {
							session.invalidate();
						}
					
					response.setStatus(401);
					response.getWriter().print("Login Invalid");
					
					
				}			
		}	
	}

}
