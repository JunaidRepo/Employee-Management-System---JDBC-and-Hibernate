package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.employee;

public class EmployeeService {
	private static String loc="jdbc:mysql://localhost:3306/users?user=root&password=root";
	 static Connection c;
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection(loc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int insert(employee e1) {
		int id=e1.getId();
		String name=e1.getName();
		int age=e1.getAge();
		String email=e1.getEmail();
		int sal=e1.getSal();
		//System.out.println(id+" "+name+" "+age+" "+email+" "+sal);
		String sql="insert into employees values(?,?,?,?,?);";
		int i=0;
		try(PreparedStatement p=c.prepareStatement(sql);	) {
			p.setInt(1,id);
			p.setString(2, name);
			p.setInt(3,age);
			p.setString(4,email);
			p.setInt(5, sal);
			i=p.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		System.out.println(i+" denotes the data insertion");
		
		return i;
	}
	public static List<employee> ListOfEmployees(){
		String sql="select * from employees;";
		List<employee> l1=new ArrayList<employee>();
		try(PreparedStatement p=c.prepareStatement(sql)) {
			
			ResultSet r = p.executeQuery();
			while(r.next()) {
				employee e1 = new employee(r.getInt(1), r.getString(2), r.getInt(3), r.getString(4), r.getInt(5));
				l1.add(e1);
				
			}	
		}catch(Exception e) {
			
		}
		
		return l1;
		
	}
	public static int update(int newid,String name,int age,String email,int sal ,int id) {
		int r=0;
		String sql="update employees set id=?,name=?,age=?,email=?,sal=? where id=?;";
        try(PreparedStatement p=c.prepareStatement(sql)) {
        	p.setInt(1, newid);
        	p.setString(2, name);
        	p.setInt(3, age);
        	p.setString(4, email);
        	p.setInt(5, sal);
        	p.setInt(6, id);
        	r = p.executeUpdate();
        } catch (SQLException e) {
			System.out.println("errr is-----> "+e.getMessage());
		}
   
		
		return r;
	}
	public static employee check(int id) {
		String sql="select * from employees where id=?";
		employee e1=null;
		try(PreparedStatement p=c.prepareStatement(sql)) {
        	p.setInt(1, id);
        	ResultSet r = p.executeQuery();
        	while(r.next()) {
        		e1 = new employee(r.getInt(1), r.getString(2), r.getInt(3), r.getString(4), r.getInt(5));
			}
        	
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return e1;
	}
	public static int delete(int id) {
		int r=0;
		String sql="delete from employees where id=?";
		try(PreparedStatement p=c.prepareStatement(sql)) {
        	p.setInt(1, id);
        	r = p.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return r;
		
	}
}