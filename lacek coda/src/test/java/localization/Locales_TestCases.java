package localization;

import org.testng.annotations.Test;
import DataBase.DataBaseLocalization;
import Utility.TestBase;

public class Locales_TestCases extends TestBase {
	
	@Test(priority=0,enabled=true)
	public void create_a_new_locales()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.clickAddLocalesButton()
		.addName("selenium_locale_01")
		.addCode("S_L_01")
		.clickSave()
		.validateUpdates("selenium_locale_01","name","selenium_locale_01")
		.validateUpdates("selenium_locale_01","code","S_L_01")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void create_a_new_locales_without_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.clickAddLocalesButton()
		.addCode("S_L_01")
		.failToCreate()
		.getTitle();
	}
	@Test(priority=2,enabled=true)
	public void create_a_new_locales_without_code()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.clickAddLocalesButton()
		.addName("selenium_locale_02")
		.failToCreate()
		.getTitle();
	}
	@Test(priority=3,enabled=true)
	public void click_cancel_in_locales_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.clickAddLocalesButton()
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void return_to_locales_main_page_from_add_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.clickAddLocalesButton()
		.returnToMainPage()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void delete_locale_from_database()
	{
		DataBaseLocalization.deleteLocale();
	}
	/*@Test(priority=30,enabled=true)
	public void create_a_test_locales()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.clickAddLocalesButton()
		.addName("latin")
		.addCode("la")
		.clickSave()
		.validateUpdates("latin","name","latin")
		.validateUpdates("latin","code","la")
		.getTitle()
		.logout();
	}*/
}