package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class MessagesPublish_Testcases extends TestBase{

	@Test(priority=0)
	public void publish_message() 
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.publishMessage("publish_message_test_01")
		.checkAll()
		//.clickPublishButton()
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	public void cancel_publish_campaign()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.publishMessage("publish_message_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();	
	}
}