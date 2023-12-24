package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	Actions act;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='index.php?module=Leads&action=index']")
	private WebElement leadsModule;

	@FindBy(linkText = "More")
	private WebElement moreOption;

	@FindBy(linkText = "Quotes")
	private WebElement quotesModule;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsModule;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutOption;

	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getQuotesModule() {
		return quotesModule;
	}

	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}

	public void clickOnLeadsModule() {
		leadsModule.click();
	}

	public void clickOnQuotesModule() {
		act.moveToElement(moreOption).perform();
		act.click(quotesModule).perform();
	}

	public void clickOnOrganizationsModule() {
		organizationsModule.click();
	}

	public void clickOnOpportunitiesModule() {
		opportunitiesModule.click();
	}

	public void clickOnCampaignsModule() {
		act.moveToElement(moreOption).perform();
		act.click(campaignsModule).perform();
	}

	public void signOutAction() {
		act.moveToElement(administratorIcon).perform();
		act.click(signOutOption).perform();
	}
}
