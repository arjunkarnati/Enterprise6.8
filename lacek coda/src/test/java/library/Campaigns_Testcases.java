package library;

import org.testng.annotations.Test;
import DataBase.DataBaseLibrary;
import Utility.TestBase;

public class Campaigns_Testcases extends TestBase{

	
	//CREATE CAMPAIGN 
	@Test(priority=0,enabled=true)
	public void create_a_new_campaign()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addClient("Carnival Corporation & PLC")
		.addBrand("cunard")
         .addBrand("Costa Cruises")
		.addProgram("VIFP")
		.addCampaignName("selenium_campaign_regression_01")
		.addDescription("selenioum testing")
		.addSeries("Opt_in")
		.clickSubmitCampaign()
		.validateUpdates("selenium_campaign_regression_01","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_campaign_regression_01","brand","2")
		.validateUpdates("selenium_campaign_regression_01","program","1")
		.validateUpdates("selenium_campaign_regression_01","name","selenium_campaign_regression_01")
		.validateUpdates("selenium_campaign_regression_01","series","1")
		.validateUpdates("selenium_campaign_regression_01","status","ACTIVE")
		.validateUpdates("selenium_campaign_regression_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	
	@Test(priority=1,enabled=true)
	public void create_a_new_campaign_without_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addCampaignName("selenium_campaign_regression_02")
		.addDescription("regression test with java and selenium2")
		.failToCreate()
		.getTitle()
		.logout();	
	}
	
	@Test(priority=2,enabled=true)
	public void create_a_new_campaign_without_campaignname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addClient("Carnival Corporation & PLC")
		.addBrand("costa cruises")
		.addProgram("VIFP")
		.addDescription("regression test with selenium")
		.addSeries("Opt_in")
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=3,enabled=true,dependsOnMethods={"create_a_new_campaign"})
	public void create_a_new_campaign_without_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addClient("Carnival Corporation & PLC")
		.addProgram("VIFP")
		.addBrand("costa cruises")//5.9
		.addBrand("cunard")//added 5.9
		.addCampaignName("selenium_campaign_regression_04")
		.addDescription("testing using selenium create campaign with no brand")
		.addSeries("Opt_in")
		.clickSubmitCampaign()
		.validateUpdates("selenium_campaign_regression_04","brand","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=4,enabled=true,dependsOnMethods={"create_a_new_campaign_without_brand"})
	public void create_a_new_campaign_without_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addClient("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addCampaignName("selenium_campaign_regression_05")
		.addDescription("testing using selenium create campaign with no brand")
		.addSeries("Opt_in")
		.clickSubmitCampaign()
		.validateUpdates("selenium_campaign_regression_05","program","1")//updated 0 to 1 on 5.9
		.getTitle()
		.logout();	
	}
	@Test(priority=5,enabled=true)
	public void create_a_new_campaign_without_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addClient("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addCampaignName("selenium_campaign_regression_06")
		.addDescription("testing using selenium create campaign with no brand")
		.clickSubmitCampaign()
		.validateUpdates("selenium_campaign_regression_06","series","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=6,enabled=true)
	public void click_cancel_button_in_campaign_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.clickCancelCampaign()
		.getTitle()
		.logout();	
	}
	@Test(priority=7,enabled=true)
	public void delete_campaign_from_db()
	{
		DataBaseLibrary.deleteCampaign();
	}
	/*@Test(priority=30,enabled=true)
	public void create_test_campaign()  
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addClient("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addProgram("VIFP")
		.addSeries("Opt_in")
		.addCampaignName("edit_campaign_test_01")
		.addDescription("camp edit testing")
		.clickSubmitCampaign()
		.validateUpdates("edit_campaign_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_campaign_test_01","brand","1")
		.validateUpdates("edit_campaign_test_01","program","1")
		.validateUpdates("edit_campaign_test_01","name","edit_campaign_test_01")
		.validateUpdates("edit_campaign_test_01","series","1")
		.validateUpdates("edit_campaign_test_01","status","ACTIVE")
		.validateUpdates("edit_campaign_test_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	@Test(priority=31,enabled=true)
	public void create_publish_campaign()  
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickCampaignsLink()
		.clickAddCampaignButton()
		.addClient("Carnival Corporation & PLC")
		.addBrand("Costa Cruises")
		.addProgram("VIFP")
		.addSeries("Opt_in")
		.addCampaignName("publish_campaign_test_01")
		.addDescription("camp publish testing")
		.clickSubmitCampaign()
		.validateUpdates("publish_campaign_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("publish_campaign_test_01","brand","1")
		.validateUpdates("publish_campaign_test_01","program","1")
		.validateUpdates("publish_campaign_test_01","name","publish_campaign_test_01")
		.validateUpdates("publish_campaign_test_01","series","1")
		.validateUpdates("publish_campaign_test_01","status","ACTIVE")
		.validateUpdates("publish_campaign_test_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}*/
	
}