package com.contrller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.employee;
import com.service.EmployeeService;



@WebServlet("/reg")
public class regester extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		int sal=Integer.parseInt(req.getParameter("sal"));
		employee e1=new employee(id, name, age, email, sal);
        
		
		
		PrintWriter writer = null;
		try {
			writer = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i=EmployeeService.insert(e1);
		if (i > 0) {
            // Success case: Forward to welcome page
            RequestDispatcher rd = req.getRequestDispatcher("welcome.html");
            writer.print("<p style='color:red'>Data has been inserted successfully!</p>");
            try {
				rd.include(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            // Error case: Forward to update page with an error message
        	
            RequestDispatcher rd = req.getRequestDispatcher("regester.html");
            writer.print("<p style='color:red'>id already present!</p>");
            try {
				rd.include(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
}
