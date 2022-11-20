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

public class EmployeePageTest extends TestBase {
	public static final Logger log = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ActiPlanPage actiPlanPage;
	EmployeePage employeePage;

	public EmployeePageTest() {
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
		employeePage = actiPlanPage.clickOnEmployeeListLink();
	}

	@Test(priority = 1)
	public void verifyPgTitleTest() {
		String title = employeePage.verifyPgTitle();
		Assert.assertEquals(title, "actiPLANS - User List");

	}

	@Test(priority = 2)
	public void clickEmployeeTest() {
		employeePage.clickEmployee();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}

}
