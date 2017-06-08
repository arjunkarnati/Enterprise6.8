package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class PermissionCategoriesArchivePage extends PageBase {

	public PermissionCategoriesArchivePage(WebDriver driver) 
	{
		super(driver);
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
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_category_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_edit_page_title"));
			break;
		}	
		case "edit_permission_category_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_permission_category_test_01"))).click();
			try {
				Thread.sleep(5000);
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
}
