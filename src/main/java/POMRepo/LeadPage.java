package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	WebDriver driver;

	public LeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement plusButton;

	public WebElement getPlusButton() {
		return plusButton;
	}

	public void clickOnPlusButton() {
		plusButton.click();
	}
}
