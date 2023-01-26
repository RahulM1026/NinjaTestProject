package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	@FindBy(linkText = "Sony VAIO")
	private WebElement Textinfo;
	
	@FindBy(linkText = "iPhone")
	private WebElement Textinfo2;
	
	@FindBy(linkText = "Nikon D300")
	private WebElement Textinfo3;
		
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::h2")
	private WebElement NoProductInfo;
	
	

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String ProductInfo() {

		String Info = NoProductInfo.getText();
		return Info;
	}

	public boolean TextInfo() {

		boolean TextInformation = Textinfo.isDisplayed();
		return TextInformation;
	}
	
	public ProductPage ProductSearched() {

		Textinfo2.click();
		return new ProductPage(driver);
	}
	
	public ProductPage ProductSelected() {

		Textinfo3.click();
		return new ProductPage(driver);
	}
	

}
