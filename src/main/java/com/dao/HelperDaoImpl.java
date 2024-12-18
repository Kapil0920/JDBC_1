package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Helper;

public class HelperDaoImpl implements HelperDao{
	static Connection conn;
	static {
		try {
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password ", "root");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void insert(Helper h) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("insert into helper (id,name,gender,salary) values ("+h.getId()+",'"+h.getName()+"','"+h.getGender()+"',"+h.getSalary()+")");
//			stmt.executeUpdate("insert into employee(id,name,gender,salary) values(" + e.getId() + ",'" + e.getName()
//			+ "','" + e.getGender() + "'," + e.getSalary() + ")");
			
			System.out.println("HelperDaoImpl.insert()");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void insertByPS(Helper h) {
		try {
			PreparedStatement state =conn.prepareStatement("insert into helper (id,name,gender,salary) values(?,?,?,?)");
			state.setInt(1, h.getId());
			state.setString(2,h.getName());
			state.setString(3, h.getGender());
			state.setInt(4, h.getSalary());
			state.executeUpdate();
			System.out.println("HelperDaoImpl.insertByPS()");
		}
		catch(SQLException e) {e.printStackTrace();}
		
		
	}
	@Override
	public void updateHelper(Helper h) {
		try {
			 	
			Statement st = conn.createStatement();
			st.executeUpdate("update helper set salary = "+h.getSalary()+", name ="+h.getName()+" where id= "+h.getId());
			System.out.println("HelperDaoImpl.updateHelper()");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void deleteHelper(int id) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("delete from helper where id="+id);
			System.out.println("HelperDaoImpl.deleteHelper()");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void getHelperById(int id) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from helper where id="+id);
			
			while(rs.next()) {
				System.out.println("Name = "+rs.getString(1)+"   Gender = "+rs.getString(2)+"   Id ="+rs.getInt(3)+"   Salary ="+rs.getInt(4));
			}
		}catch(SQLException e) {e.printStackTrace();}
		
	} 
	
	
	
	@Override
	public void getHelperByName(String name) {
//		try {
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery("select * from helper where name ='"+name);
//			
//			while(rs.next()) {
//				System.out.println("Name ="+rs.getString(1)+"Gender ="+rs.getString(2)+"Id = "+rs.getInt(3)+"Salary = "+rs.getInt(4));
//			}
//		}catch (SQLException e) {
//				e.printStackTrace();
//		}
		
		
		
		
		
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery("select * from helper where name=" + name);

			while (rs.next()) {
				System.out.println("ID = " + rs.getInt(3) + "  Name = " + rs.getString(1) + " Gender = "
						+ rs.getString(2) + " Salary = " + rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void getAllHelper() {
		
		try(Statement st = conn.createStatement()){
			ResultSet rs = st.executeQuery("select * from helper");
			
			
			while(rs.next()) {
				
				System.out.println("Name = "+rs.getString(1)+"\tGender ="+rs.getString(2)+"\tId ="+rs.getInt(3)+"\tSalary ="+rs.getInt(4));
			}
 		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
