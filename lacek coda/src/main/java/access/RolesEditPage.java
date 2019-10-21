package access;

import Utility.PageBase;
import layout.RegionsAddPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RolesEditPage extends PageBase {

	public RolesEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update role name
	public RolesEditPage updateRoleNameTo(String newrolename)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_edit_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("role_edit_name"))).sendKeys(newrolename);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//update business rule
	public RolesEditPage updateBusinessRule(String businessrule)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_edit_business_rule"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("role_edit_business_rule"))).sendKeys(businessrule);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//upate parent role
	public RolesEditPage updateParentRole(String parentrolename)
	{
		readconfig(); 
		Select state = new Select(driver.findElement(By.id(elementslocator.getProperty("role_edit_parent_role"))));
		state.selectByVisibleText(parentrolename);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//update access level
	public RolesEditPage updateAccessLevel(int accesslevel)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_edit_access_level"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("role_edit_access_level"))).sendKeys(String.valueOf(accesslevel));
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//delete  name
	public RolesEditPage deleteName()
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//update permission
	public RolesEditPage updatePermissionGroup(String newpermissionname)
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_edit_permission_groups"))).sendKeys(newpermissionname);
		driver.findElement(By.id(elementslocator.getProperty("role_edit_permission_groups"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//inactivate and activate role
	public RolesEditPage activateRole()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("role_edit_activate"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//inactivate and activate role
	public RolesEditPage inactivateRole()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("role_edit_inactivate"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RolesEditPage(driver);
	}
	//click submit button
	public RolesPage Submit()
	{
		readconfig(); 
		driver.findElement(By.id(elementslocator.getProperty("role_edit_submit"))).click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_page_title"));
		//assert and verify
		return new RolesPage(driver);	
	}
	//click cancel button
	public RolesEditPage Cancel()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("role_edit_cancel"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		//assert and verify
		return new RolesEditPage(driver);		
	}
	//delete entry in permissions field
	public RolesEditPage emptyPermissionGroupField()
	{
		readconfig(); 	
		int iCount = driver.findElements(By.xpath(elementslocator.getProperty("role_edit_permission_groups_number"))).size();
		System.out.println("**permission groups): "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.id(elementslocator.getProperty("role_edit_permission_groups"))).sendKeys(Keys.BACK_SPACE);
		}
		return new RolesEditPage(driver);		
	}
	//click save for failed
	public RegionsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("role_edit_submit"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
		return new RegionsAddPage(driver);
	}
	//this method will be updated,(to permanent archive method)
		public RolesEditPage archiveRole()
		{
			readconfig();
			driver.findElement(By.xpath(elementslocator.getProperty("role_edit_archive"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			return new RolesEditPage(driver);			
		}
		public RolesEditPage restoreRole()
		{
			readconfig();
			driver.findElement(By.xpath(elementslocator.getProperty("role_edit_restore"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			return new RolesEditPage(driver);			
		}
}