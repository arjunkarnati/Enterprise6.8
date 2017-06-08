package access;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionCategoriesAddPage extends PageBase {

	public PermissionCategoriesAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add name
	public PermissionCategoriesAddPage addName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_add_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_add_name"))).sendKeys(name);
		return new PermissionCategoriesAddPage(driver);
	}
	//add controller name
	public PermissionCategoriesAddPage addControllerName(String controllername)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_add_controller_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_add_controller_name"))).sendKeys(controllername);
		return new PermissionCategoriesAddPage(driver);
	}
	//return to permissions main page
	public PermissionCategoriesPage clickPermissionsLink()
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
	//click save
	public PermissionCategoriesPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_add_submit"))).click();
		try {
			Thread.sleep(20000);
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
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_cancel"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_page_title"));
		return new PermissionCategoriesPage(driver);
	}
	//click save for failed
	public PermissionCategoriesAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_add_submit"))).click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_add_page_title"));
		return new PermissionCategoriesAddPage(driver);
	}
}