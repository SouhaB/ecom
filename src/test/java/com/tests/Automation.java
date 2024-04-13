package com.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Automation {
	public static WebDriver driver;

	@BeforeSuite
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	//@Test(priority = 4)
	public void deleteAccount() {
		WebElement deleteAccountButton = driver.findElement(By.xpath("//*[contains(text(), ' Delete Account')]"));
		deleteAccountButton.click();		
		WebElement accountDeleteHeader = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));
		assertEquals(accountDeleteHeader.isDisplayed(), true, "It's not displayed");
		WebElement continueButton = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
		continueButton.click();		
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
