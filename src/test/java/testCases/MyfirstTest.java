package testCases;

import org.openqa.selenium.By;
import base.BaseTest;

public class MyfirstTest extends BaseTest {

	public static void main(String[] args) throws InterruptedException {

		driver.findElement(By.linkText("Sign in")).click(); //locators  --properties 
		driver.findElement(By.id("login_id")).sendKeys("imabhiverma1@gmail.com"); //testdata
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("7071@Abhi"); //testdata
		driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();

	}

}
