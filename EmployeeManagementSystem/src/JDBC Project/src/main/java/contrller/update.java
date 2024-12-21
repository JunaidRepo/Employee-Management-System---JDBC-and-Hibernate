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


@WebServlet("/upd")
public class update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int oldid = Integer.parseInt(req.getParameter("oldid"));
		int id =Integer.parseInt( req.getParameter("id"));
		String name = req.getParameter("name");
		int age =Integer.parseInt( req.getParameter("age"));
		String email = req.getParameter("email");
		int sal =Integer.parseInt( req.getParameter("sal"));
		PrintWriter writer = resp.getWriter();
		//System.out.println(id+" "+oldid+" "+name+" "+age+" "+email+" "+sal);
		if(oldid==id) {
			EmployeeService.update(id, name, age, email, sal, oldid);
			writer.print("<p style='color:red'>sucessfully updated</p>");
			List<employee> l1=EmployeeService.ListOfEmployees();
			display.displayData(l1,req, resp);
		}else {
			employee i=EmployeeService.check(id);
			if(i==null) {
				EmployeeService.update(id, name, age, email, sal, oldid);
				writer.print("<p style='color:red'>sucessfully updated</p>");
				List<employee> l1=EmployeeService.ListOfEmployees();
				display.displayData(l1,req, resp);
			}else {
			
	            writer.print("<p style='color:red'>id already present!</p>");
	            List<employee> l1=EmployeeService.ListOfEmployees();
	    		display.displayData(l1,req, resp);
			}
		}
		
	}

}
