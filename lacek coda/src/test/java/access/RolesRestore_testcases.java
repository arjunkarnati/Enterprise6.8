package access;

import org.testng.annotations.Test;

import Utility.TestBase;

public class RolesRestore_testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void verify_roles_archive_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickArchiveButton()
		.getTitle()
		.logout();
	}
}
