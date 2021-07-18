package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.EmployeeSubmissionDTO;
import com.revature.services.EmployeeService;

public class EmployeeController {
	
	
	private ObjectMapper objMapper = new ObjectMapper();
	private EmployeeService empService = new EmployeeService();
	
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

}
