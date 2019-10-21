package login;

import Utility.TestBase;
import org.testng.annotations.Test;

public class Dashboard_TestCases extends TestBase{

	@Test(priority=0)
	public void open_campaign_page()   
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCampaignsLink()
		.getTitle()
		.logout();		
	}
	@Test(priority=1)
	public void open_communications_page() 
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickCommunicationsLink()
		.getTitle()
		.logout();	
	}
	@Test(priority=2)
	public void open_messages_page()   
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesLink()
		.getTitle()
		.logout();	
	}
	@Test(priority=3)
	public void open_tracks_page()   
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTracksLink()
		.getTitle()
		.logout();	
	}
	@Test(priority=4)
	public void open_variables_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickVariablesLink()
		.getTitle()
		.logout();		
	}
	@Test(priority=5)
	public void open_media_gallery_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMediaGallery()
		.getTitle()
		.logout();		
	}
	@Test(priority=6)
	public void open_regions_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRegions()
		.getTitle()
		.logout();		
	}
	@Test(priority=7)
	public void open_templates_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.getTitle()
		.logout();		
	}
	@Test(priority=8)
	public void open_clietns_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickClients()
		.getTitle()
		.logout();		
	}
	@Test(priority=9)
	public void open_brands_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickBrands()
		.getTitle()
		.logout();		
	}
	@Test(priority=10)
	public void open_programs_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPrograms()
		.getTitle()
		.logout();			
	}
	@Test(priority=11)
	public void open_segments_groups_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegmentGroups()
		.getTitle()
		.logout();		
	}
	@Test(priority=12)
	public void open_segments_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSegments()
		.getTitle()
		.logout();		
	}
	@Test(priority=13)
	public void open_targeting_criteria_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTargetingCriteria()
		.getTitle()
		.logout();		
	}
	@Test(priority=14)
	public void open_messages_types_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickMessagesType()
		.getTitle()
		.logout();		
	}
	@Test(priority=15)
	public void open_users_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickUsers()
		.getTitle()
		.logout();		
	}
	@Test(priority=16)
	public void open_roles_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickRoles()
		.getTitle()
		.logout();		
	}
	@Test(priority=17)
	public void open_permissions_page()  //,enabled=false
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		//.clickPermissions()
		.getTitle()
		.logout();		
	}
	@Test(priority=18)
	public void open_channels_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickChannels()
		.getTitle()
		.logout();	
	}
	@Test(priority=19,enabled=false)
	public void open_workflow_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		//.clickWorkflow()
		.getTitle()
		.logout();		
	}
	@Test(priority=20)
	public void open_connectors_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickConnectors()
		.getTitle()
		.logout();		
	}
	@Test(priority=21)
	public void open_sessions_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSessions()
		.getTitle()
		.logout();			
	}
	@Test(priority=22)
	public void open_permission_group_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionGroups()
		.getTitle()
		.logout();			
	}
	@Test(priority=23)
	public void open_permission_action_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionActions()
		.getTitle()
		.logout();			
	}
	//@Test(priority=24)
	public void open_permission_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissions()
		.getTitle()
		.logout();			
	}
	@Test(priority=25)
	public void open_permission_categories_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickPermissionCategories()
		.getTitle()
		.logout();			
	}
	@Test(priority=26)
	public void open_workflow_state_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowState()
		.getTitle()
		.logout();			
	}
	@Test(priority=27)
	public void open_workflow_manager_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickWorkflowManager()
		.getTitle()
		.logout();			
	}
	@Test(priority=28)
	public void open_change_log_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickChangelog()
		.getTitle()
		.logout();			
	}
	@Test(priority=29)
	public void select_dupont_in_client_dropdown()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.selectClient("Dupont")
		.getTitle()
		.logout();			
	}
	@Test(priority=30)
	public void select_allclient_in_client_dropdown()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.selectClient("All Clients")
		.getTitle()
		.logout();			
	}
	@Test(priority=31)
	public void open_locales_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocales()
		.getTitle()
		.logout();			
	}
	@Test(priority=32)
	public void open_locales_import_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesImport()
		.getTitle()
		.logout();			
	}
	@Test(priority=33)
	public void open_locales_export_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.getTitle()
		.logout();			
	}
	@Test(priority=34)
	public void login_and_logout()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.testLogout()
		.getTitle()
		.logout();			
	}
	@Test(priority=35)
	public void open_system_configuration_page()  
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickSystemConfiguration()
		.getTitle()
		.logout();			
	}
}