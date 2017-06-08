package login;

import org.testng.annotations.Test;
import Utility.TestBase;

public class System_configuration_testcases extends TestBase {

	@Test(priority=0,enabled=true)
	public void disable_live_publishing()   
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.enableLivePublishing(false)
		.clickSave()
		.getTitle()
		.logout();		
	}
	@Test(priority=1,enabled=true)
	public void enable_live_publishing()   
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.enableLivePublishing(true)
		.clickSave()
		.getTitle()
		.logout();		
	}
	@Test(priority=2,enabled=true)
	public void disable_automatic_publishing()   
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.enableAutomaticPublishing(false)
		.clickSave()
		.getTitle()
		.logout();		
	}
	@Test(priority=3,enabled=true)
	public void enable_automatic_publishing()   
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.enableAutomaticPublishing(true)
		.clickSave()
		.getTitle()
		.logout();		
	}
	@Test(priority=4,enabled=true)
	public void disable_live_and_automatic_publishing_()   
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.enableLivePublishing(false)
		.enableAutomaticPublishing(false)
		.clickSave()
		.getTitle()
		.logout();		
	}
	@Test(priority=5,enabled=true)
	public void enable_live_and_automatic_publishing_()   
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.enableLivePublishing(true)
		.enableAutomaticPublishing(true)
		.clickSave()
		.getTitle()
		.logout();		
	}
	@Test(priority=6,enabled=true)
	public void click_cancel_in_sys_configuration_page()   
	{
		login.loginAs("automation.admin","Monday#2")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.clickCancel()
		.getTitle()
		.logout();		
	}
}