package settings;

import Utility.TestBase;
import org.testng.annotations.Test;

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
	@Test(priority=1)
	public void update_connector_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.editConnectorname("edit_conn_test_010")
		.submit()
		//.validateConnectorUpdate("name", "edit_conn_test_010", "edit_conn_test_010")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_connector_name_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_010")
		.editConnectorname("edit_conn_test_01")
		.submit()
		//.validateConnectorUpdate("name", "edit_conn_test_01", "edit_conn_test_01")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_connector_brand()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.deleteBrand()
		.updateConnector_brand("Costa Cruises")
		.submit()
		//.validateConnectorUpdate("brand", "edit_conn_test_01", "1")
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_connector_brand_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.deleteBrand()
		.updateConnector_brand("AIDA Cruises")
		.updateConnector_brand("Cunard")
		.submit()
		//.validateConnectorUpdate("brand", "edit_conn_test_01", "1")
		.getTitle()
		.logout();
	}	
	@Test(priority=4)
	public void update_connector_program()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.deleteProgram()
		.updateConnector_program("edit_program_test_01")
		.submit()
		//.validateConnectorUpdate("program","edit_conn_test_01", "1")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_connector_program_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.deleteProgram()
		.updateConnector_program("VIFP")
		.submit()
		//.validateConnectorUpdate("program", "edit_conn_test_01", "1")
		.getTitle()
		.logout();
	}
	
	@Test(priority=6)
	public void update_connector_status()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.isActive(false)
		.submit()
		//.validateConnectorUpdate("status", "edit_conn_test_01", "INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	public void update_connector_status_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.isActive(true)
		.submit()
		//.validateConnectorUpdate("status", "edit_conn_test_01", "ACTIVE")
		.getTitle()
		.logout();
	}	
	@Test(priority=8)
	public void update_connector_workflow()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.updateConnector_workflow("APPROVED","edit_conn_test_01")
		.submit()
		//.validateConnectorUpdate("workflow", "edit_conn_test_01", "approved")
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void update_connector_workflow_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.editConnector("edit_conn_test_01")
		.updateConnector_workflow("DRAFT","edit_conn_test_01")
		.submit()
		//.validateConnectorUpdate("workflow", "edit_conn_test_01", "approved")
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void archive_connector()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.archiveConnector("edit_conn_test_01")
		.getTitle()
		.logout();
	}
   @Test(priority=11)
   public void restore_conncector()
   {
	  login.loginAs("automation.admin","Monday#223")
	  .isSuccessfulLogin("automation admin")
	  .clickConnectors()
	  .restore_connector("edit_conn_test_01")
	  .getTitle()
	  .logout();
  }
	
}
