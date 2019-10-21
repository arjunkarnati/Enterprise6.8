package login;

import Utility.PageBase;
import access.*;
import assets.MediaGalleryPage;
import configuration.*;
import layout.RegionsPage;
import layout.TemplatesPage;
import library.*;
import localization.ExportPage;
import localization.ImportPage;
import localization.LocalesPage;
import logs.SessionsPage;
import manage.BrandsPage;
import manage.ClientsPage;
import manage.ProgramsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import settings.ChannelsPage;
import settings.ConnectorsPage;
import settings.WorkflowManagerPage;
import settings.WorkflowStatePage;

import java.security.InvalidParameterException;

/*this page inherit page base class*/
public class DashboardPage extends PageBase{
	WebDriverWait wait = new WebDriverWait(driver, 30); 

	/*constructor*/
	public DashboardPage(WebDriver driver) 
	{
		super(driver);
	}
	/*isSuccessfulLogin method*/
	public DashboardPage isSuccessfulLogin(String username)
	{
		readconfig(); 
		waitForAjax(driver);
		String text=driver.findElement(By.xpath(elementslocator.getProperty("profile"))).getText();
		if (text.equalsIgnoreCase(username))
		{	
			System.out.println("******* User : "+text+" is logged in ");
		}
		else if(!text.equalsIgnoreCase(username)) 
		{
			System.out.println("**Login fail");
		}
		else
		{
			System.out.println("** Login error");
		}
		//comparing expected username and actual username
		Assert.assertEquals(text, username);
		return new DashboardPage(driver);
	}
	//logout
	public LoginPage testLogout()
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("logoutdrop"))).click();
		waitForAjax(driver);
		driver.findElement(By.xpath(elementslocator.getProperty("logout"))).click();
		waitForAjax(driver);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("login_page_title"));
		return new LoginPage(driver);
	}
	//login with invalid or empty credentials fail
	public LoginPage failLogin(String username, String password)
	{
		readconfig(); 
		waitForAjax(driver);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(elementslocator.getProperty("login_page_title")));
		return new LoginPage(driver);
	}
	/*open campaign page*/
	public CampaignPage clickCampaignsLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("campaigns"))));	
		driver.findElement(By.xpath(elementslocator.getProperty("campaigns"))).click();
		waitForAjax(driver);
		//assert that system navigates in campaigns page
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
		waitForAjax(driver);
		//assert that system navigates in series page
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
		waitForAjax(driver);
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
	//	waitForAjax(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datatable_filter")));
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
		//waitForAjax(driver);
		//assert that system naviagtes in messages page
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("mess_page_title"));
		return new MessagesPage(driver);
	}
	
	public VariablesPage clickVariablesLink() 
	{
		readconfig(); 
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("variables"))));
		driver.findElement(By.xpath(elementslocator.getProperty("variables"))).click();
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
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
		waitForAjax(driver);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("acf_page_title"));
		return new ACFPage(driver);
	}
	//open sysem configuration page	
	public SystemConfigurationPage clickSystemConfiguration() 
	{
		readconfig(); 
		driver.findElement(By.xpath(dashboard.getProperty("sys_configuration_button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboard.getProperty("sys_config_automatic_submit"))));
		waitForAjax(driver);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),dashboard.getProperty("sys_configuration_page_title"));
		return new SystemConfigurationPage(driver);
	}
	/*client context*/
	//client dropdown
	public DashboardPage selectClient(String client) 
	{
		readconfig();
		driver.findElement(By.id(elementslocator.getProperty("select_client"))).click();
		if(client.equalsIgnoreCase("kia"))
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("kia"))).click();
			waitForAjax(driver);
			Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("select_client"))).getText(),"kia KIA");
		}
		else if(client.equalsIgnoreCase("all clients"))
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("all_client"))).click();
			waitForAjax(driver);
			Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("select_client"))).getText(),"All Clients");
		}
		else if(client.equalsIgnoreCase("Carnival Corporation & PLC"))
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("carnival"))).click();
			waitForAjax(driver);
			Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("select_client"))).getText(),"Carnival Corporation & PLC CCL");
		}
		else if(client.equalsIgnoreCase("dupont")) 
		{
			driver.findElement(By.xpath(test_data_reader.getProperty("dupont"))).click();
			waitForAjax(driver);
			Assert.assertEquals(driver.findElement(By.id(elementslocator.getProperty("select_client"))).getText(),"DuPont DUP");
		}
		else
		{
			throw new InvalidParameterException(client+" is not a valid client. ref automation doc client page");
		}
		return new DashboardPage(driver);
	}
	public void clickonprofilelink() {
		// TODO Auto-generated method stub
		{
			readconfig(); 
			driver.findElement(By.xpath(elementslocator.getProperty("profile"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("myprofile"))));
			driver.findElement(By.xpath(elementslocator.getProperty("myprofile"))).click();
			driver.findElement(By.xpath(elementslocator.getProperty("preferences"))).click();
			waitForAjax(driver);
			//assert and verify
			Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("profile_page_title"));
		}
	}
	public ContentcodeAddpage clickonContentcodes() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("library"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("contentcode"))));
		driver.findElement(By.xpath(elementslocator.getProperty("contentcode"))).click();
		
		waitForAjax(driver);
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("contentcode_page_title"));
		return new  ContentcodeAddpage(driver);
		
	}
	public TemplatesPage edit_own_profile() {
		// TODO Auto-generated method stub
		readconfig();
		driver.findElement(By.xpath(elementslocator.getProperty("profile"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementslocator.getProperty("myprofile"))));
		driver.findElement(By.xpath(elementslocator.getProperty("myprofile"))).click();
		driver.findElement(By.xpath(elementslocator.getProperty("preferences"))).click();
		waitForAjax(driver);
		//assert and verify
		Assert.assertEquals(driver.getTitle(),elementslocator.getProperty("profile_page_title"));
		driver.findElement(By.xpath(elementslocator.getProperty("Search_by_column_yes"))).click();
		
		return new TemplatesPage(driver);
	}
	
	
}