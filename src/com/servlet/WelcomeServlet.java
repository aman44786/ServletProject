package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WelcomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String e=request.getParameter("uemail");
		out.println("<h3> Welcome :" +e+"</h3>");
		
		//hidden form field
		out.println("<form action='MyProfileServlet' method='get'>");
		out.println("<input type='hidden' name='he' value='"+e+"'>");
		out.println("<input type='submit' value='MyProfile'>");
		out.println("</form>");
		
		//out.println("<a href='MyProfileServlet'>MyProfile</a>");
		out.println("<a href='EmployeeSearch.html'>Employee Search</a>");


}
}