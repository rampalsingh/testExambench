package com.msrtc.ExamBench.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msrtc.ExamBench.Base.BasePage;

public class CategoryPage extends BasePage {
	
	public CategoryPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//img[@name='Image9']")
//	WebElement btnAdd;
	
	@FindBy(xpath = "//input[@type='text' and @title='Category Name']")
	WebElement mainTextBoxCategory;
	
	@FindBy(xpath = "//input[@type='text' and @title=' Level-1: Category name']")
	WebElement subTextBoxCategory;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement btnSave;
	
	
	public void btnAddCategory(String Category, String Sub_Category) throws Exception{
		btnAdd.click();
		mainTextBoxCategory.sendKeys(Category);
		subTextBoxCategory.sendKeys(Sub_Category);
		Thread.sleep(500);
		btnSave.click();
		
	}
	

	public void deleteCategory(){
		
	}
	
}
