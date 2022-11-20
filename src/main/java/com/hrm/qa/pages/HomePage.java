package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@id='logo_aT']")
	WebElement actitimeLogo;

	@FindBy(xpath = "//a[contains(@href,'/user/lock_tt.do') and text()='Lock Time-Track']")
	WebElement LockTimeLink;

	@FindBy(xpath = "//a[contains(@href,'/user/view_tt.do') and text()='View Time-Track']")
	WebElement viewTrackLink;

	@FindBy(xpath = "//a[contains(@href,'/administration/approve_tt.do') and text()='Approve Time-Track']")
	WebElement approveLink;

	@FindBy(xpath = "//a [@href='https://demo.actiplans.com/switcher.do?urlSwitchedFrom=%2Fuser%2Fsubmit_tt.do%3Fsubmitted%3D']")
	WebElement actiPlanLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean validateActiTimeLogo() {
		return actitimeLogo.isDisplayed();
	}

	public LockTimeTab clickOnLockTimeLink() {
		LockTimeLink.click();
		return new LockTimeTab();
	}

	public ViewTrackTab clickOnviewTrackLink() {
		viewTrackLink.click();
		return new ViewTrackTab();
	}

	public ApproveTab clickOnapproveLink() {
		approveLink.click();
		return new ApproveTab();
	}

	public ActiPlanPage clickOnactiPlanLink() {
		actiPlanLink.click();
		return new ActiPlanPage();
	}

	/*
	 * public void clickOnNewContactLink() { Actions action = new Actions(driver);
	 * action.moveToElement(contactsLink).build().perform(); newContactLink.click();
	 * 
	 * }
	 */

}
