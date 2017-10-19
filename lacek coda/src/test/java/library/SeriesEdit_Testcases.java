package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class SeriesEdit_Testcases extends TestBase{

	@Test(priority=0)
	public void update_series_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_01")
		.updateSeriesNameTo("edit_series_test_010")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_010","name","edit_series_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_series_name_to_previous_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_010")
		.updateSeriesNameTo("edit_series_test_01")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","name","edit_series_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_series_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()		
		.editSeries("edit_series_test_01")
		//.updateClientNameTo("DuPont")			
		.clickSubmitButton()
		//.validateUpdates("edit_series_test_01","client","DuPont")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_series_clientname_to_previous_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()			
		//.editSeries("edit_series_test_01")
		//.updateClientNameTo("Carnival Corporation & PLC")	
		//.updateBrandTo("Cunard")
		//.updateProgramTo("VIFP")
		//.updateCampaignTo("booked_guest")
		//.updateTrackTo("TrackA1")
		//.clickSubmitButton()
		.validateUpdates("edit_series_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_series_brands()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Fathom")
		.updateBrandTo("Cunard")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","brand","cunard")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_series_brands_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_01")
		.deleteEntryInBrandField()
		.updateBrandTo("Costa Cruises")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","brand","costa cruises")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void update_series_programs()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()		
		.editSeries("edit_series_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","program","vifp")
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	//@Test(enabled=false)
	public void update_series_programs_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()		
		.editSeries("edit_series_test_01")
		.deleteEntryInProgramField()
		.updateProgramTo("VIFP")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","program","vifp")
		.getTitle()
		.logout();
	}
	@Test(priority=8)
	public void update_series_tracks()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()	
		.editSeries("edit_series_test_01")
		.deleteEntryInTrackField()
		.updateTrackTo("TrackI6")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","track","1")
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void update_series_tracks_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()	
		.editSeries("edit_series_test_01")
		.deleteEntryInTrackField()
		.updateTrackTo("TrackI6")
		.updateTrackTo("TrackO1")
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","track","2")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void update_series_workflow_to_approved()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_01")
		.setWorkFlowTo("APPROVED","edit_series_test_01")
		.validateUpdates("edit_series_test_01","workflow","APPROVED")
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void update_series_workflow_to_draft()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_01")
		.setWorkFlowTo("DRAFT","edit_series_test_01")
		.validateUpdates("edit_series_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=12)
	//@Test(enabled=true)
	public void inactivate_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_01")
		.isActive(false)
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	//@Test(enabled=true)
	public void activate_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.editSeries("edit_series_test_01")
		.isActive(true)
		.clickSubmitButton()
		.validateUpdates("edit_series_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=14)
	//@Test(enabled=true)
	public void archive_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.archiveSeries("edit_series_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=15)
	//@Test(enabled=true)
	public void restore_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.retoreSeries("edit_series_test_01")
		.getTitle()
		.logout();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}