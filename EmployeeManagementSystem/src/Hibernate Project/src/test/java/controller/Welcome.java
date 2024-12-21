package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employeees;
import com.service.Operations;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String par = req.getParameter("wel");
		
		if(par.equalsIgnoreCase("add")){
			RequestDispatcher dt =req.getRequestDispatcher("Register.html");
			dt.forward(req, resp);
			
			
		}else {
			Operations op=new Operations();
			List <Employeees>e1=op.all();
			req.setAttribute("Employeees", e1);
			
			RequestDispatcher d = req.getRequestDispatcher("index.jsp");
			d.forward(req, resp);
			
		}
	}

}
