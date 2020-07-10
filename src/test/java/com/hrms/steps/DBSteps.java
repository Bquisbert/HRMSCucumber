package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.DBUtils;

import io.cucumber.java.en.When;

public class DBSteps extends CommonMethods {

	public static List<Map <String, String>> dbData;
	
	@When("get data from db")
	public void get_data_from_db() {
	String sqlQuery=	"select emp_firstname from hs_hr_employees where emp_number=14688";
	dbData=DBUtils.storeDataFromDB(sqlQuery);
	
	
	}
	
	
	
	
	
	
}
