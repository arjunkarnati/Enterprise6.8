package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class ClientsEditPage extends PageBase {

	public ClientsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update  client name
	public ClientsEditPage updateNameTo(String newname)
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_name"))).clear();
		driver.findElement(By.id(manage.getProperty("client_edit_name"))).sendKeys(newname);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//delete  client name
	public ClientsEditPage deleteName()
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//update  color 
	public ClientsEditPage updateColorTo(String newcolorvalue)
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_color"))).clear();
		driver.findElement(By.id(manage.getProperty("client_edit_color"))).sendKeys(newcolorvalue);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//delete color
	public ClientsEditPage deleteColor()
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_color"))).clear();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//update  code 
	public ClientsEditPage updateCodeTo(String newcodevalue)
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_code"))).clear();
		driver.findElement(By.id(manage.getProperty("client_edit_code"))).sendKeys(newcodevalue);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//delete color
	public ClientsEditPage deleteCode()
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_code"))).clear();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//update  url 
	public ClientsAddPage updateUrlTo(String url)
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_url"))).clear();
		driver.findElement(By.id(manage.getProperty("client_edit_url"))).sendKeys(url);
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsAddPage(driver);
	}
	//delete color
	public ClientsEditPage deleteUrl()
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_url"))).clear();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//inactivate and activate client
	public ClientsEditPage inactivateClient()
	{
		elementLocators();
		driver.findElement(By.xpath(manage.getProperty("client_edit_inactivate"))).click();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//activate and activate client
	public ClientsEditPage activateClient()
	{
		elementLocators();
		driver.findElement(By.xpath(manage.getProperty("client_edit_activate"))).click();
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsEditPage(driver);
	}
	//click cancel
	public ClientsPage clickCancel()
	{
		elementLocators();
		driver.findElement(By.xpath(manage.getProperty("client_edit_cancel"))).click();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_page_title"));
		return new ClientsPage(driver);
	}
	//click submit
	public ClientsPage clickSubmit()
	{
		elementLocators();
		driver.findElement(By.id(manage.getProperty("client_edit_submit"))).click();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_page_title"));
		return new ClientsPage(driver);
	}
	//delete entry in brand field
	public ClientsEditPage deleteEntryInLocalField()
	{
		elementLocators();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(manage.getProperty("client_edit_locales_number"))).size();
		System.out.println("**locales: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(manage.getProperty("client_edit_locales"))).sendKeys(Keys.BACK_SPACE);
		}
		return new ClientsEditPage(driver);
	}
	//click save for failed
	public ClientsAddPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(manage.getProperty("client_edit_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),manage.getProperty("client_edit_page_title"));
		return new ClientsAddPage(driver);
	}
}