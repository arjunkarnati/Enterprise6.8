package settings;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WorkflowStateAddPage extends PageBase {

	public WorkflowStateAddPage(WebDriver driver) 
	{
		super(driver);
	}
	//add name
	public WorkflowStateAddPage addName(String name)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_add_name"))).sendKeys(name);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_add_page_title"));
		return new WorkflowStateAddPage(driver);
	}
	//add color
	public WorkflowStateAddPage addColor(String color)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_add_color"))).sendKeys(color);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_add_page_title"));
		return new WorkflowStateAddPage(driver);
	}
	//add description
	public WorkflowStateAddPage addDescription(String description)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_add_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_add_page_title"));
		return new WorkflowStateAddPage(driver);
	}
	//return to index page
	public WorkflowStatePage returnToMainPage()
	{	
		readconfig();
		driver.findElement(By.linkText(elementslocator.getProperty("wf_state_main_page"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_page_title"));
		return new WorkflowStatePage(driver);
	}
	//click save
	public WorkflowStatePage clickSave()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_page_title"));	
		return new WorkflowStatePage(driver);
	}
	//click cancel
	public WorkflowStatePage clickCancel()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("wf_state_add_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_page_title"));
		return new WorkflowStatePage(driver);
	}
	//click save for failed
	public WorkflowStateAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_add_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_add_page_title"));
		return new WorkflowStateAddPage(driver);
	}
}