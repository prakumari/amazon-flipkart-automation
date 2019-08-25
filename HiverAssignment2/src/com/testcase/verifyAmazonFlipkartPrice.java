package com.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.amazon.pages.AmazonPage;
import com.amazon.pages.FlipkartPage;

public class verifyAmazonFlipkartPrice {

	@Test
	public void amazonFlipkart_PriceComparison() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		String winParent = driver.getWindowHandle();

		AmazonPage amazon = new AmazonPage(driver);

		amazon.searchProduct();
		amazon.clickSearchButton();
		Thread.sleep(8000);
		amazon.selectProduct();
		Thread.sleep(6000);
		amazon.switchNewWindow();
		amazon.clickAddtoCart();
		Thread.sleep(6000);
		String amazonAmount = amazon.fetchProductAmount();

		amazonAmount = amazonAmount.replaceAll(",", "");
		double Amazon_Amount = Double.parseDouble(amazonAmount);
		System.out.println("Amazon Product Price is: " + Amazon_Amount);
		// driver.quit();

		// Flipkart Logic
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		FlipkartPage flipkart = new FlipkartPage(driver);

		flipkart.closeLoginPopup();
		Thread.sleep(2000);
		flipkart.searchProduct();
		flipkart.clickSearchButton();
		Thread.sleep(5000);
		flipkart.clickSearchedMobile();
		Thread.sleep(5000);
		flipkart.switchNewWindow();
		flipkart.clickAddToCart();
		Thread.sleep(5000);
		String flipkartAmount = flipkart.fetchProductAmount();

		flipkartAmount = flipkartAmount.replaceAll(",", "");
		flipkartAmount = flipkartAmount.replaceAll("₹", "");
		double Flipkart_Amount = Double.parseDouble(flipkartAmount);
		System.out.println("Flipkart Product Price is: " + Flipkart_Amount);

		if (Amazon_Amount > Flipkart_Amount) {
			System.out.println("Flipkart offers better price: " + Flipkart_Amount);
		} else if (Amazon_Amount < Flipkart_Amount) {
			System.out.println("Amazon offers better price: " + Amazon_Amount);
		} else {
			System.out.println("Amazon and Flipkpart both offer same price: : " + Flipkart_Amount);
		}

		driver.quit();

	}

}
