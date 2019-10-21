package assets;

import Utility.PageBase;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

public class MediaGalleryEditPage extends PageBase {

	public MediaGalleryEditPage(WebDriver driver) 
	{
		super(driver);
	}
	//update client name in client field
	public MediaGalleryEditPage updateClientNameTo(String newclientname)
	{
		readconfig();
		driver.findElement(By.id(assets.getProperty("med_gallery_edit_client"))).click();
		driver.findElement(By.id(assets.getProperty("med_gallery_edit_client_search_field"))).sendKeys(newclientname);
		driver.findElement(By.id(assets.getProperty("med_gallery_edit_client_search_field"))).sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		//return media gallery add page
		return new MediaGalleryEditPage(driver);
	}
	//update the brand
	public MediaGalleryEditPage UpdateBrandTo(String newbrandname) 
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_brand"))).sendKeys(newbrandname);
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_brand"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_brand"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		//return media gallery edit page
		return new MediaGalleryEditPage(driver);
	}
	//update description in description field
	public MediaGalleryEditPage updateDescription(String description)
	{
		readconfig();
		driver.findElement(By.id(assets.getProperty("med_gallery_edit_description"))).clear();
		driver.findElement(By.id(assets.getProperty("med_gallery_edit_description"))).sendKeys(description);
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		//return media gallery edit page
		return new MediaGalleryEditPage(driver);				
	}
	//select a program
	public MediaGalleryEditPage updateProgramTo(String newprogramname)
	{		
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_program"))).sendKeys(newprogramname);
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_program"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_program"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		//return media gallery edit page
		return new MediaGalleryEditPage(driver);
	}
	//update media gallery name in name field
	public MediaGalleryEditPage updateImageName(String newimagename)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_name"))).clear();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_name"))).sendKeys(newimagename);
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		//return media galllery add page
		return new MediaGalleryEditPage(driver);
	}	
	//update media gallery name in name field
	public MediaGalleryEditPage updateAltTag(String alttag)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_alt_tag"))).clear();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_alt_tag"))).sendKeys(alttag);
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		//return media galllery add page
		return new MediaGalleryEditPage(driver);
	}	
	//update connectors
	public MediaGalleryEditPage updateConnector(String newconnectorname)
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_connector"))).sendKeys(newconnectorname);
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_connector"))).sendKeys(Keys.ENTER);
		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_connector"))).isEnabled());
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		//return media gallery edit page
		return new MediaGalleryEditPage(driver);
	}
	//set workflow to
	public MediaGalleryPage setWorkFlowTo(String workflowname, String mediagalleryname)
	{
		readconfig();
		switch(workflowname)
		{
		case "DRAFT":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_edit_workflow"))).sendKeys("D");
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "APPROVED":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_edit_workflow"))).sendKeys("A");
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "Qatest1":
		{
			driver.findElement(By.id(assets.getProperty("med_gallery_edit_workflow"))).sendKeys("Q");
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_submit"))).click();
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("Please verify the workflow name");
		}
		}
		return new MediaGalleryPage(driver);
	}
	//activate and inactivate series
	public MediaGalleryEditPage isActive(boolean answer)
	{  
		readconfig();
		//no
		if(answer==false)
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_status_inactive"))).click();
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		}	
		//yes
		else if(answer==true)
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_status_active"))).click();
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		}
		else
		{
			throw new InvalidParameterException("answer "+answer +" is not supported, ref automation doc page.");
		}
		return new MediaGalleryEditPage(driver);
	}
	//remove entries in program field
	public MediaGalleryEditPage deleteEntryInProgramField()
	{
		readconfig();
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(assets.getProperty("med_gallery_edit_program_number"))).size();
		System.out.println("**program: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_program"))).sendKeys(Keys.BACK_SPACE);
		}
		//return series edit page
		return new MediaGalleryEditPage(driver);
	}

	//remove entries in brand field
	public MediaGalleryEditPage deleteEntryInBrandField()
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(assets.getProperty("med_gallery_edit_brand_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_brand"))).sendKeys(Keys.BACK_SPACE);
		}
		//return series edit page
		return new MediaGalleryEditPage(driver);
	}
	//remove entries in brand field
	public MediaGalleryEditPage deleteEntryInConnectorField()
	{
		readconfig();	
		//counting the number of entry in the field
		int iCount = driver.findElements(By.xpath(assets.getProperty("med_gallery_edit_connector_number"))).size();
		System.out.println("**brand: "+iCount);
		for (int i=0; i<iCount;i++)
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_connector"))).sendKeys(Keys.BACK_SPACE);
		}
		//return series edit page
		return new MediaGalleryEditPage(driver);
	}
	//click submit button
	public MediaGalleryPage clickSubmitButton()
	{
		readconfig();
		WebElement ele =driver.findElement(By.xpath(".//*[@id='btnSubmit']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		//driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assert and verify
	//	Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
		return new MediaGalleryPage(driver);
	}
	//click cancel button
	public MediaGalleryEditPage clickCancelButton()
	{
		readconfig();
		driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_cancel"))).click();
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
		//assert and verify
		return new MediaGalleryEditPage(driver);
	}
	//upload image
	public MediaGalleryAddPage updateImage(String imagename) 
	{	
		readconfig();
		switch(imagename)
		{
		case "selenium01":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium01.png");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium02":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium02.png");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium03":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium03.jpg");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium04":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium04.png");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium05":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium05.png");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium06":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium06.jpg");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium07":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium07.jpg");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium08":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium08.png");
			//assert and verify
		//	Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium09":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium09.jpg");
			//assert and verify
			//Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium10":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium10.jpg");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		case "selenium11":
		{
			driver.findElement(By.xpath(assets.getProperty("med_gallery_edit_file")))
			.sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\selenium11.jpg");
			//assert and verify
			Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_page_title"));
			break;
		}
		default: 
		{
			throw new InvalidParameterException("imagename "+imagename +" not found, please verify that the image exists in the path.");
		}
		}
		return new MediaGalleryAddPage(driver);
	}
	//click save for failed
	public MediaGalleryEditPage failToUpdate()
	{
		readconfig();
		driver.findElement(By.id(assets.getProperty("med_gallery_edit_submit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(),assets.getProperty("med_gallery_edit_page_title"));
		return new MediaGalleryEditPage(driver);
	}
	public MediaGalleryEditPage validatealttag(String language, String alttag) {
		// TODO Auto-generated method stub
		readconfig();
		switch(language){
		case "English":
		{
			driver.findElement(By.xpath(".//*[@id='lang-tabs']/li[1]/a")).click();
			try{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='MediaGallery_AltTag_1']")).getAttribute("value"), alttag);
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		}
		case "Germany":
		{
			
			driver.findElement(By.xpath(".//*[@id='lang-tabs']/li[2]/a")).click();
			try{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='MediaGallery_AltTag_7']")).getAttribute("value"), alttag);
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		}
		case "Spanish":
		{
			driver.findElement(By.xpath(".//*[@id='lang-tabs']/li[6]/a")).click();
			try{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='MediaGallery_AltTag_8']")).getAttribute("value"), alttag);
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		}
		}
		return new MediaGalleryEditPage(driver);
	}
	
}