package com.sorting;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contrller.display;
import com.entity.employee;
import com.service.EmployeeService;


@WebServlet("/sort")
public class Sortings extends HttpServlet{
	
	List< employee> e1=EmployeeService.ListOfEmployees();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s1=req.getParameter("sorting");
		// TODO Auto-generated method stub
		if(s1.equalsIgnoreCase("idasc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i1.getId()-i2.getId()).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("iddesc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i2.getId()-i1.getId()).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("nameasc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i1.getName().compareTo(i2.getName())).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("namedesc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i2.getName().compareTo(i1.getName())).toList();
			display.displayData(l1,req, resp);
			
		}
		
		else if(s1.equalsIgnoreCase("ageasc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i1.getAge()-i2.getAge()).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("agedesc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i2.getAge()-i1.getAge()).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("emailasc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i1.getEmail().compareTo(i2.getEmail())).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("emaildesc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i2.getEmail().compareTo(i1.getEmail())).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("salasc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i1.getSal()-i2.getSal()).toList();
			display.displayData(l1,req, resp);
			
		}
		else if(s1.equalsIgnoreCase("saldesc")){
			List<employee> l1=e1.stream().sorted((i1,i2)->i2.getSal()-i1.getSal()).toList();
			display.displayData(l1,req, resp);
			
		}
		
	}
}