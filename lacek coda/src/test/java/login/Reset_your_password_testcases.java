package login;

import org.testng.annotations.Test;

import Utility.TestBase;

public class Reset_your_password_testcases extends TestBase {

	@Test(priority=0)
     public void reset_your_password_with_valid_email()
     {
	   login.clickResetYourPassword()
	   .enterEmailAddress("arjun.karnati@lacek.com")
	   .getTitle();
     }
	@Test(priority=1)
    public void reset_your_password_with_an_invalid_email()
    {
	   login.clickResetYourPassword()
	   .enterEmailAddress("testtesttest@test.test")
	   .failToResetPassword()
	   .getTitle();
    }
	
		
}
