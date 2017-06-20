package access;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utility.PageBase;

public class UsersArchivePage extends PageBase {

	public UsersArchivePage(WebDriver driver) {
		super(driver);
	}
	public UsersPage restoreUser(String username)
	{
		readconfig();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(username);
		
		switch(username)
		{
		case "edit_user_test_01":
		{
			//driver.findElement(By.xpath(test_data_reader.getProperty("edit_user_test_01"))).click();
			
			driver.findElement(By.xpath(elementslocator.getProperty("user_edit_restore"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath(elementslocator.getProperty("user_edit_submit"))).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
		default: 
		{
			throw new InvalidParameterException("user "+username +" cannot be edited, ref automation doc users page.");
		}
		}		
		return new UsersPage(driver);
	}
}





