package access;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class PermissionActionsArchivePage extends PageBase {

	public PermissionActionsArchivePage(WebDriver driver) {
		super(driver);
	}
	//edit permission groups
	public PermissionActionsEditPage editPermissionActions(String permissionactionname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionactionname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (permissionactionname)
		{
		case "edit_permission_action_test_01":
		{
			//driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_action_test_01"))).click();
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_edit_page_title"));
			break;
		}	
		case "edit_permission_action_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_action_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("actions "+permissionactionname +" cannot be edited, ref automation doc permission actions page.");
		}
		}
		return new PermissionActionsEditPage(driver);
	}
}
