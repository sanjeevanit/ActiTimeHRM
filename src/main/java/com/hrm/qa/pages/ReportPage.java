package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class ReportPage extends TestBase {
	@FindBy(xpath = "//div[@id='leaveTimeExportSelector' and @class='exportSelectorButton']")
	WebElement selectExport;

	@FindBy(xpath = "//preceding-sibling::div[@class='exportSelector noprint menuZindex']//div[@class='type' and contains(text(),'Export to CSV')]")
	WebElement clickExportCSV;

	@FindBy(xpath = "//preceding-sibling::div[@class='exportSelector noprint menuZindex']//div[@class='type' and contains(text(),'Export to PDF')]")
	WebElement clickExportPDF;

	@FindBy(xpath = "//parent::div[@id='leaveTimeAndBalancesPdfPreviewLightbox_downloadPdfBtn']//parent::div[@class='buttonIcon']//span[@class='buttonTitle' and contains(text(),'Download PDF')]")
	WebElement clickDwnPDF;

	public ReportPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePgTitle() {

		return driver.getTitle();
	}

	public void dwnldCSV() {
		selectExport.click();
		clickExportCSV.click();

	}

	public void dwnldPDF() {
		selectExport.click();
		clickExportPDF.click();
		clickDwnPDF.click();

	}

}
