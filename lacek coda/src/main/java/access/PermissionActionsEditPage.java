package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionActionsEditPage extends PageBase {

	public PermissionActionsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update name
	public PermissionActionsEditPage updateName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_name"))).sendKeys(name);
		return new PermissionActionsEditPage(driver);
	}
	//delete name
	public PermissionActionsEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_name"))).clear();
		return new PermissionActionsEditPage(driver);
	}
	//update name
	public PermissionActionsEditPage updateControllerAction(String controlleraction)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_controller_action"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_controller_action"))).sendKeys(controlleraction);
		return new PermissionActionsEditPage(driver);
	}
	//delete name
	public PermissionActionsEditPage deleteControllerAction()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_controller_action"))).clear();
		return new PermissionActionsEditPage(driver);
	}
	//update permission 
	public PermissionActionsEditPage updatePermission(String permission)
	{
		readconfig();
			driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission"))).click();
			driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission_search_field"))).sendKeys(permission);
			driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission_search_field"))).sendKeys(Keys.ENTER);
			Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission"))).getText(),permission);
		return new PermissionActionsEditPage(driver);
	}
	//delete permission group 
	public PermissionActionsEditPage emptyPermissionsField()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission"))).click();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission_search_field"))).sendKeys("Select the Permission tied to this action.");
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_permission"))).getText(),"Select the Permission tied to this action.");
		return new PermissionActionsEditPage(driver);
	}
	//activate and inactivate 
	public PermissionActionsEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permission_action_edit_inactivate"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permission_action_edit_activate"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new PermissionActionsEditPage(driver);
	}
	//click save
	public PermissionActionsPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_submit"))).click();
		try {
			Thread.sleep(18000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsPage(driver);
	}
	//click cancel
	public PermissionActionsEditPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_action_edit_cancel"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsEditPage(driver);
	}
	//click save for failed
	public PermissionActionsEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_edit_submit"))).click();
		try {
			Thread.sleep(18000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_edit_page_title"));
		return new PermissionActionsEditPage(driver);
	}
	//return to permission actioon main page
	public PermissionActionsEditPage returToPermissionGroupsPage()
	{
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("permission_actions_main_page"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionActionsEditPage archivePermissionActions()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_edit_archive"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_edit_page_title"));
		return new PermissionActionsEditPage(driver);			
	}
	//restore
	public PermissionActionsEditPage restorePermissionActions()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_actions_edit_restore"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_edit_page_title"));
		return new PermissionActionsEditPage(driver);			
	}
}