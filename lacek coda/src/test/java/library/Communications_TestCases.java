package library;

import org.testng.annotations.Test;
import DataBase.DataBaseLibrary;
import Utility.TestBase;

public class Communications_TestCases extends TestBase{

	//CREATE COMMUNICATION 
	@Test(priority=0,enabled=true)
	public void create_a_new_communication()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addTrack("TrackA1")
		.addCommunicationName("selenium_communication_selenium_test2")
		.addDescription("Test regression communication with selenium webdriver")
		.addSegmentGroups("casino")
		.addTemplate("Booked Guest")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.addConnector("Exact Target (Carnival NA) | Draft")
		.clickSubmit()
		.validateUpdates("selenium_communication_selenium_test2","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_communication_selenium_test2","brand","1")
		.validateUpdates("selenium_communication_selenium_test2","program","1")
		.validateUpdates("selenium_communication_selenium_test2","name","selenium_communication_selenium_test2")
		.validateUpdates("selenium_communication_selenium_test2","template","Booked Guest")
		//.validateUpdates("selenium_communication_selenium_test1","status","ACTIVE") //Check with Developer
		//.validateUpdates("selenium_communication_selenium_test1","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_communication_without_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addCommunicationName("selenium_communication_selenium_02")
		.addDescription("Test regression communication with selenium webdriver")
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=2,enabled=true)
	public void create_a_communication_without_communicationnname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addClientName("Carnival Corporation & PLC")
		.addProgram("VIFP")
		.addTrack("TrackA1")
		.addDescription("Test regression communication with selenium webdriver")
		.addSegmentGroups("casino")
		.addTemplate("Booked Guest")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.addConnector("Exact Target (Carnival NA) | Draft")
		.failToCreate()
		.getTitle()
		.logout();	
	}
	//@Test(priority=3,enabled=true)
	public void create_a_new_communication_without_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addClientName("Carnival Corporation & PLC")
		.addTrack("TrackA1")
		.addCommunicationName("selenium_communication_selenium_02")
		.addDescription("Test regression communication with selenium webdriver")
		.addSegmentGroups("casino")
		.addTemplate("Booked Guest")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.addConnector("Exact Target (Carnival NA) | Draft")
		.clickSubmit()
		.validateUpdates("selenium_communication_selenium_02","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_communication_selenium_02","name","selenium_communication_selenium_02")
		.validateUpdates("selenium_communication_selenium_02","template","Booked Guest")
		.validateUpdates("selenium_communication_selenium_02","status","ACTIVE")
		.validateUpdates("selenium_communication_selenium_02","workflow","DRAFT")
		.getTitle()
		.logout();	
	}
	@Test(priority=4,enabled=true)
	public void create_a_new_communication_without_template()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addClientName("Carnival Corporation & PLC")
		.addProgram("VIFP")
		.addTrack("TrackA1")
		.addCommunicationName("selenium_communication_selenium_02")
		.addDescription("Test regression communication with selenium webdriver")
		.addSegmentGroups("casino")
		.addConnector("Exact Target (Carnival NA) | Approved")
		.addConnector("Exact Target (Carnival NA) | Draft")
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=5,enabled=true)
	public void click_cancel_Button_in_communication_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.clickCancelButton()
		.getTitle()
		.logout();	
	}
	@Test(priority=6,enabled=true)
	public void delete_communication_from_db()
	{
		DataBaseLibrary.deleteCommunication();
	}
	/*@Test(priority=30,enabled=true)
	public void create_test_communication()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addTrack("TrackA1")
		.addCommunicationName("edit_comm_test_01")
		//.addDescription("for automation")
		.addSegmentGroups("casino")
		.addTemplate("Booked Guest")
		.addConnector("Exact Target (Carnival NA) | Draft")
		.clickSubmit()
		.validateUpdates("edit_comm_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_comm_test_01","brand","1")
		.validateUpdates("edit_comm_test_01","program","1")
		.validateUpdates("edit_comm_test_01","name","edit_comm_test_01")
		.validateUpdates("edit_comm_test_01","template","Booked Guest")
		.getTitle()
		.logout();
}
    @Test(priority=31,enabled=true)
	public void create_publish_communication()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addTrack("TrackA1")
		.addCommunicationName("publish_comm_test_01")
		//.addDescription("Hit hard to publish")
		.addSegmentGroups("casino")
		.addTemplate("Booked Guest")
		.addConnector("Exact Target (Carnival NA) | Draft")
		.clickSubmit()
		.validateUpdates("publish_comm_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("publish_comm_test_01","name","publish_comm_test_01")
		.validateUpdates("publish_comm_test_01","template","Booked Guest")
		.getTitle()
		.logout();
	}
    @Test(priority=32,enabled=true)
	public void create_EHI_test_communication()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickCommunicationsLink()
		.clickAddCommunicationsButton()
		.addClientName("Enterprise Holdings Inc")
		.addBrand("CarSales")
		.addProgram("Alamo Rent A Car")
		.addCommunicationName("edit_ehi_comm_test_01")
		.addDescription("for automation")
		.addSegmentGroups("Subject Line Testting")
		.addTemplate("Alamo_Loyalty")
		.addConnector("EHI EC Content Exact Target - TEST")
		.clickSubmit()
		.validateUpdates("edit_ehi_comm_test_01","client","Enterprise Holdings Inc")
		.validateUpdates("edit_ehi_comm_test_01","brand","1")
		.validateUpdates("edit_ehi_comm_test_01","program","1")
		.validateUpdates("edit_ehi_comm_test_01","name","edit_ehi_comm_test_01")
		.getTitle()
		.logout();
}
*/

}