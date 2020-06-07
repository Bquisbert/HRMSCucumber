package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class SauceDemoLoginPage extends CommonMethods{
	
	
	@FindBy(id="user-name")
	public WebElement userNameTextBox;
	
	@FindBy(id="password")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@class='btn_action']")
	public WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Product']")
	public WebElement headerText;
	
	
	public SauceDemoLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
