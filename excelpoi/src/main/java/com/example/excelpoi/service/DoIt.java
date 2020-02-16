package com.example.excelpoi.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DoIt {

	public static void main(String[] args) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("format sheet");
		CellStyle style;
		DataFormat format = wb.createDataFormat();
		Row row;
		Cell cell;
		short rowNum = 0;
		short colNum = 0;

		List<Double> asList = new ArrayList<>(Arrays.asList(1.38, 2.56, 4.3, 5.0, 6.555, 9.));

		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Sylvain", "Saurel", "sylvain.saurel@gmail.com", "17/01/1980",
				new BigDecimal(2).setScale(2, RoundingMode.CEILING)));
		contacts.add(new Contact("Albert", "Dupond", "sylvain.saurel@gmail.com", "17/08/1989",
				new BigDecimal(45.5).setScale(2, RoundingMode.CEILING)));
		contacts.add(new Contact("Pierre", "Dupont", "sylvain.saurel@gmail.com", "17/07/1956",
				new BigDecimal(7.00).setScale(2, RoundingMode.CEILING)));
		contacts.add(new Contact("Mariano", "Diaz", "sylvain.saurel@gmail.com", "17/05/1988",
				new BigDecimal(-1.52).setScale(2, RoundingMode.CEILING)));

		/*
		 * for (Double i : asList) { System.out.println(i); row =
		 * sheet.createRow(rowNum++); cell = row.createCell(colNum);
		 * cell.setCellValue(i); style = wb.createCellStyle();
		 * style.setDataFormat(format.getFormat("0.000")); cell.setCellStyle(style);
		 * 
		 * }
		 */

		for (Contact contact : contacts) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(colNum);
			cell.setCellValue(contact.hellyeah.doubleValue());
			style = wb.createCellStyle();
			style.setDataFormat(format.getFormat("0.000"));
			cell.setCellStyle(style);

		}

		/*
		 * row = sheet.createRow(rowNum++); cell = row.createCell(colNum);
		 * cell.setCellValue(1); style = wb.createCellStyle();
		 * style.setDataFormat(format.getFormat("0.000")); cell.setCellStyle(style);
		 * 
		 * row = sheet.createRow(rowNum++); cell = row.createCell(colNum);
		 * cell.setCellValue(11111.25); style = wb.createCellStyle();
		 * style.setDataFormat(format.getFormat("#,##0.0000"));
		 * cell.setCellStyle(style);
		 */

		/*
		 * FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
		 * wb.write(fileOut); fileOut.close();
		 */

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			wb.write(bos);
		} finally {
			bos.close();
		}
		byte[] bytes = bos.toByteArray();
		String encodeToString = Base64.getEncoder().encodeToString(bytes);
		System.out.println(encodeToString);
	}

}
