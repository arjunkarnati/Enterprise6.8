package library;

import DataBase.DataBaseLibrary;
import Utility.TestBase;
import org.testng.annotations.Test;

public class Messages_TestCases extends TestBase{

	//CREATE MESSAGES 
	@Test(priority=0,enabled=true)
	public void create_a_new_message()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.clickAddMessageButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("Costa Cruises")
		.addBrand("Fathom")
		.addProgram("VIFP")
		.addMessageName("selenium_message_001")	
		.addDescription("Test_regression_message_selenium1")	
		.addVariables("First Name")
		.addtemplates("Booked Guest - Primary")	
		.addConnector("Exact Target (Carnival NA) | Draft")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.clickSubmitButton()
		.validateUpdates("selenium_message_001","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_message_001","brand","3")
		.validateUpdates("selenium_message_001","program","1")
		.validateUpdates("selenium_message_001","name","selenium_message_001")
		.validateUpdates("selenium_message_001","template","1")
		.validateUpdates("selenium_message_001","status","ACTIVE")
		.validateUpdates("selenium_message_001","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_message_without_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.clickAddMessageButton()
		.addMessageName("Test_regression_message_selenium2")	
		.addDescription("Test_regression_message_selenium2")	
		.failToCreate()	
		.getTitle()
		.logout();	
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_message_without_a_message_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.clickAddMessageButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addDescription("Test_regression_message_selenium2")	
		.addVariables("First Name")
		.addtemplates("Booked Guest - Primary")	
		.addConnector("Exact Target (Carnival NA) | Draft")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.failToCreate()	
		.getTitle()
		.logout();	
	}
	@Test(priority=3,enabled=true)
	public void create_a_new_message_without_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.clickAddMessageButton()
		.addClientName("Carnival Corporation & PLC")
		.addProgram("VIFP")
		.addMessageName("selenium_message_002")	
		.addDescription("Test_regression_message_selenium3")	
		.addVariables("First Name")
		.addtemplates("Booked Guest - Primary")	
		.addConnector("Exact Target (Carnival NA) | Draft")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.clickSubmitButton()
		//5.10//.validateUpdates("selenium_message_002","brand","10")
		.getTitle()
		.logout();	
	}
	@Test(priority=9,enabled=true)
	public void click_cancel_message_button()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.clickAddMessageButton()
		.clickCancelButton()
		.getTitle()
		.logout();	
	}
	@Test(priority=10,enabled=true)
	public void clone_message(){
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		//.copyMessage("edit_message_test_01")
		//.editcopymessagename("arjun.lacek")
		//.validatecopiedmessages("arjun.lacek")
		;
	}
	@Test(priority=11,enabled=true)
	public void CCL_AE_Failtocreate_message()
	{
		login.loginAs("carnival.account","09ht1a0480")
		.isSuccessfulLogin("carnival account")
		.clickMessagesLink()
		.clickAddMessageButton()
		//.addClientName("Carnival Corporation & PLC")
		.addcclBrand("cunard")
		//.addProgram("VIFP")
		//.addDescription("Test_regression_message_selenium2")	
		//.addVariables("First Name")
		//.addtemplates("Booked Guest - Primary")	
		//.addConnector("Exact Target (Carnival NA) | Draft")
		//.addConnector("Exact Target (Carnival NA) | Approved")
		.failToCreate()	
		.getTitle()
		.logout();
	}
	@Test(priority=12,enabled=true)
	public void delete_message_from_db()
	{
		DataBaseLibrary.deleteMessage();
	}
	
	@Test(priority=30,enabled=true)
	public void create_testdata_message()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickMessagesLink()
		.clickAddMessageButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("Costa Cruises")
		.addBrand("Fathom")
		.addProgram("VIFP")
		.addMessageName("edit_message_test_01")	
		.addDescription("Test_regression_message_selenium1")	
		.addVariables("First Name")
		.addtemplates("Booked Guest - Primary")	
		.addtemplates("Booked Guest - Footer2")	
		.addConnector("Exact Target (Carnival NA) | Draft")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.clickSubmitButton()
		.validateUpdates("edit_message_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_message_test_01","program","1")
		.validateUpdates("edit_message_test_01","name","edit_message_test_01")
		.validateUpdates("edit_message_test_01","status","ACTIVE")
		.validateUpdates("edit_message_test_01","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	
	@Test(priority=31,enabled=true)
	public void create_publish_message()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickMessagesLink()
		.clickAddMessageButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("Costa Cruises")
		.addBrand("Fathom")
		.addProgram("VIFP")
		.addMessageName("publish_message_test_01")	
		.addDescription("publish_regression_message_selenium1")	
		.addVariables("First Name")
		.addtemplates("Booked Guest - Primary")	
		.addtemplates("Booked Guest - Footer2")	
		.addConnector("Exact Target (Carnival NA) | Draft")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.clickSubmitButton()
		.validateUpdates("publish_message_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("publish_message_test_01","program","1")
		.validateUpdates("publish_message_test_01","name","publish_message_test_01")
		.getTitle()
		.logout();	
	}
	
}