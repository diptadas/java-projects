package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller.servlet")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String uName;
	private String uPass;
	private RequestDispatcher view;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		uName = request.getParameter("uName");
		uPass = request.getParameter("uPass");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Controller Passed control to thr next page<br/>");

		if (uName.equals("admin") && uPass.equals("admin"))
		{
			User user = new User(uName, uPass);
			request.setAttribute("A", user);
			view = request.getRequestDispatcher("success.view");
			view.forward(request, response);
		} else
		{
			view = request.getRequestDispatcher("error.view");
			view.include(request, response);
		}
	}

}
