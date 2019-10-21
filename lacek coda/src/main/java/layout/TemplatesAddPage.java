package layout;

import Utility.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TemplatesAddPage extends PageBase {

	public TemplatesAddPage(WebDriver driver) 
	{
		super(driver);	
	}
	//enter client name in client field
	public TemplatesAddPage addClientName(String clientname) 
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("template_add_client"))).click();
		driver.findElement(By.id(layout.getProperty("template_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(layout.getProperty("template_add_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		//return templates add page
		return new TemplatesAddPage(driver);
	}
	//select a brand
	public TemplatesAddPage addBrand(String brandname)
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("template_add_brand"))).sendKeys(brandname);
		driver.findElement(By.xpath(layout.getProperty("template_add_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(layout.getProperty("template_add_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		//return templates add page
		return new TemplatesAddPage(driver);
	}
	//select a channel
	public TemplatesAddPage addChannel(String channel)
	{
		readconfig();
		if(driver.findElement(By.xpath(layout.getProperty("template_add_channel"))).getText().equalsIgnoreCase(channel))
		{
			driver.findElement(By.xpath(layout.getProperty("template_add_submit"))).click();
			Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		}
		else
		{
			driver.findElement(By.xpath(layout.getProperty("template_add_channel"))).click();
			driver.findElement(By.xpath(layout.getProperty("template_add_channel_search_field"))).sendKeys(channel);
			driver.findElement(By.xpath(layout.getProperty("template_add_channel_search_field"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(layout.getProperty("template_add_channel"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		}
		//return templates add page
		return new TemplatesAddPage(driver);
	}
	//add template name
	public TemplatesAddPage addTemplateName(String templatename)
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("template_add_name"))).clear();
		driver.findElement(By.id(layout.getProperty("template_add_name"))).sendKeys(templatename);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		return new TemplatesAddPage(driver);
	}
	//select a type
	public TemplatesAddPage addType(String type)
	{
		readconfig();
		if(driver.findElement(By.xpath(layout.getProperty("template_add_type"))).getText().equalsIgnoreCase(type))
		{
			driver.findElement(By.xpath(layout.getProperty("template_add_cancel"))).click();
			Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		}
		else
		{
			driver.findElement(By.xpath(layout.getProperty("template_add_type"))).click();
			driver.findElement(By.xpath(layout.getProperty("template_add_type_search_field"))).sendKeys(type);
			driver.findElement(By.xpath(layout.getProperty("template_add_type_search_field"))).sendKeys(Keys.ENTER);
			//assert and verify
			Assert.assertTrue(driver.findElement(By.xpath(layout.getProperty("template_add_type"))).isEnabled());
			Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		}
		//return templates add page
		return new TemplatesAddPage(driver);
	}
	//add CSS
	public TemplatesAddPage addCss(String ccsvalue)
	{		
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("template_add_css"))).click();
		driver.findElement(By.xpath(layout.getProperty("template_add_type"))).sendKeys(ccsvalue);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		return new TemplatesAddPage(driver);
	}
	//add markup
	public TemplatesAddPage addMarkup(String markupvalue)
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("template_add_markup"))).click();
		driver.findElement(By.xpath(layout.getProperty("template_add_markup"))).sendKeys(markupvalue);
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		return new TemplatesAddPage(driver);
	}
	//click submit button in templates add page
	public TemplatesPage clickSubmitButton()
	{
		readconfig();
		driver.findElement(By.name(layout.getProperty("template_add_submit"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_page_title"));
		//return media templates
		return new TemplatesPage(driver);
	}
	//click cancel button in templates add page
	public TemplatesPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(layout.getProperty("template_add_cancel"))).click();
		//driver.switchTo().alert().accept();
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_page_title"));
		//return media templates
		return new TemplatesPage(driver);
	}
	//click save for failed
	public TemplatesAddPage failToCreate()
	{
		readconfig();
		driver.findElement(By.id(layout.getProperty("template_add_submit"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),layout.getProperty("template_add_page_title"));
		return new TemplatesAddPage(driver);
	}
}