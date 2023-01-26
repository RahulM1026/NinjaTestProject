package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	@FindBy(id = "input-quantity")
	private WebElement quantityNum;

	@FindBy(id = "button-cart")
	private WebElement AddCartBtn;
	
	@FindBy(id = "cart-total")
	private WebElement CartTotal;
	
	@FindBy(xpath = "//header/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]/strong[1]")
	private WebElement checkout;
	
	@FindBy(xpath = "//a[@title='Shopping Cart']")
	private WebElement shoppingCartBtn;
	
	@FindBy(xpath = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
	private WebElement wishlist;
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void QuantityNum() {

		quantityNum.clear();
		quantityNum.sendKeys("2");

	}

	public void AddCart() {

		AddCartBtn.click();
	}

	public ShoppingCartPage CartBtn() {
		
		CartTotal.click();
		checkout.click();
		return new ShoppingCartPage(driver);
	}
	
	public ShoppingCartPage ClickOnShoppingCartBtn() {
		
		shoppingCartBtn.click();
		return new ShoppingCartPage(driver);
		
	}
	
	public void CLickToAddWishlist() {
		
		wishlist.click();
	}

}
