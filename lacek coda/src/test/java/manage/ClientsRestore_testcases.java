package manage;

import org.testng.annotations.Test;

import Utility.TestBase;

public class ClientsRestore_testcases extends TestBase{
		
	@Test(priority=0)
	public void validate_client_archive_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.getTitle()
		.logout();
	}
	
}
