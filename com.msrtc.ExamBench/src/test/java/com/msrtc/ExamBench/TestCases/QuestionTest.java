package com.msrtc.ExamBench.TestCases;

import java.util.Hashtable;

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

	public String questionText, choice1, choice1Marks, choice2, choice2Marks, choice3, choice3Marks, choice4,
			choice4Marks = null;

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
		addNQpg.addNewQuestionDetails(questionText, choice1, choice1Marks, choice2, choice2Marks, choice3, choice3Marks,
				choice4, choice4Marks);

	}

	@Test(dataProvider = "getData", priority = 1)
	public void test(Hashtable<String, String> data) throws Exception {
		this.questionText = data.get("Question_Text");
		this.choice1 = data.get("Choice_1");
		this.choice1Marks = data.get("Choice_1_Mark");
		this.choice2 = data.get("Choice_2");
		this.choice2Marks = data.get("Choice_2_Mark");
		this.choice3 = data.get("Choice_3");
		this.choice3Marks = data.get("Choice_3_Mark");
		this.choice4 = data.get("Choice_4");
		this.choice4Marks = data.get("Choice_4_Mark");
		AddQuestion();
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = Utils.readDataTestData(xls_path, "Question");
		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
