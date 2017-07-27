package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class CommunicationsPublish_Testcases extends TestBase{

	@Test(priority=0)
	public void publish_Communication() 
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.publishCommunications("publish_comm_test_01")
		.checkAll()
		.deletelocales()
		.addlocales("en-us")
		.clickPublishButton()	
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	public void cancel_publish_communicaton()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.publishCommunications("publish_comm_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();	
	}
	
	
}
