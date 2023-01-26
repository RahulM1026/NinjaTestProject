package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

	WebDriver driver;
	Select sel;
	
	@FindBy(xpath = "//body/div[@id='checkout-cart']/div[2]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")
	private WebElement shippingAddres;
	
	@FindBy(id = "input-country")
	private WebElement SelectCountry;
	
	@FindBy(id = "input-zone")
	private WebElement SelectZone;
	
	@FindBy(id = "button-quote")
	private WebElement qoute;
	
	@FindBy(name = "shipping_method")
	private WebElement radio;
	
	@FindBy(id = "button-shipping")
	private WebElement shippingBtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement EstimateInfo;
	
	public ShoppingCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickOnShippingAddress() {
		
		shippingAddres.click();
		SelectCountry.click();
		sel = new Select(SelectCountry);
		sel.selectByValue("99");
	}
	
	
	
	public void SelectZoneField() {
		
		SelectZone.click();
		sel = new Select(SelectZone);
		sel.selectByValue("1489");
	}
	
	public void ClickOnShipping() {
		
		qoute.click();
		radio.click();
		shippingBtn.click();
	}
	
	public boolean EstimateInformation() {
		
		boolean Estinfo = EstimateInfo.isDisplayed();
		return Estinfo;
	}
}
