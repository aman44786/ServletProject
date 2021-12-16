package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//String e=request.getParameter("uemail");
		String e=request.getParameter("he");
		out.println("Welcome :"+e);
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
			PreparedStatement ps=con.prepareStatement("select * from EmpInfo where email=?");
			ps.setString(1, e);
			ResultSet rs=ps.executeQuery();
			out.println("<table>");
			if(rs.next())
			{
				out.println("<tr><td>Name</td><td>"+rs.getString("name")+"</td></tr>");
				out.println("<tr><td>Password</td><td>"+rs.getString("password")+"</td></tr>");
				out.println("<tr><td>Address</td><td>"+rs.getString("address")+"</td></tr>");
				out.println("<tr><td>Date Of Birth</td><td>"+rs.getString("date_of_birth")+"</td></tr>");
				out.println("<tr><td>Gender</td><td>"+rs.getString("gender")+"</td></tr>");

			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
}
}