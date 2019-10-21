package configuration;

import Utility.TestBase;
import org.testng.annotations.Test;

public class MessageTypes_TestCases extends TestBase{
	
	@Test(priority=0)
	//@Test(enabled=false)
	public void message_type_test_scripts_will_be_added_in_maintenace()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesType()
		.getTitle()
		.logout();
    }
}
