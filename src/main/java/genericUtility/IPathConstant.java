package genericUtility;

public interface IPathConstant {
	String PROPERTY_FILE_PATH = "./src/test/resources/testData/vtigerPropertyData.properties";
	String EXCEL_FILE_PATH = "./src/test/resources/testData/vtigerTestData.xlsx";
	String SCREENSHOTS_FOLDER_PATH = "./src/test/resources/screenshots/";

	String BROWSER_KEY = "browser";
	String CHROME_BROWSER_VALUE = "chrome";
	String FIREFOX_BROWSER_VALUE = "firefox";
	String EDGE_BROWSER_VALUE = "edge";

	String URL_KEY = "url";

	String USERNAME_KEY = "username";
	String PASSWORD_KEY = "password";

	Long IMPLICIT_WAIT_SECONDS = 10L;

	String LEADS_SHEET_NAME = "Leads";
	String ORGANIZATIONS_SHEET_NAME = "Organizations";
	String CAMPAIGNS_SHEET_NAME = "Campaigns";
	String OPPORTUNITIES_SHEET_NAME = "Opportunities";

	String USER_KEY = "User";
	String GROUP_KEY = "Group";

	String DATABASE_URL = "jdbc:mysql://localhost:3306/db1";
	String DATABASE_USERNAME = "root";
	String DATABASE_PASSWORD = "root";
}
