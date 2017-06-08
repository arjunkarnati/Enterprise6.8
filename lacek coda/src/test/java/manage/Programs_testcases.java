package manage;

import org.testng.annotations.Test;

import DataBase.DataBaseManage;
import Utility.TestBase;

public class Programs_testcases extends TestBase{

	/*create program test cases */
	@Test(priority=0,enabled=true)
	public void create_a_new_program()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.clickAddProgramButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("Costa Cruises")
		.addProgramName("selenium_program_008")
		.addUrl("http://www.lacek.com/")
		.addDescription("creating a new prgram using selenium WD")
		.clickSubmit()	
		.validateUpdates("selenium_program_008","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_program_008","brand","2")
		.validateUpdates("selenium_program_008","name","selenium_program_008")
		.validateUpdates("selenium_program_008","url","http://www.lacek.com/")
		.validateUpdates("selenium_program_008","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_program_without_a_client_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.clickAddProgramButton()
		.addProgramName("test_selenium_program_02")
		.addUrl("http://www.lacek.com/")
		.addDescription("creating a new prgram using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_program_without_a_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.clickAddProgramButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addUrl("http://www.lacek.com/")
		.addDescription("creating a new prgram using selenium WD")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=50,enabled=true)
	public void delete_program_from_db()
	{
		DataBaseManage.deleteProgram();
	}
	/*@Test(priority=60,enabled=true)
	public void create_test_program()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.clickAddProgramButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("Costa Cruises")
		.addProgramName("edit_program_test_01")
		.addUrl("http://www.lacek.com/")
		.addDescription("using selenium for automation")
		.clickSubmit()	
		.validateUpdates("edit_program_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_program_test_01","brand","2")
		.validateUpdates("edit_program_test_01","name","edit_program_test_01")
		.validateUpdates("edit_program_test_01","status","ACTIVE")
		.getTitle()
		.logout();
	}*/
	
}