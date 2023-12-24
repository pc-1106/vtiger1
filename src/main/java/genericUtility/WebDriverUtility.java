package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class WebDriverUtility {
	public void implicitWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void switchToWindow(WebDriver driver, String windowTitlePartial) {
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().contains(windowTitlePartial))
				break;
		}
	}

	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		JavaUtility jUtils = new JavaUtility();
		screenshotName = screenshotName + "_" + jUtils.generateSystemDateAndTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(IPathConstant.SCREENSHOTS_FOLDER_PATH + screenshotName + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}
}
