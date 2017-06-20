package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class CanpaignsEdit_TestCases extends TestBase{

	//EDIT CAMPAIGN 
	@Test(priority=0,enabled=true)
	public void update_campaign_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.updateCampaignName("edit_campaign_test_010")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_010","name","edit_campaign_test_010")
		.getTitle()
		.logout();	
	}	
	@Test(priority=1,enabled=true)
	public void update_campaign_name_to_previous_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_010")
		.updateCampaignName("edit_campaign_test_01")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","name","edit_campaign_test_01")
		.getTitle()
		.logout();	
	}
	@Test(priority=2,enabled=true)
	public void update_campaign_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()	
		.editCampaign("edit_campaign_test_01")
		.updateClientNameTo("DuPont")			
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","client","DuPont")
		.getTitle()
		.logout();	
	}
	@Test(priority=3,enabled=true)
	public void update_campaign_clientname_to_previous_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")
		.updateBrand("Costa Cruises")
		.updateProgram("VIFP")
		.updateSeries("Opt_in")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();	
	}
	@Test(priority=4,enabled=true)
	public void update_campaign_brands()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()		
		.editCampaign("edit_campaign_test_01")
		.deleteEntryInBrandField()
		.updateBrand("Cunard")
		.updateBrand("Costa Cruises")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","brand","2")
		.getTitle()
		.logout();	
	}
	@Test(priority=5,enabled=true)
	public void update_campaign_brands_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()	
		.editCampaign("edit_campaign_test_01")
		.deleteEntryInBrandField()
		.updateBrand("Costa Cruises")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","brand","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=6,enabled=true)
	public void update_campaign_programs()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()	
		.editCampaign("edit_campaign_test_01")
		.deleteEntryInProgramField()
		.updateProgram("smm1")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","program","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=7,enabled=true)
	public void update_campaign_programs_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.deleteEntryInProgramField()
		.updateProgram("VIFP")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","program","1")
		.getTitle()
		.logout();	
	}
	@Test(priority=8,enabled=true)
	public void update_campaign_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.deleteEntryInSeriesField()
		.updateSeries("Welcome Home")
		.updateSeries("Opt_in")
		.updateSeries("Opt-out")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","series","3")
		.getTitle()
		.logout();	
	}	
	@Test(priority=9,enabled=true)
	public void update_campaign_series_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.deleteEntryInSeriesField()
		.updateSeries("Opt_in")
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","series","1")
		.getTitle()
		.logout();	
	}	
	@Test(priority=10,enabled=true)
	public void update_campaign_workflow_to_approved()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")		
		.setWorkFlowTo("APPROVED","coda_camp_regression_01")
		.validateUpdates("edit_campaign_test_01","workflow","APPROVED")
		.getTitle()
		.logout();	
	}
	@Test(priority=11,enabled=true)
	public void update_campaign_workflow_to_draft()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.setWorkFlowTo("DRAFT","coda_camp_regression_01")
		.validateUpdates("edit_campaign_test_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	@Test(priority=12,enabled=true)
	public void inactivate_campaign()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.isActive(false)
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","status","INACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=13,enabled=true)
	public void activate_campaign()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.editCampaign("edit_campaign_test_01")
		.isActive(true)
		.clickSubmit()
		.validateUpdates("edit_campaign_test_01","status","ACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=14,enabled=true)
	public void archive_campaign()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.archiveCampaign("edit_campaign_test_01")
		.getTitle();		
	}
	@Test(priority=15,enabled=true)
	public void restorte_campaign()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.restoreCampaign("edit_campaign_test_01")
		.getTitle();	
	}
	@Test(priority=16,enabled=true)
	public void camp_mass_advance_workflow()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		//.clickMassadvanceworkflow()
		.getTitle()
		.logout();
	}
	
	
	
	
	
	
	
	
	
	
	
}