package login;

import Utility.TestBase;
import org.testng.annotations.Test;

public class Client_context_TestCases extends TestBase{

	@Test(priority=0)
	public void client_is_updated_to_Dupont_when_dupont_is_selected()   
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.selectClient("dupont")
		.getTitle()
		.logout();		
	}
	@Test(priority=1)
	public void client_is_updated_to_carnival_when_carnival_is_selected()   
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.selectClient("Carnival Corporation & PLC")
		.getTitle()
		.logout();		
	}
	@Test(priority=2)
	public void client_is_updated_to_kia_when_kia_is_selected()   
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		//.selectClient("McDonald's")
		.getTitle()
		.logout();		
	}
	@Test(priority=3)
	public void client_is_updated_to_allclient_when_allclient_is_selected()   
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.selectClient("All Clients")
		.getTitle()
		.logout();		
	}
}