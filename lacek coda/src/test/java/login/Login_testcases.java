package login;

import org.testng.annotations.Test;
import Utility.TestBase;

public class Login_testcases extends TestBase{

	//login scenarios with active directory set to no
	@Test(priority=0) 
	public void login_with_valid_username_and_valid_password() 
	{		
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.getTitle()
		.logout();
	}		
	@Test(priority=1)
	public void login_with_empty_password()
	{	
		login.loginAs("automation.admin", "")
		.failLogin("automation.admin", "")
		.getTitle();
	}
	@Test(priority=2)
	public void login_with_empty_username()
	{
		login.loginAs("", "Monday#223")
		.failLogin("", "Monday#223")
		.getTitle();
	}
	@Test(priority=3)
	public void login_with_empty_username_password()
	{
		login.loginAs("", "")
		.failLogin("", "")
		.getTitle();
	}
	@Test(priority=4)
	public void login_with_invalid_password()
	{
		login.loginAs("automation.admin", "invalidpassword")
		.failLogin("automation.admin", "invalidpassword")
		.getTitle();
	}
	@Test(priority=5)
	public void login_with_invalid_username()
	{
		login.loginAs("invalidusername", "Monday#223")
		.failLogin("invalidusername", "Monday#223")
		.getTitle();
	}	
}