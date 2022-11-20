package com.hrm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public static final Logger log = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(
				"****************************** Starting test cases execution  *****************************************");
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		log.info("****************************** starting test case1 *****************************************");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
		log.info("****************************** ending test case1 *****************************************");
	}

	@Test(priority = 2)
	public void actiTimeLogoTest() {
		log.info("****************************** starting test case2 *****************************************");
		boolean flag = loginPage.validateActiTimeLogo();
		Assert.assertTrue(flag);
		log.info("****************************** starting test case2 *****************************************");
	}

	@Test(priority = 3)
	public void loginTest() {
		log.info("****************************** starting test case3 *****************************************");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("****************************** starting test case3 *****************************************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
