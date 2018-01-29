package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		dealspage=new DealsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title is not matched!!");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testutil.switchToFrame();
		boolean userNameLabel=homepage.verifyUserNameLabel();
		Assert.assertTrue(userNameLabel);
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void clickOnDealsLinkTest(){
		testutil.switchToFrame();
		dealspage=homepage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
