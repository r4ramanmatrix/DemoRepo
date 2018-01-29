package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory OR: Object Repository
	@FindBy(xpath="//input[@name='username']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement crmLogo;
	
	//initialize page objects
	public LoginPage() {
		//PageFactory is a class.
		PageFactory.initElements(driver, this);  //this pointing to current class object
	}
	
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pass){
		username.sendKeys(uname);
		password.sendKeys(pass);
		password.submit();
		//loginBtn.click();
		
		return new HomePage();
	}
	

}
