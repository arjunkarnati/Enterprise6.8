package settings;

import org.testng.annotations.Test;

import Utility.TestBase;

public class ChannelsEdit_testcases extends TestBase{

	@Test(priority=0)
	public void empty_test()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickChannels()
		.getTitle()
		.logout();
	}
}
