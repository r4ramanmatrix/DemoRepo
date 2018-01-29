package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selectTitle;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement surNameTextBox;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyTextBox;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel(){
		
		return contactsLabel.isDisplayed();
	}
	
	public void clickOnContactsCheckBox(String name){
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();		
	}
	
	public void createNewContact(String title, String fname, String lastSurname, String companyname){
		Select select=new Select(selectTitle);
		select.selectByVisibleText(title);
		firstNameTextBox.sendKeys(fname);
		surNameTextBox.sendKeys(lastSurname);
		companyTextBox.sendKeys(companyname);
		saveButton.click();
	}
}
