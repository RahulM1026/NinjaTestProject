package Npack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.qa.pages.AccountSuccess;
import com.ninja.qa.pages.Home;
import com.ninja.qa.pages.RegisterPage;
import com.ninja.utils.Utilities;

import Base.Basic;

public class RegisterTest extends Basic {

	public WebDriver driver;
	RegisterPage register;
	AccountSuccess success;

	public RegisterTest() {
		super();
	}
	
	@AfterMethod
	public void Close() {

		driver.quit();
	}

	@BeforeMethod
	public void Setup() {

		driver = Launch(prop.getProperty("browser"));  
	}

	@Test(priority = 1)
	public void RegisterWithFields() {
		
		Home home=new Home(driver);
		home.ClickOnAccount();
		register = home.ClickOnRegister();
		success= register.FillAllFields(dataprop.getProperty("Fname"), dataprop.getProperty("Lname"), Utilities.GenerateEmail(), dataprop.getProperty("phoneNumber"), dataprop.getProperty("password"), dataprop.getProperty("password"));
		String ActualHeading = success.SuccessInfo();
		Assert.assertEquals(ActualHeading,dataprop.getProperty("AccountSuccessCreation"), "Account Succes Page Not Displayed");

	}

	@Test(priority = 2)
	public void RegisterWithAllFields() {
		
		Home home=new Home(driver);
		home.ClickOnAccount();
		register = home.ClickOnRegister();
		success= register.FillAllFields(dataprop.getProperty("Fname"), dataprop.getProperty("Lname"), Utilities.GenerateEmail(), dataprop.getProperty("phoneNumber"), dataprop.getProperty("password"), dataprop.getProperty("password"));
		String ActualHeading = success.SuccessInfo();
		Assert.assertEquals(ActualHeading, dataprop.getProperty("AccountSuccessCreation"), "Account Succes Page Not Displayed");

	}

	@Test(priority = 3)
	public void RegisterWithoutFields() {

		Home home=new Home(driver);
		home.ClickOnAccount();
		register =  home.ClickOnRegister();
		register.Continue();
		String PrivacyWarning = register.PrivacyWarningInfo();
		Assert.assertTrue(PrivacyWarning.contains(dataprop.getProperty("privacyWarning")),"Privacy Warning is Not Displayed");
		String FnameWarning = register.FNameWarningInfo();
		Assert.assertTrue(FnameWarning.contains(dataprop.getProperty("FnameWarning")),"First name Warning is Not Displayed");
		String LnameWarning = register.LNameWarningInfo();
		Assert.assertTrue(LnameWarning.contains(dataprop.getProperty("LnameWarning")),"Last name Warning is Not Displayed");
		String EmailWarning = register.EmailWarningInfo();
		Assert.assertTrue(EmailWarning.contains(dataprop.getProperty("emailWarning")),"Email Warning is Not Displayed");
		String TeleWarning = register.PhoneNumWarningInfo();
		Assert.assertTrue(TeleWarning.contains(dataprop.getProperty("PhoneWarning")),"Telephone Warning is Not Displayed");
		String passwordWarning = register.PasswordWarningInfo();
		Assert.assertTrue(passwordWarning.contains(dataprop.getProperty("PasswordWarning")),"Password Warning is Not Displayed");

	}

}
