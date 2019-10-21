package settings;

import Utility.PageBase;
import access.RolesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ChannelsPage extends PageBase{

	public ChannelsPage(WebDriver driver) {
		super(driver);
	}

	//this method will be updated,(to permanent archive method)
			public RolesPage archiveRole(String rolename)
			{
				driver.findElement(By.xpath("//input[@type='search']")).clear();
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(rolename);
				sleep();
				//select all check boxes
				java.util.List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
				for ( WebElement el : els ) 
				{
					if(!el.isSelected()) 
					{
						el.click();
					}
					Assert.assertTrue(el.isSelected());
				}
				driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[5]/div/div/div/a[2]")).click();
				//switching to class="modal-dialog" 
				driver.switchTo().activeElement();
				sleep();
				// find the button which contains text "yes" 
				driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

				return new RolesPage(driver);			
			}

}
