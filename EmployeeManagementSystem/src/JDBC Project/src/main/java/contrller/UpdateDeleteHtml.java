package com.contrller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.employee;
import com.service.EmployeeService;
public class UpdateDeleteHtml {
	public static void update(int id,HttpServletRequest req, HttpServletResponse resp) {
		employee e1=EmployeeService.check(id);
		int oldid=e1.getId();
		String name=e1.getName();
		int age=e1.getAge();
		String email=e1.getEmail();
		int sal=e1.getSal();
		try {
			PrintWriter we = resp.getWriter();
			we.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>update</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<h4>update the employee details</h4>\r\n"
					
					+ "<form action=\"upd\">\r\n"
					+"<input type=\"hidden\" name=\"oldid\" value="+oldid+">"
					+ "id<input type=\"number\" name=\"id\" value="+id+" required>\r\n"
					+ "<br>\r\n"
					+ "name<input type=\"text\" name=\"name\" value="+name+" required>\r\n"
					+ "<br>\r\n"
					+ "age<input type=\"number\" name=\"age\" value="+age+" required>\r\n"
					+ "<br>\r\n"
					+ "email<input type=\"email\" name=\"email\" value="+email+" required>\r\n"
					+ "<br>\r\n"
					+ "salary<input type=\"number\" name=\"sal\" value="+sal+" required>\r\n"
					+ "<br>\r\n"
					+ "<input type=\"submit\" value=\"update\">\r\n"
					+ "\r\n"
					+ "</form>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void delete(int id,HttpServletRequest req, HttpServletResponse resp) {
		employee e1=EmployeeService.check(id);
		String name=e1.getName();
		int age=e1.getAge();
		String email=e1.getEmail();
		int sal=e1.getSal();
		try {
			PrintWriter we = resp.getWriter();
			we.print("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>table</title>\r\n"
					+ "</head>\r\n"
					+ "<h4>do you want to delete this details</h4>\r\n"
					+ "<form action=\"del\">\r\n"
					+ "    id:"+id+"<input type=\"hidden\" name=\"id\" value="+id+">\r\n"
					+ "    <br>\r\n"
					+ "    name:"+name+"<input type=\"hidden\" name=\"name\" value=\"name\">\r\n"
					+ "    <br>\r\n"
					+ "    age="+age+"<input type=\"hidden\" name=\"age\" value=\"age\">\r\n"
					+ "    <br>\r\n"
					+ "    email="+email+"<input type=\"hidden\" name=\"email\" value=\"email\">\r\n"
					+ "    <br>\r\n"
					+ "    sal="+sal+"<input type=\"hidden\" name=\"sal\" value=\"sal\">\r\n"
					+ "    <br>\r\n"
					+ "    <input type=\"submit\" value=\"delete\">\r\n"
					+ "   \r\n"
					+ "</form> \r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		catch (Exception e) {
		}
	}
}
