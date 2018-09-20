package com.msrtc.ExamBench.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.msrtc.ExamBench.Base.BasePage;
import com.msrtc.ExamBench.Pages.ExamTemplatePage;
import com.msrtc.ExamBench.Pages.HomePage;
import com.msrtc.ExamBench.Pages.LoginPage;

public class ExamTemplateTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;
	ExamTemplatePage examTemplatepage;

	public ExamTemplateTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin();
		homePage.gotoExamTemplate();
		examTemplatepage = new ExamTemplatePage();
		
	}

	@Test
	public void TestExamTemplate() throws Exception {
		examTemplatepage.addExamTemplate();

	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
