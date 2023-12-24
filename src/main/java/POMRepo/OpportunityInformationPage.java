package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	public OpportunityInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	private WebDriver driver;

	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeIcon;

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public String verifyOpportunityInformationText(String opportunityName) {
		return driver.findElement(By.xpath("(//span[contains(text(), '" + opportunityName + "')])[1]")).getText();
	}

	public void clickOnHomeIcon() {
		homeIcon.click();
	}
}
