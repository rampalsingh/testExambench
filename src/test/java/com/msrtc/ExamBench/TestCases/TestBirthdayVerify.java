package com.msrtc.ExamBench.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.msrtc.ExamBench.Util.Xls_Reader;

import junit.framework.Assert;

public class TestBirthdayVerify {
	public static String sysPath = System.getProperty("user.dir");
	public static String path = sysPath + "\\drivers\\chromedriver.exe";
	WebDriver driver = null;
	Xls_Reader xls = null;
	String excelPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\msrtc\\ExamBench\\Data\\Msrtc.xlsx";

	@Test
	public void validLogin() throws Exception {
		
		xls = new Xls_Reader(excelPath);
		int totalRow = xls.getRowCount("Sheet1");
		System.out.println("Total Row "+totalRow);
		String baseUrl = "http://192.168.1.106:8080/msrtcPortal/";
	
		for (int i = 1; i < totalRow; i++) {
		String applicantID = xls.getCellData("Sheet1", 0, i);
			
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.findElement(By.name("j_username")).sendKeys(applicantID);
		driver.findElement(By.name("password")).sendKeys("admin1");
		driver.findElement(By.name("password")).sendKeys(Keys.RETURN);

		driver.navigate().to(baseUrl+"applicant?operation=viewProfile&menu=viewProfile");
		
		driver.findElement(By.xpath("//a[@title='इंग्रजी भाषे मध्ये रूपांतर करा']")).click();
//		xls.getCellData(sheetName, colNum, rowNum)
		String excelData = xls.getCellData("sheet1", 1, i);
		System.out.println(i+") Applicant Id : "+applicantID);
		System.out.println("Excel data : "+ excelData);
		String pageData = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[3]/em[1]")).getText();
		System.out.println("Page data  : "+ pageData.trim());
		try {
			System.out.println("Result Match : "+excelData.equals(pageData));
			Assert.assertEquals(excelData.trim(), pageData.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		driver.quit();
		
		}
	}

}
