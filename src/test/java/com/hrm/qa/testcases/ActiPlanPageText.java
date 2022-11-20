package com.hrm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.ActiPlanPage;
import com.hrm.qa.pages.EmployeePage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.ReportPage;
import com.hrm.qa.pages.ReviewLeavePage;

public class ActiPlanPageText extends TestBase {
	public static final Logger log = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ActiPlanPage actiPlanPage;
	ReviewLeavePage reviewLeavePage;
	ReportPage reportPage;
	EmployeePage employeePage;

	public ActiPlanPageText() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		initialization();
		actiPlanPage = new ActiPlanPage();
		loginPage = new LoginPage();
		reviewLeavePage = new ReviewLeavePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		actiPlanPage = homePage.clickOnactiPlanLink();
	}

	@Test(priority = 1)
	public void validateActiTimeLogoTest() {
		boolean flag = actiPlanPage.validateActiTimeLogo();
		Assert.assertTrue(flag, "Cannot find the Logo");

	}

	@Test(priority = 2)
	public void validatePgTitleTest() {
		String title = actiPlanPage.validatePgTitle();
		Assert.assertEquals(title, "actiPLANS - My Schedule");
	}

	@Test(priority = 3)
	public void verifyReviewLeaveLinkTest() {
		reviewLeavePage = actiPlanPage.clickOnReviewLeaveLink();
	}

	@Test(priority = 4)
	public void verifyReportLinkTest() {
		reportPage = actiPlanPage.clickOnReportLink();
	}

	@Test(priority = 5)
	public void verifyEmployeeListLinkTest() {
		employeePage = actiPlanPage.clickOnEmployeeListLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
