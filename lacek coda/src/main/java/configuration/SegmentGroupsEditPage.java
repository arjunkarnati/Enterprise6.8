package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class SegmentGroupsEditPage extends PageBase {

	public SegmentGroupsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name in client field
	public SegmentGroupsEditPage updateClientNameTo(String newclientname) 
	{
		readconfig();	
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_client"))).click();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_client_search_field"))).sendKeys(newclientname);
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("seg_group_add_client"))).getText(),newclientname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//update  brand
	public SegmentGroupsEditPage updateBrandTo(String newbrandname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(configuration.getProperty("seg_group_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//update segement groups name
	public SegmentGroupsEditPage updateSegementGroupNameTo(String newsegementgroupname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_name"))).sendKeys(newsegementgroupname);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//delete segement groups name
	public SegmentGroupsEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//update type
	public SegmentGroupsEditPage updateTypeTo(String newtype) 
	{
		readconfig();	
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_type"))).click();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_type_search_field"))).sendKeys(newtype);
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_type_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//add description
	public SegmentGroupsEditPage updateDescriptionTo(String newdescription)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_description"))).clear();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_description"))).sendKeys(newdescription);
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//click submit button 
	public SegmentGroupsPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(configuration.getProperty("seg_group_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_page_title"));
		//return segment groups
		return new SegmentGroupsPage(driver);
	}
	//click cancel button
	public SegmentGroupsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("seg_group_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_page_title"));
		//driver.switchTo().alert().accept();
		//return media templates
		return new SegmentGroupsPage(driver);
	}
	//inactivate and activate regions
	public SegmentGroupsEditPage activateSegmentGroup()
	{
		readconfig();	
		driver.findElement(By.xpath(configuration.getProperty("seg_group_edit_activate"))).click();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//inactivate and activate regions
	public SegmentGroupsEditPage inactivateSegmentGroup()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("seg_group_edit_inactivate"))).click();
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);
	}
	//remove entries in brand field
	public SegmentGroupsEditPage deleteEntryInBrandField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(configuration.getProperty("seg_group_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.id(configuration.getProperty("seg_group_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		//return segment groups edit page
		return new SegmentGroupsEditPage(driver);	
	}
	//click save for failed
	public SegmentGroupsEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("seg_group_edit_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
		return new SegmentGroupsEditPage(driver);
	}
}