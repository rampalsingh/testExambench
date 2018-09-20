package com.msrtc.ExamBench.Util;

import java.util.Hashtable;

public class Utils {

	String excelPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\msrtc\\ExamBench\\Data\\EB_Data.xlsx";
	String sheet = "Question";

	public static Object[][] readDataTestData(String excelPath, String sheeetName) {
		Excel_Reader xls = new Excel_Reader(excelPath, sheeetName);
		int rowCount = xls.getRowCount();
		System.out.println("row : " + (rowCount-1));
		int colCount = xls.getColCount();
		System.out.println("col : " + (colCount-1));

		Object data[][] = new Object[rowCount - 1][1];
		Hashtable<String, String> table = null;
		int r=0;
		
		for (int i = 1; i < rowCount; i++) {
			table = new Hashtable<String, String>();
			for (int j = 1; j < colCount; j++) {
				
				String title = xls.getCellData(0, j).toString().trim();
				String value = xls.getCellData(i, j).toString().trim();
				table.put(title,value);
				data[i - 1][0] = table; //xls.getCellData(i, j);
			}
			data[r][0]=table;
			r++;
		}
		return data;
	}
}

/*	
 * public static Object[][] readDataTestData(String excelPath, String sheeetName) {
		Excel_Reader xls = new Excel_Reader(excelPath, sheeetName);
		int rowCount = xls.getRowCount();
		System.out.println("row : " + (rowCount-1));
		int colCount = xls.getColCount();
		System.out.println("col : " + (colCount-1));

		Object data[][] = new Object[rowCount - 1][colCount - 1];
		for (int i = 1; i < rowCount; i++) {

		for (int j = 1; j < colCount; j++) {
				
				Object value = xls.getCellData(i, j).toString().trim();
				data[i - 1][j - 1] = value; //xls.getCellData(i, j);
			}
		}
		return data;
	}
*/
