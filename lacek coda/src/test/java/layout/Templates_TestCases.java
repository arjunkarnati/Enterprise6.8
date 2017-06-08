package layout;

import org.testng.annotations.Test;
import DataBase.DataBaseLayout;
import Utility.TestBase;

public class Templates_TestCases extends TestBase{

	//CREATE TEMPLATE 
	@Test(priority=0,enabled=true)
	public void create_a_new_template_channel_email_type_communication()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addBrand("cunard")
		.addChannel("email")
		.addTemplateName("selenium_test_001")
		.addType("Communication")
		.clickSubmitButton()
		.validateUpdates("selenium_test_001","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_test_001","brand","1")
		.validateUpdates("selenium_test_001","name","selenium_test_001")
		.validateUpdates("selenium_test_001","type","Communication")
		.validateUpdates("selenium_test_001","channel","Email")
		.validateUpdates("selenium_test_001","status","ACTIVE")
		.validateUpdates("selenium_test_001","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_template_channel_web_type_communication()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addChannel("Web")
		.addTemplateName("selenium_test_002")
		.addType("Communication")
		.clickSubmitButton()
		.validateUpdates("selenium_test_002","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_test_002","brand","1")
		.validateUpdates("selenium_test_002","name","selenium_test_002")
		.validateUpdates("selenium_test_002","type","Communication")
		.validateUpdates("selenium_test_002","channel","Web")
		.validateUpdates("selenium_test_002","status","ACTIVE")
		.validateUpdates("selenium_test_002","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_template_channel_email_type_message()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addChannel("email")
		.addTemplateName("selenium_test_003")
		.addType("Message")
		.clickSubmitButton()
		.validateUpdates("selenium_test_003","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_test_003","brand","1")
		.validateUpdates("selenium_test_003","name","selenium_test_003")
		.validateUpdates("selenium_test_003","type","Message")
		.validateUpdates("selenium_test_003","channel","Email")
		.validateUpdates("selenium_test_003","status","ACTIVE")
		.validateUpdates("selenium_test_003","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void create_a_new_template_channel_web_type_message()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addChannel("Web")
		.addTemplateName("selenium_test_004")
		.addType("Message")
		.clickSubmitButton()
		.validateUpdates("selenium_test_004","client","Carnival Corporation & PLC")
		.validateUpdates("selenium_test_004","brand","1")
		.validateUpdates("selenium_test_004","name","selenium_test_004")
		.validateUpdates("selenium_test_004","type","Message")
		.validateUpdates("selenium_test_004","channel","Web")
		.validateUpdates("selenium_test_004","status","ACTIVE")
		.validateUpdates("selenium_test_004","workflow","DRAFT")
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void create_a_new_template_without_a_clientname()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addChannel("email")
		.addTemplateName("test_selenium_web_mes_template_08")
		.addType("Communication")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void create_a_new_template_without_a_channel()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addTemplateName("test_selenium_web_mes_template_09")
		.addType("Communication")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void create_a_new_template_without_a_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addChannel("email")
		.addType("Communication")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=7,enabled=true)
	public void create_a_new_template_without_a_type()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addChannel("email")
		.addTemplateName("test_selenium_web_mes_template_02")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=10,enabled=true)
	public void delete_template_from_db()
	{
		DataBaseLayout.deleteTemplate();
	}
	/*@Test(priority=30,enabled=true)
	public void create_test_template_channel()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.clickAddTemplateButton()
		.addClientName("Carnival Corporation & PLC")
		.addBrand("Costa cruises")
		.addBrand("cunard")
		.addChannel("email")
		.addTemplateName("edit_template_test_01")
		.addType("Communication")
		.clickSubmitButton()
		.validateUpdates("edit_template_test_01","client","Carnival Corporation & PLC")
		.validateUpdates("edit_template_test_01","brand","1")
		.validateUpdates("edit_template_test_01","name","selenium_test_001")
		.validateUpdates("edit_template_test_01","type","Communication")
		.validateUpdates("edit_template_test_01","channel","Email")
		.validateUpdates("edit_template_test_01","status","ACTIVE")
		.validateUpdates("edit_template_test_01","workflow","DRAFT")
		.getTitle()
		.logout();
	}*/
}