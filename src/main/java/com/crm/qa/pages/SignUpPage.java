package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	@FindBy(xpath="//select[@id='payment_plan_id']")
	WebElement selectEdition;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailTextBox;
	
	@FindBy(xpath="//input[@name='email_confirm']")
	WebElement confirmEmailTextBox;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='passwordconfirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement termsConditions;
	
	@FindBy(xpath="//div[@class='myButton']")
	WebElement submitButton;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSignUpPageTitle(){
		return driver.getTitle();
	}
	
	public void selectEditionDropDown(){
		Select select=new Select(selectEdition);
		select.selectByValue("1");
	}
	
	public void signUpPageForm(){
		
	}
	

}
