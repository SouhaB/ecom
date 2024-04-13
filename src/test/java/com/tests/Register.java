package com.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Register extends Automation {
	
	@Parameters({"email", "username", "existingIdentifiers"})
	@Test(priority = 1)
	public void signUp(String email, String username, Boolean existingIdentifiers) {
		WebElement signUpButton = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
		signUpButton.click();
		WebElement signUpHeader = driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]"));
		assertEquals(signUpHeader.isDisplayed(), true, "It's not displayed");
		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys(username);
		WebElement emailInput = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
		emailInput.sendKeys(email);
		WebElement signUpFormButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
		signUpFormButton.click();
		if (existingIdentifiers) {
			WebElement createAccountError = driver.findElement(By.xpath("//*[contains(text(),'Email Address already exist!')]"));
			assertEquals(createAccountError.isDisplayed(), true, "It's not displayed");
		} else {
			WebElement createAccountHeader = driver.findElement(By.xpath("//*[contains(text(),'Enter Account Information')]"));
			assertEquals(createAccountHeader.isDisplayed(), true, "It's not displayed");
		}
	}
	
	@Parameters({"password"})
	@Test(priority = 2)
	public void createAccount(String password) {
		WebElement gender = driver.findElement(By.id("id_gender2"));
		gender.click();
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		Select selectDay = new Select(driver.findElement(By.id("days")));
		selectDay.selectByValue("5");
		Select selectMonth = new Select(driver.findElement(By.id("months")));
		selectMonth.selectByValue("2");
		Select selectYear = new Select(driver.findElement(By.id("years")));
		selectYear.selectByValue("1990");
		WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
		newsletterCheckbox.click();
		WebElement offersCheckbox = driver.findElement(By.id("optin"));
		offersCheckbox.click();
	}
	
	@Parameters({"username"})
	@Test(priority = 3)
	public void addressInformation(String username) {
		WebElement firstNameInput = driver.findElement(By.id("first_name"));
		firstNameInput.sendKeys("Test");
		WebElement lastNameInput = driver.findElement(By.id("last_name"));
		lastNameInput.sendKeys("Admin");
		WebElement companyInput = driver.findElement(By.id("company"));
		companyInput.sendKeys("Test Automation");
		WebElement addressInput = driver.findElement(By.id("address1"));
		addressInput.sendKeys("1 St Test");
		Select selectCountry = new Select(driver.findElement(By.id("country")));
		selectCountry.selectByValue("Singapore");
		WebElement stateInput = driver.findElement(By.id("state"));
		stateInput.sendKeys("State");
		WebElement cityInput = driver.findElement(By.id("city"));
		cityInput.sendKeys("City");
		WebElement zipcodeInput = driver.findElement(By.id("zipcode"));
		zipcodeInput.sendKeys("123");
		WebElement mobileNumberInput = driver.findElement(By.id("mobile_number"));
		mobileNumberInput.sendKeys("98235123");	
		WebElement createAccountButton = driver.findElement(By.xpath("//*[@data-qa='create-account']"));
		createAccountButton.click();
		WebElement accountCreatedHeader = driver.findElement(By.xpath("//*[contains(text(),'Account Created!')]"));
		assertEquals(accountCreatedHeader.isDisplayed(), true, "It's not displayed");
		WebElement continueButton = driver.findElement(By.xpath("//*[@data-qa='continue-button']"));
		continueButton.click();
		WebElement loggedAs = driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]"));
		assertEquals(loggedAs.getText(), "Logged in as " + username, "It's not displayed");
		 
	}
}
