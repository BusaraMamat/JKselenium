package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utilities.BrowserUtilities;

public class Suzuki3 {
	/*
	 * Navigate to http://www.suzukicycles.com/ - Verify Title of the page - Verify
	 * “Suzuki” icon is present (highlighted in the picture)
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/busara/Documents/selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.suzukicycles.com");

		BrowserUtilities.verifyTitle(driver, "Suzuki Cycles");

		WebElement element = driver.findElement(By.id("suzuki"));
		BrowserUtilities.verifyElement(element);
		// Click on MOTORCYCLES
		WebElement motorcycles = driver.findElement(By.id("cycles"));
		BrowserUtilities.clickElement(motorcycles);
		// Click on 2016
		WebElement Year2016 = driver.findElement(By.id("body_0_rptYears_yearItem_2"));
		BrowserUtilities.clickElement(Year2016);
		// - Verify the text is “GSX-S750” (see highlighted picture)
		WebElement motoType = driver.findElement(By.id("body_0_rptCat_rptBike_3_lnkProductName_6"));
		BrowserUtilities.verifyText(motoType, "GSX-S750");
		// Click on the “GSX-S750” motorcycle
		WebElement gsx750 = driver.findElement(By.id("body_0_rptCat_rptBike_3_imgBike_6"));
		BrowserUtilities.clickElement(gsx750);

		// Verify “2016 GSX-S750” text is present
		WebElement GSX750 = driver.findElement(By.xpath("//*[@id=\"productOutline\"]/h1"));
		BrowserUtilities.verifyElement(GSX750);

		// Verify text “This model is not available in California.” is present
		WebElement california = driver.findElement(By.xpath("//*[@id=\"productOutline\"]/p"));
		BrowserUtilities.verifyText(california, "*This model is not available in California. ");
		// Click on the “Financing” tab
		WebElement financing = driver.findElement(By.id("FinancingLink"));
		BrowserUtilities.clickElement(financing);
		// Verify text “2016 GSX-S750 Financing” is present
		WebElement finance2016 = driver.findElement(
				By.cssSelector("#productFinancing > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)"));
		BrowserUtilities.verifyText(finance2016, "2016 GSX-S750 Financing");
		// Verify Base MSRP is “$7,999”
		WebElement baseMSRP = driver.findElement(
				By.cssSelector("#productFinancing > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)"));
		BrowserUtilities.verifyText(baseMSRP, "$7,999");

		driver.close();

	}
}