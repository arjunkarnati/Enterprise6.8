package localization;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;


public class LocalesEditPage extends PageBase {

	public LocalesEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//edit name
	public LocalesEditPage updateName(String name)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_name"))).sendKeys(name);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_edit_page_title"));
		return new LocalesEditPage(driver);
	}
	//delete name
	public LocalesEditPage deleteName()
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_edit_page_title"));
		return new LocalesEditPage(driver);
	}
	//edit code
	public LocalesEditPage updateCode(String code)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_code"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_code"))).sendKeys(code);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_edit_page_title"));
		return new LocalesEditPage(driver);
	}
	//delete code
	public LocalesEditPage deleteCode()
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_code"))).clear();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_edit_page_title"));
		return new LocalesEditPage(driver);
	}
	//activate and inactivate 
	public LocalesEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("locales_edit_inactivate"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("locales_edit_activate"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc locales page.");
		}
		return new LocalesEditPage(driver);
	}
	//return to index page
	public LocalesPage returnToMainPage()
	{	
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("locales_main_page"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));
		return new LocalesPage(driver);
	}
	//click save
	public LocalesPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));	
		return new LocalesPage(driver);
	}
	//click cancel
	public LocalesPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("locales_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));
		return new LocalesPage(driver);
	}
	//click save for failed
	public LocalesAddPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_edit_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_edit_page_title"));
		return new LocalesAddPage(driver);
	}
}