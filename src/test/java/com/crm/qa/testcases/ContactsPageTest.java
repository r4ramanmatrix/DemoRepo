package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	TestUtil testutil;
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactsPage;
	
	String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testutil=new TestUtil();
		contactsPage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactsPage=homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Label is missing on the page");
	}
	
	@Test(priority=2)
	public void verifyContactsCheckBoxTest(){
		contactsPage.clickOnContactsCheckBox("aditya sharma");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstname, String surname, String company){
		homepage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Mohit", "Verma", "Gspann Technologies Inc.");
		contactsPage.createNewContact(title, firstname, surname, company);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
