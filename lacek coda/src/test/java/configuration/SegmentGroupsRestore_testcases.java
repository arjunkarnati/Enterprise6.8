package configuration;

import org.testng.annotations.Test;

import Utility.TestBase;

public class SegmentGroupsRestore_testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void open_archive_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.clickArchiveButton()
		.getTitle()
		.logout();

	}
}
