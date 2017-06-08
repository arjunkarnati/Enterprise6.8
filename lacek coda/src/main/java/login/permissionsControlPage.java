package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Utility.PageBase;
import access.PermissionActionsPage;
import access.PermissionCategoriesPage;
import access.PermissionGroupsPage;
import access.PermissionsPage;
import access.RolesPage;
import access.UsersPage;
import assets.MediaGalleryPage;
import configuration.ACFPage;
import configuration.MessageTypesPage;
import configuration.SegmentGroupsPage;
import configuration.SegmentsPage;
import configuration.TargetingCriteriaPage;
import layout.RegionsPage;
import layout.TemplatesPage;
import library.CampaignPage;
import library.CommunicationsPage;
import library.MessagesPage;
import library.SeriesPage;
import library.TracksPage;
import library.VariablesPage;
import localization.ExportPage;
import localization.ImportPage;
import localization.LocalesPage;
import logs.SessionsPage;
import manage.BrandsPage;
import manage.ClientsPage;
import manage.ProgramsPage;
import settings.ChannelsPage;
import settings.ConnectorsPage;
import settings.WorkflowManagerPage;
import settings.WorkflowStatePage;

public class permissionsControlPage extends PageBase {

	public permissionsControlPage(WebDriver driver) {
		super(driver);
	}
	/*open campaign page*/
	public CampaignPage clickCampaignsLink(boolean answer) 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("campaigns"))));	
		driver.findElement(By.xpath(elementslocator.getProperty("campaigns"))).click();
		sleep();
		//assert that system naviagtes in campaigns page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("campaign_page_title"));
		return new CampaignPage(driver);
	}
	/*open series page*/
	public SeriesPage clickSertiesLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("series"))));	
		driver.findElement(By.xpath(elementslocator.getProperty("series"))).click();
		sleep();
		//assert that system naviagtes in series page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("series_page_title"));
		return new SeriesPage(driver);
	}
	/*open tracks page*/
	public TracksPage clickTracksLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("tracks"))));		
		driver.findElement(By.xpath(elementslocator.getProperty("tracks"))).click();
		sleep();
		//assert that system naviagtes in tracks page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("tracks_page_title"));
		return new TracksPage(driver);
	}
	/*open communication page*/
	public CommunicationsPage clickCommunicationsLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("communications"))));
		driver.findElement(By.xpath(elementslocator.getProperty("communications"))).click();
		sleep();
		//assert that system naviagtes in communications page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("comm_page_title"));
		return new CommunicationsPage(driver);
	}
	/*open messages page*/
	public MessagesPage clickMessagesLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("messages"))));
		driver.findElement(By.xpath(elementslocator.getProperty("messages"))).click();
		sleep();
		//assert that system naviagtes in messages page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("mess_page_title"));
		return new MessagesPage(driver);
	}
	/*open variables page*/
	public VariablesPage clickVariablesLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("variables"))));
		driver.findElement(By.xpath(elementslocator.getProperty("variables"))).click();
		sleep();
		//assert that system naviagtes in varables page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("var_page_title"));
		return new VariablesPage(driver);
	}
	/*open media gallery page*/
	public MediaGalleryPage clickMediaGallery() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("assets"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("media_gallery"))));
		driver.findElement(By.xpath(elementslocator.getProperty("media_gallery"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),driver.getTitle(),elementslocator.getProperty("med_gallery_page_title"));
		return new MediaGalleryPage(driver);
	}
	/*open regions page*/
	public RegionsPage clickRegions() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("layout"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("regions"))));
		driver.findElement(By.xpath(elementslocator.getProperty("regions"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("region_page_title"));
		return new RegionsPage(driver);
	}
	/*open templates page*/
	public TemplatesPage clickTemplates() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("layout"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("templates"))));
		driver.findElement(By.xpath(elementslocator.getProperty("templates"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("template_page_title"));
		return new TemplatesPage(driver);
	}
	/*open users page*/	
	public UsersPage clickUsers() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("users"))));
		driver.findElement(By.xpath(elementslocator.getProperty("users"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("user_page_title"));
		return new UsersPage(driver);
	}
	/*open roles page*/	
	public RolesPage clickRoles() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("roles"))));
		driver.findElement(By.xpath(elementslocator.getProperty("roles"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("role_page_title"));
		return new RolesPage(driver);
	}
	/*open clients page*/	
	public ClientsPage clickClients() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("manage"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("clients"))));
		driver.findElement(By.xpath(elementslocator.getProperty("clients"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("client_page_title"));
		return new ClientsPage(driver);
	}
	/*open brands page*/	
	public BrandsPage clickBrands() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("manage"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("brands"))));
		driver.findElement(By.xpath(elementslocator.getProperty("brands"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("brand_page_title"));
		return new BrandsPage(driver);
	}
	/*open program page*/	
	public ProgramsPage clickPrograms() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("manage"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("programs"))));
		driver.findElement(By.xpath(elementslocator.getProperty("programs"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("program_page_title"));
		return new ProgramsPage(driver);
	}
	/*open segment groups page*/	
	public SegmentGroupsPage clickSegmentGroups() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("segement_groups"))));
		driver.findElement(By.xpath(elementslocator.getProperty("segement_groups"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("seg_group_page_title"));
		return new SegmentGroupsPage(driver);
	}
	/*open segments page*/	
	public SegmentsPage clickSegments() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("segments"))));
		driver.findElement(By.xpath(elementslocator.getProperty("segments"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("segment_page_title"));
		return new SegmentsPage(driver);
	}
	/*open segments page*/	
	public TargetingCriteriaPage clickTargetingCriteria() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("targeting_criteria"))));
		driver.findElement(By.xpath(elementslocator.getProperty("targeting_criteria"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("targ_criteria_page_title"));
		return new TargetingCriteriaPage(driver);
	}
	/*open message types page*/	
	public MessageTypesPage clickMessagesType() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("messages_type"))));
		driver.findElement(By.xpath(elementslocator.getProperty("messages_type"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("mes_type_page_title"));
		return new MessageTypesPage(driver);
	}
	//open permission actions page
	public PermissionGroupsPage clickPermissionGroups() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("access_controls"))));
		driver.findElement(By.xpath(elementslocator.getProperty("access_controls"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("permission_groups"))));
		driver.findElement(By.xpath(elementslocator.getProperty("permission_groups"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_group_page_title"));
		return new PermissionGroupsPage(driver);
	}
	//open permissions page	
	public PermissionsPage clickPermissions() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("access_controls"))));
		driver.findElement(By.xpath(elementslocator.getProperty("access_controls"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("permissions"))));
		new Actions(driver).moveToElement(driver.findElement(By.xpath(elementslocator.getProperty("permissions")))).perform();
		driver.findElement(By.xpath(elementslocator.getProperty("permissions"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("permission_page_title"));
		return new PermissionsPage(driver);
	}

	/*open permission categories page*/	
	public PermissionCategoriesPage clickPermissionCategories() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("access_controls"))));
		driver.findElement(By.xpath(elementslocator.getProperty("access_controls"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("permission_categories"))));
		driver.findElement(By.xpath(elementslocator.getProperty("permission_categories"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_category_page_title"));
		return new PermissionCategoriesPage(driver);
	}
	/*open permission group page*/	
	public PermissionActionsPage clickPermissionActions() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("access_controls"))));
		driver.findElement(By.xpath(elementslocator.getProperty("access_controls"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("permission_actions"))));
		driver.findElement(By.xpath(elementslocator.getProperty("permission_actions"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("perm_action_page_title"));
		return new PermissionActionsPage(driver);
	}	
	//open workflow states page	
	public WorkflowStatePage clickWorkflowState() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("settings"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("workflow"))));
		driver.findElement(By.xpath(elementslocator.getProperty("workflow"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("workflow_state"))));
		driver.findElement(By.xpath(elementslocator.getProperty("workflow_state"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_state_page_title"));
		return new WorkflowStatePage(driver);
	}
	//open workflow manager page	
	public WorkflowManagerPage clickWorkflowManager() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("settings"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("workflow"))));
		driver.findElement(By.xpath(elementslocator.getProperty("workflow"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("workflow_manager"))));
		driver.findElement(By.xpath(elementslocator.getProperty("workflow_manager"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("wf_manager_page_title"));
		return new WorkflowManagerPage(driver);
	}
	/*open channels page*/	
	public ChannelsPage clickChannels() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("settings"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("channels"))));
		driver.findElement(By.xpath(elementslocator.getProperty("channels"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("channel_page_title"));
		return new ChannelsPage(driver);
	}
	/*open connectors page*/	
	public ConnectorsPage clickConnectors() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("settings"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("connectors"))));
		driver.findElement(By.xpath(elementslocator.getProperty("connectors"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("connector_page_title"));
		return new ConnectorsPage(driver);
	}
	/*open connectors page*/	
	public SessionsPage clickSessions() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("logs"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("sessions"))));
		driver.findElement(By.xpath(elementslocator.getProperty("sessions"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("session_page_title"));
		return new SessionsPage(driver);
	}
	//open change log page	
	public SessionsPage clickChangelog() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("change_log"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("change_log_page_title"));
		return new SessionsPage(driver);
	}
	//open locales page	
	public LocalesPage clickLocales() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("localization"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("locales"))));
		driver.findElement(By.xpath(elementslocator.getProperty("locales"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("locales_page_title"));
		return new LocalesPage(driver);
	}
	//open locales export page	
	public ExportPage clickLocalesExport() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("localization"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("locales_export"))));
		driver.findElement(By.xpath(elementslocator.getProperty("locales_export"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("localization_export_page_title"));
		return new ExportPage(driver);
	}
	//open locales import page	
	public ImportPage clickLocalesImport() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("localization"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("locales_import"))));
		driver.findElement(By.xpath(elementslocator.getProperty("locales_import"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("localization_import_page_title"));
		return new ImportPage(driver);
	}
	//open acf page	
	public ACFPage clickAcf() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("custom_field"))));
		driver.findElement(By.xpath(elementslocator.getProperty("custom_field"))).click();
		sleep();
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("acf_page_title"));
		return new ACFPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//validate permissions
