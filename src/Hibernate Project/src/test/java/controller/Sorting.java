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

@WebServlet("/sort")
public class Sorting extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {;
		Operations o=new Operations();
		List<Employeees> e1 = o.all();
		List<Employeees>l1=null;
		String s1=req.getParameter("sorting");
		
		if(s1.equalsIgnoreCase("idasc")) l1=e1.stream().sorted((i1,i2)->i1.getId()-i2.getId()).toList();
		else if(s1.equalsIgnoreCase("iddesc")) l1=e1.stream().sorted((i1,i2)->i2.getId()-i1.getId()).toList();
		else if(s1.equalsIgnoreCase("nameasc")) l1=e1.stream().sorted((i1,i2)->i1.getName().compareTo(i2.getName())).toList();	
		else if(s1.equalsIgnoreCase("namedesc")) l1=e1.stream().sorted((i1,i2)->i2.getName().compareTo(i1.getName())).toList();
		else if(s1.equalsIgnoreCase("ageasc")) l1=e1.stream().sorted((i1,i2)->i1.getAge()-i2.getAge()).toList();
		else if(s1.equalsIgnoreCase("agedesc")) l1=e1.stream().sorted((i1,i2)->i2.getAge()-i1.getAge()).toList();
		else if(s1.equalsIgnoreCase("emailasc")) l1=e1.stream().sorted((i1,i2)->i1.getEmail().compareTo(i2.getEmail())).toList();
		else if(s1.equalsIgnoreCase("emaildesc")) l1=e1.stream().sorted((i1,i2)->i2.getEmail().compareTo(i1.getEmail())).toList();
		else if(s1.equalsIgnoreCase("salasc")) l1=e1.stream().sorted((i1,i2)->i1.getSal()-i2.getSal()).toList();
		else if(s1.equalsIgnoreCase("saldesc")) l1=e1.stream().sorted((i1,i2)->i2.getSal()-i1.getSal()).toList();
		
		
//		l1.forEach(i->System.out.println(i.getAge()+" "+i.getEmail()+" "+i.getId()+" "+i.getName()+" "+i.getSal()));
		req.setAttribute("Employeees", l1);
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}
}
