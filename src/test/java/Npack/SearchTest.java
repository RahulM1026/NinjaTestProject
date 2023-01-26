package Npack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.qa.pages.Home;
import com.ninja.qa.pages.SearchPage;

import Base.Basic;

public class SearchTest extends Basic {

	public WebDriver driver;
	SearchPage searchpage;

	@AfterMethod
	public void Close() {

		driver.quit();
	}

	@BeforeMethod
	public void Setup() {

		driver = Launch(prop.getProperty("browser"));
	}

	@Test(priority=1)
	public void SearchValidProduct() {
		
		Home home = new Home(driver);
		home.Search(dataprop.getProperty("ValidProduct"));
		searchpage = home.ClickOnSearchButton();
		
		Assert.assertTrue(searchpage.TextInfo());
	}

	@Test(priority=2)
	public void SearchInValidProduct() {

		Home home = new Home(driver);
		home.Search(dataprop.getProperty("ValidProduct"));
		searchpage = home.ClickOnSearchButton();
		
		String ActuaText= searchpage.ProductInfo();
		Assert.assertEquals(ActuaText,dataprop.getProperty("NoProductWarning"),"No Product in Search Results");
		
	}
	
	@Test(priority=3)
	public void SearchNoProduct() {
		Home home = new Home(driver);
		home.Search(dataprop.getProperty("ValidProduct"));
		searchpage = home.ClickOnSearchButton();
		
		String ActuaText= searchpage.ProductInfo();
		Assert.assertEquals(ActuaText,dataprop.getProperty("NoProductWarning"),"No Product in Search Results");
	}

}
