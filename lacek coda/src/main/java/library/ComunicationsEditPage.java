package library;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import Utility.PageBase;

public class ComunicationsEditPage extends PageBase{

	public ComunicationsEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name in client field
	public ComunicationsEditPage updateClientNameTo(String newclientname)
	{
		readconfig();
		if(driver.findElement(By.id(library.getProperty("comm_edit_client"))).getText().equals(newclientname))
		{
			driver.findElement(By.xpath(library.getProperty("comm_edit_cancel"))).click();
		}
		else
		{
			driver.findElement(By.id(library.getProperty("comm_edit_client"))).click();
			driver.findElement(By.id(library.getProperty("comm_edit_client_search_field"))).sendKeys(newclientname);
			driver.findElement(By.id(library.getProperty("comm_edit_client_search_field"))).sendKeys(Keys.ENTER);
			//assert
			String i= driver.findElement(By.id(library.getProperty("comm_edit_client"))).getText();
			Assert.assertEquals(i, newclientname);
		}
		//return communications add page
		return new ComunicationsEditPage(driver);
	}
	//update the brand
	public ComunicationsEditPage UpdateBrandTo(String newbrandname) 
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(library.getProperty("comm_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_edit_brand"))).isDisplayed());
		//return communication edit page
		return new ComunicationsEditPage(driver);
	}
	//update description in description field
	public ComunicationsEditPage updateDescription(String description)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_description"))).clear();
		driver.findElement(By.xpath(library.getProperty("comm_edit_description"))).sendKeys(description);
		//return communications edit page
		return new ComunicationsEditPage(driver);				
	}
	//select a program
	public ComunicationsEditPage updateProgramTo(String newprogramname)
	{		
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_program"))).sendKeys(newprogramname);
		driver.findElement(By.xpath(library.getProperty("comm_edit_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_edit_program"))).isEnabled());
		//return communications edit page
		return new ComunicationsEditPage(driver);
	}
	//update  track
	public ComunicationsEditPage updateTrackTo(String newtrackname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_tracks"))).sendKeys(newtrackname);
		driver.findElement(By.xpath(library.getProperty("comm_edit_tracks"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_edit_tracks"))).isEnabled());
		//return communications add page
		return new ComunicationsEditPage(driver);
	}
	//update communication name in name field
	public ComunicationsEditPage updateCommunicationName(String newcommunicationname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("comm_edit_name"))).clear();
		driver.findElement(By.id(library.getProperty("comm_edit_name"))).sendKeys(newcommunicationname);
		//return communications add page
		return new ComunicationsEditPage(driver);
	}	
	//update segments groups
	public ComunicationsEditPage updateSegmentGroups(String newsegmentgroupsname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_segment_groups"))).sendKeys(newsegmentgroupsname);
		driver.findElement(By.xpath(library.getProperty("comm_edit_segment_groups"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_edit_segment_groups"))).isEnabled());
		//return communications add page
		return new ComunicationsEditPage(driver);
	}
	//update connectors
	public ComunicationsEditPage updateConnector(String newconnectorname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_connector"))).sendKeys(newconnectorname);
		driver.findElement(By.xpath(library.getProperty("comm_edit_connector"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_edit_connector"))).isEnabled());
		//return communications add page
		return new ComunicationsEditPage(driver);
	}
	//activate and inactivate campaign
	public ComunicationsEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(library.getProperty("comm_status_inactive"))).click();
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(library.getProperty("comm_status_active"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc workflow page.");
		}
		return new ComunicationsEditPage(driver);
	}
	//validate that campaign status
	public ComunicationsEditPage validateStatusUpdate(String status, String communicationname)
	{
		readconfig();
		switch(status)
		{
		case "ACTIVE":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationname);
			Assert.assertEquals("ACTIVE", driver.findElement(By.xpath(library.getProperty("comm_status"))).getText());
			System.out.println("*** status is :"+driver.findElement(By.xpath(library.getProperty("comm_status"))).getText());
			break;
		}
		case "INACTIVE":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationname);
			Assert.assertEquals("INACTIVE", driver.findElement(By.xpath(library.getProperty("comm_status"))).getText());
			System.out.println("*** status is :"+driver.findElement(By.xpath(library.getProperty("comm_status"))).getText());
			break;		
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the status name");
		}
		}
		return new ComunicationsEditPage(driver);
	}
	//set workflow to
	public ComunicationsEditPage setWorkFlowTo(String workflowname, String Communicationname)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.id(library.getProperty("comm_edit_workflow"))).sendKeys("D");
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(library.getProperty("comm_edit_workflow"))).sendKeys("A");
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(library.getProperty("comm_edit_workflow"))).sendKeys("Q");
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new ComunicationsEditPage(driver);
	}
	//validate workflow update
	public ComunicationsEditPage validateWorkflowUpdate(String workflowname, String Communicationname)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(Communicationname);
			String actual=workflowname;
			Assert.assertEquals(actual, driver.findElement(By.xpath(library.getProperty("comm_workflow"))).getText());
			System.out.println("*** workflow is :"+driver.findElement(By.xpath(library.getProperty("comm_workflow"))).getText());
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(Communicationname);
			String actual=workflowname;
			Assert.assertEquals(actual, driver.findElement(By.xpath(library.getProperty("comm_workflow"))).getText());
			System.out.println("*** workflow is :"+driver.findElement(By.xpath(library.getProperty("comm_workflow"))).getText());
			break;		
		}
		case "Qatest1":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(Communicationname);
			String actual=workflowname;
			Assert.assertEquals(actual, driver.findElement(By.xpath(library.getProperty("comm_workflow"))).getText());
			System.out.println("*** workflow is :"+driver.findElement(By.xpath(library.getProperty("comm_workflow"))).getText());
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new ComunicationsEditPage(driver);
	}
	//archive communication
	//this method will be updated,(to permanent archive method)
	public CommunicationsPage archiveCommunication(String Communicationname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_page"))).click();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(Communicationname);
		//select all check boxes
		java.util.List<WebElement> els = driver.findElements(By.xpath(library.getProperty("tracks_publish_button")));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			Assert.assertTrue(el.isSelected());
		}
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[15]/div/div/a[3]")).click();
		driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[1]")).click();

		return new CommunicationsPage(driver);			
	}
	//click submit button
	public CommunicationsPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(library.getProperty("comm_edit_submit"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_page_title")));
		return new CommunicationsPage(driver);
	}
	//click cancel button
	public CommunicationsPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_cancel"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_page_title")));
		return new CommunicationsPage(driver);
	}
	//click cancel button
	public CommunicationsPreviewPage clickPreviwButton()
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_edit_preview"))).click();	
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_preview_page_title")));
		return new CommunicationsPreviewPage(driver);
	}
	//click cancel button
	public ComunicationsEditPage clickSaveButton()
	{
		readconfig();
		driver.findElement(By.name(library.getProperty("comm_edit_save"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_edit_page_title")));
		return new ComunicationsEditPage(driver);
	}
	//remove entries in brand field
	public ComunicationsEditPage deleteEntryInBrandField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("comm_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("comm_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		return new ComunicationsEditPage(driver);
	}
	//remove entries in track field
	public ComunicationsEditPage deleteEntryInTrackField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("comm_edit_tracks_number"))).size();
		System.out.println("**tracks: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("comm_edit_tracks"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_edit_tracks"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_edit_tracks"))).sendKeys(Keys.BACK_SPACE);
			
		}
		return new ComunicationsEditPage(driver);
	}
	//remove entries in program field
	public ComunicationsEditPage deleteEntryInProgramField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("comm_edit_program_number"))).size();
		System.out.println("**tracks: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("comm_edit_program"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_edit_program"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("comm_edit_program"))).sendKeys(Keys.BACK_SPACE);

		}
		return new ComunicationsEditPage(driver);
	}
	//remove entries in segment groups field
	public ComunicationsEditPage deleteEntryInSegmentgroupsField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(library.getProperty("comm_edit_segment_groups_number"))).size();
		System.out.println("**segment groups: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(library.getProperty("comm_edit_segment_groups_number"))).sendKeys(Keys.BACK_SPACE);
		}
		if(driver.findElement(By.xpath("html/body/div[9]/div/div/div[1]")).isDisplayed())
		{
			driver.findElement(By.xpath("html/body/div[9]/div/div/div[3]/button[2]")).click();
		}
		else{
			sleep();
		}
		return new ComunicationsEditPage(driver);
	}
	//verify that the communications is created 
	public CommunicationsPage isCommunicationSuccessfullyCreated(String communicationname)
	{
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(communicationname);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_name"))).getText().equalsIgnoreCase(communicationname));
		//return communications page
		return new CommunicationsPage(driver);
	}	
	//communication is not created when required fields are not filled
	public CommunicationsAddPage failTocreateCommunication(String communicationnname)
	{	
		readconfig();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("comm_add_page_title")));
		return new CommunicationsAddPage(driver);
	}
	public CommunicationsAddPage deleteprimarymessage() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(".//*[@id='messageListItem_2_148']/div[2]/div/div/div/a[3]/i")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(),'Yes')]")).click();
		
		return new CommunicationsAddPage(driver);
	}
	public CommunicationsAddPage clientesingtointernaltesting() 
	{
		readconfig();
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[16]/div/a[1]/i")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='communication-datatable']/thead/tr/th[1]/input")).click();
		driver.findElement(By.xpath(".//*[@id='communication-datatable']/thead/tr/th[1]/input")).click();
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(".//*[@id='publish-button']")).click();
		
		return new CommunicationsAddPage(driver);
	}
	public ComunicationsEditPage updateworkflow(String value) 
	{
		readconfig();
	//	driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[16]/div/div/a[4]/i")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select se = new Select(driver.findElement(By.xpath(".//*[@id='Communication_140_NewWorkflowID']")));
		se.selectByValue(value);
		// TODO Auto-generated method stub
		return new ComunicationsEditPage (driver);
	}
	public ComunicationsEditPage editlocales(String locale1, String locale2) {
		// TODO Auto-generated method stub
		readconfig();
		try{
		Thread.sleep(6000);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='s2id_Communication_Messages_2_1718_Locales']/ul"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);


//		driver.findElement(By.xpath(".//*[@id='s2id_Communication_Messages_2_1718_Locales']/ul")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_Communication_Messages_2_1718_Locales']/ul")).sendKeys(locale1);
		driver.findElement(By.xpath("//div[@id='s2id_Communication_Messages_1_1723_Locales']//ul[@class='select2-choices']")).sendKeys(locale2);;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ComunicationsEditPage(driver);
	}
	public ComunicationsEditPage addmessage(String newmessage)
	{		
		readconfig();
		driver.findElement(By.xpath(library.getProperty("click_message_library"))).click();
		//driver.findElement(By.xpath(library.getProperty("comm_add_message"))).clear();
		driver.findElement(By.xpath(library.getProperty("comm_add_message"))).sendKeys(newmessage);
		driver.findElement(By.xpath(library.getProperty("click_+_button"))).sendKeys(Keys.ENTER);
		//assert and verify
		//Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("comm_edit_program"))).isEnabled());
		//return communications edit page
		return new ComunicationsEditPage(driver);
	}
	public  ComunicationsEditPage deleteMessage(String msgname) {
	
		readconfig();
		
		driver.findElement(By.xpath(library.getProperty("click_message_library"))).click();
			driver.findElement(By.xpath(library.getProperty("click_select_messages"))).click();
			//driver.findElement(By.xpath(library.getProperty("clear_msg-filters"))).clear();
		    driver.findElement(By.xpath(library.getProperty("filter_slect_messages"))).sendKeys(msgname);
		    try{
		    	Thread.sleep(1000);
		    }catch(Exception e){
		    		e.printStackTrace();
		    	}
		    
		    driver.findElement(By.xpath(library.getProperty("click_delte_button"))).click();
		    
	return new ComunicationsEditPage(driver);
}
	public ComunicationsEditPage selectRemovemessage() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("remove_select_yes"))).click();
		return new ComunicationsEditPage(driver);
	}
	
	public ComunicationsEditPage clearallMessagesfrom() {
		
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_all_clear"))).click();
		driver.findElement(By.xpath(library.getProperty("comm_all_clear_yes"))).click();
		
		
		return new ComunicationsEditPage(driver);
		// TODO Auto-generated method stub
		
	}
	public ComunicationsEditPage addallmessagestocomm() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("comm_add_allmessages"))).click();
		driver.findElement(By.xpath(library.getProperty("comm_add_allclick_yes"))).click();
		return new ComunicationsEditPage(driver);
	}
	public CommunicationsPage validateUpdates(String comunnicationname,String column,String expectedresult) {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(library.getProperty("filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(comunnicationname);
		
		switch(column)
		{
		case"Description":
		{
			Assert.assertEquals(driver.findElement(By.xpath(library.getProperty("comm_get_description"))).getText(),expectedresult);
			break;
		}
		}
		return new CommunicationsPage(driver);
	}
	
	
	}
