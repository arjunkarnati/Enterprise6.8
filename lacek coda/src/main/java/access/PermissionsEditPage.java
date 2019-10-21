package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class PermissionsEditPage extends PageBase {

	public PermissionsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update name
	public PermissionsEditPage updateName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_name"))).sendKeys(name);
		return new PermissionsEditPage(driver);
	}
	//delete name
	public PermissionsEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_name"))).clear();
		return new PermissionsEditPage(driver);
	}
	//update permission category
	public PermissionsEditPage updatePermissionCategory(String permissioncategory)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_permission_category"))).click();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_category_search_field"))).sendKeys(permissioncategory);
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_category_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permissions_edit_permission_category"))).getText(),permissioncategory);
		return new PermissionsEditPage(driver);
	}
	//empty permission category field
	public PermissionsEditPage emptyPermissionCategoryField()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_permission_category"))).click();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_category_search_field"))).sendKeys("Select a Permission Category");
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_category_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permissions_edit_permission_category"))).getText(),"Select a Permission Category");
		return new PermissionsEditPage(driver);
	}
	//update business rule
	public PermissionsEditPage updateBusinessRule(String businessrule)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_business_rule"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_business_rule"))).sendKeys(businessrule);
		return new PermissionsEditPage(driver);
	}
	//delete business rule
	public PermissionsEditPage deleteBusinessRule()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_business_rule"))).clear();
		return new PermissionsEditPage(driver);
	}
	//return to permissions main page
	public PermissionsPage clickPermissionsLink()
	{
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("permissions_main_page"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));
		return new PermissionsPage(driver);
	}
	//activate and inactivate 
	public PermissionsEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permissions_edit_inactivate"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permissions_edit_activate"))).click();
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new PermissionsEditPage(driver);
	}
	//click save
	public PermissionsPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_submit"))).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));
		return new PermissionsPage(driver);
	}
	//click cancel
	public PermissionsEditPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_edit_cancel"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));
		return new PermissionsEditPage(driver);
	}
	//click save for failed
	public PermissionsEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_edit_submit"))).click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_edit_page_title"));
		return new PermissionsEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionsEditPage archivePermissions()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_edit_archive"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_edit_page_title"));
		return new PermissionsEditPage(driver);			
	}
	//restore
	public PermissionsEditPage restorePermissions()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_edit_restore"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_edit_page_title"));
		return new PermissionsEditPage(driver);			
	}
}