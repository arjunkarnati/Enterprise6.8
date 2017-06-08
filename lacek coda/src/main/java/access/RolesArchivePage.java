package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class RolesArchivePage extends PageBase {

	public RolesArchivePage(WebDriver driver) {
		super(driver);
	}
	//edit a role
	public RolesEditPage editRole(String rolename)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(rolename);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(rolename)
		{
		case "analytics_1":{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			try {
				Thread.sleep(5000);
				driver.findElement(By.id("Role_Name")).clear();
				driver.findElement(By.id("Role_Name")).sendKeys("analytics");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			break;
		}
		case "analytics":{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			try {
				Thread.sleep(5000);
				driver.findElement(By.id("Role_Name")).clear();
				driver.findElement(By.id("Role_Name")).sendKeys("analytics_1");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			break;
		
		}
		case "edit_role_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_role_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			break;
		}
		case "edit_role_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_role_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("role "+rolename +" cannot be published, ref automation doc roles page.");
		}
		}
		return new RolesEditPage(driver);
	}
}