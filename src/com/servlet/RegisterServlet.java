package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
PrintWriter out=response.getWriter();
response.setContentType("text/html");

String n=request.getParameter("uname");
String p=request.getParameter("psw");
String e=request.getParameter("uemail");
String g=request.getParameter("gender");
String a=request.getParameter("add");
String d=request.getParameter("desig");
String dob=request.getParameter("dob");
String cv=request.getParameter("cv");

try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
	PreparedStatement ps=con.prepareStatement("insert into EmpInfo values(?,?,?,?,?,?,?,?,?)");
	ps.setString(1, null);
	ps.setString(2, n);
	ps.setString(3, e);
	ps.setString(4, p);
	ps.setString(5, a);
	ps.setString(6, g);
	ps.setString(7, d);
	ps.setString(8, dob);
	ps.setString(9, cv);

	int i=ps.executeUpdate();
	if(i==1)
	{
		out.println("Inserted");
}
	else
	{
		out.println("Try Again");
	}
}
catch(Exception e1)
{
	e1.printStackTrace();
}
}
}
