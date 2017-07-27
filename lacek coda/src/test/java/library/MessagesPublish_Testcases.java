package library;

import org.testng.annotations.Test;

import Utility.TestBase;

public class MessagesPublish_Testcases extends TestBase{

	@Test(priority=0)
	public void publish_message() 
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.publishMessage("publish_message_test_01")
		.checkAll()
		//.clickPublishButton()
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	public void cancel_publish_messages()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.publishMessage("publish_message_test_01")
		.clickCancelButton()
		.getTitle()
		.logout();	
	}
	/*@Test(priority=2)
	public void select_all_messages_publish()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.publishMessage("publish_message_test_01")
		.select_all_messages()
		.clickPublishButton()
		.validated_selected_files("Exact Target (Carnival NA) | Approved");
	}*/
}