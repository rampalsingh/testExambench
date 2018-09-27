package com.msrtc.ExamBench.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msrtc.ExamBench.Base.BasePage;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends BasePage {

	HomePage homePage;

	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "j_username")
	WebElement username;

	@FindBy(id = "j_password")
	WebElement password;

	@FindBy(xpath = "//input[@name='submit' and @value='Login']")
	WebElement submit;

	public HomePage doLogin() throws Exception {
		test.log(LogStatus.INFO, "Entering Username");
		username.sendKeys(prop.getProperty("username"));
		
		test.log(LogStatus.INFO, "Entering Password");
		password.sendKeys(prop.getProperty("password"));
		
		test.log(LogStatus.INFO, "Clicking on Submit Button");
		submit.click();
		
		test.log(LogStatus.INFO, "returning homePage Object");
		return new HomePage();

	}
}
