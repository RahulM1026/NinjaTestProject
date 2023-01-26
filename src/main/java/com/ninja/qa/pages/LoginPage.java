package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement EmailAds; 
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement EmailWarningMsg;
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void EmailAddress(String emailText) {
		
		EmailAds.sendKeys(emailText);
	}
	
	public void PasswordBox(String passwordtext) {
		
		PasswordField.sendKeys(passwordtext);
	}
	
	public AccountPage LoginButton() {
		
		LoginBtn.click();
		return new AccountPage(driver);
	}
	
	public String EmailWarning() {
		
		String EmailWarnText=EmailWarningMsg.getText();
		return EmailWarnText;
	}
}
