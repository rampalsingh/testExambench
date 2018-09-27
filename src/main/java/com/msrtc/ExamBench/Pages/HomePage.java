package com.msrtc.ExamBench.Pages;

import org.openqa.selenium.support.PageFactory;

import com.msrtc.ExamBench.Base.BasePage;

public class HomePage extends BasePage {

	public HomePage() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public void gotoCategory(){
		driver.get(prop.getProperty("mainUrl")+prop.getProperty("categoryUrl"));
		
	}
	
	public void gotoQuestion(){
		driver.get(prop.getProperty("mainUrl")+prop.getProperty("questionUrl"));
		
	}
	
	public void gotoExamTemplate(){
		driver.get(prop.getProperty("mainUrl")+prop.getProperty("examTemplate"));
		
	}
}
