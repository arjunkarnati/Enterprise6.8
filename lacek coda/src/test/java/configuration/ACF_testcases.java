package configuration;

import DataBase.DataBaseConfiguration;
import Utility.TestBase;
import org.testng.annotations.Test;

public class ACF_testcases extends TestBase {

	@Test(priority=0,enabled=true)
	public void create_an_acf_data_type_int_field_type_text()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_A3.9")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValInt")
		.addFieldType("Text")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_A3.9","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_A3.9","brand","2")
		//.validateUpdates("selenium_acf_A3.9","program","1")
		.validateUpdates("selenium_acf_A3.9","object","2")
		.validateUpdates("selenium_acf_A3.9","name","selenium_acf_A3.9")
		.validateUpdates("selenium_acf_A3.9","field","1")
		.validateUpdates("selenium_acf_A3.9","in use","No")
		.validateUpdates("selenium_acf_A3.9","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_an_acf_data_type_int_field_type_select()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_B3.9")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addFieldType("Select")
		.addDataType("ValInt")
		.addFieldInstructions("using selenium to test")
		.addTextForfieldTypeSelect("test3")
		.addValueForfieldTypeSelect("4")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_B3.9","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_B3.9","brand","3")
		//.validateUpdates("selenium_acf_B3.9","program","1")
		.validateUpdates("selenium_acf_B3.9","object","4")
		.validateUpdates("selenium_acf_B3.9","name","selenium_acf_B3.9")
		.validateUpdates("selenium_acf_B3.9","field","1")
		.validateUpdates("selenium_acf_B3.9","in use","No")
		.validateUpdates("selenium_acf_B3.9","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void create_an_acf_data_type_varchar_field_type_text()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_C3.9")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValVarchar")
		.addFieldType("Text")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_C3.9","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_C3.9","brand","3")
		//.validateUpdates("selenium_acf_C3.9","program","1")
		.validateUpdates("selenium_acf_C3.9","object","4")
		.validateUpdates("selenium_acf_C3.9","name","selenium_acf_C3.9")
		.validateUpdates("selenium_acf_C3.9","field","1")
		.validateUpdates("selenium_acf_C3.9","in use","No")
		.validateUpdates("selenium_acf_C3.9","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void create_an_acf_data_type_varchar_field_type_text_area()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_D3.9")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValVarchar")
		.addFieldType("Text Area")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_D3.9","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_D3.9","brand","3")
		//.validateUpdates("selenium_acf_D3.9","program","1")
		.validateUpdates("selenium_acf_D3.9","object","4")
		.validateUpdates("selenium_acf_D3.9","name","selenium_acf_D3.9")
		.validateUpdates("selenium_acf_D3.9","field","1")
		.validateUpdates("selenium_acf_D3.9","in use","No")
		.validateUpdates("selenium_acf_D3.9","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void create_an_acf_data_type_varchar_field_type_Wysiwyg_editor()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_E3.9")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValVarchar")
		.addFieldType("Wysiwyg Editor")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_E3.9","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_E3.9","brand","3")
		//.validateUpdates("selenium_acf_E3.9","program","1")
		.validateUpdates("selenium_acf_E3.9","object","4")
		.validateUpdates("selenium_acf_E3.9","name","selenium_acf_E3.9")
		.validateUpdates("selenium_acf_E3.9","field","1")
		.validateUpdates("selenium_acf_E3.9","in use","No")
		.validateUpdates("selenium_acf_E3.9","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void create_an_acf_data_type_varchar_field_type_select()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_F3.9")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValVarchar")
		.addFieldType("Select")
		.addFieldInstructions("using selenium to test")
		.addTextForfieldTypeSelect("test1")
		.addValueForfieldTypeSelect("3")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_F3.9","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_F3.9","brand","3")
		//.validateUpdates("selenium_acf_F3.9","program","1")
		.validateUpdates("selenium_acf_F3.9","object","4")
		.validateUpdates("selenium_acf_F3.9","name","selenium_acf_F3.9")
		.validateUpdates("selenium_acf_F3.9","field","1")
		.validateUpdates("selenium_acf_F3.9","in use","No")
		.validateUpdates("selenium_acf_F3.9","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void create_an_acf_data_type_decimal_field_type_text()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_G3.9")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValDecimal")
		.addFieldType("Text")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_G3.9","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_G3.9","brand","3")
		//.validateUpdates("selenium_acf_G3.9","program","1")
		.validateUpdates("selenium_acf_G3.9","object","4")
		.validateUpdates("selenium_acf_G3.9","name","selenium_acf_G3.9")
		.validateUpdates("selenium_acf_G3.9","field","1")
		.validateUpdates("selenium_acf_G3.9","in use","No")
		.validateUpdates("selenium_acf_G3.9","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=true)
	public void create_an_acf_data_type_decimal_field_type_select()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_3.9Z")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValDecimal")
		.addFieldType("Select")
		.addFieldInstructions("using selenium to test")
		.addTextForfieldTypeSelect("test")
		.addValueForfieldTypeSelect("2")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.clickSubmitButton()
		.validateUpdates("selenium_acf_3.9Z","client","Carnival Corporation & PLC")
		//.validateUpdates("selenium_acf_3.9Z","brand","3")
		//.validateUpdates("selenium_acf_3.9Z","program","1")
		.validateUpdates("selenium_acf_3.9Z","object","4")
		.validateUpdates("selenium_acf_3.9Z","name","selenium_acf_3.9Z")
		.validateUpdates("selenium_acf_3.9Z","field","1")
		.validateUpdates("selenium_acf_3.9Z","in use","No")
		.validateUpdates("selenium_acf_3.9Z","status","Active")
		.getTitle()
		.logout();
	}
	@Test(priority=8,enabled=true)
	public void create_a_new_acf_without_group_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValDecimal")
		.addFieldType("Text Area")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=9,enabled=true)
	public void create_a_new_acf_without_screens()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_SIX")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValDecimal")
		.addFieldType("Text Area")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=10,enabled=true)
	public void create_a_new_acf_without_field_label()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_SIX")
		.emptyFieldLabel()
		.addFieldName("selenium_field_name")
		.addDataType("ValDecimal")
		.addFieldType("Text Area")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=11,enabled=true)
	public void create_a_new_acf_without_field_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_SIX")
		.addFieldLabel("selenium_field_label")
		.emptyFieldName()
		.addDataType("ValDecimal")
		.addFieldType("Text Area")
		.addFieldInstructions("using selenium to test")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=12,enabled=true)
	public void create_a_new_acf_without_field_instructions()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		//.addBrand("cunard")
		//.addBrand("costa cruises")
		//.addBrand("Fathom")
		//.addProgram("VIFP")
		.addGroupName("selenium_acf_SIX")
		.addFieldLabel("selenium_field_label")
		.addFieldName("selenium_field_name")
		.addDataType("ValDecimal")
		.addFieldType("Text Area")
		.closeAddField()
		.addScreen("Tracks")
		.addScreen("Messages")
		.addScreen("Variables")
		.addScreen("Brands")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=13,enabled=true)
	public void click_cancel_in_acf_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.clickCancelButton()
		.getTitle()
		.logout();
	}
	@Test(priority=14,enabled=true)
	public void return_to_acf_main_page_from_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickAcf()
		.clickAddAcfButton()
		.returnToMainPage()
		.getTitle()
		.logout();
	}
	@Test(priority=50,enabled=true)
	public void delete_acf_from_database()
	{
		DataBaseConfiguration.deleteAcf();
		
	}
	/*@Test(priority=51,enabled=true)
	public void create_test_acf_data_type()
	{
	login.loginAs("test.data","Monday#223")
		.isSuccessfulLogin("test data")
		.clickAcf()
		.clickAddAcfButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("cunard")
		.addBrand("costa cruises")
		.addGroupName("edit_acf_test_01")
		.addFieldLabel("selenium_field_label")
		.addFieldName("new_field_0")
		.addDataType("ValInt")
		.addFieldType("Text")
		.addFieldInstructions("using to edit")
		.closeAddField()
		.addScreen("Message Types")
		.clickSubmitButton()
		.validateUpdates("edit_acf_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_acf_test_01","brand","2")
		.validateUpdates("edit_acf_test_01","program","1")
		.validateUpdates("edit_acf_test_01","name","edit_acf_test_01")
		.validateUpdates("edit_acf_test_01","field","1")
		.validateUpdates("edit_acf_test_01","status","Active")
		.getTitle()
		.logout();
	}*/
}