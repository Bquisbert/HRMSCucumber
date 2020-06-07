package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class PIM extends CommonMethods{

	@FindBy(css="a[id=menu_pim_addEmployee]")
	public WebElement addEmp;
	
	
	
	
	
	
	
	
	
	
	
	public PIM() {

	PageFactory.initElements(driver, this);
	
	}
	
	
}
