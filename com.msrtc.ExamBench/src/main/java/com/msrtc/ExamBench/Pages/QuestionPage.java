package com.msrtc.ExamBench.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msrtc.ExamBench.Base.BasePage;

public class QuestionPage extends BasePage{
	
	@FindBy(xpath = "//span[contains(text(),'Subject')]")
	WebElement selectCategory;
	
	//label[@id='labelCategory23']//preceding-sibling::input[@title='GK']
	@FindBy(xpath = "//preceding-sibling::input[@title='GK']")
	WebElement selectGK;
	
	@FindBy(xpath = "//select[@id='questiontype']")
	WebElement selectQuestDropdown;
	
	@FindBy(xpath = "//option[@title='Multiple Choice Single Answer']")
	WebElement selectMultipleTypeOption;
	
	@FindBy(xpath = "//td[@colspan='2']//input[@value='Submit']")
	WebElement selectSubmit;
	
	@FindBy(xpath = "//td[@class='messageBoxTD']//input[@value='YES']")
	WebElement selectPopupYes;

	
	public QuestionPage() throws Exception{
		PageFactory.initElements(driver, this);
	}

	
	public AddNewQuestionPage btnAddQuestion() throws Exception{
		btnAdd.click();
		selectCategory.click(); //hardcoded value
		selectGK.click();
		selectQuestDropdown.click();
		selectMultipleTypeOption.click();
		selectSubmit.click();
		selectPopupYes.click();
		return new AddNewQuestionPage();
	}
	
}
