package com.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends Automation {
	
	@Parameters({"email","password", "username", "correctIdentifiers"})
	@Test(priority = 0)
	public void loginMeth(String email, String password, String username, Boolean correctIdentifiers) {
		WebElement signUpButton = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
		signUpButton.click();
		WebElement loginHeader = driver.findElement(By.xpath("//*[contains(text(),'Login to your account')]"));
		assertEquals(loginHeader.isDisplayed(), true, "It's not displayed");
		WebElement emailInput = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
		emailInput.sendKeys(email);		
		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys(password);		
		WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
		loginButton.click();
		if(correctIdentifiers) {
			WebElement loggedAs = driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]"));
			assertEquals(loggedAs.getText(), "Logged in as " + username, "It's not displayed");
		} else {
			WebElement loginError = driver.findElement(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]"));
			assertEquals(loginError.isDisplayed(), true, "It's not displayed");
		}
		
		
	}
}
