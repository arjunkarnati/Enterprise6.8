package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class TracksPublish_Testcases extends TestBase{

	@Test(priority=0)
	public void publish_tracks() 
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.publishTracks("publish_tracks_test_01")
		.checkAll()
		.clickPublishButton()
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	public void cancel_publish_tracks()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.publishTracks("publish_tracks_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();	
	}

}
