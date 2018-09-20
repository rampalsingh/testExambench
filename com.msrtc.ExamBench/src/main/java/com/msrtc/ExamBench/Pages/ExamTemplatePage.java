package com.msrtc.ExamBench.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msrtc.ExamBench.Base.BasePage;

public class ExamTemplatePage extends BasePage {

	//Parent category path
	@FindBy(xpath = "//*[contains(text(),'Subject')]//preceding-sibling::span")
	WebElement mainCategory;

	//Sub category path
	@FindBy(xpath = "//input[@name='selectedCategory']")
	WebElement subCategory;
	
	
	@FindBy(xpath = "//input[@data-questiontype='MULTIPLE_CHOICE_SINGLE_ANSWER']")
	WebElement popupMultipleChoiceWindow;
	

	@FindBy(xpath = "//input[@type='text' and @onkeypress='return isNumberKey(event)']")
	WebElement questionCount;
	
	public ExamTemplatePage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void addExamTemplate() throws Exception {
		btnAdd.click();
		mainCategory.click();
		subCategory.click();
		popupMultipleChoiceWindow.click();
		questionCount.sendKeys("1");
	}

}
