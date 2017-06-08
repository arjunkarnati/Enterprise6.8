package access;

import org.testng.annotations.Test;

import Utility.TestBase;

public class UsersRestore_testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void verify_user_archive_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.clickArchiveButton()
		.getTitle()
		.logout();

	}
}
