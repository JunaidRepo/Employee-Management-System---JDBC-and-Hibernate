package com.contrller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.employee;
import com.service.EmployeeService;


@WebServlet("/del")
public class delete extends HttpServlet {
//	static {
//		System.out.println("----");
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id =Integer.parseInt( req.getParameter("id"));
		
		
		PrintWriter writer = resp.getWriter();
		// TODO Auto-generated method stub
		EmployeeService.delete(id);
		writer.print("<p style='color:red'>sucessfully deleted</p>");
		List<employee> l1=EmployeeService.ListOfEmployees();
		display.displayData(l1,req, resp);
	}
	
	
	
	
}
