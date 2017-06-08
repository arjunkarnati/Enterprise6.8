package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class CommunicationsPublish_Testcases extends TestBase{

	@Test(priority=0)
	public void publish_series() 
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
//		.publishCommunications("granulapub")
//		.checkAll()
//		.clickPublishButton()
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	public void cancel_publish_campaign()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
//		.publishCommunications("granulapub")
//		.clickCancelButton()
		.getTitle()
		.logout();	
	}
	
	
}
