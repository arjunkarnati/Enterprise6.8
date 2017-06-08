package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PermissionGroupsArchivePage extends RolesArchivePage {

	public PermissionGroupsArchivePage(WebDriver driver) 
	{
		super(driver);
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
}
