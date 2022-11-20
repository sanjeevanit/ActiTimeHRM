package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class ApproveTab extends TestBase {
	@FindBy(xpath = "//span[text()='Ready for Approval']//parent::td[@class='statusCell']//parent::tr[@class='childRow ready']//preceding-sibling::td[@class='selectionCell']//input[@type='checkbox']")
	WebElement selectApproval;

	@FindBy(xpath = "//span[@id='approveButton' and @class='actionButton approve']")
	WebElement clickApproval;

	@FindBy(xpath = "//span[text()='Rejected']//parent::td[@class='statusCell']//parent::tr[@class='childRow rejected']//preceding-sibling::td[@class='selectionCell']//input[@type='checkbox']")
	WebElement selectRejection;

	@FindBy(xpath = "//span[@id='rejectButton' and @class='actionButton reject disabled']")
	WebElement clickReject;

	public ApproveTab() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPgTitle() {

		return driver.getTitle();
	}

	public void selectApproved() {
		driver.findElement(By.xpath(
				"//span[text()='Ready for Approval']//parent::td[@class='statusCell']//parent::tr[@class='childRow ready']//preceding-sibling::td[@class='selectionCell']//input[@type='checkbox']"))
				.click();
	}

	public void selectRejected() {
		driver.findElement(By.xpath(
				"//span[text()='Rejected']//parent::td[@class='statusCell']//parent::tr[@class='childRow rejected']//preceding-sibling::td[@class='selectionCell']//input[@type='checkbox']"))
				.click();
	}

	public void confirmApproved() {
//		driver.findElement(By.xpath("//span[@id='approveButton' and @class='actionButton approve']")).click();
		selectApproval.click();
		clickApproval.click();
	}

	public void confirmRejected() {
//		driver.findElement(By.xpath("//span[@id='approveButton' and @class='actionButton approve']")).click();
		selectRejection.click();
		clickReject.click();
	}

}
