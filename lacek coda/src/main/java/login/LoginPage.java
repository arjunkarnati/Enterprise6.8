package login;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


/*inherit PageBase classpage*/
public class LoginPage extends PageBase {

	/*Login constructor calling PageBase driver*/
	public LoginPage(WebDriver driver) 
	{
		super(driver);		
	}
	/*login*/
	public DashboardPage loginAs(String username, String password) 
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("user_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_name"))).sendKeys(username);
		waitForAjax(driver);
		driver.findElement(By.id(elementslocator.getProperty("password"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("password"))).sendKeys(password);
		waitForAjax(driver);
		driver.findElement(By.id(elementslocator.getProperty("login_button"))).click();	
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		waitForAjax(driver);
		switch (username){
		case "":
		{
			//Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("error1"))).isDisplayed());	
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("login_page_title"));
			break;
		}
		case "invalidusername":
		{
			//Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("error1"))).isDisplayed());	
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("login_page_title"));
			break;
		}
		default:
			driver.getTitle();
		}
		switch (password){
		case "":
		{
			//Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("error2"))).isDisplayed());	
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("login_page_title"));
			break;
		}
		case "invalidpassword":
		{
			//Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("error2"))).isDisplayed());	
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("login_page_title"));
			break;
		}
		default:
			driver.getTitle();
		}
		return new DashboardPage(driver);
	}
	/*toggle Active Directory Login To Yes*/
	public LoginPage directoryToYes()
	{
		readconfig();
		driver.findElement(By.xpath("html/body/div[3]/form/div[5]/div/div/span[3]")).click();
		return new LoginPage(driver);
	}
	/*clickResetYourPassword method*/
	public ResetYourPasswordPage clickResetYourPassword()
	{
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("reset_password"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("CODA - Reset Password Request"));
		return new ResetYourPasswordPage(driver);
	}
	/*login rbac*/
	public permissionsControlPage rbacLoginAs(String username, String password) 
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("user_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("user_name"))).sendKeys(username);
		sleep();
		driver.findElement(By.id(elementslocator.getProperty("password"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("password"))).sendKeys(password);
		sleep();
		driver.findElement(By.id(elementslocator.getProperty("login_button"))).click();
		return new permissionsControlPage(driver);	
	}
}