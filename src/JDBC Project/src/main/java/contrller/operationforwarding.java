package com.contrller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ud")
public class operationforwarding extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str=req.getParameter("b");
		String[] spl=str.split(",");
		int id=Integer.parseInt(spl[1]);
		
		if(spl[0].equalsIgnoreCase("up")) {
			UpdateDeleteHtml.update(id,req,resp);
		}else {
			UpdateDeleteHtml.delete(id,req,resp);
		}
	}

}
