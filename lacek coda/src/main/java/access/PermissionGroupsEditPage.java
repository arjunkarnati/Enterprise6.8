package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class PermissionGroupsEditPage extends PageBase{

	public PermissionGroupsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update name
	public PermissionGroupsEditPage updateName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_name"))).sendKeys(name);
		return new PermissionGroupsEditPage(driver);
	}
	//delete namef
	public PermissionGroupsEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_name"))).clear();
		return new PermissionGroupsEditPage(driver);
	}
	//update name
	public PermissionGroupsEditPage updateBusinessRule(String businessrule)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_business_rule"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_business_rule"))).sendKeys(businessrule);
		return new PermissionGroupsEditPage(driver);
	}
	//delete name
	public PermissionGroupsEditPage deleteBusinessRule()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_business_rule"))).clear();
		return new PermissionGroupsEditPage(driver);
	}
	//update parent permission groups
	public PermissionGroupsEditPage updateParentPermissionGroup(String parentpermissiongroup)
	{
		readconfig();
		if(driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups"))).getText().equalsIgnoreCase(parentpermissiongroup))
		{
			driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_submit"))).click();
		}
		else
		{
			driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups"))).click();
			driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups_search_field"))).sendKeys(parentpermissiongroup);
			driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups_search_field"))).sendKeys(Keys.ENTER);
			Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups"))).getText(),parentpermissiongroup);
		}
		return new PermissionGroupsEditPage(driver);
	}
	//delete permission group 
	public PermissionGroupsEditPage deleteParentPermissionGroup()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups"))).click();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups_search_field"))).sendKeys("Select a Parent Permission Group if applicable");
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_parent_perm_groups"))).getText(),"Select a Parent Permission Group if applicable");
		return new PermissionGroupsEditPage(driver);
	}
	//delete permission group 
	public PermissionGroupsEditPage emptyPermissionField()
	{
		readconfig();
		int iCount = driver.findElements(By.xpath(elementslocator.getProperty("perm_grousp_edit_permission_number"))).size();
		//System.out.println("**permissions): "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_permissions"))).sendKeys(Keys.BACK_SPACE);
		}
		return new PermissionGroupsEditPage(driver);
	}
	//update permission
	public PermissionGroupsEditPage addPermission(String permission)
	{
		readconfig();		
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_permissions"))).sendKeys(permission);
		new Actions(driver).moveToElement(driver.findElement(By.xpath(elementslocator.getProperty("perm_grps_edit_permissions_search_field")))).build().perform();
		driver.findElement(By.xpath(elementslocator.getProperty("perm_grps_edit_permissions_search_field"))).click();
		Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("perm_grousp_edit_permission_number"))).isDisplayed());
		return new PermissionGroupsEditPage(driver);
	}
	//activate and inactivate 
	public PermissionGroupsEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_edit_inactive"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_edit_active"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new PermissionGroupsEditPage(driver);
	}
	//activate and inactivate 
	public PermissionGroupsEditPage validateStatus(String status,String permgroupname)
	{  
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_submit"))).click();
		driver.findElement(By.id(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("filter"))).sendKeys(permgroupname);
		Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_status"))),status);
		return new PermissionGroupsEditPage(driver);
	}
	//click save
	public PermissionGroupsPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_submit"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsPage(driver);
	}
	//click cancel
	public PermissionGroupsEditPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsEditPage(driver);
	}
	//click save for failed
	public PermissionGroupsEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_edit_submit"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_edit_page_title"));
		return new PermissionGroupsEditPage(driver);
	}
	//return to permission groups main page
	public PermissionGroupsAddPage returToPermissionGroupsPage()
	{
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("permission_groups_main_page"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsAddPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionGroupsEditPage archivePermissionGroups()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_edit_archive"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_edit_page_title"));
		return new PermissionGroupsEditPage(driver);			
	}
	//restore
	public PermissionGroupsEditPage restorePermissionGroups()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_edit_restore"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_edit_page_title"));
		return new PermissionGroupsEditPage(driver);			
	}
}