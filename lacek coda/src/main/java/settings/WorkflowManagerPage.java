package settings;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class WorkflowManagerPage extends PageBase {

	public WorkflowManagerPage(WebDriver driver) 
	{
		super(driver);
	}
	//open wf manager add page
	public WorkflowManagerAddPage clickAddWfMgrButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_add_page_title"));
		return new WorkflowManagerAddPage(driver);
	}
	//relaod the page
	public WorkflowManagerPage reloadWfMgrPagePage()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_manager_add_reload"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_page_title"));
		return new WorkflowManagerPage(driver);
	}
	//open archive page
	public WorkflowManagerArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_archive_page_title"));
		return new WorkflowManagerArchivePage(driver);
	}
	//edit locales
	public WorkflowManagerEditPage editWorkflowMgr(String wfmgr)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(wfmgr);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (wfmgr)
		{
		case "edit_wfmgr_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_wfmgr_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_edit_page_title"));
			break;
		}	
		case "edit_wfmgr_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_wfmgr_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("wf manager "+wfmgr +" is not correct, please verify the wf manager name.");
		}
		}
		return new WorkflowManagerEditPage(driver);
	}
	//test validation
	public WorkflowManagerPage validateUpdates(String wfmgr,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(wfmgr);
		switch(column)
		{
		case"name":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_name"))).getText(),expectedresult);
			break;
		}
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_client"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("wf_manager_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for workflow manager page.");
		}
		}
		return new WorkflowManagerPage(driver);			
	}
	//restore wf state
	public WorkflowStateArchivePage restoreWorkflowMgr(String wfmgr)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(wfmgr);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Roles - Archive"));
		return new WorkflowStateArchivePage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public WorkflowStatePage archiveWorkFlowMgr(String wfmgr)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(wfmgr);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[15]/div/div/div/a[2]")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new WorkflowStatePage(driver);			
	}
}