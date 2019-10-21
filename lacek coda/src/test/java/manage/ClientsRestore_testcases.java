package manage;

import Utility.TestBase;
import org.testng.annotations.Test;

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
