package localization;

import org.testng.annotations.Test;

import Utility.TestBase;

public class LocalesEdit_TestCases extends TestBase {

	@Test(priority=0,enabled=true)
	public void update_locale_name()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.updateName("gaulois")
		.clickSave()
		.validateUpdates("gaulois","name","gaulois")
		.getTitle()
		.logout();
	}
	@Test(priority=1,enabled=true)
	public void update_locale_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("gaulois")
		.updateName("latin")
		.clickSave()
		.validateUpdates("latin","name","latin")
		.getTitle()
		.logout();
	}
	@Test(priority=2,enabled=true)
	public void update_locale_code()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.updateCode("gu")
		.clickSave()
		.validateUpdates("latin","code","gu")
		.getTitle()
		.logout();
	}
	@Test(priority=3,enabled=true)
	public void update_locale_code_to_previous()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.updateCode("la")
		.clickSave()
		.validateUpdates("latin","code","la")
		.getTitle()
		.logout();
	}
	@Test(priority=4,enabled=true)
	public void click_cancel_in_locales_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.clickCancel()
		.getTitle()
		.logout();
	}
	@Test(priority=5,enabled=true)
	public void return_to_locales_main_page_from_edit()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.returnToMainPage()
		.getTitle()
		.logout();
	}
	@Test(priority=6,enabled=true)
	public void empty_name_field_in_locales_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.deleteName()
		.failToUpdate()
		.getTitle();
	}
	@Test(priority=7,enabled=true)
	public void empty_code_field_in_locales_edit_page()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.deleteCode()
		.failToUpdate()
		.getTitle();
	}
	@Test(priority=8,enabled=true)
	public void inactivate_locales()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.isActive(false)
		.clickSave()
		.validateUpdates("latin","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=9,enabled=true)
	public void activate_locales()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.editLocales("latin")
		.isActive(true)
		.clickSave()
		.validateUpdates("latin","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=10,enabled=true)
	public void archive_locales()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.archiveLocales("latin")
		.getTitle()
		.logout();
	}
	@Test(priority=11,enabled=true)
	public void restore_locales()
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.restoreLocales("latin")
		.getTitle()
		.logout();
	}
}