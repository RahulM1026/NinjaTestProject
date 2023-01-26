package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement FirstName;

	@FindBy(id = "input-lastname")
	private WebElement LastName;

	@FindBy(id = "input-email")
	private WebElement Email;

	@FindBy(id = "input-telephone")
	private WebElement Phone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirm;

	@FindBy(name = "agree")
	private WebElement checkbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement ContinueBtn;

	@FindBy(xpath = "//input[@value='1' and @name='newsletter']")
	private WebElement NewsletterBtn;
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement PrivacyWarning;
	
	@FindBy(xpath ="//input[@id='input-firstname']//following-sibling::div")
	private WebElement FirstNameWarning;
	
	@FindBy(xpath ="//input[@id='input-lastname']//following-sibling::div")
	private WebElement LastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement EmailWarning;
	
	@FindBy(xpath ="//input[@id='input-telephone']//following-sibling::div")
	private WebElement PhoneNumWarning;
	
	@FindBy(xpath ="//input[@id='input-password']//following-sibling::div")
	private WebElement PasswordWarning;
	
	

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public AccountSuccess FillMandatoryFields(String Fname,String Lname,String email,String phoneNum,String passWord,String Cpass) {
		
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Email.sendKeys(email);
		Phone.sendKeys(phoneNum);
		password.sendKeys(passWord);
		confirm.sendKeys(Cpass);
		checkbox.click();
		ContinueBtn.click();
		return new AccountSuccess(driver);
		
	}
	
	public AccountSuccess FillAllFields(String Fname,String Lname,String email,String phoneNum,String passWord,String Cpass) {
		
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Email.sendKeys(email);
		Phone.sendKeys(phoneNum);
		password.sendKeys(passWord);
		confirm.sendKeys(Cpass);
		NewsletterBtn.click();
		checkbox.click();
		ContinueBtn.click();
		return new AccountSuccess(driver);
		
		
	}

	public AccountSuccess Continue() {
		
		ContinueBtn.click();
		return new AccountSuccess(driver);
	}
	
	
	public String PrivacyWarningInfo() {
		
		String PrivacyPolicy = PrivacyWarning.getText();
		return PrivacyPolicy;
	}
	
	public String FNameWarningInfo() {
		
		String Firstname = FirstNameWarning.getText();
		return Firstname;
	}
	
	public String LNameWarningInfo() {
		
		String LastName = LastNameWarning.getText();
		return LastName;
	}
	
	public String EmailWarningInfo() {
		
		String EmailWarningText = EmailWarning.getText();
		return EmailWarningText;
	}
	
	public String PhoneNumWarningInfo() {
		
		String PhoneNum = PhoneNumWarning.getText();
		return PhoneNum;
	}
	
	public String PasswordWarningInfo() {
		
		String Password = PasswordWarning.getText();
		return Password;
	}
	

}
