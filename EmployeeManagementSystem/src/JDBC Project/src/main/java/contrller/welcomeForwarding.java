package com.contrller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.employee;
import com.service.EmployeeService;

@WebServlet("/submit")
public class welcomeForwarding extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str=req.getParameter("aa");
		
		if(str.equalsIgnoreCase("add")) {
			RequestDispatcher d = req.getRequestDispatcher("regester.html");
			d.forward(req, resp);
			
		}else {
			List<employee>l1=EmployeeService.ListOfEmployees();
			display.displayData(l1,req, resp);
			
		}		
		
	}

}
