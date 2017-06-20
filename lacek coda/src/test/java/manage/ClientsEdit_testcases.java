package manage;

import org.testng.annotations.Test;
import Utility.TestBase;

public class ClientsEdit_testcases extends TestBase{

	//EDIT CLIENT
	@Test(priority=0)
	public void update_client_name()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.updateNameTo("US Bank01")
		.clickSubmit()
		.validateUpdates("US Bank01","name","US Bank01")
		.getTitle()
		.logout();
	}
	@Test(priority=1)
	public void update_client_name_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank01")
		.updateNameTo("US Bank")
		.clickSubmit()
		.validateUpdates("US Bank","name","US Bank")
		.getTitle()
		.logout();
	}
	@Test(priority=2)
	public void update_client_color()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.updateColorTo("#b31919")
		.clickSubmit()
		.getTitle()
		.logout();
	}
	@Test(priority=3)
	public void update_client_color_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()	
		.editClient("US Bank")
		.updateColorTo("#c4f03e")
		.clickSubmit()
		.getTitle()
		.logout();
	}
	@Test(priority=4)
	public void update_client_url()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.updateUrlTo("http://www.ogilvy.com/")
		.clickSubmit()
		.validateUpdates("US Bank","url","http://www.ogilvy.com/")
		.getTitle()
		.logout();
	}
	@Test(priority=5)
	public void update_client_url_to_previous()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.updateUrlTo("https://www.usbank.com")
		.clickSubmit()
		.validateUpdates("US Bank","url","https://www.usbank.com")
		.getTitle()
		.logout();
	}
	@Test(priority=6)
	public void inactivate_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()	
		.editClient("US Bank")
		.inactivateClient()
		.clickSubmit()
		.validateUpdates("US Bank","status","INACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=7)
	public void activate_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.activateClient()
		.clickSubmit()
		.validateUpdates("US Bank","status","ACTIVE")
		.getTitle()
		.logout();
	}
	@Test(priority=8)
	public void empty_name_field_in_client_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.deleteName()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=9)
	public void empty_code_field_in_client_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.deleteCode()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=10)
	public void empty_color_field_in_client_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.deleteColor()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=11)
	public void empty_url_field_in_client_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.deleteUrl()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	//@Test(priority=12)
	public void empty_locales_field_in_client_edit_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.editClient("US Bank")
		.deleteEntryInLocalField()
		.failToUpdate()
		.getTitle()
		.logout();
	}
	@Test(priority=13)
	public void archive_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.archiveClient("US Bank")
		.getTitle();
	}
	@Test(priority=14)
	public void restore_client()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.restoreClient("US Bank")
		.getTitle();
	}
}