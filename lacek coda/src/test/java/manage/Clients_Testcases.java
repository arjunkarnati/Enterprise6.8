package manage;

import org.testng.annotations.Test;
import DataBase.DataBaseManage;
import Utility.TestBase;

public class Clients_Testcases extends TestBase{

	//CREATE CLIENT 
	@Test(priority=0)
	//@Test(enabled=false)
	public void create_a_new_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.clickAddClientButton()
		.addName("selenium_client_3.15")
		.addCode("test")
		.addColor("#24804d")
		.addUrl("https://www.google.com/")
		.addLocales("French")
		.addLocales("English")
		.addDefaultLocales(1)
		.clickSubmit()
		.validateUpdates("selenium_client_3.15","name","selenium_client_3.15")
		.validateUpdates("selenium_client_3.15","url","https://www.google.com/")
		.validateUpdates("selenium_client_3.15","locales","2")
		.validateUpdates("selenium_client_3.15","status","ACTIVE")
		.getTitle()
		.logout();		
	}
	@Test(priority=1)
	//@Test(enabled=false)
	public void create_a_new_client_without_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.clickAddClientButton()
		.addCode("test")
		.addColor("#24804d")
		.addUrl("http://www.lacek.com/")
		.addLocales("French")
		.addLocales("English")
		.addDefaultLocales(1)
		.failToCreate()
		.getTitle()
		.logout();		
	}
	@Test(priority=2)
	//@Test(enabled=false)
	public void create_a_new_client_without_color()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.clickAddClientButton()
		.addName("test_selenium_client_02")
		.addCode("test")
		.addUrl("http://www.lacek.com/")
		.addLocales("French")
		.addLocales("English")
		.addDefaultLocales(1)
		.failToCreate()
		.getTitle()
		.logout();	
	}
	@Test(priority=3)
	//@Test(enabled=false)
	public void create_a_new_client_witout_a_url()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.clickAddClientButton()
		.addName("test_selenium_client_03")
		.addCode("test")
		.addColor("#24804d")
		.addLocales("French")
		.addLocales("English")
		.addDefaultLocales(1)
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	//@Test(enabled=false)
	public void create_a_new_client_witout_locales()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.clickAddClientButton()
		.addName("test_selenium_client_03")
		.addCode("test")
		.addColor("#24804d")
		.addUrl("http://www.lacek.com/")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	//@Test(enabled=false)
	public void create_a_new_client_witout_a_default_locales()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.clickAddClientButton()
		.addName("test_selenium_client_03")
		.addCode("test")
		.addColor("#24804d")
		.addUrl("http://www.lacek.com/")
		.addLocales("English")
		.failToCreate()
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	//@Test(enabled=false)
	public void cancel_client_add_process()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.clickAddClientButton()
		.clickCancel()
		.getTitle()
		.logout();		
	}
	@Test(priority=50)
	//@Test(enabled=false)
	public void delete_client_from_db()
	{
		DataBaseManage.deleteClient();
	}
}