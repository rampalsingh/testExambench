package com.msrtc.ExamBench.TestCases;



public class rough {

	public static void main(String[] args) {
//	C:\Users\MyPC\git\testExambench\com.msrtc.ExamBench\src\main\java\com\msrtc\ExamBench\Data\EB_Data.xlsx
//  C:/Users/MyPC/git/testExambench/com.msrtc.ExamBench/src/main/java/com/msrtc/ExamBench/Data/EB_Data.xlsx		
//	C:/Users/MyPC/git/testExambench/com.msrtc.ExamBench/src/main/java/com/msrtc/ExamBench/Data/EB_Data.xlsx

		

		String Excel_data = "27 - Years  0 - Months  1 - Days";
		String Page_data  = "27 - Years  0 - Months  1 - Days";
		
		String newExcelData = Excel_data.toString();
		String newPageData = Page_data.toString();
		
		System.out.println(newExcelData.equalsIgnoreCase(newPageData));
		
		
		
	}

}
