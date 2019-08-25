/**
 * 
 */
package com.flipkart.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
		WebDriver driver;
		
		By username= By.xpath("//span[contains(text(),'Enter Email')]//parent::label/preceding-sibling::input");
		By password= By.xpath("//span[contains(text(),'Enter Password')]//parent::label/preceding-sibling::input");
		By loginButton= By.xpath("//button//span[contains(text(),'Login')]");
		By closeButton= By.xpath("//span[contains(text(),'Login')]/ancestor::div/div/div/button");
	 
	   public LoginPage(WebDriver driver) {
		   this.driver= driver;
	   }
	   
	   public void closeLoginPopou() {
		   driver.findElement(closeButton).click();
	   }
	  
	   
	   //Uncomment below code for login functionality
	   
	/* public void enterUsername() {
		   driver.findElement(username).sendKeys("9090909090");
	   }
	   
	   public void enterPassword() {
		   driver.findElement(password).sendKeys("@Qwerty");
	   }
	   
	   public void clickSubmit() {
		   driver.findElement(loginButton).click();
	   }*/

}
