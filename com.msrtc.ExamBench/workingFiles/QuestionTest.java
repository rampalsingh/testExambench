package com.msrtc.ExamBench.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.msrtc.ExamBench.Base.BasePage;
import com.msrtc.ExamBench.Pages.AddNewQuestionPage;
import com.msrtc.ExamBench.Pages.HomePage;
import com.msrtc.ExamBench.Pages.LoginPage;
import com.msrtc.ExamBench.Pages.QuestionPage;
import com.msrtc.ExamBench.Util.Utils;

public class QuestionTest extends BasePage {
	HomePage homePage;
	LoginPage loginPage;
	QuestionPage questionPage;
	AddNewQuestionPage addNQpg;

	public String questionText, choice1, choice1Marks, choice2, choice2Marks,
	choice3, choice3Marks, choice4, choice4Marks = null;
	
	
	public QuestionTest() throws Exception {
		super();

	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin();
		homePage.gotoQuestion();
		questionPage = new QuestionPage();
		addNQpg = questionPage.btnAddQuestion();
	}

	

	
	public void AddQuestion() throws Exception {
		addNQpg.addNewQuestionDetails(questionText, choice1, choice1Marks, choice2, choice2Marks, choice3, choice3Marks, choice4, choice4Marks);
		
	}

	// D U M M Y
	@Test(dataProvider = "GETDATA",priority=1)
	public void test(String questionText, String choice1, String choice1Marks, String choice2, String choice2Marks,
			String choice3, String choice3Marks, String choice4, String choice4Marks) throws Exception{	
		
		this.questionText = questionText;
		this.choice1 = choice1;
		this.choice1Marks = choice1Marks;
		this.choice2 = choice2;
		this.choice2Marks = choice2Marks;
		this.choice3 = choice3;
		this.choice3Marks = choice3Marks;
		this.choice4 = choice4;
		this.choice4Marks = choice4Marks;
		AddQuestion();

		

		Thread.sleep(2000);
//		addNQpg.submitButton.click();
	}

	@DataProvider(name = "GETDATA")
	public Object[][] getData() {
		Object data[][] = Utils.readDataTestData(xls_path, "Question");
		return data;
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}