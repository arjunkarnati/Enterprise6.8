package library;

import org.testng.annotations.Test;
import DataBase.DataBaseLibrary;
import Utility.TestBase;

public class Tracks_Testcases extends TestBase{

	//CREATE TRACKS 
	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_track()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.clickAddTrackButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addSeries("opt_in")
		.addTracksName("series_selenium001")
		.addDescription("Test regression series with selenium webdriver")	
		.addCommunication("16054CCLLIVESAMHUNT20160815")
		//.addCommunication("CCLCBA16031-May-Core-Casino")
		//.addCommunication("CCLNON16055BIRTHDAY")
		.clickSubmitButton()
		.validateUpdates("series_selenium001","client","Carnival Corporation & PLC")
		.validateUpdates("series_selenium001","brand","1")
		.validateUpdates("series_selenium001","program","1")
		.validateUpdates("series_selenium001","name","series_selenium001")
		.validateUpdates("series_selenium001","series","1")
		.validateUpdates("series_selenium001","series","1")
		//.validateUpdates("series_selenium001","communication","3")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_track_without_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.clickAddTrackButton()
		.addTracksName("Test_regression_series_selenium2")
		.addDescription("Test regression series with selenium webdriver")	
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_track_without_tracksnname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.clickAddTrackButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addSeries("opt_in")
		.addDescription("Test regression series with selenium webdriver")	
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void create_a_new_track_without_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.clickAddTrackButton()
		.addClientName("Carnival Corporation & PLC")
		.addProgram("VIFP")
		.addSeries("opt_in")
		.addTracksName("series_selenium005")
		.addDescription("Test regression series with selenium webdriver")	
		.clickSubmitButton()
		.validateUpdates("series_selenium005","brand","1")
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void click_cancel_track_button()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.clickAddTrackButton()
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	//@Test(enabled=false)
	public void delete_tracks_from_db()
	{
		DataBaseLibrary.deleteTracks();
	}
	/*@Test(priority=30)
	//@Test(enabled=false)
	public void create_test_track()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickTracksLink()
		.clickAddTrackButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addSeries("opt_in")
		.addTracksName("edit_tracks_test_01")
		.addDescription("automation tracks")	
		.clickSubmitButton()
		.validateUpdates("edit_tracks_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_tracks_test_01","brand","1")
		.validateUpdates("edit_tracks_test_01","program","1")
		.validateUpdates("edit_tracks_test_01","name","edit_tracks_test_01")
		.validateUpdates("edit_tracks_test_01","series","1")
		.validateUpdates("edit_tracks_test_01","series","1")
		.getTitle()
		.logout();
	}
	@Test(priority=30)
	//@Test(enabled=false)
	public void create_publish_track()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickTracksLink()
		.clickAddTrackButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addSeries("opt_in")
		.addTracksName("publish_tracks_test_01")
		.addDescription("Happens all the time hit publish ")	
		.clickSubmitButton()
		.validateUpdates("publish_tracks_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("publish_tracks_test_01","brand","1")
		.validateUpdates("publish_tracks_test_01","program","1")
		.validateUpdates("publish_tracks_test_01","name","publish_tracks_test_01")
		.validateUpdates("publish_tracks_test_01","series","1")
		.validateUpdates("publish_tracks_test_01","series","1")
		.getTitle()
		.logout();
	}*/
}