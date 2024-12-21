package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employeees;
import com.service.Operations;

@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Employeees e1=new Employeees();
		e1.setName(req.getParameter("name"));
		e1.setEmail(req.getParameter("email"));
		e1.setAge(Integer.parseInt(req.getParameter("age")));
		e1.setId(Integer.parseInt(req.getParameter("id")));
		e1.setSal(Integer.parseInt(req.getParameter("sal")));
		Operations o=new Operations();
		o.update(e1);
		
		
		
        
        Operations op=new Operations();
		List <Employeees>e2=op.all();
		req.setAttribute("Employeees", e2);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		req.setAttribute("successMessage", "Updated successfully!");
		rd.forward(req, resp);
		
		
		
		
	}
}
