package access;

import org.testng.annotations.Test;

import Utility.TestBase;

public class PermissionGroupsRestore_testcases extends TestBase{

	
	@Test(priority=0,enabled=true)
	public void verify_permission_archive_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.getTitle()
		.logout();

	}
}
