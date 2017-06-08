package access;

import java.security.InvalidParameterException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionGroupsPage extends PageBase{

	public PermissionGroupsPage(WebDriver driver) {
		super(driver);
	}
	//open permission groups add page
	public PermissionGroupsAddPage clickAddpermissionGroupsButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_add_button"))).click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_add_page_title"));
		return new PermissionGroupsAddPage(driver);
	}
	//relaod the page
	public PermissionGroupsPage reloadPermissionGroupsPagePage()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_add_button"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsPage(driver);
	}
	//open permission groups archive page
	public PermissionGroupsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_archive_button"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_archive_page_title"));
		return new PermissionGroupsArchivePage(driver);
	}
	//click print & view
	public PermissionGroupsPage clickViewPrintView()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("permission_groups_view_print_button"))).click();
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsPage(driver);
	}
	//edit permission groups
	public PermissionGroupsEditPage editPermissionGroups(String permissiongroupsname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissiongroupsname);
		waitForAjax(driver);
		switch (permissiongroupsname)
		{
		case "edit_permission_group_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_group_test_01"))).click();
			waitForAjax(driver);
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_edit_page_title"));
			break;
		}	
		case "edit_permission_group_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_group_test_010"))).click();
			waitForAjax(driver);
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("groups "+permissiongroupsname +" cannot be published, ref automation doc permission groups page.");
		}
		}
		return new PermissionGroupsEditPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public PermissionGroupsPage validateUpdates(String permgroupname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permgroupname);
		switch(column)
		{
		case"name":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_name"))).getText(),expectedresult);
			break;
		}
		case"parent name":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_parent_name"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("permission_groups_status"))).getText(),expectedresult);
			break;
		}
		case"permissions":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("permission_groups_permissions"))).size();
			System.out.println("**permissions: "+iCount);
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("permission_groups_permissions")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**permissions: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(String.valueOf(iCount), expectedresult);
			break;
		}
		case"role":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("permission_groups_roles"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("permission_groups_roles")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**roles: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for permission groups page.");
		}
		}
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();

		return new PermissionGroupsPage(driver);			
	}
	//restore role
	public PermissionGroupsPage ValidatePermissionsNumber(String permissiongroupsname,int expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissiongroupsname);
		int iCount = driver.findElements(By.xpath(elementslocator.getProperty("permission_groups_permissions"))).size();
		for (int i=0; i<iCount;i++)
		{
			Assert.assertEquals(iCount, expectedresult);
		}
		return new PermissionGroupsPage(driver);
	}
	//restore role
	public PermissionGroupsPage restorePermissionGroups(String permissiongroupsname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(permissiongroupsname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_archive_page_title"));
		return new PermissionGroupsPage(driver);
	}
	//select check boxes in show hide column
	public PermissionGroupsPage checkInShowhide()
	{
		driver.findElement(By.xpath("//a[4]")).click();
		sleep();
		java.util.List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			Assert.assertTrue(el.isSelected());
		}
		return new PermissionGroupsPage(driver);	
	}
	//this method will be updated,(to permanent archive method)
	public PermissionGroupsPage archivePermissionGroups(String permissiongroupsname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissiongroupsname);
		waitForAjax(driver);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[6]/div/div/div/a[2]")).click();
		waitForAjax(driver);
		//switch to active element
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

		return new PermissionGroupsPage(driver);			
	}
}