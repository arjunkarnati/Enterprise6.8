package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class UsersEditPage extends PageBase {

	public UsersEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update first name
	public UsersEditPage updateFirstNameTo(String newfirstname)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_first_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_first_name"))).sendKeys(newfirstname);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//update last name
	public UsersEditPage updateLastNameTo(String newlastname)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_last_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_last_name"))).sendKeys(newlastname);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//update email address
	public UsersEditPage updateEmailTo(String newemailaddress)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_email"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_email"))).sendKeys(newemailaddress);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//add phone number
	public UsersEditPage updatePhoneNumberTo(int newphonenumber)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_phone"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_phone"))).sendKeys(String.valueOf(newphonenumber));
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//add username 
	public UsersEditPage updateUserNameTo(String newusername)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_username"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_username"))).sendKeys(newusername);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//add password 
	public UsersEditPage updatePassWordTo(String newpassword)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_password"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_password"))).sendKeys(newpassword);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//confirm password  password 
	public UsersEditPage updateConfirmPassWordTo(String newpassword)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_repeat_pw"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_repeat_pw"))).sendKeys(newpassword);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//delete password 
	public UsersEditPage deletePassWord()
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_password"))).clear();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//update client 
	public UsersEditPage updateClient(String newclient)
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("user_edit_client"))).sendKeys(newclient);
		driver.findElement(By.xpath(elementslocator.getProperty("user_edit_client"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//update role 
	public UsersEditPage updateRole(String newrole)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("user_edit_role"))).sendKeys(newrole);
		driver.findElement(By.id(elementslocator.getProperty("user_edit_role"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		return new UsersEditPage(driver);
	}
	//click submit button
	public UsersPage Submit()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("user_edit_submit"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_page_title"));
		//return users edit page
		return new UsersPage(driver);
	}
	//Click on save
	public UsersPage Save()
	{
		readconfig(); 
	//	WebElement element = driver.findElement(By.id(elementslocator.getProperty("user_edit_save")));
		driver.findElement(By.xpath(elementslocator.getProperty("user_edit_save"))).click();
	//	JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("arguments[0].click();", element);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_page_title"));
		//return users edit page
		return new UsersPage(driver);
	}
	
	//click cancel button
	public UsersEditPage Cancel()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("user_edit_cancel"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_page_title"));
		//return users edit page
		return new UsersEditPage(driver);		
	}
	//fail to ubpdate when a required field is empty
	public UsersEditPage failUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("user_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		//return users edit page
		return new UsersEditPage(driver);		
	}
	//inactivate and activate user
	public UsersEditPage isActive(boolean answer)
	{
		readconfig(); 
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("user_edit_inactivate"))).click();  
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("user_edit_activate"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc user page.");
		}
		return new UsersEditPage(driver);
	}
	//is user admin
	public UsersEditPage isAdmin(Boolean answer)
	{
		readconfig(); 
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("user_edit_all_not_access"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		}
		else if (answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("user_edit_all_access"))).click();
			//Assert.assertFalse(driver.findElement(By.id(elementslocator.getProperty("user_add_role"))).isDisplayed());
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc user page.");
		}
		return new UsersEditPage(driver);
	}
	//delete fields
	public UsersEditPage deleteField(String field)
	{
		readconfig(); 
		switch (field)
		{
		case "firstname":
		{
			driver.findElement(By.id(elementslocator.getProperty("user_edit_first_name"))).clear();
			break;
		}
		case "lastname":
		{
			driver.findElement(By.id(elementslocator.getProperty("user_edit_last_name"))).clear();
			break;
		}
		case "email":
		{
			driver.findElement(By.id(elementslocator.getProperty("user_edit_email"))).clear();
			break;
		}
		case "username":
		{
			driver.findElement(By.id(elementslocator.getProperty("user_edit_username"))).clear();
			break;
		}
		case "client":
		{
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("user_edit_client_number"))).size();
			System.out.println("**client(s): "+iCount);

			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.xpath(elementslocator.getProperty("user_edit_client"))).sendKeys(Keys.BACK_SPACE);
			}
			break;
		}
		case "role":
		{
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("user_edit_role_number"))).size();
			System.out.println("**role(s): "+iCount);

			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.id(elementslocator.getProperty("user_edit_role"))).sendKeys(Keys.BACK_SPACE);
			}
			break;
		}
		default: 
		{
			throw new InvalidParameterException("field "+field +" does not exist, ref automation doc users page.");
		}
		}
		return new UsersEditPage(driver);
	}
}