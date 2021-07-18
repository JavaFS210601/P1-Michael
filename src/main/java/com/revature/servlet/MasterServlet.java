package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;

public class MasterServlet extends HttpServlet {
	
	private EmployeeController ec = new EmployeeController();
	private LoginController lc = new LoginController();
	private ManagerController mc = new ManagerController();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json"); //set the content of our resposne object to be JSON
		
		//by default, Tomcat will send back a successful status code (200) if a request gets handled.
		//since we have a master servlet that takes all requests, this means all requests will get handled.
		//this can lead to problems - we don;t want a 200 if the request isn't handled correctly
		//thus, by default, we'll set the status code to 404, and change it in our code upon success. 
		res.setStatus(404);
		
		//Now we want to write some code that will determine where requests get sent
		String URI = req.getRequestURI().replace("/P1-Michael/", "");
		//getting the request URI, and stripping out the base path
		//so we'll just be left with the endpoint (e.g. "avengers", "login") to use in a switch statement
		System.out.println(URI);
		switch(URI) {
		
		case "login": 
			lc.login(req, res);
			break;
		
		
		case "employee":
			break;
			
			
		case "manager":
			break;
		}
			
			
	
			
//			if(req.getSession(false) != null) { //if there is an active session (which means user is logged in)
//			ec.getAllEmployees(res); //doGet all avengers
//			} else {
//				res.setStatus(403); //forbidden, they aren't logged in so they can't get the goods 
//			}
//			break;
			
		
		
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		//this sends every POST request to the doGet method, why??
		//I only want one switch statement in this servlet. It can get very messy otherwise
		//and we'll differentiate get from post in the controllers instead of the servlet 
	}

}
