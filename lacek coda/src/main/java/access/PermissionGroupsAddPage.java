package access;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionGroupsAddPage extends PageBase{

	public PermissionGroupsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add name
	public PermissionGroupsAddPage addName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_name"))).sendKeys(name);
		return new PermissionGroupsAddPage(driver);
	}
	//add business rule
	public PermissionGroupsAddPage addBusinessRule(String businessrule)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_business_rule"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_business_rule"))).sendKeys(businessrule);
		return new PermissionGroupsAddPage(driver);
	}
	//add parent permission group
	public PermissionGroupsAddPage addParentPermissionGroup(String parentpermissiongroup)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_parent_perm_groups"))).click();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_parent_perm_groups_search_field"))).sendKeys(parentpermissiongroup);
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_parent_perm_groups_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_parent_perm_groups"))).getText(),parentpermissiongroup);
		return new PermissionGroupsAddPage(driver);
	}
	//add permission
	public PermissionGroupsAddPage addPermission(String permission)
	{
		readconfig();		
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_permissions"))).sendKeys(permission);
		new Actions(driver).moveToElement(driver.findElement(By.xpath(elementslocator.getProperty("perm_grps_add_permissions_search_field")))).build().perform();
		driver.findElement(By.xpath(elementslocator.getProperty("perm_grps_add_permissions_search_field"))).click();
		Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("perm_grousp_add_permission_number"))).isDisplayed());
		return new PermissionGroupsAddPage(driver);
	}
	//return to permission groups main page
	public PermissionGroupsAddPage clickPermissionGroupsLink()
	{
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("permission_groups_main_page"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsAddPage(driver);
	}
	//click save
	public PermissionGroupsPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_submit"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));	
		return new PermissionGroupsPage(driver);
	}
	//click cancel
	public PermissionGroupsAddPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_add_cancel"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsAddPage(driver);
	}
	//click save for failed
	public PermissionGroupsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_add_submit"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_add_page_title"));
		return new PermissionGroupsAddPage(driver);
	}
}