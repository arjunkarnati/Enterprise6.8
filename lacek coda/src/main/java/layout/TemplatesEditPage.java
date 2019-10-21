package layout;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class TemplatesEditPage extends PageBase {

	public TemplatesEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name in client field
	public TemplatesEditPage updateClientNameTo(String newclientname) 
	{
		readconfig();
		if(driver.findElement(By.id(elementslocator.getProperty("template_edit_client"))).getText().equalsIgnoreCase(newclientname))
		{
			driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_page_title"));
		}
		else
		{
			driver.findElement(By.id(elementslocator.getProperty("template_edit_client"))).click();
			driver.findElement(By.id(elementslocator.getProperty("template_edit_client_search_field"))).sendKeys(newclientname);
			driver.findElement(By.id(elementslocator.getProperty("template_edit_client_search_field"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.id(elementslocator.getProperty("template_edit_client"))).getText().equalsIgnoreCase(newclientname));
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		}
		//return templates edit page
		return new TemplatesEditPage(driver);
	}
	//update a brand
	public TemplatesEditPage updateBrandTo(String newbrandname)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("template_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(elementslocator.getProperty("template_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("template_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		//return templates edit page
		return new TemplatesEditPage(driver);
	}
	//update channel
	public TemplatesEditPage updateChannel(String newchannel)
	{
		readconfig();
		if(driver.findElement(By.xpath(elementslocator.getProperty("template_edit_channel"))).getText().equalsIgnoreCase(newchannel))
		{
			driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_page_title")); 
		}
		else if(driver.findElement(By.xpath(elementslocator.getProperty("template_edit_channel"))).getText().equalsIgnoreCase(newchannel));
		{
			driver.findElement(By.xpath(elementslocator.getProperty("template_edit_channel"))).click();
			driver.findElement(By.xpath(elementslocator.getProperty("template_edit_channel_search_field"))).sendKeys(newchannel);
			driver.findElement(By.xpath(elementslocator.getProperty("template_edit_channel_search_field"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("template_edit_channel"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
			//return templates edit page
		}
		return new TemplatesEditPage(driver);
	}
	//update template name
	public TemplatesEditPage updateTemplateName(String newtemplatename)
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("template_edit_name"))).clear();
		driver.findElement(By.xpath(elementslocator.getProperty("template_edit_name"))).sendKeys(newtemplatename);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		//return Templates Edit Page
		return new TemplatesEditPage(driver);
	}
	//update type
	public TemplatesEditPage updateType(String newtype)
	{
		readconfig();
		if(driver.findElement(By.xpath(elementslocator.getProperty("template_edit_type"))).getText().equalsIgnoreCase(newtype))
		{
			driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_page_title"));
		}
		else
		{
			driver.findElement(By.xpath(elementslocator.getProperty("template_edit_type"))).click();
			driver.findElement(By.xpath(elementslocator.getProperty("template_edit_type_search_field"))).sendKeys(newtype);
			driver.findElement(By.xpath(elementslocator.getProperty("template_edit_type_search_field"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("template_edit_type"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		}
		//return templates edit page
		return new TemplatesEditPage(driver);
	}
	//activate and inactivate campaign
	public TemplatesEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(layout.getProperty("template_status_inactive"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(layout.getProperty("template_status_active"))).click();
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new TemplatesEditPage(driver);
	}
	//set workflow to
	public TemplatesPage setWorkFlowTo(String workflowname, String templatename)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.id(elementslocator.getProperty("template_edit_workflow"))).sendKeys("D");
			driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(elementslocator.getProperty("template_edit_workflow"))).sendKeys("A");
			driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(elementslocator.getProperty("template_edit_workflow"))).sendKeys("Q");
			driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new TemplatesPage(driver);
	}
	//click submit button
	public TemplatesPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(layout.getProperty("template_edit_submit"))).click();
		boolean modalDialog = false;
		if(modalDialog==true)
			try {
				// Check the presence of alert
				driver.switchTo().activeElement();
				//Alert present; set the flag
				modalDialog = true;				
				System.out.println("*******************************modal dialog");
				// if present consume the alert
				alert.accept();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//refresh the page
				driver.navigate().refresh();
				//Now, click on ok or cancel button 
			} catch (NoAlertPresentException ex) {
				// Alert not present
				ex.printStackTrace();
			}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_page_title"));
		//return templates edit page
		return new TemplatesPage(driver);	
	}
	//click cancel button
	public TemplatesEditPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("template_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_page_title"));
		//return templates edit page
		return new TemplatesEditPage(driver);		
	}
	//click cancel button
	public TemplatesEditPage clickSaveButton()
	{
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("template_edit_save"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		return new TemplatesEditPage(driver);	 
	}
	//remove entries in brand field
	public TemplatesEditPage deleteEntryInBrandField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(elementslocator.getProperty("template_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(elementslocator.getProperty("template_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		//return teplates edit page
		return new TemplatesEditPage(driver);	
	}
	//click save for failed
	public TemplatesEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_edit_page_title"));
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage selectTemplatehistory() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("temp_history"))).click();
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage latestTemplatehistory() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("temp_latest_record"))).click();
		
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage compareTemplate() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("temp_compare"))).click();
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage validateTemp_count() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("temp_compare_count"))).getText();
		return new TemplatesEditPage(driver);
		
		
	}
	public TemplatesEditPage selectTemp_media_add() {
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("temp_media_add"))).click();
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage add_media_to_temp(String medianame) {
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("filet_in_temp_media"))).clear();
		driver.findElement(By.xpath(layout.getProperty("filet_in_temp_media"))).sendKeys(medianame);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(layout.getProperty("temp_media_select"))).click();
		driver.findElement(By.xpath(layout.getProperty("temp_media_close"))).click();
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage  rollbackTemplate() 
	{
		readconfig();
		
		driver.findElement(By.xpath(layout.getProperty("temp_rollback"))).click();
		driver.findElement(By.xpath(layout.getProperty("temp_rollback_yes"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage addmarkup_to_Template(String newmarkup) 
	{
        readconfig();
		
		driver.findElement(By.xpath(layout.getProperty("temp_add_markup"))).sendKeys(newmarkup);
		
		
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage selectTemp_region_header() {
          readconfig();
		
		driver.findElement(By.xpath(layout.getProperty("temp_region_header"))).click();
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage click_comm_temp() {
		 readconfig();
			
			driver.findElement(By.xpath(layout.getProperty("comm_temp_select"))).click();
			driver.findElement(By.xpath(layout.getProperty("comm_temp_select_region"))).click();
		return new TemplatesEditPage(driver);
	}
	public TemplatesEditPage deleteTemp_media() 
	{
		 readconfig();
			
			driver.findElement(By.xpath(layout.getProperty("temp_media_delete"))).click();
			driver.findElement(By.xpath(layout.getProperty("temp_media_delete_yes"))).click();
		return new TemplatesEditPage(driver);	
	}
	public TemplatesPage setWorkFlow_ehi_aeTo(String workflowname, String templatename) 
		
		{
			readconfig();
			switch(workflowname)
			{
			case "DRAFT":
			{
				driver.findElement(By.id(elementslocator.getProperty("template_edit_workflow"))).sendKeys("D");
				driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
				break;
			}
			case "APPROVED":
			{
				driver.findElement(By.id(elementslocator.getProperty("template_edit_workflow"))).sendKeys("A");
				driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
				break;
			}
			case "Qatest1":
			{
				driver.findElement(By.id(elementslocator.getProperty("template_edit_workflow"))).sendKeys("Q");
				driver.findElement(By.id(elementslocator.getProperty("template_edit_submit"))).click();
				break;
			}
			default: 
			{
				throw new InvalidParameterException("Please verify the workflow name");
			}
			}
			return new TemplatesPage(driver);
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
