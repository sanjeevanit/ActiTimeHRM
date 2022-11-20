package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class ActiPlanPage extends TestBase {
	@FindBy(xpath = "//div[@id='logo_aP']")
	WebElement actitimeLogo;

	@FindBy(xpath = "//a[contains(@href,'/administration/leave_time_planning.do')]")
	WebElement ReviewLeaveLink;

	@FindBy(xpath = "//a[contains(@href,'/reports/reports.do')]")
	WebElement ReportLink;

	@FindBy(xpath = "//a[contains(@href,'/administration/userlist.do')]")
	WebElement EmployeeListLink;
	
	@FindBy(xpath = "//div[@id='closeProjectLightBoxBtn' and @class='closeButton']")
	WebElement clickClose;

	public ActiPlanPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean validateActiTimeLogo() {
		return actitimeLogo.isDisplayed();
	}

	public String validatePgTitle() {
		return driver.getTitle();
	}

	public ReviewLeavePage clickOnReviewLeaveLink() {
		ReviewLeaveLink.click();
		return new ReviewLeavePage();
	}

	public ReportPage clickOnReportLink() {
		ReportLink.click();
		return new ReportPage();
	}

	public EmployeePage clickOnEmployeeListLink() {
		EmployeeListLink.click();
		return new EmployeePage();
	}

}
