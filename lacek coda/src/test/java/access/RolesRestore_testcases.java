package access;

import Utility.TestBase;
import org.testng.annotations.Test;

public class RolesRestore_testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void verify_roles_archive_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.clickArchiveButton()
		.getTitle()
		.logout();
	}
}
