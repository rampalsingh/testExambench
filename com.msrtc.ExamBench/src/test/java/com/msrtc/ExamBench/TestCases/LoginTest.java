package com.msrtc.ExamBench.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.msrtc.ExamBench.Base.BasePage;
import com.msrtc.ExamBench.Pages.HomePage;
import com.msrtc.ExamBench.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class LoginTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;

	public LoginTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void setUp() throws Exception {
		test = extent.startTest("Starting LoginTest testcase");
		
		test.log(LogStatus.INFO, "Executing Initialization method");
		initialization();
		
		test.log(LogStatus.INFO, "creating loginPage Object");
		loginPage = new LoginPage();
	}

	@Test
	public void validLogin() throws Exception {
		test.log(LogStatus.INFO, "Navigating to doLogin() method");
		loginPage.doLogin();
		
		// Assert.assertEquals("Exambench", driver.getTitle());
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
		driver.quit();
	}

}
