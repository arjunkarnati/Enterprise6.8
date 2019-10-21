package localization;

import Utility.TestBase;
import org.testng.annotations.Test;

public class Import_TestCases extends TestBase {
	
	@Test(priority=16,enabled=true)
	public void message_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesImport()
		.getTitle()
		.logout();
	}
}
