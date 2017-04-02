package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String name = request.getParameter("userName");
			out.print("Welcome " + name + "</br>");

			//appending the user name in the query string
			out.print("<a href='SecondServlet.do?uName=" + name + "'>visit</a>");
					
			out.close();

	        }catch(Exception e){
	        	e.printStackTrace();;
	        }
	}

}
