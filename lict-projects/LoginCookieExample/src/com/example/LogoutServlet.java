package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher view=request.getRequestDispatcher("link.html");
		view.include(request,response);
		
		Cookie c = new Cookie("pass", "");
		c.setMaxAge(0);
		response.addCookie(c);
		
		out.println("Logout successful");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

}
