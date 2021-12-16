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


public class EmpSearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String d=request.getParameter("Designation");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
			PreparedStatement ps=con.prepareStatement("select * from EmpInfo where designation=?");
			ps.setString(1, d);
			ResultSet rs=ps.executeQuery();
			out.println("<table>");
			out.println("<tr><th>id</th><th>Name</th><th>Email</th><th>date of birth</th></tr>");
			while(rs.next())
			{
				out.println("<tr><td>\t"+rs.getInt("id") +"<tr><td>\t"+rs.getString("name") +"<tr><td>\t"+rs.getString("email") +"<tr><td>\t"+rs.getString("date_of_birth")+"</td></tr>\t");
			}
			out.println("<table>");
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
