package com.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Logout extends Automation {
	
	@Test
	public void logoutMeth() {
		WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logoutButton.click();
		assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "The user is not navigated to login page");
	}

}
