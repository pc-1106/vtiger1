package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {
	WebDriver driver;

	public LeadInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homePageIcon;

	public WebElement getHomePageIcon() {
		return homePageIcon;
	}

	public String verifyLeadInformationText(String lastName) {
		return driver.findElement(By.xpath("(//span[contains(text(), '" + lastName + "')])[1]")).getText();
	}

	public void clickOnHomePageIcon() {
		homePageIcon.click();
	}
}
