package settings;

import Utility.TestBase;
import org.testng.annotations.Test;

public class ChannelsEdit_testcases extends TestBase{

	@Test(priority=0)
	public void empty_test()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickChannels()
		.getTitle()
		.logout();
	}
}
