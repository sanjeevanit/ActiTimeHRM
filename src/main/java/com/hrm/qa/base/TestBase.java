package com.hrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.qa.util.TestUtil;

public class TestBase {
	public static final Logger log = LogManager.getLogger(TestBase.class);
	public static WebDriver driver;
	public static Properties prop;
//	public static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;

	public TestBase() {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\DELL\\eclipse-workspace\\actiTimeHrm\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\actiTimeHrm\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\DELL\\eclipse-workspace\\actiTimeHrm\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		/*
		 * e_driver = new EventFiringWebDriver(driver); // Now create object of
		 * EventListerHandler to register it with // EventFiringWebDriver eventListener
		 * = new WebEventListener(); e_driver.register(eventListener); driver =
		 * e_driver;
		 */
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

		driver.get(prop.getProperty("url"));
		
	
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "//screenshots//" + System.currentTimeMillis() + ".png"));
	}

}
