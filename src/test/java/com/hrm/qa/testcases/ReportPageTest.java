package com.hrm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.ActiPlanPage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.ReportPage;

public class ReportPageTest extends TestBase {
	public static final Logger log = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ActiPlanPage actiPlanPage;
	ReportPage reportPage;

	public ReportPageTest() {
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
		reportPage = actiPlanPage.clickOnReportLink();
	}

	@Test(priority = 1)
	public void validatePgTitleTest() {
		String title = reportPage.validatePgTitle();
		Assert.assertEquals(title, "actiPLANS - Reports");

	}

	@Test(priority = 2)
	public void dwnldCSVTest() throws InterruptedException {
		reportPage.dwnldCSV();
		Thread.sleep(5000);

	}

	@Test(priority = 3)
	public void dwnldPDFTest() throws InterruptedException {
		reportPage.dwnldPDF();
		Thread.sleep(5000);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
