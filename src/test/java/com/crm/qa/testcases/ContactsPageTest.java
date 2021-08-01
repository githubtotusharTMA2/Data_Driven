package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.pages.ContactsPage;
import com.qa.crm.base.TestBase;

public class ContactsPageTest extends TestBase
{
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		contactsPage = new ContactsPage();	
	}
	
	@Test(priority = 1)
	public void loginTest() throws InterruptedException
	{
		contactsPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(contactsPage.menu.isDisplayed());
	}
	
	@Test(priority = 2)
	public void contactsGoTest()
	{
		contactsPage.contactsGo();
		Assert.assertTrue(driver.findElement(By.xpath("//i[@class = 'checkmark icon']")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void createNewContactTest()
	{
		contactsPage.createNewContact("Main", "Attacker", "TMA");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'ui header item mb5 light-black']")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
