package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyFirstTestWithFW extends BaseTest {

	@Test
	public void login() throws InterruptedException {

		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click(); // locators --properties
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys("imabhiverma1@gmail.com"); // testdata
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys("7071@Abhi"); // testdata
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}

}
