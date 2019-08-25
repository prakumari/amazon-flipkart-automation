package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartPage {
	
WebDriver driver;
	
	String searchText = "iPhone 7 32 gb(black)";	
	By closeButton_LoginPopup= By.xpath("//span[contains(text(),'Login')]/ancestor::div/div/div/button"); 
	By searchInputField = By.xpath("//input[@title='Search for products, brands and more']");
	By searchButton = By.xpath("//button[@type='submit']");
	By searchedMobile = By.xpath("//div[contains(text(),'iPhone 7')] [contains(text(),'32 GB')][contains(text(),'Black')][not(contains(text(),'Plus'))][not(contains(text(),'Jet'))]");	
	By addToCartButton = By.xpath("//li/button");
	By totalPayablePrice = By.xpath("//div[contains(text(),'Total Payable')]/span");
	
	public FlipkartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	 public void closeLoginPopup() {
		   driver.findElement(closeButton_LoginPopup).click();
	   }
	 
	 public void searchProduct() {
		 driver.findElement(searchInputField).sendKeys(searchText);
	 }
	
	 public void clickSearchButton() {
		 driver.findElement(searchButton).click();
	 }
	 
	 public void clickSearchedMobile() {
		 driver.findElement(searchedMobile).click();
	 }
	 
	public void switchNewWindow() {
		for(String winHandle: driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void clickAddToCart() {
		driver.findElement(addToCartButton).click();
	}
	
	public String fetchProductAmount() {
		String flipkartAmount= driver.findElement(totalPayablePrice).getText();
		return flipkartAmount;
	}
	

}
