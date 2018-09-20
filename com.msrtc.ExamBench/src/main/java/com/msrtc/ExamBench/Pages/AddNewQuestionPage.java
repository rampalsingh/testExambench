package com.msrtc.ExamBench.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msrtc.ExamBench.Base.BasePage;

public class AddNewQuestionPage extends BasePage {

	// Add Question page elements
	public @FindBy(xpath = "//select[@id='difficultylevel']") WebElement selectDifficultyDropdown;

	public @FindBy(xpath = "//select[@id='difficultylevel']/option[@value='2']") WebElement selectDifficultyValue;

	// Question Test
	public @FindBy(xpath = "//textarea[@id='questiontext']") WebElement pageQuestionField;

	// Choice 1
	public @FindBy(xpath = "//textarea[@id='choiceText1']") WebElement pg_choice_1;
	public @FindBy(xpath = "//input[@id='marks1']") WebElement pg_choice_1_Marks;

	// Choice 2
	public @FindBy(xpath = "//textarea[@id='choiceText2']") WebElement pg_choice_2;
	public @FindBy(xpath = "//input[@id='marks2']") WebElement pg_choice_2_Marks;

	// Choice 3
	public @FindBy(xpath = "//textarea[@id='choiceText3']") WebElement pg_choice_3;
	public @FindBy(xpath = "//input[@id='marks3']") WebElement pg_choice_3_Marks;

	// Choice 1
	public @FindBy(xpath = "//textarea[@id='choiceText4']") WebElement pg_choice_4;
	public @FindBy(xpath = "//input[@id='marks4']") WebElement pg_choice_4_Marks;

	// Submit Button
	public @FindBy(xpath = "//input[@id='createQuestion']") WebElement submitButton;

	public String questionText, choice_1_Text, choice_1_Marks, choice_2_Text, choice_2_Marks, choice_3_Text,
			choice_3_Marks, choice_4_Text, choice_4_Marks = null;

	public AddNewQuestionPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void addNewQuestionDetails(String questionText, String choice1, String choice1Marks, String choice2, String choice2Marks,
			String choice3, String choice3Marks, String choice4, String choice4Marks) throws Exception {
		
		selectDifficultyDropdown.click();
		selectDifficultyValue.click();
		
		pageQuestionField.sendKeys(questionText);
		
		pg_choice_1.sendKeys(choice1);
		pg_choice_1_Marks.sendKeys(choice1Marks);
		
		pg_choice_2.sendKeys(choice2);
		pg_choice_2_Marks.sendKeys(choice2Marks);
		
		pg_choice_3.sendKeys(choice3);
		pg_choice_3_Marks.sendKeys(choice3Marks);
		
		pg_choice_4.sendKeys(choice4);
		pg_choice_4_Marks.sendKeys(choice4Marks);
		
		
		Thread.sleep(2000);
		submitButton.click();
		}
}
