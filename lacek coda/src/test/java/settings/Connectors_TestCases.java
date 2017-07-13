package settings;

import org.testng.annotations.Test;

import DataBase.DataBaseLibrary;
import Utility.TestBase;

public class Connectors_TestCases extends TestBase{

	
	@Test(priority=0)
	public void open_connector_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void relaod_workflow_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.reloadPage()
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void click_print_view_print()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.clickViewPrintView()
		.getTitle();
	}
	@Test(priority=3)
	public void add_connector_validate()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.addConnectors()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addConnectorName("Selenium_01")
		.addAttributeNameValue("PublishKeySuffix", ".qa")
		//.addWorkflow("Draft")
		.saveConnector()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void delete_connector_from_db()
	{
		DataBaseLibrary.connector();
	}
	/*@Test(priority=20)
	public void test_connector()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickConnectors()
		.addConnectors()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addProgram("VIFP")
		.addConnectorName("edit_conn_test_01")
		.addAttributeNameValue("PublishKeySuffix", ".qa")
		.saveConnector()
		.logout();
	}*/
	
}

