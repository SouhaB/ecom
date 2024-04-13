package com.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Home extends Automation {
	
	@Test
	public void openHome() {
		driver.get("https://automationexercise.com");
		assertEquals(driver.getTitle(), "Automation Exercise", "It's not the home page");
	}
}
