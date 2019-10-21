package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PermissionsAddPage extends PageBase {

	public PermissionsAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add name
	public PermissionsAddPage addName(String name)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_add_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_add_name"))).sendKeys(name);
		return new PermissionsAddPage(driver);
	}
	//add permission category
	public PermissionsAddPage addPermissionCategory(String permissioncategory)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_add_permission_category"))).click();
		driver.findElement(By.id(elementslocator.getProperty("permissions_add_category_search_field"))).sendKeys(permissioncategory);
		driver.findElement(By.id(elementslocator.getProperty("permissions_add_category_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("permissions_add_permission_category"))).getText(),permissioncategory);
		return new PermissionsAddPage(driver);
	}
	//add business rule
	public PermissionsAddPage addBusinessRule(String businessrule)
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_add_business_rule"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("permissions_add_business_rule"))).sendKeys(businessrule);
		return new PermissionsAddPage(driver);
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
	//click save
	public PermissionsPage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_submit"))).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));	
		return new PermissionsPage(driver);
	}
	//click cancel
	public PermissionsPage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_action_add_cancel"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));
		return new PermissionsPage(driver);
	}
	//click save for failed
	public PermissionsAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_action_add_submit"))).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_add_page_title"));
		return new PermissionsAddPage(driver);
	}
}