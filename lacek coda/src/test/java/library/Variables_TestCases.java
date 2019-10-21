package library;

import DataBase.DataBaseLibrary;
import Utility.TestBase;
import org.testng.annotations.Test;

public class Variables_TestCases extends TestBase{

	//CREATE VARIABLES 2
	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_locale_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.clickAddVariableButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addVariableName("selenium_regression_001")		
		.addDescription("Test regression series with selenium webdriver")
		.isGlobal(false)
		.addDefault("still testing")
		//.addacfvalue("0")
		.clickSubmit()
		.validateUpdates("selenium_regression_001","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_regression_001","brands","1")
		.validateUpdates("selenium_regression_001","name","selenium_regression_001")
		.validateUpdates("selenium_regression_001","is global","NO")
		.validateUpdates("selenium_regression_001","default","still testing")
		.validateUpdates("selenium_regression_001","status","ACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_global_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.clickAddVariableButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addVariableName("selenium_regression_002")		
		.addDescription("Test regression series with selenium webdriver")
		.isGlobal(true)
		.addDefault("still testing")
		//.addacfvalue("0")
		.clickSubmit()
		.validateUpdates("selenium_regression_002","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_regression_002","brands","1")
		.validateUpdates("selenium_regression_002","name","selenium_regression_002")
		.validateUpdates("selenium_regression_002","is global","YES")
		.validateUpdates("selenium_regression_002","default","still testing")
		.validateUpdates("selenium_regression_002","status","ACTIVE")
		.getTitle()
		.logout();	
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void create_a_duplicate_variable()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.clickAddVariableButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addVariableName("selenium_regression_002")		
		.addDescription("Test regression series with selenium webdriver")
		.isGlobal(true)
		.addDefault("test1")
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void create_a_new_variablle_without_clientname()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.clickAddVariableButton()
		.addVariableName("regression_selenium_coda_2")		
		.addDescription("Test regression series with selenium webdriver")	
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=6)
	//@Test(enabled=false)
	public void click_cancel_variable_button()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.clickAddVariableButton()
		.clickCancel()
		.getTitle()
		.logout();	
	}
	@Test(priority=7)
	//@Test(enabled=false)
	public void create_a_new_variablle_without_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.clickAddVariableButton()
		.addClientName("Carnival Corporation & PLC")	
		.addDescription("Test regression series with selenium webdriver")	
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=10)
	public void delete_variable_from_db()
	{
		DataBaseLibrary.deleteVariable();
	}
	/*@Test(priority=30)
	//@Test(enabled=false)
	public void create_test_variable()
	{
		login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickVariablesLink()
		.clickAddVariableButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addVariableName("edit_variable_test_01")		
		.addDescription("automation variable")
		.isGlobal(false)
		.addDefault("edit_variable_test_01")
		.clickSubmit()
		.validateUpdates("edit_variable_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_variable_test_01","brands","1")
		.validateUpdates("edit_variable_test_01","name","edit_variable_test_01")
		.validateUpdates("edit_variable_test_01","is global","NO")
		.validateUpdates("edit_variable_test_01","default","edit_variable_test_01")
		.validateUpdates("edit_variable_test_01","status","ACTIVE")
		.getTitle()
		.logout();	
	}*/
}