//	public permissionsControlPage validatePermission(String client, String role)
//	{
//		readconfig();
//		switch (client)
//		{
//		case "no clients":
//			Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("no_client"))).getText(),"No Clients Assigned");
//			if(role.equalsIgnoreCase("no role")){
//				Assert.assertEquals(driver.findElement(By.xpath(elementslocator.getProperty("no_object"))).getText(),"No Roles Assigned");
//			}			
//		case "Carnival Corporation & PLC":
//		{
//			Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("select_client"))).getText(),"Carnival Corporation & PLC CCL");
//
//			if(role.equalsIgnoreCase("testrole1"))
//			{
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//				//verify that library is displayed in the menu bar
//				int iCount=driver.findElements(By.xpath(elementslocator.getProperty("library"))).size();
//				{
//					if(iCount==1){
//						Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("library"))).isDisplayed());
//					}
//					else if(iCount==0)
//					{
//						Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("library"))).getSize().toString().equalsIgnoreCase("0"),"verify user permissions");
//					}
//					else {throw new InvalidParameterException("verify the object's xpath");}
//				}
//			}
//
//
//
//			else if(role.equalsIgnoreCase("testrole2"))
//				//assert that page title is dashboard
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			//assert that library is displayed
//			int iCount=driver.findElements(By.xpath(elementslocator.getProperty("library"))).size();
//			Assert.assertTrue(iCount==1);
//			{
//				if(iCount==1){
//					//positive testing
//					Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("library"))).isDisplayed());
//					//negative testing
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("assets"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********assets is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("layout"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********layout is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("manage"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********manage is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********configuration is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********access is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("settings"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********setting is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("logs"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********log is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("workflow"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********workflow is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("localization"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********localization is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//					//under library module
//					driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					// assert that campaign is displayed
//					Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("campaigns"))).isDisplayed());
//					// assert that series is displayed
//					Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("series"))).isDisplayed());
//					// assert that tracks is displayed
//					Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("tracks"))).isDisplayed());
//					// assert that communications is displayed
//					Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("communications"))).isDisplayed());
//					// assert that messages is displayed
//					Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("messages"))).isDisplayed());
//					// assert that variables is displayed
//					Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("variables"))).isDisplayed());
//				}
//				else if(iCount==0)
//				{
//					try {
//						driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();					        
//					} catch (NoSuchElementException e) {
//						System.out.println("**********library is not displayed");
//					}
//					Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//				}
//				else{ throw new InvalidParameterException("verify the object's xpath");
//
//				}
//			}
//
//
//
//
//			//else if(role.equalsIgnoreCase("testrole3"))
//			{
//				//assert that page title is dashboard
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//				//assert that library is displayed
//				int iCount1=driver.findElements(By.xpath(elementslocator.getProperty("library"))).size();
//				Assert.assertTrue(iCount1==1);
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("library"))).isDisplayed());
//				//under library 
//				driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("custom_field"))).isDisplayed()); 
//				//assert that configuration pages are displayed
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("campaigns"))).isDisplayed());
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("series"))).isDisplayed());
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("tracks"))).isDisplayed());
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("communications"))).isDisplayed());
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("messages"))).isDisplayed());
//				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("variables"))).isDisplayed());
//			}
//			//assert that assets is displayed
//			int iCount1=driver.findElements(By.xpath(elementslocator.getProperty("assets"))).size();
//			Assert.assertTrue(iCount1==1);
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("assets"))).isDisplayed());
//			//under assets 
//			driver.findElement(By.xpath(elementslocator.getProperty("assets"))).click();
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("custom_field"))).isDisplayed()); 
//			//assert that configuration pages are displayed
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("media_gallery"))).isDisplayed());
//		}	
//		//assert that configuration is displayed
//		int iCount2=driver.findElements(By.xpath(elementslocator.getProperty("configuration"))).size();
//		Assert.assertTrue(iCount2==1);
//		if(iCount2==1){
//			//positive testing
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).isDisplayed());
//			//negative testing
//
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("layout"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********layout is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("manage"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********manage is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));	
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("access"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********access is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("settings"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********setting is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("logs"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********log is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("workflow"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********workflow is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("localization"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********localization is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//			//under library configuration
//			driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("custom_field"))).isDisplayed()); 
//			//assert that configuration pages are displayed
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("segement_groups"))).isDisplayed());
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("segments"))).isDisplayed());
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("targeting_criteria"))).isDisplayed());
//			Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("messages_type"))).isDisplayed());
//		}
//		else if(iCount2==0)
//		{
//			try {
//				driver.findElement(By.xpath(elementslocator.getProperty("configuration"))).click();					        
//			} catch (NoSuchElementException e) {
//				System.out.println("**********localization is not displayed");
//			}
//			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("dashboard_page_title"));
//		}
//
//		else{ throw new InvalidParameterException("verify the object's xpath");
//		}
//		return new permissionsControlPage(driver);
//		}
//		return null;
//
//	}
//
//
//
//
//		//pages validations
//		public permissionsControlPage permissionGranted(boolean answer, String pagename)
//		{
//			switch(pagename)
//			{
//			case"campaign add":
//			{
//				//assert that user cannot open campaign add page
//				driver.findElement(By.xpath(elementslocator.getProperty("campaigns"))).click();
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementslocator.getProperty("campaign_main_page"))));
//				driver.navigate().to(urls.getProperty("camp_add_page_url"));
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("coda_error"));
//				//navigate back to index page
//				driver.navigate().back();	
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementslocator.getProperty("campaign_main_page"))));
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("campaign_page_title"));
//				break;
//			}
//			case"campaign edit":
//			{
//				//assert that user cannot open campaign edit page
//				driver.navigate().to(urls.getProperty("camp_edit_page_url"));
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("coda_error"));
//				//navigate back to index page
//				driver.navigate().back();	
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementslocator.getProperty("campaign_main_page"))));
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("campaign_page_title"));
//				break;
//			}
//			case"campaign archive":
//			{
//				//assert that user cannot open campaign archive page
//				driver.navigate().to(urls.getProperty("camp_archive_page_url"));
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("coda_error"));
//				//navigate back to index page
//				driver.navigate().back();	
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementslocator.getProperty("campaign_main_page"))));
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("campaign_page_title"));
//				break;
//			}
//			case"campaign publish":
//			{
//				//assert that user cannot open campaign publish page
//				driver.navigate().to(urls.getProperty("camp_publish_page_url"));
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("coda_error"));
//				//navigate back to index page
//				driver.navigate().back();	
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementslocator.getProperty("campaign_main_page"))));
//				Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("campaign_page_title"));
//				break;
//			}
//			default:{ throw new InvalidParameterException("verify the object's xpath");
//			}
//			}
//			return new permissionsControlPage(driver);
//		}


	}