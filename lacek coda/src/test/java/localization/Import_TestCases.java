package localization;

import org.testng.annotations.Test;

import Utility.TestBase;

public class Import_TestCases extends TestBase {
	
	@Test(priority=16,enabled=true)
	public void message_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocalesImport()
		.getTitle()
		.logout();
	}
}
