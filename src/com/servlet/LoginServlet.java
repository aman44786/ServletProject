package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String e=request.getParameter("uemail");
		String p=request.getParameter("psw");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
			PreparedStatement ps=con.prepareStatement("select * from EmpInfo where email=? and password=?");
			ps.setString(1,e);
			ps.setString(2,p);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
//				Cookie ck=new Cookie("email",e);
//				response.addCookie(ck);
				
//				HttpSession session=request.getSession();
//				session.setAttribute("email", e);
				
				out.println("welcome :"+rs.getString("name"));
				RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
				rd.forward(request, response);
			}
			else
			{
				out.println("please ragister first !!! ");
				out.println("please enter valid username and password");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				out.println("<a href='Register.html'>Register</a>");
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
		
}
