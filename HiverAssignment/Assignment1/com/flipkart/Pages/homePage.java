/**
 * 
 */
package com.flipkart.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;


public class homePage {
	
	WebDriver driver;
	
	String searchText = "Pixel 3a | 3a XL";
	By electronicTab = By.xpath("//span[contains(text(),'Electronics')]//parent::li");
	By listMobilesElements = By.xpath("(//a[contains(text(),'Mobiles')])[1]//..//parent::ul/li/a");
	By firstMobile = By.xpath("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
	By addToCartButton = By.xpath("//li/button");
	By incrementItemButton = By.xpath("//div/div[contains(text(),'Save for later')]/parent::div/preceding-sibling::div//button[2]");
	By totalPayablePrice = By.xpath("//div[contains(text(),'Total Payable')]/span");
	
	
	public homePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void mouseoverElectronics() {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(electronicTab)).build().perform();
	}
	
	public void selectPixel3AMobile() {
		List<WebElement> allMobiles = driver.findElements(listMobilesElements);				
		for ( WebElement we: allMobiles) { 			 			 	
		        if ( we.getText().equalsIgnoreCase(searchText)) {		        	
		        	we.click();
		        }
		    }		
		}
	
	public void clickOnFirstMobile() {		
		driver.findElement(firstMobile).click();		
	}
	
	public void switchNewWindow() {
		for(String winHandle: driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
	public void clickAddToCartButton(){
		driver.findElement(addToCartButton).click();
	}
	
	public void incrementItemClick() {
		driver.findElement(incrementItemButton).click();
	}
	
	public void getTotalPayablePrice() {
		String tot_PayablePrice = driver.findElement(totalPayablePrice).getText();
		System.out.println("Total Payable Price is: "+tot_PayablePrice);
	}
	
}
