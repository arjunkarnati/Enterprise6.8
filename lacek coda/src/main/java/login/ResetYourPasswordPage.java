package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class ResetYourPasswordPage extends PageBase {
	//constructor
	public ResetYourPasswordPage(WebDriver driver) 
	{
		super(driver);
	}
	//email address fields
	public ResetYourPasswordPage enterEmailAddress(String emailaddress)
	{
		elementLocators();
		driver.findElement(By.xpath(elementslocator.getProperty("reset_pw_email_address"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("reset_pw_email_address"))).sendKeys(emailaddress);
		driver.findElement(By.name(elementslocator.getProperty("reset_pw_submit"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResetYourPasswordPage(driver);
	}
	public ResetYourPasswordPage failToResetPassword()
	{
		elementLocators();
		Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("reset_pw_error_message"))).isDisplayed());
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("reset_pw_page_title"));
		return new ResetYourPasswordPage(driver);
	}	
}
