package com.flipkart.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.flipkart.Pages.LoginPage;
import com.flipkart.Pages.homePage;

public class verifyFlipkartLogin {
	
	@Test
	public void verifyFlipkartValidLogin() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);				
		String winParent = driver.getWindowHandle();
		
		LoginPage login = new LoginPage(driver);
		
		login.closeLoginPopou();
		Thread.sleep(8000);
		//Uncomment for login functionality
		/*login.enterUsername();
		login.enterPassword();
		login.clickSubmit();
		Thread.sleep(8000);*/
				
		homePage home = new homePage(driver);

		home.mouseoverElectronics();
		home.selectPixel3AMobile();
		Thread.sleep(8000);
		home.clickOnFirstMobile();
		Thread.sleep(8000);
		home.switchNewWindow();
		home.clickAddToCartButton();
		Thread.sleep(5000);
		home.incrementItemClick();
		Thread.sleep(5000);
		home.getTotalPayablePrice();
		
		driver.quit();
		
	}
	
}
