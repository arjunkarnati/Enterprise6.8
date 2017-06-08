package configuration;

import java.security.InvalidParameterException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;

public class TargetingCriteriaPage extends PageBase{

	public TargetingCriteriaPage(WebDriver driver) 
	{
		super(driver);
	}
	//open targetingcriteria add page
	public TargetingCriteriaAddPage clickAddTargetingcriteriaButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("tar_criteria_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_add_page_title"));
		//return targetingcriteria add page
		return new TargetingCriteriaAddPage(driver);
	}	
	//open targetincriteria archive page
	public TargetingCriteriaArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("tar_criteria_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_archive_page_title"));
		//return targetingcriteria page
		return new TargetingCriteriaArchivePage(driver);
	}
	//edit a targetingcriteria
	public TargetingCriteriaEditPage editTargetingCriteria (String targetingcriterianame)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(targetingcriterianame);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(targetingcriterianame)
		{
		case "edit_tar_criteria_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_tar_criteria_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
			break;
		}
		case "edit_tar_criteria_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_tar_criteria_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("targeting criteria "+targetingcriterianame +" cannot be edited, ref automation doc targeting criteria page.");
		}
		}
		return new TargetingCriteriaEditPage(driver);
	}
	//restore targetingcriteria
	public TargetingCriteriaPage restoreTargetingCriteria(String targetingcriterianame)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(targetingcriterianame);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("targ_criteria_archive_page_title"));
		return new  TargetingCriteriaPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public TargetingCriteriaPage archiveTargetingcriteria(String targetingcriterianame)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(targetingcriterianame);
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
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new TargetingCriteriaPage(driver);			
	}
	//test validation
	public TargetingCriteriaPage validateUpdates(String tarcriterianame,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(tarcriterianame);
		switch(column)
		{
		case"client":
		{

			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("tar_criteria_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			System.out.println(""+configuration.getProperty("tar_criteria_brand"));
			
			int iCount = driver.findElements(By.xpath(configuration.getProperty("tar_criteria_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(configuration.getProperty("tar_criteria_brand")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**Brand: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"name":
		{
			
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("tar_criteria_name"))).getText(),expectedresult);
			break;
		}
		case"code":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("tar_criteria_code"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("tar_criteria_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new TargetingCriteriaPage(driver);			
	}
}