package com.msrtc.ExamBench.TestCases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.msrtc.ExamBench.Base.BasePage;
import com.msrtc.ExamBench.Pages.CategoryPage;
import com.msrtc.ExamBench.Pages.HomePage;
import com.msrtc.ExamBench.Pages.LoginPage;
import com.msrtc.ExamBench.Util.Utils;
import com.relevantcodes.extentreports.LogStatus;

public class CategoryTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;
	CategoryPage categoryPage;
	
	public String Category, Sub_Category;
	
	public CategoryTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		test = extent.startTest("Starting LoginTest testcase");

		test.log(LogStatus.INFO, "Executing Initialization method");
//		initialization();

		test.log(LogStatus.INFO, "creating loginPage Object");
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

	@Test(dataProvider = "getData")
	public void AddCategory(Hashtable<String, String> data) throws Exception {
		this.Category = data.get("Category");
		this.Sub_Category = data.get("SubCategory");
		addCategoryData();
//		categoryPage.btnAddCategory();
	}

	public void addCategoryData() throws Exception{
		categoryPage.btnAddCategory(Category, Sub_Category);
	}

	@DataProvider
	public Object[][] getData() {
		return Utils.readDataTestData(xls_path, "Category");
	}
}
