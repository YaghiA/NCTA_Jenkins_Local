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

public class InternalWrite_Data {
	public String path;
	public FileOutputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public static void StorePersonalAccountNumber(String ExcelPath, String AccountNum, String plateNumber) throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell = row.createCell(0);

		cell.setCellValue(AccountNum);
		
		Cell cell2 = row.createCell(1);

		cell2.setCellValue(plateNumber);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}

	public static void StoreBusinessAccountNumber(String ExcelPath, String AccountNum) throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell = row.createCell(1);

		cell.setCellValue(AccountNum);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}

	public static void StoreFirstResponderAccountNumber(String ExcelPath, String AccountNum) throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(1);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell = row.createCell(2);

		cell.setCellValue(AccountNum);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}

	public static void StoreGovernmentAccountNumber(String ExcelPath, String AccountNum) throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell = row.createCell(3);

		cell.setCellValue(AccountNum);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}

	public static void StoreHOVOnlyAccountNumber(String ExcelPath, String AccountNum) throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell = row.createCell(4);

		cell.setCellValue(AccountNum);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}

	public static void StoreRegisteredLicPlateAccountNumber(String ExcelPath, String AccountNum) throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell = row.createCell(5);

		cell.setCellValue(AccountNum);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}

	public static void StoreTransitAccountNumber(String ExcelPath, String AccountNum) throws IOException {

		FileInputStream fis = new FileInputStream(ExcelPath);

		Workbook workbook = new XSSFWorkbook(fis);

		// int index = workbook.getSheetIndex(SheetName);

		Sheet sheet = workbook.getSheetAt(0);

		int rowNum = sheet.getLastRowNum() + 1;

		Row row = sheet.createRow(rowNum);

		// Row row = sheet.getRow(2);

		Cell cell = row.createCell(6);

		cell.setCellValue(AccountNum);

		FileOutputStream fos = new FileOutputStream(ExcelPath);

		workbook.write(fos);

		fos.close();

	}
}