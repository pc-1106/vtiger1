package genericUtility;

public interface IPathConstant {
	String PROPERTY_FILE_PATH = "./src/test/resources/testData/vtigerPropertyData.properties";
	String EXCEL_FILE_PATH = "./src/test/resources/testData/vtigerTestData.xlsx";

	String BROWSER_KEY = "browser";
	String CHROME_BROWSER_VALUE = "chrome";
	String FIREFOX_BROWSER_VALUE = "firefox";
	String EDGE_BROWSER_VALUE = "edge";

	String URL_KEY = "url";

	String USERNAME_KEY = "username";
	String PASSWORD_KEY = "password";

	Long IMPLICIT_WAIT_SECONDS = 10L;

	String LEAD_SHEET_NAME = "Lead";
}
