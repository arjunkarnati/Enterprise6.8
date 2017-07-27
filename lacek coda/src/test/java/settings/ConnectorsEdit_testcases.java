package settings;

import org.testng.annotations.Test;

import Utility.TestBase;

public class ConnectorsEdit_testcases extends TestBase{


	@Test(priority=0)
	public void test_is_empty()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.getTitle()
		.logout();
	}
	/*@Test(priority=1)
	public void update_connector(){
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_1")
		.updateNameTo("edit_conn_test_01")
		//.addacfvalue("0")
		.submit()
		.validateConnectorUpdate("name", "edit_conn_test_1", "arjun_connector_01")
		.logout();
	}
	@Test(priority=2)
	public void update_prevconnector(){
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("arjun_connector_1")
		.updateNameTo("arjun_connector")
		//.addacfvalue("0")
		.submit()
		.validateConnectorUpdate("name", "arjun_connector", "arjun_connector")
		.logout();
	}
	@Test(priority=3)
	public void update_client(){
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
    	.clickConnectors()
		.editConnector("edit_conn_test_1")
		.updateClientTo("Enterprise Holdings Inc.")
		.submit()
		.getTitle()
		.logout();
	}
	

    //this was commented by prince
	@Test(priority=4)
	public void update_client_to_previous(){
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
    	.clickConnectors()
		.editConnector("edit_conn_test_1")
		.updateClientTo("Carnival Corporation & PLC")
		.submit()
		.getTitle()
		.logout();
	}

    @Test(priority=5)
	public void update_connector_name()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_1")
		.updateNameTo("edit_conn_test_010")
		.submit()
		.getTitle()
		.logout();
	}

	@Test(priority=6)
	public void validate_name_update()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.validateConnectorUpdate("name", "edit_conn_test_010", "edit_conn_test_010")
		.getTitle()
		.logout();
	}

	@Test(priority=7)
	public void update_connector_name_to_previous()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_010")
		.updateNameTo("edit_conn_test_1")
		.submit()
		.getTitle()
		.logout();
	}

	@Test(priority=8)
	public void validate_name_update_to_previous()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.validateConnectorUpdate("name", "edit_conn_test_1", "edit_conn_test_1")
		.getTitle()
		.logout();
	}

	@Test(priority=9)
	public void add_brands()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_1")
		.addBrand("cunard")
		.addBrand("costa cruises")
		.submit()
		.getTitle()
		.logout();
	}

/*	@Test(priority=7)
	public void validate_brands_add()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.validateBrand("edit_conn_test_1",2)
		.getTitle()
		.logout();
	}*/

	@Test(priority=8)
	public void delete_entry_in_brand_field()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.deleteBrand()
		.submit()
		.getTitle()
		.logout();
	}
//
//	@Test(priority=9)
//	public void validate_brands_update()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.validateBrand("Exact Target (Dev) - Approved", 1)
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=10)
//	public void update_brand_to_previous()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.editConnector("Exact Target (Dev) - Approved")
//		.updateClientTo("DuPont")
//		.submit()
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=11)
//	public void validate_brands_update_to_previous()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.validateBrand("Exact Target (Dev) - Approved", 1)
//		.getTitle()
//		.logout();
//	}
//	
//	@Test(priority=12)
//	public void update_to_previous_client()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.editConnector("Exact Target (Dev) - Approved")
//		.updateClientTo("Carnival Corporation & PLC")
//		.submit()
//		.getTitle()
//		.logout();
//	}
//
	@Test(priority=13)
	public void add_programs()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.addProgram("VIFP")
		.submit()
		.getTitle()
		.logout();
	}

	@Test(priority=14)
	public void validate_program_add()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		// 5.19 .validateProgram("edit_conn_test_1", 2)
		.getTitle()
		.logout();
	}
//
//	@Test(priority=15)
//	public void delete_entry_in_program_field()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.editConnector("Exact Target (Dev) - Approved")
//		.updateClientTo("DuPont")
//		.submit()
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=16)
//	public void validate_program_update()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.validateProgram("Exact Target (Dev) - Approved", 1)
//		.getTitle()
//		.logout();
//	}
//	
//	@Test(priority=17)
//	public void update_brand_to_previous_client()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.editConnector("Exact Target (Dev) - Approved")
//		.updateClientTo("Carnival Corporation & PLC")
//		.submit()
//		.getTitle()
//		.logout();
//	}

	@Test(priority=18)
	public void inacativate_connector()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_1")
		.isActive(false)
		.submit()
		.validateConnectorUpdate("status", "edit_conn_test_01", "INACTIVE")
		.getTitle()
		.logout();
	}
//
//	@Test(priority=19)
//	public void validate_that_the_connector_is_inactive()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.validateConnectorUpdate("status", "INACTIVE", "Exact Target (Dev) - Approved")
//		.getTitle()
//		.logout();
//	}
//
	@Test(priority=20)
	public void acativate_connector()
	{
		login.loginAs("automation.admin", "Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.isActive(true)
		.submit()
		.validateConnectorUpdate("status", "edit_conn_test_01", "ACTIVE")
		.getTitle()
		.logout();
	}
//
//	@Test(priority=21)
//	public void validate_that_the_connector_is_active()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.validateConnectorUpdate("status", "ACTIVE", "Exact Target (Dev) - Approved")
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=22)
//	public void set_workflow_to_draft()
//	{
//		login.loginAs("automation.admin", "Monday#223")
//		.isSuccessfulLogin("automation admin")
//		.clickConnectors()
//		.editConnector("edit_conn_test_1")
//		.setWorkflowTo("draft")
//		.submit()
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=23)
//	public void validate_that_the_workflow_is_set_to_draft()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.validateConnectorUpdate("Workflow Association", "DRAFT", "Exact Target (Dev) - Approved")
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=24)
//	public void name_field_is_empty_and_click_submit()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.editConnector("Exact Target (Dev) - Approved")
//		.deleteName()
//		.submit()
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=25)
//	public void client_field_is_empty_and_click_submit()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.editConnector("Exact Target (Dev) - Approved")
//		.updateClientTo("Select a Client")
//		.submit()
//		.getTitle()
//		.logout();
//	}
//
//	@Test(priority=26)
//	public void click_cancel()
//	{
//		login.loginAs("prince.kabuika", "Monday#223")
//		.isSuccessfulLogin("Prince Kabuika")
//		.clickConnectors()
//		.editConnector("Exact Target (Dev) - Approved")
//		.cancel()
//		.getTitle()
//		.logout();
//	}
//
//

	
}
