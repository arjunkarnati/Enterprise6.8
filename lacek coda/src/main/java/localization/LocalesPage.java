package localization;

import Utility.PageBase;
import access.PermissionActionsPage;
import access.PermissionGroupsArchivePage;
import access.RolesArchivePage;
import localization.LocalesAddPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class LocalesPage extends PageBase {

	public LocalesPage(WebDriver driver) 
	{
		super(driver);
	}
	//open locales add page
	public LocalesAddPage clickAddLocalesButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("locales_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_add_page_title"));
		return new LocalesAddPage(driver);
	}
	//relaod the page
	public LocalesPage reloadLocalesPagePage()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("locales_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));
		return new LocalesPage(driver);
	}
	//open archive page
	public RolesArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("locales_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_archive_page_title"));
		return new PermissionGroupsArchivePage(driver);
	}
	//click print & view
	public PermissionActionsPage clickViewPrintView()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("locales_view_print_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));
		return new PermissionActionsPage(driver);
	}
	//edit locales
	public LocalesEditPage editLocales(String localesname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(localesname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (localesname)
		{
		case "latin":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("latin"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_edit_page_title"));
			break;
		}	
		case "gaulois":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("gaulois"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("locale "+localesname +" is not correct, please verify the locale name.");
		}
		}
		return new LocalesEditPage(driver);
	}
	//test validation
	public LocalesPage validateUpdates(String localesname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(localesname);
		switch(column)
		{
		case"name":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("locales_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("locales_code"))).getText(),expectedresult);
			break;
		}
		case"client":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("locales_client"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("locales_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new LocalesPage(driver);			
	}
	//restore locales
	public PermissionActionsPage restoreLocales(String localesname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(localesname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Roles - Archive"));
		return new PermissionActionsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionActionsPage archiveLocales(String localesname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(localesname);
		//select all check boxes
		java.util.List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			Assert.assertTrue(el.isSelected());
		}
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[9]/div/div/a[2]/i")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new PermissionActionsPage(driver);			
	}
}