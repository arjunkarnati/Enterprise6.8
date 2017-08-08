package settings;

import java.security.InvalidParameterException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utility.PageBase;
import library.MessagesPage;
import library.VariablesAddPage;

public class ConnectorsEditPage extends PageBase {

	public ConnectorsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//empty and update name field
	public ConnectorsEditPage updateNameTo(String newname)
	{
		driver.findElement(By.xpath(".//*[@id='Connector_Name']")).clear();
		sleep();
		driver.findElement(By.xpath(".//*[@id='Connector_Name']")).sendKeys(newname);

		return new ConnectorsEditPage(driver);
	}
	//empty name field
	public ConnectorsEditPage deleteName()
	{
		driver.findElement(By.xpath(".//*[@id='Connector_Name']")).clear();
		sleep();
		return new ConnectorsEditPage(driver);
	}
	//update client
	public ConnectorsEditPage updateClientTo(String newclient)
	{
		driver.findElement(By.xpath(".//*[@id='select2-chosen-1']")).click();
		sleep();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen1_search']")).sendKeys(newclient);
		sleep();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen1_search']")).sendKeys(Keys.ENTER);
		//assert and verify		
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='select2-chosen-1']")).getText().equalsIgnoreCase(newclient));
		return new ConnectorsEditPage(driver);
	}
	//add a brand
	public ConnectorsEditPage addBrand(String brandname)
	{
		driver.findElement(By.xpath(".//*[@id='s2id_autogen7']")).click();
		sleep();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen7']")).sendKeys(brandname);
		sleep();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen7']")).sendKeys(Keys.ENTER);

		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='s2id_Connector_Brands']/ul/li")).isDisplayed());

		return new ConnectorsEditPage(driver);
	}
	//add a brand
	public ConnectorsEditPage addProgram(String programname)
	{
		driver.findElement(By.xpath(".//*[@id='s2id_autogen8']")).click();
		sleep();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen8']")).sendKeys(programname);
		sleep();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen8']")).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='s2id_Connector_Programs']/ul/li[1]")).isDisplayed());
		return new ConnectorsEditPage(driver);
	}
	//delete one entry in brand field
	public ConnectorsEditPage deleteBrand()
	{
		readconfig();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen7']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(".//*[@id='s2id_autogen7']")).sendKeys(Keys.BACK_SPACE);
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@id='s2id_Workflow_RoleID']/ul/li/input")).getText().isEmpty());
		return new ConnectorsEditPage(driver);
	}
	//delete one entry in program field
	public ConnectorsEditPage deleteProgram()
	{ 
		readconfig();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen8']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(".//*[@id='s2id_autogen8']")).sendKeys(Keys.BACK_SPACE);
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@id='s2id_Workflow_RoleID']/ul/li/input")).getText().isEmpty());
		return new ConnectorsEditPage(driver);
	}
	//update workflow
	public ConnectorsEditPage setWorkflowTo(String workflowname)
	{
		// Create instance of Javascript executor		 
		JavascriptExecutor je = (JavascriptExecutor) driver; 
		//Identify the WebElement which will appear after scrolling down			 
		WebElement element = driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']"));
		// execute query which actually will scroll until that element is not appeared on page	 
		je.executeScript("arguments[0].scrollIntoView(true);",element);

		driver.findElement(By.xpath(".//*[@id='select2-chosen-2']")).click();
		sleep();
		driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys(workflowname);
		sleep();
		driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys(Keys.ENTER);
		sleep();
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='select2-chosen-2']")).getText().equals(workflowname));
		return new ConnectorsEditPage(driver);
	}
	//activate and inactivate connector
	public ConnectorsEditPage isActive(boolean answer)
	{  
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(".//*[@id='connector-form']/div[1]/div[8]/div/div/div/span[2]")).click();
			sleep();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(".//*[@id='connector-form']/div[1]/div[8]/div/div/div/span[2]")).click();
			sleep();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new ConnectorsEditPage(driver);
	}
	//archive connector
	public ConnectorsEditPage archive()
	{
		driver.findElement(By.xpath("//form[@id='connector-form']/div[2]/div[8]/div/div/div/span[2]")).click();
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@id='s2id_Workflow_RoleID']/ul/li/input")).getText().isEmpty());
		return new ConnectorsEditPage(driver);
	}
	//click submit button
	public WorkflowStateEditPage submit()
	{
		driver.findElement(By.id("btnSubmit")).click();
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Workflow"));
		return new WorkflowStateEditPage(driver);
	}
	//click cancel button
	public WorkflowStateEditPage cancel()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
		sleep();
		//assert and verify
		//Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Workflow"));
		return new WorkflowStateEditPage(driver);
	}
	//fail updates
	public ConnectorsEditPage failToUpdate(String connectorname)
	{		
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Connectors - Edit"));
		return new ConnectorsEditPage(driver);
	}
	public ConnectorsEditPage addacfvalue(String string) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(".//*[@id='text_105']/div/div[1]/input")).sendKeys("0");
		return new ConnectorsEditPage(driver);
	
	}
	public ConnectorsEditPage editConnectorname(String newname) {
		// TODO Auto-generated method stub
		
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_name"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_name"))).sendKeys(newname);
		
		
		

		return new ConnectorsEditPage(driver);	
	}
	public ConnectorsEditPage updateConnector_brand(String newbrand) {
		// TODO Auto-generated method stub
		readconfig();
		
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_brand"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_brand"))).sendKeys(newbrand);
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_brand"))).sendKeys(Keys.ENTER);
		return new ConnectorsEditPage(driver);	

	}
	public ConnectorsEditPage updateConnector_program(String newprogram) {
		// TODO Auto-generated method stub
        readconfig();
		
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_program"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_program"))).sendKeys(newprogram);
		driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_program"))).sendKeys(Keys.ENTER);
		return new ConnectorsEditPage(driver);	
	}
	public ConnectorsEditPage updateConnector_workflow(String workflowname, String messagename)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_workflow"))).sendKeys("D");
			//driver.findElement(By.xpath(library.getProperty("mes_edit_submit"))).click();
			//Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.xpath(elementslocator.getProperty("conn_edit_workflow"))).sendKeys("A");
			//driver.findElement(By.xpath(library.getProperty("mes_edit_submit"))).click();
			//Assert.assertEquals(driver.getTitle(),library.getProperty("mess_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new ConnectorsEditPage(driver);	
	
		
			
	}
	
}