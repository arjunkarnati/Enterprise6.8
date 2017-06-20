package configuration;

import org.testng.annotations.Test;

import Utility.TestBase;

public class SegmentsRestore_testcases extends TestBase{


	@Test(priority=0)
	//@Test(enabled=false)
	public void validate_segments_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.clickArchiveButton()
		.getTitle()
		.logout();
	}
}
