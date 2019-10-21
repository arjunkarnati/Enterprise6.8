package library;

import Utility.TestBase;
import org.testng.annotations.Test;

public class TracksEdit_Testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void update_track_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.editTracks("edit_tracks_test_01")
		.updateTracksName("edit_tracks_test_010")
		.Submit()
		.validateUpdates("edit_tracks_test_010","name","edit_tracks_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void update_track_name_to_previous_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.editTracks("edit_tracks_test_010")
		.updateTracksName("edit_tracks_test_01")
		.Submit()
		.validateUpdates("edit_tracks_test_01","name","edit_tracks_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void update_track_client_field()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		//.updateClientNameTo("Carnival Corporation & PLC")			
		.Submit()
		.validateUpdates("edit_tracks_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();
	}
	/*@Test(priority=3)
	//@Test(enabled=false)
	public void update_track_clientname_to_previous_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()		
		.editTracks("edit_tracks_test_01")
		.updateClientNameTo("Carnival Corporation & PLC")		
		.updateBrandTo("costa cruises")
		.updateBrandTo("cunard")
		.updateProgramTo("VIFP")
		.updateSeriesTo("Opt_in")
		.updateSeriesTo("Travel Agent")
		.Submit()
		.validateUpdates("edit_tracks_test_01","client","Carnival Corporation & PLC")
		.getTitle()
		.logout();
	}*/
	@Test(priority=4)
	//@Test(enabled=false)
	public void update_track_brands()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.emptyField("brand")
		.updateBrandTo("Costa Cruises")
		.Submit()
		.validateUpdates("edit_tracks_test_01","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void update_track_brands_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.emptyField("brand")
		.updateBrandTo("Costa Cruises")
		.updateBrandTo("Cunard")
		.Submit()
		.validateUpdates("edit_tracks_test_01","brand","2")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void update_track_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.emptyField("series")
		.updateSeriesTo("Agent_DIM")
		.Submit()
		.validateUpdates("edit_tracks_test_01","series","1")
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	//@Test(enabled=false)
	public void update_track_series_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.emptyField("series")
		.updateSeriesTo("Agent_DIM")
		.updateSeriesTo("Opt_in")
		.Submit()
		.validateUpdates("edit_tracks_test_01","series","2")
		.getTitle()
		.logout();
	}
	@Test(priority=8)
	//@Test(enabled=false)
	public void update_tracks_programs()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.emptyField("program")
		.updateProgramTo("VIFP")
		.Submit()
		.validateUpdates("edit_tracks_test_01","program","1")
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	//@Test(enabled=false)
	public void update_tracks_programs_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.emptyField("program")
		.updateProgramTo("VIFP")
		.updateProgramTo("smm1")
		.Submit()
		.validateUpdates("edit_tracks_test_01","program","2")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	//@Test(enabled=false)
	public void update_track_workflow_to_approved()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.setWorkFlowTo("APPROVED","edit_tracks_test_01")	
		.validateUpdates("edit_tracks_test_01","workflow","APPROVED")
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	//@Test(enabled=false)
	public void update_track_workflow_to_draft()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()		
		.editTracks("edit_tracks_test_01")
		.setWorkFlowTo("DRAFT","edit_tracks_test_01")	
		.validateUpdates("edit_tracks_test_01","workflow","DRAFT")		
		.getTitle()
		.logout();
	}
	//@Test(priority=12)
	//@Test(enabled=false)
	public void inactivate_track()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()		
		.editTracks("edit_tracks_test_01")
		.isActive(false)
		.Submit()
		.validateUpdates("edit_tracks_test_01","status","INACTIVE")	
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	//@Test(enabled=false)
	public void activate_track()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.editTracks("edit_tracks_test_01")
		.isActive(true)
		.Submit()
		.validateUpdates("edit_tracks_test_01","status","ACTIVE")	
		.getTitle()
		.logout();
	}
	@Test(priority=14)
	//@Test(enabled=false)
	public void archive_track()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()			
		.archiveTracks("edit_tracks_test_01")
		.getTitle()
		.logout();
	}	
	@Test(priority=15)
	//@Test(enabled=false)
	public void restore_track()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()		
		.restoreTracks("edit_tracks_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=16)
	//@Test(enabled=false)
	public void update_track_name_by_EHI_AE()
	{
		login.loginAs("ehi.ae","09ht1a0480123")
		.isSuccessfulLogin("ehi ae")
		.clickTracksLink()
		//.editTracks("edit_ehi_track_01")
		//.updateTracksName("edit_ehi_track_010")
		//.Submit()
		//.validateUpdates("edit_tracks_test_010","name","edit_tracks_test_010")
		.getTitle()
		.logout();
	}
//	//communication prioritization
//	@Test(priority=20)
//	//@Test(enabled=false)
//	public void add_a_communication_in_track()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickTracksLink()
//		.editTracks("test_carnival_track_03")
//		.clickCommunicationsLibrary()
//		.addCommunicationInTrack("CBA16030-MARCH-CORE-CASINO")
//		.Submit()
//		.getTitle()
//		.logout();	
//	}
//	@Test(priority=21)
//	//@Test(enabled=false)
//	public void remove_a_communication_from_track()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickTracksLink()
//		.editTracks("test_carnival_track_03")
//		.clickSelectedCommunications()
//		.removeCommunication("CBA16030-MARCH-CORE-CASINO")
//		.Submit()
//		.getTitle()
//		.logout();		
//	}
//	@Test(priority=22)
//	//@Test(enabled=false)
//	public void check_a_communication_to_include_it_in_the_track()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickTracksLink()
//		.editTracks("test_carnival_track_03")
//		.clickCommunicationsLibrary()
//		.addCommunicationInTrack("Email I2.2")
//		.clickSelectedCommunications()
//		.checkCommunication("Email I2.2")
//		.Submit()
//		.getTitle()
//		.logout();		
//	}
//	@Test(priority=23)
//	//@Test(enabled=false)
//	public void uncheck_a_communication_to_exclude_it_from_the_track()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickTracksLink()
//		.editTracks("test_carnival_track_03")
//		.clickSelectedCommunications()
//		.uncheckCommunication("Email I2.2")
//		.Submit()
//		.getTitle()
//		.logout();		
//	}
//	@Test(priority=24)
//	//@Test(enabled=false)
//	public void change_the_communication_priority_in_the_track()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickTracksLink()
//		.editTracks("test_carnival_track_03")
//		.clickSelectedCommunications()
//		.dragAndDrop(1)
//		.dragAndDrop(2)
//		.Submit()
//		.getTitle()
//		.logout();		
//	}
//	@Test(priority=25)
//	//@Test(enabled=false)
//	public void select_cancel_button()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickTracksLink()
//		.editTracks("test_carnival_track_03")
//		.Cancel()
//		.getTitle()
//		.logout();			
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}