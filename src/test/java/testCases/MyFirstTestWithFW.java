package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class MyFirstTestWithFW extends BaseTest {

	@Test(dataProviderClass = ReadXLSdata.class, dataProvider = "bvtdata")
	public void LoginTest(String username, String password) throws InterruptedException {

		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click(); // locators --properties
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username); // testdata
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password); // testdata
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}

//	@DataProvider(name = "testDataUNamePwd")
//	public Object[][] tData() {
//		return new Object[][] { 	
//				{ "imsaabhiverma1@gmail.com", "7071@Abhi" },
//				{ "imabhiverma1@gmail.cosm", "7071@Abhisa" },
//				{ "imabhiverma1@gmail.com", "7071@Abhi" }
//				};
//	}
}
