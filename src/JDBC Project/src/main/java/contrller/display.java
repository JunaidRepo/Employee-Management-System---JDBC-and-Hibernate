package com.contrller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.employee;
import com.service.EmployeeService;

import java.util.List;





public class display {

	public static void displayData(List<employee> l1,   HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		//RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.html");
		writer.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>table</title>\r\n"
				+ "</head>\r\n"
				+ "<body>"
				+"<form action=\"sort\" style=\"position: absolute; right: 0;\">\r\n"
				+ "    <h5>Check the data based on filters</h5>\r\n"
				+ "    <select name=\"sorting\" onchange=\"this.form.submit()\">\r\n"
				+ "        <option value=\"\" disabled selected>Select an option</option>\r\n"
				+ "        <option value=\"idasc\">id &uarr;</option>\r\n"
				+ "        <option value=\"iddesc\">id &darr;</option>\r\n"
				+ "        <option value=\"nameasc\">name &uarr;</option>\r\n"
				+ "        <option value=\"namedesc\">name &darr;</option>\r\n"
				+ "        <option value=\"ageasc\">age &uarr;</option>\r\n"
				+ "        <option value=\"agedesc\">age &darr;</option>\r\n"
				+ "        <option value=\"emailasc\">email &uarr;</option>\r\n"
				+ "        <option value=\"emaildesc\">email &darr;</option>\r\n"
				+ "        <option value=\"salasc\">salary &uarr;</option>\r\n"
				+ "        <option value=\"saldesc\">salary &darr;</option>\r\n"
				+ "    </select>\r\n"
				+ "</form>"
				+ "    <h1 align=\"center\">Employee Details</h1>\r\n"
				+ "<table border=\"5\" cellspacing=\"10\"  align=\"center\"\r\n"
				
				+ "        <tr>\r\n"
				+ "            <th>id</th>\r\n"
				+ "            <th>name</th>\r\n"
				+ "            <th>age</th>\r\n"
				+ "            <th>email</th>\r\n"
				+ "            <th>sal</th>\r\n"
				+
				"<th colspan=\"2\">update\\delete</th>"
				+ "        </tr>\r\n");
		for(int i=0;i<l1.size();i++) {
			employee e1=l1.get(i);
			int id=e1.getId();
			String name=e1.getName();
			int age=e1.getAge();
			String email=e1.getEmail();
			int sal=e1.getSal();
			String up="up,"+id;
			String del="del,"+id;
			writer.print("<tr>\r\n"
					+ "            <td>"+id+"</td>\r\n"
					+ "            <td>"+name+"</td>\r\n"
					+ "            <td>"+age+"</td>\r\n"
					+ "            <td>"+email+"</td>\r\n"
					+ "            <td>"+sal+"</td>\r\n"
					
					+"<form action=\"ud\"> <td>\r\n"
					+ "                <button name=\"b\" value="+up+" >update</button></td>\r\n"
					+ "                <td><button name=\"b\" value="+del+">delete</button></td>\r\n"
					+ "                </form>"
					+ "        </tr>\r\n");
			
		}
		writer.print("</table>\r\n"
				+"<a href=\"home\">homepage</a>"
				+ "</body>\r\n"
				+ "</html>"
				+ "</table>");
		
		
	}
	

}
