package com.hrm.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.ActiPlanPage;
import com.hrm.qa.pages.ApproveTab;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LockTimeTab;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.ViewTrackTab;
import com.hrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	public static final Logger log = LogManager.getLogger(LoginPageTest.class);

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ActiPlanPage actiPlanPage;
	LockTimeTab lockTimeTab;
	ViewTrackTab viewTrackTab;
	ApproveTab approveTab;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		initialization();
		testUtil = new TestUtil();
		actiPlanPage = new ActiPlanPage();
		loginPage = new LoginPage();
		lockTimeTab = new LockTimeTab();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageLogoTest() {

		boolean flag = homePage.validateActiTimeLogo();
		Assert.assertTrue(flag, "Cannot find the Logo");

	}

	@Test(priority = 2)
	public void verifyLockTimeLinkTest() {
		lockTimeTab = homePage.clickOnLockTimeLink();
	}

	@Test(priority = 3)
	public void verifyviewTrackLinkTest() {
		viewTrackTab = homePage.clickOnviewTrackLink();
	}

	@Test(priority = 4)
	public void verifyapproveLinkTest() {
		approveTab = homePage.clickOnapproveLink();
	}

	@Test(priority = 5)
	public void verifyactiPlanLinkTest() {
		actiPlanPage = homePage.clickOnactiPlanLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
