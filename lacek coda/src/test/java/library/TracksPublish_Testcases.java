package library;

import Utility.TestBase;
import org.testng.annotations.Test;

public class TracksPublish_Testcases extends TestBase{

	@Test(priority=0)
	public void publish_tracks() 
	{
		login.loginAs("automation.admin","Monday#223")
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
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.publishTracks("publish_tracks_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();	
	}

}
