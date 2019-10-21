package localization;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LocalesAddPage extends PageBase {

	public LocalesAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add name
	public LocalesAddPage addName(String name)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_add_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("locales_add_name"))).sendKeys(name);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_add_page_title"));
		return new LocalesAddPage(driver);
	}
	//add code
	public LocalesAddPage addCode(String code)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_add_code"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("locales_add_code"))).sendKeys(code);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_add_page_title"));
		return new LocalesAddPage(driver);
	}
	//return to index page
	public LocalesPage returnToMainPage()
	{	
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("locales_main_page"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));
		return new LocalesPage(driver);
	}
	//click save
	public LocalesPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_add_submit"))).click();
		try {
			Thread.sleep(7000);
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
		driver.findElement(By.xpath(elementslocator.getProperty("locales_add_cancel"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));
		return new LocalesPage(driver);
	}
	//click save for failed
	public LocalesAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_add_page_title"));
		return new LocalesAddPage(driver);
	}
}