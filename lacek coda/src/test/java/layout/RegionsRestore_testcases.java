package layout;

import Utility.TestBase;
import org.testng.annotations.Test;

public class RegionsRestore_testcases extends TestBase{

	@Test(priority=0)
	public void validate_region_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.getTitle()
		.logout();
	}
	
}
