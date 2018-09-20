package com.msrtc.ExamBench.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.msrtc.ExamBench.Base.BasePage;
import com.msrtc.ExamBench.Pages.CategoryPage;
import com.msrtc.ExamBench.Pages.HomePage;
import com.msrtc.ExamBench.Pages.LoginPage;

public class CategoryTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;
	CategoryPage categoryPage;

	public CategoryTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin();
		categoryPage = new CategoryPage();
		homePage.gotoCategory();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void AddCategory() throws Exception {
		categoryPage.btnAddCategory();
		
	}
}
