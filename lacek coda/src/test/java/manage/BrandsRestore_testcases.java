package manage;

import Utility.TestBase;
import org.testng.annotations.Test;

public class BrandsRestore_testcases extends TestBase{
	
	@Test(priority=0)
	public void validate_brands_archive_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.getTitle()
		.logout();
	}

}
