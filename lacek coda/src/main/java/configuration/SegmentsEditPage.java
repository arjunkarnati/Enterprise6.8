package configuration;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SegmentsEditPage extends PageBase {

	public SegmentsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name in client field
	public SegmentsEditPage updateClientNameTo(String newclientname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_client"))).click();
		driver.findElement(By.id(configuration.getProperty("segments_edit_client_search_field"))).sendKeys(newclientname);
		driver.findElement(By.id(configuration.getProperty("segments_edit_client_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("segments_edit_client"))).getText(), newclientname);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//update segmentgroups
	public SegmentsEditPage updateSegmentGroupsTo(String newsegmentgroupsname) 
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_segementgroups"))).click();
		driver.findElement(By.id(configuration.getProperty("segments_edit_segementgroups_search_field"))).sendKeys(newsegmentgroupsname);
		driver.findElement(By.id(configuration.getProperty("segments_edit_segementgroups_search_field"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertEquals(driver.findElement(By.id(configuration.getProperty("segments_edit_segementgroups"))).getText(),newsegmentgroupsname);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//update segement  name
	public SegmentsEditPage updateSegementNameTo(String newsegementname)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_name"))).clear();
		driver.findElement(By.id(configuration.getProperty("segments_edit_name"))).sendKeys(newsegementname);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//delete segement  name
	public SegmentsEditPage deleteName()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//update description
	public SegmentsEditPage updateDescriptionTo(String newdescription)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_description"))).clear();
		driver.findElement(By.id(configuration.getProperty("segments_edit_description"))).sendKeys(newdescription);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//update code
	public SegmentsEditPage updateCodeTo(String newintcode)
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_code"))).clear();
		driver.findElement(By.id(configuration.getProperty("segments_edit_code"))).sendKeys(newintcode);
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//update code
	public SegmentsEditPage deleteCode()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_code"))).clear();
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//inactivate segments
	public SegmentsEditPage inactivateSegment()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("segments_edit_inactivate"))).click();
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//activate segments
	public SegmentsEditPage activateSegment()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("segments_edit_activate"))).click();
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_edit_page_title"));
		//return segments  edit page
		return new SegmentsEditPage(driver);
	}
	//click submit button 
	public SegmentsPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(configuration.getProperty("segments_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_page_title"));
		//return segment 
		return new SegmentsPage(driver);
	}
	//click cancel button
	public SegmentsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("segments_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("segment_page_title"));
		//driver.switchTo().alert().accept();
		//return
		return new SegmentsPage(driver);
	}
	//click save for failed
	public SegmentsEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(configuration.getProperty("segments_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("segment_edit_page_title"));
		return new SegmentsEditPage(driver);
	}
}