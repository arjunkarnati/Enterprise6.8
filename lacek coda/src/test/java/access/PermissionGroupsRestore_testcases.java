package access;

import Utility.TestBase;
import org.testng.annotations.Test;

public class PermissionGroupsRestore_testcases extends TestBase{

	
	@Test(priority=0,enabled=true)
	public void verify_permission_archive_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.getTitle()
		.logout();

	}
}
