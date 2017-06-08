package manage;

import org.testng.annotations.Test;

import Utility.TestBase;

public class BrandsRestore_testcases extends TestBase{
	
	@Test(priority=0)
	public void validate_brands_archive_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.getTitle()
		.logout();
	}

}
