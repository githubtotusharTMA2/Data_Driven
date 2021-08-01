package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath = "//button[contains(text(), 'Got It')]")
	WebElement gotItButton;
	
	@FindBy(xpath = "//a[contains(text(), 'About')]")
	WebElement aboutButton;
	
	@FindBy(xpath = "//span[@class = 'icon icon-xs mdi-chart-bar']")
	WebElement loginButton;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(text(), 'Login') and @class = 'ui fluid large blue submit button']")
	WebElement finalLoginButton;
	
	@FindBy(id = "main-nav")
	public WebElement menu;
	
	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement contactsButton;
	
	@FindBy(xpath = "(//button[@class = 'ui linkedin button'])[3]")
	WebElement createButton;
	
	@FindBy(name = "first_name")
	WebElement firstNameField;
	
	@FindBy(name = "last_name")
	WebElement lastNameField;
	
	@FindBy(xpath = "//i[@class = 'save icon']")
	WebElement saveButton;
	
	@FindBy(xpath = "(//input[@type = 'text' and @tabindex = '0' and @autocomplete = 'off' and @class = 'search' and @value = '' and @aria-autocomplete = 'list'])[6]")
	WebElement supervisorField;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void gotItButtonMethod()
	{
		try
		{
			gotItButton.click();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void login(String un, String pwd) throws InterruptedException
	{
		ContactsPage cp = new ContactsPage();
		cp.gotItButtonMethod();
		aboutButton.click();
		cp.gotItButtonMethod();
		loginButton.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		finalLoginButton.click();
		cp.gotItButtonMethod();
	}
	
	public void contactsGo()
	{
		Actions action = new Actions(driver);
		action.moveToElement(menu).build().perform();
		contactsButton.click();
	}
	
	public void createNewContact(String firstName, String lastName, String supervisor)
	{
		createButton.click();
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		supervisorField.sendKeys(supervisor);
		saveButton.click();
	}
}
