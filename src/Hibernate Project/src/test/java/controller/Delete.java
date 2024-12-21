package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.Operation;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employeees;
import com.service.Operations;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Operations o=new Operations();
		o.delete(id);
		
		
		Operations op=new Operations();
		List <Employeees>e2=op.all();
		req.setAttribute("Employeees", e2);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		req.setAttribute("successMessage", "Deleted successfully!");
		rd.forward(req, resp);
	}
	

}
