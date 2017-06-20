package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class CampaignsPublish_Testcases extends TestBase{

	//PUBLISH CAMPAIGN
	@Test(priority=0)
	public void publish_campaign()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.publishCampaign("publish_campaign_test_01")
		.checkAll()
		.clickPublishButton()
		.getTitle();
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void cancel_publish_campaign()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.publishCampaign("publish_campaign_test_01")
		.clickCancelButton()
		.getTitle();
	}
}
