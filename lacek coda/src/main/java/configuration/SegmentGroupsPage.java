package configuration;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;


public class SegmentGroupsPage extends PageBase{

	public SegmentGroupsPage(WebDriver driver) 
	{
		super(driver);
	}
	//open Segment Groups add page
	public SegmentGroupsAddPage clickAddSegementGroupButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("seg_group_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_add_page_title"));
		//return Segment Groups add page
		return new SegmentGroupsAddPage(driver);
	}	
	//open regions archive page
	public SegmentGroupsArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("seg_group_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_archive_page_title"));
		//return Segment Groups archive page
		return new SegmentGroupsArchivePage(driver);
	}
	//edit a Segment Groups
	public SegmentGroupsEditPage editSegmentGroup(String segmentgroupname)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(segmentgroupname);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch(segmentgroupname)
		{
		case "edit_seg_group_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_seg_group_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
			break;
		}
		case "edit_seg_group_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_seg_group_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.getTitle(),configuration.getProperty("seg_group_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("segment group "+segmentgroupname +" cannot be edited, ref automation segement groups page.");
		}
		}
		return new SegmentGroupsEditPage(driver);
	}
	//restore Segment Groups
	public SegmentGroupsPage restoreSegmentgroup(String segmentgroupsname)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(segmentgroupsname);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();		
		//assert ad verify	
		Assert.assertEquals(driver.getTitle(), configuration.getProperty("seg_group_archive_page_title"));
		return new  SegmentGroupsPage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public SegmentGroupsPage archiveSegementgroups(String segmentgroupsname)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(segmentgroupsname);
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new SegmentGroupsPage(driver);			
	}
	//test validation
	public SegmentGroupsPage validateUpdates(String seggroupname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).clear();
		driver.findElement(By.xpath(configuration.getProperty("filter"))).sendKeys(seggroupname);
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("seg_group_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(configuration.getProperty("seg_group_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(configuration.getProperty("seg_group_brand")));
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
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("seg_group_name"))).getText(),expectedresult);
			break;
		}
		case"type":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("seg_group_type"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(configuration.getProperty("seg_group_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new SegmentGroupsPage(driver);			
	}
}