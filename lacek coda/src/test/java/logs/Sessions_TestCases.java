package logs;

import Utility.TestBase;
import org.testng.annotations.Test;

public class Sessions_TestCases extends TestBase{
	
	@Test(priority=0)
	public void test_is_empty_1()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSessions()
		.getTitle()
		.logout();
	}

}
