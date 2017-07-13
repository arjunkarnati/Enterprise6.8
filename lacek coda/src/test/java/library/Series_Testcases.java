package library;

import org.testng.annotations.Test;

import DataBase.DataBaseLibrary;
import Utility.TestBase;

public class Series_Testcases extends TestBase{


	//CREATE SERIES 
	/*create series test cases with workflow set to approved*/
	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_serie()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.clickAddSeriesButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addCampaign("publish_campaign_test_01")
		.addSeriesName("series_selenium001")	
		.addDescription("series_selenium001")	
		.addTracks("TrackI5")
		.clickSubmitButton()
		.validateUpdates("series_selenium001","client","Carnival Corporation & PLC")
		.validateUpdates("series_selenium001","brand","cunard")
		.validateUpdates("series_selenium001","program","vifp")
		.validateUpdates("series_selenium001","track","1")
		.validateUpdates("series_selenium001","campaign","1")
		.validateUpdates("series_selenium001","status","ACTIVE")
		.validateUpdates("series_selenium001","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_serie_without_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.clickAddSeriesButton()
		//.addClientName("Carnival Corporation & PLC")//empty		
		.addSeriesName("Test_regression_series_selenium2")	
		.addDescription("Test regression series with selenium webdriver")		
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_series_without_seriesnname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.clickAddSeriesButton()
		.addClientName("Carnival Corporation & PLC")	
		//.addSeriesName("Test_regression_series_selenium2")	
		.addDescription("Test regression series with selenium webdriver")		
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void create_a_new_series_without_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.clickAddSeriesButton()
		.addClientName("Carnival Corporation & PLC")
		.addProgram("VIFP")
		.addCampaign("publish_campaign_test_01")			
		.addSeriesName("Test_regression_series_selenium30")	
		.addDescription("Test regression series with selenium webdriver")		
		.clickSubmitButton()
		.validateUpdates("Test_regression_series_selenium30","brand","")
		.getTitle()
		.logout();	
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void click_cancel_series_button()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.clickAddSeriesButton()
		.clickCancelButton()
		.getTitle()
		.logout();	
	}
    @Test(priority=11)
	//@Test(enabled=false)
	public void delete_series_from_db()
	{
		DataBaseLibrary.deleteSeries();
	}
  /*  @Test(priority=21)
	//@Test(enabled=false)
	public void create_testdata_serie()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickSertiesLink()
		.clickAddSeriesButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addCampaign("publish_campaign_test_01")
		.addSeriesName("edit_series_test_01")	
		.addDescription("edit_series_test_01")	
		.addTracks("TrackI5")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_series_test_01","brand","cunard")
		.validateUpdates("edit_series_test_01","program","vifp")
		.validateUpdates("edit_series_test_01","track","1")
		.validateUpdates("edit_series_test_01","campaign","1")
		.validateUpdates("edit_series_test_01","status","ACTIVE")
		.validateUpdates("edit_series_test_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
    
    @Test(priority=22)
  	//@Test(enabled=false)
  	public void create_publish_serie()
  	{
  		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
  		.clickSertiesLink()
  		.clickAddSeriesButton()
  		.addClientName("Carnival Corporation & PLC")
  		.addBrand("cunard")
  		.addProgram("VIFP")
  		.addCampaign("publish_campaign_test_01")
  		.addSeriesName("publish_series_test_01")	
  		.addDescription("Thankyou for publishing ME !!!")	
  		.addTracks("TrackI5")
  		.clickSubmitButton()
  		.validateUpdates("publish_series_test_01","client","Carnival Corporation & PLC")
  		.validateUpdates("publish_series_test_01","brand","cunard")
  		.validateUpdates("publish_series_test_01","program","vifp")
  		.validateUpdates("publish_series_test_01","track","1")
  		.validateUpdates("publish_series_test_01","campaign","1")
  		.validateUpdates("publish_series_test_01","status","ACTIVE")
  		.validateUpdates("publish_series_test_01","workflow","DRAFT")
  		.getTitle()
  		.logout();	
  	}*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}