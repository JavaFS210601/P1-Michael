package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.NewReimbursementDTO;
import com.revature.DTO.ReimbursementDTO;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.daos.TypeDAO;
import com.revature.daos.UserDAO;
import com.revature.services.ReimbursementService;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.Users;

public class ReimbursementController {

	private static UserDAO userDao = new UserDAO();
	private static StatusDAO statusDao = new StatusDAO();
	private static TypeDAO typeDao = new TypeDAO();
	private static ReimbursementDAO rDao = new ReimbursementDAO();
	private static ReimbursementService rs = new ReimbursementService();
	private static ObjectMapper om = new ObjectMapper();
	
	
	public void getAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		{
			List<Reimbursement> reimbList = rs.getAllReimbursements();
			
			String data = null;
	
			data = om.writeValueAsString(reimbList);
	
			
			response.getWriter().print(data);
			response.setStatus(200);
		}
	}

	public void getCompleteReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		List<Reimbursement> reimbList = rs.getCompletedReimbursements();
		
		String data = null;

		data = om.writeValueAsString(reimbList);
		
		response.getWriter().print(data);
		response.setStatus(200);
		
	}
	
	public void getPendingReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		List<Reimbursement> reimbList = rs.getPendingReimbursements();
		
		String data = null;

		data = om.writeValueAsString(reimbList);
		
		response.getWriter().print(data);
		response.setStatus(200);
		
	}

	public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		//make a buffered reader to read text from the input string
				BufferedReader reader = request.getReader();
				StringBuilder sb = new StringBuilder();
				//read the contents of the bufferedReader into a String
				String line = reader.readLine();
				
				while(line != null)
				{
					//add the contents of line to the stringbulder
					sb.append(line);
					//assign line to the next line of data in the reader
					line = reader.readLine();
				}
				//ObjectMapper only works with Strings
				String body = new String(sb);
				//use the ObjectMapper to read the JSON into the DTO
				ReimbursementDTO rDTO = om.readValue(body, ReimbursementDTO.class);
				
				//if the approval was successful...
				if(rs.approveReimbursement(Integer.parseInt(rDTO.getreimbursementId())))
				{
					response.setStatus(200);
				}
				else//approval was unsuccessful
				{
					response.setStatus(424);
				}
				
		
	}

	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		//read the contents of the bufferedReader into a String
		String line = reader.readLine();
		
		while(line != null)
		{
			//add the contents of line to the stringbulder
			sb.append(line);
			//assign line to the next line of data in the reader
			line = reader.readLine();
		}
		//ObjectMapper only works with Strings
		String body = new String(sb);
		//use the ObjectMapper to read the JSON into the DTO
		NewReimbursementDTO rDTO = om.readValue(body, NewReimbursementDTO.class);
		Users user = userDao.getUserByName(rDTO.getUsername());
		ReimbursementStatus status = statusDao.getStatus(1);
		ReimbursementType type = typeDao.getType(Integer.parseInt(rDTO.getType()));
		Date date = new Date(Long.parseLong(rDTO.getDate()));
		
		
		Reimbursement newReimbursement = new Reimbursement(Integer.parseInt(rDTO.getAmount()), date, null, rDTO.getDesc(), user, null, status, type);
		
		rDao.createReimbursement(newReimbursement);
		
	}

}
