package library;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.InvalidParameterException;

public class TracksEditPage extends PageBase{

	public TracksEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name
	public TracksEditPage updateClientNameTo(String newclientname)
	{  
		elementLocators();
		if(driver.findElement(By.id(library.getProperty("tracks_edit_client"))).getText().equals(newclientname))
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_submit"))).click();
		}
		else
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_client"))).click();
			driver.findElement(By.id(library.getProperty("tracks_edit_client_search_field"))).sendKeys(newclientname);
			driver.findElement(By.id(library.getProperty("tracks_edit_client_search_field"))).sendKeys(Keys.ENTER);
			//assert
			Assert.assertTrue(driver.findElement(By.id(library.getProperty("tracks_edit_client"))).getText().equalsIgnoreCase(newclientname));	
			if(!driver.findElement(By.id(library.getProperty("tracks_edit_client"))).isDisplayed())
			{
				sleep();
				driver.switchTo().activeElement();
				driver.findElement(By.xpath(library.getProperty("tracks_move_to_active_element"))).click();
			}
			else
			{
				sleep();
			}
			sleep();
		}
		//return series edit page
		return new TracksEditPage(driver);
	}
	//update the brand
	public TracksEditPage updateBrandTo(String newbrandname)
	{	
		elementLocators();
		driver.findElement(By.xpath(library.getProperty("tracks_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(library.getProperty("tracks_edit_brand"))).sendKeys(Keys.ENTER);	
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_edit_brand"))).isEnabled());
		//return series edit page
		return new TracksEditPage(driver);
	}
	//update program
	public TracksEditPage updateProgramTo(String newprogramname)
	{
		elementLocators();
		driver.findElement(By.xpath(library.getProperty("tracks_edit_program"))).sendKeys(newprogramname);
		driver.findElement(By.xpath(library.getProperty("tracks_edit_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("tracks_edit_program"))).isEnabled());
		//return series edit page
		return new TracksEditPage(driver);
	}
	//enter tracks name in name field
	public TracksEditPage updateTracksName(String newtracksname)
	{
		elementLocators();
		driver.findElement(By.id(library.getProperty("tracks_edit_name"))).clear();
		driver.findElement(By.id(library.getProperty("tracks_edit_name"))).sendKeys(newtracksname);
		//return tracks add page
		return new TracksEditPage(driver);
	}
	//update description
	public TracksEditPage updateDescription(String newdescription)
	{
		elementLocators();
		driver.findElement(By.id(library.getProperty("tracks_edit_description"))).clear();
		driver.findElement(By.id(library.getProperty("tracks_edit_description"))).sendKeys(newdescription);
		//return series edit page
		return new TracksEditPage(driver);	
	}
	//update series
	public TracksEditPage updateSeriesTo(String newseriesname)
	{
		elementLocators();
		driver.findElement(By.xpath(library.getProperty("tracks_edit_series"))).sendKeys(newseriesname);
		driver.findElement(By.xpath(library.getProperty("tracks_edit_series"))).sendKeys(Keys.ENTER);
		return new TracksEditPage(driver);
	}
	//activate and inactivate
	public TracksEditPage isActive(boolean answer)
	{
		elementLocators();
		if(answer==false)
		{
			driver.findElement(By.xpath(library.getProperty("series_status_inactive"))).click();
		}			
		else if(answer==true)
		{
			driver.findElement(By.xpath(library.getProperty("tracks_status_active"))).click();
		}
		else
		{
			throw new InvalidParameterException
			("answer "+answer +" is not supported, ref automation doc track page.");
		}
		return new TracksEditPage(driver);
	}
	//update code
	public TracksEditPage updateCampaignCode(String code)
	{
		elementLocators();
		driver.findElement(By.id(library.getProperty("tracks_edit_code"))).clear();
		driver.findElement(By.id(library.getProperty("tracks_edit_code"))).sendKeys(code);
		//assert and verify
		String i= driver.findElement(By.id("Campaign_Code")).getText();
		Assert.assertEquals(i, code);
		return new TracksEditPage(driver);
	}
	//set workflow to
	public TracksPage setWorkFlowTo(String workflowname, String tracksname)
	{
		elementLocators();
		testconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_workflow"))).sendKeys("D");
			driver.findElement(By.id(library.getProperty("tracks_edit_submit"))).click();
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_workflow"))).sendKeys("A");
			driver.findElement(By.id(library.getProperty("tracks_edit_submit"))).click();
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_workflow"))).sendKeys("Q");
			driver.findElement(By.id(library.getProperty("tracks_edit_submit"))).click();
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new TracksPage(driver);
	}
	//validate workflow update
	public TracksEditPage validateWorkflowUpdate(String workflowname, String tracksname)
	{
		elementLocators();
		testconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(tracksname);
			String actual=workflowname;
			Assert.assertEquals(actual, driver.findElement(By.xpath(library.getProperty("tracks_workflow"))).getText());
			System.out.println("*** workflow is :"+driver.findElement(By.xpath(library.getProperty("tracks_workflow"))).getText());

			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(tracksname);
			String actual=workflowname;
			Assert.assertEquals(actual, driver.findElement(By.xpath(library.getProperty("tracks_workflow"))).getText());
			System.out.println("*** workflow is :"+driver.findElement(By.xpath(library.getProperty("tracks_workflow"))).getText());

			break;		
		}
		case "Qatest1":
		{
			driver.findElement(By.xpath(library.getProperty("filter"))).clear();
			driver.findElement(By.xpath(library.getProperty("filter"))).sendKeys(tracksname);
			String actual=workflowname;
			Assert.assertEquals(actual, driver.findElement(By.xpath(library.getProperty("tracks_workflow"))).getText());
			System.out.println("*** workflow is :"+driver.findElement(By.xpath(library.getProperty("tracks_workflow"))).getText());

			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new TracksEditPage(driver);
	}
	//select submit button 
	public TracksPage Submit()
	{
		elementLocators();
		driver.findElement(By.id(library.getProperty("tracks_edit_submit"))).click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("tracks_page_title")));
		return new TracksPage(driver);
	}
	//select cancel button 
	public TracksPage Cancel()
	{
		elementLocators();
		driver.findElement(By.xpath(library.getProperty("tracks_edit_cancel"))).click();
		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(library.getProperty("tracks_page_title")));
		return new TracksPage(driver);
	}
	//delete fields
	public TracksEditPage deleteField(String field)
	{
		elementLocators();
		switch (field)
		{
		case "client":
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_client"))).click();
			driver.findElement(By.id(library.getProperty("tracks_edit_client_search_field"))).sendKeys("Select a Client");
			driver.findElement(By.id(library.getProperty("tracks_edit_client_search_field"))).sendKeys(Keys.ENTER);
			break;
		}
		case "brand":
		{
			driver.findElement(By.xpath(library.getProperty("tracks_edit_brand"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("tracks_edit_brand"))).sendKeys(Keys.BACK_SPACE);
			break;
		}
		case "program":
		{
			driver.findElement(By.xpath(library.getProperty("tracks_edit_program"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("tracks_edit_program"))).sendKeys(Keys.BACK_SPACE);
			break;
		}
		case "series":
		{
			driver.findElement(By.xpath(library.getProperty("tracks_edit_series"))).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(library.getProperty("tracks_edit_series"))).sendKeys(Keys.BACK_SPACE);
			break;
		}
		case "name":
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_name"))).clear();
			break;
		}
		case "code":
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_code"))).clear();
			break;
		}
		case "description":
		{
			driver.findElement(By.id(library.getProperty("tracks_edit_description"))).clear();
			break;
		}
		default: 
		{
			throw new InvalidParameterException
			("field "+field +" does not exist, ref automation doc users page.");
		}
		}
		return new TracksEditPage(driver);
	}
	//empty client field
	public TracksEditPage emptyField(String fieldname)
	{	
		elementLocators();
		switch (fieldname)
		{
		case "brand":
		{
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("tracks_edit_brand_number"))).size();
			System.out.println("**brand(s): "+iCount);
			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.xpath(library.getProperty("tracks_edit_brand"))).sendKeys(Keys.BACK_SPACE);
			}
			break;
		}
		case "program":
		{				
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("tracks_edit_program_number"))).size();
			System.out.println("**program(s): "+iCount);
			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.xpath(library.getProperty("tracks_edit_program"))).sendKeys(Keys.BACK_SPACE);
			}
			break;
		}
		case "series":
		{				
			//counting the number of entry in the field
			int iCount = driver.findElements(By.xpath(library.getProperty("tracks_edit_series_number"))).size();
			System.out.println("**series: "+iCount);
			for (int i=0; i<iCount;i++)
			{
				driver.findElement(By.xpath(library.getProperty("tracks_edit_series"))).sendKeys(Keys.BACK_SPACE);
			}
			//assert and verify	
			break;
		}
		default: 
		{
			throw new InvalidParameterException
			("fieldname "+fieldname +" does not exist, ref automation doc users page.");
		}
		}
		return new TracksEditPage(driver);
	}
	//click save for failed
	public TracksEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("series_edit_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),library.getProperty("series_edit_page_title"));
		return new TracksEditPage(driver);
	}
























	//COMMUNICATION IN TRACK
	//click selected communication
	public TracksEditPage clickSelectedCommunications()
	{
		elementLocators();
		driver.findElement(By.id(library.getProperty("tracks_edit_selected_communications"))).click();
		//retrun series edit page
		return new TracksEditPage(driver);
	}
	//click communication library
	public TracksEditPage clickCommunicationsLibrary()
	{ 
		elementLocators();
		driver.findElement(By.linkText(library.getProperty("tracks_edit_cummunication_library"))).click();
		//retrun series edit page
		return new TracksEditPage(driver);
	}
	//add a communication in track
	public TracksEditPage addCommunicationInTrack(String communicationname)
	{
		elementLocators();
		driver.findElement(By.xpath(library.getProperty("tracks_edit_clear_comm_filter"))).clear();
		driver.findElement(By.xpath(library.getProperty("tracks_edit_clear_comm_filter"))).sendKeys(communicationname);
		switch(communicationname)
		{
		case "test_carnival_communication_02" :
		{
			driver.findElement(By.id("addItem_78")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_78_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "Booked Guest CE" :
		{
			driver.findElement(By.id("addItem_73")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_73_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "Email A1.1" :
		{
			driver.findElement(By.id("addItem_57")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_57_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "CBA16030-MARCH-CORE-CASINO" :
		{
			driver.findElement(By.id("addItem_67")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_67_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "CPC16003-Feb-CPC" :
		{
			driver.findElement(By.id("addItem_63")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_63_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "Email I1.1" :
		{
			driver.findElement(By.id("addItem_1")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_1_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "Email I2.1" :
		{
			driver.findElement(By.id("addItem_3")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("selectedItemsListItem_3")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "Email I2.2" :
		{
			driver.findElement(By.id("addItem_4")).click();
			///assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_4_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "Email I2.3" :
		{
			driver.findElement(By.id("addItem_5")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_5_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		case "Email I3.1" :
		{
			driver.findElement(By.id("addItem_6")).click();
			//assert and verify
			driver.findElement(By.id("libraryTab_selected")).click();
			sleep();
			//Assert.assertTrue(driver.findElement(By.id("TrackCommunication_6_IsIncluded")).isDisplayed());
			driver.findElement(By.id("libraryTab_library")).click();
			sleep();
			break;
		}
		default : 
		{
			throw new InvalidParameterException
			("communication "+communicationname +" cannot be added, ref automation doc communications page.");
		}
		}
		return new TracksEditPage(driver);
	}
	//	//PRIORITIZATION
	//	/* INCLUDE COMMUNICATION IN TRACK*/
	//	//select checkbox
	//	public TracksEditPage checkCommunication(String communicationname)
	//	{
	//		elementLocators();
	//		switch(communicationname)
	//		{
	//		case "test_carnival_communication_02" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_78_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_78_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "Email A1.1" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_57_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_57_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "Booked Guest CE" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_73_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_73_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "CBA16030-MARCH-CORE-CASINO" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_67_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_67_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "CPC16003-Feb-CPC" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_63_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_63_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "Email I1.1" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_1_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_1_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "Email I2.1" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_3_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_3_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "Email I2.2" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_4_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_4_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "Email I2.3" :  
	//		{
	//			driver.findElement(By.id("TrackCommunication_5_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_5_IsIncluded")).isSelected());
	//			break;
	//		}
	//		case "Email I3.1" :  
	//
	//		{
	//			driver.findElement(By.id("TrackCommunication_6_IsIncluded")).click();
	//			sleep();
	//			//assert and verify
	//			Assert.assertTrue(driver.findElement(By.id("TrackCommunication_6_IsIncluded")).isSelected());
	//			break;
	//		}
	//		default : 
	//		{
	//			throw new InvalidParameterException
	//			("communication "+communicationname +" cannot be checked, ref automation doc communications page.");
	//		}
	//		}
	//		return new TracksEditPage(driver);
	//	}
	//	/* EXCLUDE COMMUNICATION IN TRACK*/ 
	//	//deselect checkbox
	//	public TracksEditPage uncheckCommunication(String communicationname)
	//	{
	//		elementLocators();
	//		switch (communicationname)
	//		{
	//		case "Email A1.1":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_57_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_57_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_57_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "test_carnival_communication_02":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_78_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_78_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException	(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_78_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "Booked Guest CE":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_73_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_73_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_73_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "CBA16030-MARCH-CORE-CASINO":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_67_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_67_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_67_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "CPC16003-Feb-CPC":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_63_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_63_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_63_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "Email I1.1":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_1_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_1_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_1_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "Email I2.1":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_3_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_3_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_3_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "Email I2.2":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_4_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_4_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_4_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "Email I2.3":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_5_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_5_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_5_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		case "Email I3.1":
	//		{
	//			String chk = driver.findElement(By.id("TrackCommunication_6_IsIncluded")).getAttribute("checked");
	//			if (chk.equalsIgnoreCase("true"))
	//			{		
	//				driver.findElement(By.id("TrackCommunication_6_IsIncluded")).click();
	//				sleep();
	//			}
	//			else
	//			{	 
	//				throw new InvalidParameterException(communicationname+ " is already unchecked");
	//			}
	//			//assert and verify
	//			Assert.assertFalse(false, driver.findElement(By.id("TrackCommunication_6_IsIncluded"))
	//					.getAttribute("checked"));
	//			break;
	//		}
	//		default : 
	//		{
	//			throw new InvalidParameterException
	//			("communication "+communicationname +" cannot be unchecked, ref automation doc communications page.");
	//		}
	//		}
	//		return new TracksEditPage(driver);
	//	}
	//	// REMOVE COMMUNICATION  
	//	//remove a selected communication return it to communication library tab
	//	public TracksEditPage removeCommunication(String communicationname)
	//	{
	//		elementLocators();
	//		switch(communicationname)
	//		{
	//		case "test_carnival_communication_02" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_78']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_78")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "Email A1.1" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_57']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_57")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "Booked Guest CE" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_73']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_73")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "CBA16030-MARCH-CORE-CASINO" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_67']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_67")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "CPC16003-Feb-CPC" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_68']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_63")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "Email I1.1" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_1']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_1")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "Email I2.1" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_3']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_3")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "Email I2.2" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_4']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_4")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "Email I2.3" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_5']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_5")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		case "Email I3.1" :
	//		{
	//			driver.findElement(By.xpath(".//*[@id='selectedItemsListItem_6']/div[2]/div/div/div/a[2]")).click();
	//			sleep();
	//			//driver.switchTo().activeElement();
	//			// find the button which contains text "yes" 
	//			driver.findElement(By.xpath("html/body/div[7]/div/div/div[3]/button[2]")).click();
	//			sleep();
	//			//driver.navigate().refresh();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).clear();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(communicationname);
	//			sleep();
	//			Assert.assertTrue(driver.findElement(By.id("addItem_6")).isDisplayed());
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//			break;
	//		}
	//		default : 
	//		{
	//			throw new InvalidParameterException
	//			("communication "+communicationname +" cannot be removed, ref automation doc communications page.");
	//		}
	//		}
	//		return new TracksEditPage(driver);
	//	}
	//	//DRAG AND DROP COMMUNICATION IN TRACK
	//	//change the priority of communications in selected communications tab
	//	public TracksEditPage dragAndDrop(int priority)
	//	{
	//		elementLocators();
	//		if (priority==1)
	//		{
	//			WebElement source = driver.findElement(By.xpath("//li[@id='selectedItemsListItem_57']/div")); 
	//			WebElement target = driver.findElement(By.xpath("//li[@id='selectedItemsListItem_78']/div"));
	//			(new Actions(driver)).dragAndDrop(source, target).perform();
	//			sleep();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//		}
	//		else if (priority==2)
	//		{
	//			WebElement target = driver.findElement(By.xpath("//li[@id='selectedItemsListItem_78']/div"));
	//			WebElement source = driver.findElement(By.xpath("//li[@id='selectedItemsListItem_3']/div")); 
	//			(new Actions(driver)).dragAndDrop(source, target).perform();
	//			sleep();
	//			//assert and verify
	//			driver.findElement(By.id("libraryTab_library")).click();
	//			sleep();
	//			driver.findElement(By.id("libraryTab_selected")).click();
	//			sleep();
	//		}
	//		else
	//		{
	//			throw new InvalidParameterException("priority-" +priority +" is not yet supported ref automation doc communications page.");
	//		}	
	//		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Tracks - Edit"));
	//		return new TracksEditPage(driver);
	//	}

}