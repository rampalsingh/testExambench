package com.msrtc.ExamBench.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.msrtc.ExamBench.Util.Excel_Reader;
import com.msrtc.ExamBench.Util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class BasePage {

	public static Properties prop;
	public static WebDriver driver;
	public static String sysPath = System.getProperty("user.dir");
	public static String path = sysPath + "\\drivers\\chromedriver.exe";
	public static String xls_path = sysPath +"\\src\\main\\java\\com\\msrtc\\ExamBench\\Data\\EB_Data.xlsx";
	
	public static ExtentReports extent = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	@FindBy(xpath = "//img[@name='Image9']")
	public WebElement btnAdd;
	
	public Excel_Reader xls;
	public BasePage() throws Exception {

		FileInputStream file = new FileInputStream(sysPath+"\\src\\main\\java\\com\\msrtc\\ExamBench\\Util\\Config.properties");
		xls = new Excel_Reader(xls_path, "Question");
		prop = new Properties();
		prop.load(file);
	}

	public void initialization() {
		
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("mainUrl"));
	} 

}
