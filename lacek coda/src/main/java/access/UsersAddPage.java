package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class UsersAddPage extends PageBase {

	public UsersAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add first name
	public UsersAddPage addFirstName(String firstname)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_first_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_add_first_name"))).sendKeys(firstname);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//add last name
	public UsersAddPage addLastName(String lastname)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_last_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_add_last_name"))).sendKeys(lastname);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//add last name
	public UsersAddPage addEmail(String emailaddress)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_email"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_add_email"))).sendKeys(emailaddress);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//add phone number
	public UsersAddPage addPhoneNumber(int phonenumber)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_phone"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_add_phone"))).sendKeys(String.valueOf(phonenumber));
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//add username 
	public UsersAddPage addUserName(String username)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_username"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_add_username"))).sendKeys(username);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//add password 
	public UsersAddPage addPassWord(String password)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_password"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_add_password"))).sendKeys(password);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//confirm password 
	public UsersAddPage confirmPassWord(String password)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_repeat_pw"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_add_repeat_pw"))).sendKeys(password);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//add client 
	public UsersAddPage addClient(String client)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_client"))).sendKeys(client);
		driver.findElement(By.id(elementslocator.getProperty("user_add_client"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//add role 
	public UsersAddPage addRole(String role)
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("user_add_role"))).sendKeys(role);
		driver.findElement(By.xpath(elementslocator.getProperty("user_add_role"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
	//is user admin
	public UsersAddPage isAdmin(Boolean answer)
	{
		readconfig(); 
		if(answer==false)
		{
			sleep();
		}
		else if (answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("user_add_all_access"))).click();
			//Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("user_add_role"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc user page.");
		}
		return new UsersAddPage(driver);
	}
	//click cancel button
	public UsersPage Cancel()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("user_add_cancel"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_page_title"));
		return new UsersPage(driver);
	}
	//click submit button
	public UsersPage Submit()
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_add_submit"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_page_title"));
		return new UsersPage(driver);
	}
	//click save for failed
	public UsersAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("user_add_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_add_page_title"));
		return new UsersAddPage(driver);
	}
}