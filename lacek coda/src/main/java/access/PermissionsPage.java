package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionsPage extends PageBase{

	public PermissionsPage(WebDriver driver) 
	{
		super(driver);
	}
	//open permissions add page
	public PermissionsAddPage clickAddpermissionsButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_add_page_title"));
		return new PermissionsAddPage(driver);
	}
	//relaod the page
	public PermissionsPage reloadPermissionsPage()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));
		return new PermissionsPage(driver);
	}
	//open archive page
	public PermissionsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_archive_page_title"));
		return new PermissionsArchivePage(driver);
	}
	//click print & view
	public PermissionsPage clickViewPrintView()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_view_print_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));
		return new PermissionsPage(driver);
	}
	//edit permission groups
	public PermissionsEditPage editPermissions(String permissionsname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionsname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (permissionsname)
		{
		case "edit_permission_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_edit_page_title"));
			break;
		}	
		case "edit_permission_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("actions "+permissionsname +" cannot be published, ref automation doc permission groups page.");
		}
		}
		return new PermissionsEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionsPage validateUpdates(String permissionsname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionsname);
		switch(column)
		{
		case"permission":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permissions_permission"))).getText(),expectedresult);
			break;
		}
		case"category":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permissions_category"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permissions_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for permissions page.");
		}
		}
		return new PermissionsPage(driver);			
	}
	//restore role
	public PermissionsPage restorePermissions(String permissionsname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(permissionsname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		return new PermissionsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionsArchivePage archivePermissions(String permissionsname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionsname);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[5]/div/div/div/a[2]")).click();

		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PermissionsArchivePage(driver);			
	}
}