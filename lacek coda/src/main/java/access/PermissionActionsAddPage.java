package access;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utility.PageBase;

public class PermissionActionsAddPage extends PageBase {

	public PermissionActionsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add name
	public PermissionActionsAddPage addName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_name"))).sendKeys(name);
		return new PermissionActionsAddPage(driver);
	}
	//add controller name
	public PermissionActionsAddPage addControllerName(String controllername)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_controller_action"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_controller_action"))).sendKeys(controllername);
		return new PermissionActionsAddPage(driver);
	}
	//add permissions
	public PermissionActionsAddPage addPermissions(String permission)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_permission"))).click();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_permission_search_field"))).sendKeys(permission);
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_permission_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permission_action_add_permission"))).getText(),permission);
		return new PermissionActionsAddPage(driver);
	}
	//return to permission groups main page
	public PermissionActionsAddPage clickPermissionActionsLink()
	{
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("permission_actions_main_page"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsAddPage(driver);
	}
	//click save
	public PermissionActionsPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_submit"))).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));	
		return new PermissionActionsPage(driver);
	}
	//click cancel
	public PermissionActionsAddPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_action_add_cancel"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsAddPage(driver);
	}
	//click save for failed
	public PermissionActionsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_submit"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_add_page_title"));
		return new PermissionActionsAddPage(driver);
	}
}