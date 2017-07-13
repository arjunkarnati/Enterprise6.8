package access;

import java.security.InvalidParameterException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionActionsPage extends PageBase{

	public PermissionActionsPage(WebDriver driver) 
	{
		super(driver);
	}
	//open permission groups add page
	public PermissionActionsAddPage clickAddpermissionActionsButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_add_page_title"));
		return new PermissionActionsAddPage(driver);
	}
	//relaod the page
	public PermissionActionsPage reloadPermissionActionsPagePage()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsPage(driver);
	}
	//open archive page
	public PermissionActionsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_archive_page_title"));
		return new PermissionActionsArchivePage(driver);
	}
	//click print & view
	public PermissionActionsPage clickViewPrintView()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_actions_view_print_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsPage(driver);
	}
	//edit permission groups
	public PermissionActionsEditPage editPermissionActions(String permissionactionname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionactionname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (permissionactionname)
		{
		case "edit_permission_action_test_01":
		{
			//driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_action_test_01"))).click();
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_edit_page_title"));
			break;
		}	
		case "edit_permission_action_test_010":
		{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("actions "+permissionactionname +" cannot be edited, ref automation doc permission actions page.");
		}
		}
		return new PermissionActionsEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionActionsPage validateUpdates(String permissionactionname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionactionname);
		switch(column)
		{
		case"action name":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_action_name"))).getText(),expectedresult);
			break;
		}
		case"permission name":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_permission_name"))).getText(),expectedresult);
			break;
		}
		case"controller action":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_controller_action"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for permission actions page.");
		}
		}
		return new PermissionActionsPage(driver);			
	}
	//restore role
	public PermissionActionsPage restorePermissionAction(String permissionactionname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(permissionactionname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		return new PermissionActionsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionActionsPage archivePermissionActions(String permissionactionname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionactionname);
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
		                         
		//switch to active element
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PermissionActionsPage(driver);			
	}
}