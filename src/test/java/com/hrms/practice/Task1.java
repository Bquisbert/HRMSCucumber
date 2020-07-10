package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Task1 {

	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	//jdbc:driver type:hostname:port/db name
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void jobTitles() throws SQLException {
		Connection con= DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from ohrm_job_title");
		
		List<String> jobTitles= new ArrayList<>();
		
		while(rs.next()) {
			jobTitles.add(rs.getObject("job_Title").toString());
		}
		
		
		for(String jt:jobTitles) {
			System.out.println(jt);
		}
		
	}
}
