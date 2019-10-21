package configuration;

import Utility.TestBase;
import org.testng.annotations.Test;

public class TargetingCriteriaRestore_testcases extends TestBase{

	@Test(priority=0)
	//@Test(enabled=false)
	public void verify_targeting_criteria_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.clickArchiveButton()
		.getTitle()
		.logout();
	}
}
