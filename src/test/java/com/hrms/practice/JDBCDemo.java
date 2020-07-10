package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo {

	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	//jdbc:driver type:hostname:port/db name
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void abc() throws SQLException {
		Connection con= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from hs_hr_employees;");
		rs.next();
		String firstName=rs.getString("emp_firstname");
		System.out.println(firstName);
		rs.next();
		String firstName2 = rs.getObject("emp_firstname").toString();
		System.out.println(firstName2);
		
		while(rs.next()) {
			String allData;
			allData = rs.getObject("emp_firstname").toString();
			System.out.println(allData);
		}
		rs.close();
		st.close();
		con.close();
		
	}
	
	
	
	
	
	
	
	
	
}
