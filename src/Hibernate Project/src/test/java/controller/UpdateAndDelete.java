package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employeees;
import com.service.Operations;

@WebServlet("/ud")
public class UpdateAndDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s=req.getParameter("upd");
		PrintWriter w = resp.getWriter();
		Operations o=new Operations();
		String []s1=s.split(" ");
		Employeees e1= o.display(Integer.parseInt(s1[1]));
		if(s1[0].equalsIgnoreCase("u")) {
			update(e1, w);
			
		}else {
			delete(e1, w);
			
			
		}
	}
	
	
	
	
	
	
	
	public void update(Employeees e1,PrintWriter pr) {
		String name=e1.getName();
		String Email=e1.getEmail();
		int sal=e1.getSal();
		int age=e1.getAge();
		int id=e1.getId();
		
		
		pr.write("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h3>Update the details</h3>\r\n"
				+ "    <form action=\"update\">\r\n"
				+ "     id:"+id+"<input type=\"hidden\" name=\"id\" value="+id+" \r\n"
				+ "        <br>\r\n"
				+ "        <br>"
				+ "        name: <input type=\"text\" name=\"name\" value="+name+">\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Email: <input type=\"email\" name=\"email\" value="+Email+">\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Age: <input type=\"number\" name=\"age\" value="+age+">\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Salary: <input type=\"number\" name=\"sal\" value="+sal+">\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        <button type=\"submit\">Update</button>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    </form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
	}
	
	
	
    public void delete(Employeees e1,PrintWriter pr) {
    	String name=e1.getName();
		String Email=e1.getEmail();
		int sal=e1.getSal();
		int age=e1.getAge();
		int id=e1.getId();
		
		
		
		pr.write("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h3>delete the datais</h3>\r\n"
				+ "    <form action=\"delete\">\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "        id:"+id+"<input type=\"hidden\" name=\"id\" value="+id+">\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        name:"+name+"\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Email:"+ Email+"\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Age: "+age+"\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        Salary: "+sal+"\r\n"
				+ "        <br>\r\n"
				+ "        <br>\r\n"
				+ "        <button type=\"submit\">Delete</button>\r\n"
				+ "    </form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
	}

}
