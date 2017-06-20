package localization;

import org.testng.annotations.Test;

import Utility.TestBase;

public class Export_TestCases extends TestBase{

	@Test(priority=0,enabled=true)
	public void export_a_camapign_format_type_xlsx()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addCampaign("Booked_guest")
		.selectFormat("Microsoft Excel 2007+ (.xlsx)")
		.clickExport()
		.getTitle();
	}
	@Test(priority=1,enabled=true)
	public void export_a_camapign_format_type_xliff()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addCampaign("Booked_guest")
		.selectFormat("XLIFF 2.0")
		.clickExport()
		.getTitle();
	}
	@Test(priority=2,enabled=true)
	public void export_a_series_format_type_xlsx()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addSeries("Opt_in")
		.selectFormat("Microsoft Excel 2007+ (.xlsx)")
		.clickExport()
		.getTitle();
	}
	@Test(priority=3,enabled=true)
	public void export_a_series_format_type_xliff()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addSeries("Opt_in")
		.selectFormat("XLIFF 2.0")
		.clickExport()
		.getTitle();
	}
	@Test(priority=4,enabled=true)
	public void export_a_track_format_type_xlsx()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addTrack("TrackI1")
		.selectFormat("Microsoft Excel 2007+ (.xlsx)")
		.clickExport()
		.getTitle();
	}
	@Test(priority=5,enabled=true)
	public void export_a_track_format_type_xliff()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addTrack("TrackI1")
		.selectFormat("XLIFF 2.0")
		.clickExport()
		.getTitle();
	}
	@Test(priority=6,enabled=true)
	public void export_a_communication_format_type_xlsx()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addCommunication("Email I1.1")
		.selectFormat("Microsoft Excel 2007+ (.xlsx)")
		.clickExport()
		.getTitle();
	}
	@Test(priority=7,enabled=true)
	public void export_a_communication_format_type_xliff()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addCommunication("Email I1.1")
		.selectFormat("XLIFF 2.0")
		.clickExport()
		.getTitle();
	}
	@Test(priority=8,enabled=true)
	public void export_a_message_format_type_xlsx()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addMessage("Footer1")
		.selectFormat("Microsoft Excel 2007+ (.xlsx)")
		.clickExport()
		.getTitle();
	}
	@Test(priority=9,enabled=true)
	public void export_a_message_format_type_xliff()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addMessage("Footer1")
		.selectFormat("XLIFF 2.0")
		.clickExport()
		.getTitle();
	}
	@Test(priority=10,enabled=true)
	public void export_a_media_gallery_format_type_xlsx()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addMediaGallery("Cclnon15035 cta banner")
		.selectFormat("Microsoft Excel 2007+ (.xlsx)")
		.clickExport()
		.getTitle();
	}
	@Test(priority=11,enabled=true)
	public void export_a_media_gallery_format_type_xliff()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.addClient("Carnival Corporation & PLC")
		.addMediaGallery("Cclnon15035 cta banner")
		.selectFormat("XLIFF 2.0")
		.clickExport()
		.getTitle();
	}
	@Test(priority=12,enabled=true)
	public void campaign_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.isDisabled("campaign")
		.getTitle()
		.logout();
	}
	@Test(priority=13,enabled=true)
	public void series_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.isDisabled("series")
		.getTitle()
		.logout();
	}
	@Test(priority=14,enabled=true)
	public void track_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.isDisabled("track")
		.getTitle()
		.logout();
	}
	@Test(priority=15,enabled=true)
	public void communication_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.isDisabled("communication")
		.getTitle()
		.logout();
	}
	@Test(priority=16,enabled=true)
	public void message_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.isDisabled("message")
		.getTitle()
		.logout();
	}
	@Test(priority=17,enabled=true)
	public void media_gallery_field_is_greyed_out_when_client_is_not_selected()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.isDisabled("media gallery")
		.getTitle()
		.logout();
	}
	@Test(priority=18,enabled=true)
	public void click_export_with_empty_fields()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickLocalesExport()
		.failToExport()
		.getTitle()
		.logout();
	}
}