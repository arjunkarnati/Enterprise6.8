package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionCategoriesPage extends PageBase {

	public PermissionCategoriesPage(WebDriver driver) 
	{
		super(driver);
	}
	//open permission categories add page
	public PermissionCategoriesAddPage clickAddpermissionCategoriesButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_add_page_title"));
		return new PermissionCategoriesAddPage(driver);
	}
	//relaod the page
	public PermissionCategoriesPage reloadPermissionActionsPagePage()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_reload_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_page_title"));
		return new PermissionCategoriesPage(driver);
	}
	//open archive page
	public PermissionCategoriesArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_archive_page_title"));
		return new PermissionCategoriesArchivePage(driver);
	}
	//click print & view
	public PermissionCategoriesPage clickViewPrintView()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permissions_categories_view_print_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_page_title"));
		return new PermissionCategoriesPage(driver);
	}
	//edit permission categories
	public PermissionCategoriesEditPage editPermissionCategories(String permissioncategoriesname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissioncategoriesname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (permissioncategoriesname)
		{
		case "edit_permission_category_test_01":
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_edit"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_edit_page_title"));
			break;
		}	
		case "edit_permission_category_test_010":
		{
			driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_edit"))).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("actions "+permissioncategoriesname +" cannot be published, ref automation doc permission categories page.");
		}
		}
		return new PermissionCategoriesEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionCategoriesPage validateUpdates(String permissioncategoriesname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissioncategoriesname);
		switch(column)
		{
		case"name":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_name"))).getText(),expectedresult);
			break;
		}
		case"controller":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_controller"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permissions_categories_status"))).getText(),expectedresult);
			System.out.println("ACTIVE");
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for permission categories page.");
		}
		}
		return new PermissionCategoriesPage(driver);			
	}
	//restore role
	public PermissionCategoriesPage restorePermissionAction(String permissioncategories)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(permissioncategories);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Roles - Archive"));
		return new PermissionCategoriesPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionCategoriesPage archivePermissionCategory(String permissioncategories)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissioncategories);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
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
		WebElement ele = driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[5]/div/div/div/a[2]"));		                      
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[5]/div/div/div/a[2]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
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
		return new PermissionCategoriesPage(driver);			
	}
}