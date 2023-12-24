package demo_module;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;

@Listeners(genericUtility.ITestListenerImplementationClass.class)

public class DemoTest extends BaseClass {
	@Test(retryAnalyzer = genericUtility.IRetryAnalyzerImplementationClass.class)
	public void demo1Test() throws SQLException {
		String firstName = dbUtils.fetchDataFromDatabase(connection,
				"select first_name from employees where employee_id = 4;");
		System.out.println("-----------" + firstName + "-----------");
		Assert.fail();
	}

	@Test(retryAnalyzer = genericUtility.IRetryAnalyzerImplementationClass.class)
	public void demo2Test() {
		Assert.assertTrue(true);
	}
}
