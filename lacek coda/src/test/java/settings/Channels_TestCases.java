package settings;

import org.testng.annotations.Test;

import Utility.TestBase;

public class Channels_TestCases extends TestBase{
	
	@Test(priority=0)
	public void test_is_empty()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickChannels()
		.getTitle()
		.logout();
	}

}
