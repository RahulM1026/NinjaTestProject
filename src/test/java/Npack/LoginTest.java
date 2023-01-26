package Npack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninja.qa.pages.AccountPage;
import com.ninja.qa.pages.Home;
import com.ninja.qa.pages.LoginPage;
import com.ninja.utils.Utilities;

import Base.Basic;

public class LoginTest extends Basic {
	
	public WebDriver driver;
	LoginPage login;
	AccountPage Accpage;
	
	public LoginTest() {
		
		super();
	}
	
	@AfterMethod
	public void Closing() {
		
		driver.quit();
	}
	
	@BeforeMethod
	public void Setup() {
		
		driver = Launch(prop.getProperty("browser"));
		Home home =new Home(driver);
		home.ClickOnAccount();
		login = home.ClickOnLogin();
	}
	
	@DataProvider(name="ValidInput")
	public Object[][] SupplyTestData(){
		Object[][] data = Utilities.GetTestData("Login");
		return data;
		
	}
	
	
	@Test(priority=1,dataProvider="ValidInput")
	public void Validinput(String email,String password) {
		
		login.EmailAddress(email);
		login.PasswordBox(password);
		Accpage = login.LoginButton();
		Accpage.DisplayInfo();
				
	}
	
	@Test(priority=2)
	public void InvalidInput() {
		
		login.EmailAddress(Utilities.GenerateEmail());
		login.PasswordBox(dataprop.getProperty("InvalidPassword"));
		login.LoginButton();
		
		String Actual= login.EmailWarning();
		String Expected = dataprop.getProperty("ExpectedWarning");
		
		Assert.assertTrue(Actual.contains(Expected),"Expected Warning message is Not Displayed");
	
	}
	
	@Test(priority=3)
	public void ValidMailInvalidPassword() {
		
		login.EmailAddress(prop.getProperty("email"));
		login.PasswordBox(dataprop.getProperty("InvalidPassword"));
		login.LoginButton();
		
		String Actual=login.EmailWarning();
		String Expected = dataprop.getProperty("ExpectedWarning");
		
		Assert.assertTrue(Actual.contains(Expected),"Expected Warning message is Not Displayed");
		
	}
	
	@Test(priority=4)
	public void InvalidMailValidPassword() {

		login.EmailAddress(Utilities.GenerateEmail());
		login.PasswordBox(prop.getProperty("password"));
		login.LoginButton();
		
		String Actual= login.EmailWarning();
		String Expected = dataprop.getProperty("ExpectedWarning");
		
		Assert.assertTrue(Actual.contains(Expected),"Expected Warning message is Not Displayed");
		
	}
	
	@Test(priority=5)
	public void LoginWithoutInput() {

		login.EmailAddress("");
		login.PasswordBox("");
		login.LoginButton();
		
		String Actual= login.EmailWarning();
		String Expected = dataprop.getProperty("ExpectedWarning");
		
		Assert.assertTrue(Actual.contains(Expected),"Expected Warning message is Not Displayed");
		
	}
	
	

}
