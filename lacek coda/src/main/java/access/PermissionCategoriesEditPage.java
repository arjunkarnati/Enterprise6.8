package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class PermissionCategoriesEditPage extends PageBase {

	public PermissionCategoriesEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update name
	public PermissionCategoriesEditPage updateName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_name"))).sendKeys(name);
		return new PermissionCategoriesEditPage(driver);
	}
	//delete name
	public PermissionCategoriesEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_name"))).clear();
		return new PermissionCategoriesEditPage(driver);
	}
	//update name
	public PermissionCategoriesEditPage updateControllerNmae(String controllername)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_controller_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_controller_name"))).sendKeys(controllername);
		return new PermissionCategoriesEditPage(driver);
	}
	//delete name
	public PermissionCategoriesEditPage deleteControllerName()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_controller_name"))).clear();
		return new PermissionCategoriesEditPage(driver);
	}
	//activate and inactivate 
	public PermissionCategoriesEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_edit_inactivate"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_edit_activate"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc access page.");
		}
		return new PermissionCategoriesEditPage(driver);
	}
	//click save
	public PermissionCategoriesPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_submit"))).click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_page_title"));
		return new PermissionCategoriesPage(driver);
	}
	//click cancel
	public PermissionCategoriesPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_edit_cancel"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_page_title"));
		return new PermissionCategoriesPage(driver);
	}
	//click save for failed
	public PermissionCategoriesEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_edit_submit"))).click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_edit_page_title"));
		return new PermissionCategoriesEditPage(driver);
	}
	//return to permission groups main page
	public PermissionCategoriesPage returnToMainPage()
	{
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("permission_categories_main_page"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_page_title"));
		return new PermissionCategoriesPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionCategoriesEditPage archivePermissionCategories()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_edit_archive"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_edit_page_title"));
		return new PermissionCategoriesEditPage(driver);			
	}
	//restore
	public PermissionCategoriesEditPage restorePermissionCategories()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_edit_restore"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_edit_page_title"));
		return new PermissionCategoriesEditPage(driver);			
	}
}