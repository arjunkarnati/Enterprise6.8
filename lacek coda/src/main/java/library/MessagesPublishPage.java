package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class MessagesPublishPage extends PageBase {

	public MessagesPublishPage(WebDriver driver) 
	{
		super(driver);		
	}
	//select every checkboxes
	public MessagesPublishPage checkAll()
	{
		elementLocators();
		java.util.List<WebElement> els = driver.findElements(By.xpath(library.getProperty("mes_publish_checkboxes")));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			//Assert.assertTrue(el.isSelected());	
		}
		//return campaign publish page
		return new MessagesPublishPage(driver);
	}
	//clcik publish button
	public MessagesPublishPage clickPublishButton()
	{
		elementLocators();
		driver.findElement(By.id(library.getProperty("mes_publish_button"))).click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Switch to active element model dialogue box.
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "submit" 
		driver.findElement(By.xpath(library.getProperty("mes_publish_submit_buton"))).click();	
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("dashboard_page_title")));
		return new  MessagesPublishPage(driver);
	}
	//click cancel button
	public MessagesPage clickCancelButton()
	{
		elementLocators();
		driver.findElement(By.xpath(library.getProperty("mes_publish_cancel_button"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("mess_page_title")));
		return new MessagesPage(driver);
	}
}