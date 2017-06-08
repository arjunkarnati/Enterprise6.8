package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class TargetingCriteriaAddPage extends PageBase {

	public TargetingCriteriaAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//enter client name in client field
	public TargetingCriteriaAddPage addClientName(String clientname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_client"))).click();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("tar_criteria_add_client"))).getText(),clientname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_add_page_title"));
		//return targeting criteria add page
		return new TargetingCriteriaAddPage(driver);
	}
	//select a brand
	public TargetingCriteriaAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_brand"))).sendKeys(brandname);
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("tar_criteria_add_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_add_page_title"));
		//return targeting criteria add page
		return new TargetingCriteriaAddPage(driver);
	}
	//add targeting criteria name
	public TargetingCriteriaAddPage addTargetingCriteriaName(String targetingcriterianame)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_name"))).sendKeys(targetingcriterianame);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_add_page_title"));
		//return targeting criteria add page
		return new TargetingCriteriaAddPage(driver);
	}
	//add description
	public TargetingCriteriaAddPage addDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_description"))).clear();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_add_page_title"));
		//return targeting criteria add page
		return new TargetingCriteriaAddPage(driver);
	}
	//click submit button 
	public TargetingCriteriaPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(configuration.getProperty("tar_criteria_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_page_title"));
		//return targeting criteria add page
		return new TargetingCriteriaPage(driver);
	}
	//click cancel button
	public TargetingCriteriaPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("tar_criteria_add_cancel"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_page_title"));
		//return targeting criteria add page
		return new TargetingCriteriaPage(driver);
	}
	//click save for failed
	public TargetingCriteriaAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_add_page_title"));
		return new TargetingCriteriaAddPage(driver);
	}
}