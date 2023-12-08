package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pomRepo.CreateNewLeadPage;
import pomRepo.HomePage;
import pomRepo.LeadInformationPage;
import pomRepo.LeadPage;
import pomRepo.LoginPage;

public class BaseClass {
	public FileUtility fUtils = new FileUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public CreateNewLeadPage createLead;
	public LeadInformationPage leadInfo;
	public LeadPage lead;

	@BeforeSuite
	public void bsConfig() {
		System.out.println("Database connection established");
	}

	@BeforeClass
	public void bcConfig() throws IOException {
		String browser = fUtils.fetchDataFromPropertyFile(IPathConstant.BROWSER_KEY);
		if (browser.equals(IPathConstant.CHROME_BROWSER_VALUE))
			driver = new ChromeDriver();
		else if (browser.equals(IPathConstant.FIREFOX_BROWSER_VALUE))
			driver = new FirefoxDriver();
		else if (browser.equals(IPathConstant.EDGE_BROWSER_VALUE))
			driver = new EdgeDriver();
		System.out.println(browser + " browser is launched");

		wUtils.implicitWait(driver, IPathConstant.IMPLICIT_WAIT_SECONDS);
		wUtils.maximizeWindow(driver);

		String url = fUtils.fetchDataFromPropertyFile(IPathConstant.URL_KEY);

		driver.get(url);
		System.out.println(url + " is navigated");
	}

	@BeforeMethod
	public void bmConfig() throws IOException {
		String username = fUtils.fetchDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		String password = fUtils.fetchDataFromPropertyFile(IPathConstant.PASSWORD_KEY);

		lp = new LoginPage(driver);
		lp.loginAction(username, password);
		System.out.println("the user " + username + " has logged in");
	}

	@AfterMethod
	public void amConfig() {
		leadInfo.clickOnHomePageIcon();
		hp.signOutAction();
		System.out.println("the user has logged out");
	}

	@AfterClass
	public void acConfig() {
		driver.quit();
		System.out.println("the browser has closed");
	}

	@AfterSuite
	public void asConfig() {
		System.out.println("Database connection closed");
	}
}
