package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionsArchivePage extends PageBase {

	public PermissionsArchivePage(WebDriver driver) 
	{
		super(driver);
	}
	//edit permission groups
	public PermissionsEditPage editPermissions(String permissionsname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(permissionsname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (permissionsname)
		{
		case "edit_permission_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_edit_page_title"));
			break;
		}	
		case "edit_permission_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("actions "+permissionsname +" cannot be published, ref automation doc permission groups page.");
		}
		}
		return new PermissionsEditPage(driver);
	}
}