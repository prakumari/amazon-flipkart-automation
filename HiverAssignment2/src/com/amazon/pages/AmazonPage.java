package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AmazonPage {
	WebDriver driver;
	
	String searchText = "iPhone 7 32 gb(black)";
	By searchField = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchButton = By.xpath("//span[contains(text(),'Go')]/following-sibling::input[@type='submit']");
	By iPhoneLink = By.xpath("//span[contains(text(),'iPhone 7 (32GB) - Black')]");
	By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");	
	By cartAmount = By.xpath("(//span/b[contains(text(),'Cart subtotal')]/parent::span/following-sibling::span/span)[1]");
			
	
	public AmazonPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct() {
		driver.findElement(searchField).sendKeys(searchText);
	}
	
	public void switchNewWindow() {
		for(String winHandle: driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void selectProduct() {
		driver.findElement(iPhoneLink).click();
	}
	
	public void clickAddtoCart() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(addToCartButton));
	//	driver.findElement(addToCartButton).click();
	}
	
	public String fetchProductAmount() {
		String amazonAmount= driver.findElement(cartAmount).getText();
		return amazonAmount;
	}
}
