package com.hrm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.ApproveTab;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class ApproveTabTest extends TestBase {
	public static final Logger log = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ApproveTab approveTab;

	public ApproveTabTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		initialization();
		approveTab = new ApproveTab();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		approveTab = homePage.clickOnapproveLink();
	}

	@Test(priority = 1)
	public void verifyPgTitleTest() {
		String title = approveTab.verifyPgTitle();
		Assert.assertEquals(title, "actiTIME - Approve Time-Track");

	}

	@Test(priority = 2)
	public void selectApprovedTest() {
		approveTab.selectApproved();

	}

	@Test(priority = 3)

	public void selectRejectedTest() {
		approveTab.selectRejected();
	}

	@Test(priority = 4)
	public void confirmApprovalTest() {
		approveTab.confirmApproved();

	}

	@Test(priority = 5)
	public void confirmRejectionTest() {
		approveTab.confirmRejected();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
