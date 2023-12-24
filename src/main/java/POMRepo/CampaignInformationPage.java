package pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	private WebDriver driver;

	@FindBy(xpath = "//a[@href='index.php?module=Home&action=index&parenttab=My Home Page']")
	private WebElement homeIcon;

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public String verifyCampaignInformationText(String campaignName) {
		return driver.findElement(By.xpath("(//span[contains(text(), '" + campaignName + "')])[1]")).getText();
	}

	public void clickOnHomeIcon() {
		homeIcon.click();
	}
}
