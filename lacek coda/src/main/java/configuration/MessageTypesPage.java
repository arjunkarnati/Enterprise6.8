package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utility.PageBase;

public class MessageTypesPage extends PageBase{

	public MessageTypesPage(WebDriver driver) {
		super(driver);
	}
	
	//this method will be updated,(to permanent archive method)
		public TargetingCriteriaPage archiveTargetingcriteria(String targetingcriterianame)
		{
			driver.findElement(By.xpath("//input[@type='search']")).clear();
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(targetingcriterianame);
			sleep();
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
			driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[7]/div/div/div/a[2]")).click();
			//switching to class="modal-dialog" 
			driver.switchTo().activeElement();
			sleep();
			// find the button which contains text "yes" 
			driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

			return new TargetingCriteriaPage(driver);			
		}
	
}


