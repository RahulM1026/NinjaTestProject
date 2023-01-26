package Npack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.qa.pages.Home;
import com.ninja.qa.pages.LoginPage;
import com.ninja.qa.pages.ProductPage;
import com.ninja.qa.pages.SearchPage;
import com.ninja.qa.pages.ShoppingCartPage;

import Base.Basic;

public class AddToCartTest extends Basic {

	public WebDriver driver;
	LoginPage login;
	SearchPage searchpage;
	ProductPage product;
	LoginTest Login;
	Home home;
	ShoppingCartPage Cart;
	
	public AddToCartTest() {

		super();
	}

	@BeforeMethod
	public void Setup() {

		driver = Launch(prop.getProperty("browser"));
		home = new Home(driver);
		home.ClickOnAccount();
		login = home.ClickOnLogin();
		login.EmailAddress(prop.getProperty("email"));
		login.PasswordBox(prop.getProperty("password"));
		login.LoginButton();
		home.Search(dataprop.getProperty("ValidProduct"));
		searchpage = home.ClickOnSearchButton();
	}

	@AfterMethod
	public void closing() {

		driver.quit();
	}

	@Test(priority=1)
	public void AddToCartProductBySearch() {

		product =searchpage.ProductSearched();
		product.QuantityNum();
		product.AddCart();		
		product.ClickOnShoppingCartBtn();
		Cart = new ShoppingCartPage(driver);
		Cart.ClickOnShippingAddress();
		Cart.SelectZoneField();
		Cart.ClickOnShipping();
		Assert.assertTrue(Cart.EstimateInformation());
	}
	
	@Test(priority=2)
	public void AddToCartBySelectProduct() {
		
		home = new Home(driver);
		searchpage = home.ClickOnProduct();
		product = searchpage.ProductSelected();
		product.CLickToAddWishlist();
		product.AddCart();
		Cart = product.CartBtn();
		Cart.ClickOnShippingAddress();
		Cart.SelectZoneField();
		Cart.ClickOnShipping();
		Assert.assertTrue(Cart.EstimateInformation());
	}
	
	
	
}
