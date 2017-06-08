package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class TargetingCriteriaEditPage extends PageBase {

	public TargetingCriteriaEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name in client field
	public TargetingCriteriaEditPage updateClientNameTo(String newclientname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_client"))).click();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_client_search_field"))).sendKeys(newclientname);
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_client"))).getText(),newclientname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//update a brand
	public TargetingCriteriaEditPage updateBrandTo(String newbrandname)
	{
		readconfig();	
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//update targeting criteria name
	public TargetingCriteriaEditPage updateTargetingCriteriaName(String newtargetingcriterianame)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_name"))).sendKeys(newtargetingcriterianame);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//delete targeting criteria name
	public TargetingCriteriaEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//delete targeting criteria code
	public TargetingCriteriaEditPage deleteCode()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_code"))).clear();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//update targeting criteria name
	public TargetingCriteriaEditPage updateDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_description"))).clear();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//inactivate regions
	public TargetingCriteriaEditPage inactivateTargetingCriteria()
	{
		readconfig();	
		driver.findElement(By.xpath(configuration.getProperty("tar_criteria_edit_inactivate"))).click();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//activate regions
	public TargetingCriteriaEditPage activateTargetingCriteria()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("tar_criteria_edit_activate"))).click();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaEditPage(driver);
	}
	//click submit button
	public TargetingCriteriaPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_page_title"));
		//return targeting criteria edit page
		return new TargetingCriteriaPage(driver);	
	}
	//click cancel button
	public TargetingCriteriaPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("tar_criteria_edit_cancel"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_page_title"));
		//return targeting criteria  page
		return new TargetingCriteriaPage(driver);	
	}
	//remove entries in brand field
	public TargetingCriteriaEditPage deleteEntryInBrandField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(configuration.getProperty("tar_criteria_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		//return targeting criteria edit  page
		return new TargetingCriteriaEditPage(driver);
	}
	//click save for failed
	public TargetingCriteriaEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("tar_criteria_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("targ_criteria_edit_page_title"));
		return new TargetingCriteriaEditPage(driver);
	}
}