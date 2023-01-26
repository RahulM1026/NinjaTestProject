package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement MyAccount;

	@FindBy(linkText = "Login")
	private WebElement Login;

	@FindBy(linkText = "Register")
	private WebElement Register;
	
	@FindBy(name="search")
	private WebElement SearchField;

	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement SearchBtn;
	
	@FindBy(linkText = "Cameras")
	private WebElement producttext;

	public Home(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void ClickOnAccount() {

		MyAccount.click();
	}

	public LoginPage ClickOnLogin() {

		Login.click();
		return new LoginPage(driver);
	}

	public RegisterPage ClickOnRegister() {

		Register.click();
		return new RegisterPage(driver);
	}
	
	public void Search(String Product) {

		SearchField.sendKeys(Product);
	}

	public SearchPage ClickOnSearchButton() {

		SearchBtn.click();
		return new SearchPage(driver);
	}
	
	public SearchPage ClickOnProduct() {
		
		producttext.click();
		return new SearchPage(driver);
	}

}
