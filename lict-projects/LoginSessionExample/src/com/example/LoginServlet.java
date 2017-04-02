package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
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
		
		String uName=request.getParameter("t1");
		String uPass=request.getParameter("t2");
		
		if((uName.equals("admin")) &&(uPass.equals("admin")))
		{
			HttpSession session=request.getSession();
			session.setAttribute("name",uName);
			out.println("Welcome "+uName);
		}
		else
		{
			out.println("Wrong username / password<br/>");
			view=request.getRequestDispatcher("login.html");
			view.include(request,response);
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

}
