package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class SeriesPublish_Testcases extends TestBase{

	@Test(priority=1)
	public void publish_series()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.publishSeries("publish_series_test_01")
		.checkAll()
		.clickPublishButton()   
	    .getTitle()
	    .logout();
	}
	@Test(priority=2)
	public void cancel_publish_series()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.publishSeries("publish_series_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}


}
