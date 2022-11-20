package com.hrm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.ActiPlanPage;
import com.hrm.qa.pages.ReviewLeavePage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class ReviewLeavePageTest extends TestBase {
	public static final Logger log = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ActiPlanPage actiPlanPage;
	ReviewLeavePage reviewLeavePage;

	public ReviewLeavePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		initialization();
		actiPlanPage = new ActiPlanPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		actiPlanPage = homePage.clickOnactiPlanLink();
		reviewLeavePage = actiPlanPage.clickOnReviewLeaveLink();
	}

	@Test
	public void validatePgTitleTest() {
		String tt = reviewLeavePage.validatePgTitle();
		Assert.assertEquals(tt, "actiPLANS - Leave Time Chart");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
