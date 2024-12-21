package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employeees;
import com.service.Operations;

@WebServlet("/Reg")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		int sal=Integer.parseInt(req.getParameter("sal"));
		Employeees e=new Employeees();
		e.setName(name);
		e.setAge(age);
		e.setEmail(email);
		e.setSal(sal);
		Operations op=new Operations();
		boolean b=false;
		b= op.insert(e);
		System.out.println(b);
		
		PrintWriter w = resp.getWriter();
		

		if (b) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
            w.print("<p style='color:red'>Data Inserted successfully!</p>");
            try {
				rd.include(req, resp);
			} catch (ServletException | IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		     // Forward the request to welcome.html (response will be committed here)
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("Register.html");
		    w.write("<p style='color:red'>Email ID already Present</p>");
		    rd.include(req, resp);
		}
	}
	

}
