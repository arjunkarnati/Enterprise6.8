package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class VariablesRestore_Testcases extends TestBase{
	
	@Test(priority=0)
	public void validate_region_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.getTitle()
		.logout();		
	}
	

}
