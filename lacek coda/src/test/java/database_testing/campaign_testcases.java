package database_testing;

import org.testng.annotations.Test;

import Utility.TestBase;

public class campaign_testcases extends TestBase {

	@Test
	public void ui_vs_database_campaign()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.selectClient("Carnival Corporation & PLC")
		.clickCampaignsLink();
		dbhelp.validateCampaignCount("Carnival Corporation & PLC");
	}
	
}
