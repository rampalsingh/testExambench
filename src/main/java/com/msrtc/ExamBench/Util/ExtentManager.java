package com.msrtc.ExamBench.Util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";

			String reportPath = System.getProperty("user.dir")+"\\reports\\" + fileName; 
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\ReporterConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "3.14.0").addSystemInfo("Environment", "UAT");
		}
		return extent;
	}

}
