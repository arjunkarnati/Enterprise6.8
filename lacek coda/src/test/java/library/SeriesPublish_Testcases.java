package library;

import Utility.TestBase;
import org.testng.annotations.Test;

public class SeriesPublish_Testcases extends TestBase{

	@Test(priority=1)
	public void publish_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.publishSeries("publish_series_test_01")
		.checkAll()
	    //.deletelocales()
		//.addlocale("en-us")
		.clickPublishButton()   
	    .getTitle()
	    .logout();
	}
	@Test(priority=2)
	public void cancel_publish_series()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSertiesLink()
		.publishSeries("publish_series_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();
	}


}
