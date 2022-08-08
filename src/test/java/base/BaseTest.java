package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader frLoc;

	@BeforeMethod
	public void setUp() throws IOException {

		if (driver == null) {
			fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
			frLoc = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\locators.properties");
			prop.load(fr);
			loc.load(frLoc);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup(); // move to base
			driver = new ChromeDriver(); // move to base
			driver.get(prop.getProperty("url"));

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup(); // move to base
			driver = new EdgeDriver(); // move to base
			driver.get(prop.getProperty("url"));
		}
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
		System.out.println("Test completed ,browser closed");
	}

}
