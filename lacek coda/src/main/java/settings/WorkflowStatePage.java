package settings;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class WorkflowStatePage extends PageBase{

	public WorkflowStatePage(WebDriver driver) 
	{
		super(driver);
	}
	//open wf state add page
	public WorkflowStateAddPage clickAddWfStateButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("wf_state_add_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_add_page_title"));
		return new WorkflowStateAddPage(driver);
	}
	//relaod the page
	public WorkflowStatePage reloadLocalesPagePage()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_add_reload"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_page_title"));
		return new WorkflowStatePage(driver);
	}
	//open archive page
	public WorkflowStateArchivePage clickArchiveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("wf_state_archive_button"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_archive_page_title"));
		return new WorkflowStateArchivePage(driver);
	}
	//edit locales
	public WorkflowStateEditPage editWorkflowState(String wfstate)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(wfstate);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (wfstate)
		{
		case "edit_wfstate_test_01":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_wfstate_test_01"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
			break;
		}	
		case "edit_wfstate_test_010":
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("edit_wfstate_test_010"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("wf state "+wfstate +" is not correct, please verify the wf state name.");
		}
		}
		return new WorkflowStateEditPage(driver);
	}
	//test validation
	public WorkflowStatePage validateUpdates(String wfname,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(wfname);
		switch(column)
		{
		case"name":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("wf_state_name"))).getText().toLowerCase(),expectedresult.toLowerCase());
			break;
		}
		case"description":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("wf_state_description"))).getText(),expectedresult);
			break;
		}
		case"status":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("wf_state_status"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for workflow state page.");
		}
		}
		return new WorkflowStatePage(driver);			
	}
	//restore wf state
	public WorkflowStateArchivePage restoreWorkflowState(String WorkFlowState)
	{
		readconfig();
		driver.findElement(By.xpath("//a[contains(text(),'Archive')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(WorkFlowState);
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		sleep();
		driver.findElement(By.xpath("html/body/div[6]/div/div/div[3]/button[1] | //button[@class='btn btn-success' and contains(text(),'Yes')]")).click();
		sleep();
		driver.findElement(By.id("reload")).click();
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Roles - Archive"));
		return new WorkflowStateArchivePage(driver);
	}
	//this method will be updated,(to permanent archive method)
	public WorkflowStatePage archiveWorkFlowState(String workfloestate)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("filter"))).sendKeys(workfloestate);
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
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[10]/div/div/a[2] | //i[contains(@class,'fa fa-trash-o')]")).click();
		//switch to active element 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		return new WorkflowStatePage(driver);			
	}
}