package settings;

import java.security.InvalidParameterException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;
import library.MessagesPage;

public class WorkflowStateEditPage extends PageBase {

	public WorkflowStateEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update name
	public WorkflowStateEditPage updateName(String name)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_name"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_name"))).sendKeys(name);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
		return new WorkflowStateEditPage(driver);
	}
	//delete name
	public WorkflowStateEditPage deleteName()
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_name"))).clear();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
		return new WorkflowStateEditPage(driver);
	}
	//update color
	public WorkflowStateAddPage updateColor(String color)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_color"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_color"))).sendKeys(color);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
		return new WorkflowStateAddPage(driver);
	}
	//delete color
	public WorkflowStateEditPage deleteColor()
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_color"))).clear();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
		return new WorkflowStateEditPage(driver);
	}
	//edit description
	public WorkflowStateEditPage updateDescription(String description)
	{	
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_description"))).clear();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
		return new WorkflowStateEditPage(driver);
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
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_submit"))).click();
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
		driver.findElement(By.xpath(elementslocator.getProperty("wf_state_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_page_title"));
		return new WorkflowStatePage(driver);
	}
	//click save for failed
	public WorkflowStateEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("wf_state_edit_submit"))).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_edit_page_title"));
		return new WorkflowStateEditPage(driver);
	}
	//activate and inactivate workflow
	public WorkflowStateEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_state_edit_inactivate"))).click();
			sleep();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("wf_state_edit_activate"))).click();
			sleep();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new WorkflowStateEditPage(driver);
	}
	public WorkflowStateEditPage validateConnectorUpdate(String name, String searchconnector, String connectorvalidate) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(searchconnector);
			try{
				Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[6]/span")).getText(), connectorvalidate);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		return new WorkflowStateEditPage(driver);
	}
	public WorkflowStateEditPage validateUpdates(String searchconnector,String column,String expectedresult)
	{
		readconfig();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(searchconnector);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		switch(column)
		{
		case"client":
		{
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("connector_client"))).getText(),expectedresult);
			break;
		}
		case"brand":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("connector_brand"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("connector_brand")));
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
		case"program":
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(elementslocator.getProperty("connector_program"))).size();
			//getting the entry value
			List<WebElement> iname = driver.findElements(By.xpath(elementslocator.getProperty("connector_program")));
			java.util.Iterator<WebElement> name = iname.iterator();
			while(name.hasNext()) 
			{
				WebElement row = name.next();
				System.out.println("**program: "+row.getText());
			} 
			//assert and verify
			Assert.assertEquals(expectedresult,String.valueOf(iCount));
			break;
		}
		case"name":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("connector_name"))).getText(),expectedresult);
			
			break;
		}
		
		case"status":
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("connector_status"))).getText(),expectedresult);
			break;
		}
		case"workflow":
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("connector_workflow"))).getText(),expectedresult);
			break;
		}
		default :
		{
			throw new InvalidParameterException(column +" is not a column for locales page.");
		}
		}
		return new WorkflowStateEditPage(driver);
	}
}