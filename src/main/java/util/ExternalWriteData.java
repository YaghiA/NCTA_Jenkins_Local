package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExternalWriteData {
	public String path;
	public FileOutputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public static void StorePersonalAccountNumber(String ExcelPath, String AccountNum, String UserName, String Password)
			throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		// Strore Account Num

		Cell cell1 = row.createCell(0);

		cell1.setCellValue(AccountNum);

		// Strore UserName
		Cell cell2 = row.createCell(1);

		cell2.setCellValue(UserName);

		// Strore Password

		Cell cell3 = row.createCell(2);

		cell3.setCellValue(Password);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();
	}

	public static void StoreBusinessAccountNumber(String ExcelPath, String AccountNum, String userName, String password)
			throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(1);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell1 = row.createCell(0);

		cell1.setCellValue(AccountNum);

		Cell cell2 = row.createCell(1);

		cell2.setCellValue(userName);

		Cell cell3 = row.createCell(2);

		cell3.setCellValue(password);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}

}
