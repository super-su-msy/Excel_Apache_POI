package com.example.boom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

  private static String[] columns = { "First Name", "Last Name", "Email",
    "Date Of Birth", "Count" };
  private static List<Contact> contacts = new ArrayList<Contact>();
  private static DecimalFormat df = new DecimalFormat("0.00");

  public static void main(String[] args) throws IOException, 
	InvalidFormatException {
    contacts.add(new Contact("Sylvain", "Saurel",
      "sylvain.saurel@gmail.com", "17/01/1980", new BigDecimal(2).setScale(2, RoundingMode.CEILING)));
    contacts.add(new Contact("Albert", "Dupond",
      "sylvain.saurel@gmail.com", "17/08/1989", new BigDecimal(45.5).setScale(2, RoundingMode.CEILING)));
    contacts.add(new Contact("Pierre", "Dupont",
      "sylvain.saurel@gmail.com", "17/07/1956", new BigDecimal(7.00).setScale(2, RoundingMode.CEILING)));
    contacts.add(new Contact("Mariano", "Diaz", "sylvain.saurel@gmail.com",
      "17/05/1988", new BigDecimal(1.52).setScale(2, RoundingMode.CEILING)));

    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Contacts");

    Font headerFont = workbook.createFont();
    headerFont.setBold(true);
    headerFont.setFontHeightInPoints((short) 14);
    headerFont.setColor(IndexedColors.RED.getIndex());

    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    // Create a Row
    Row headerRow = sheet.createRow(0);

    for (int i = 0; i < columns.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columns[i]);
      cell.setCellStyle(headerCellStyle);
    }

    // Create Other rows and cells with contacts data
    int rowNum = 1;

    for (Contact contact : contacts) {
      Row row = sheet.createRow(rowNum++);
      row.createCell(0).setCellValue(contact.firstName);
      row.createCell(1).setCellValue(contact.lastName);
      row.createCell(2).setCellValue(contact.email);
      row.createCell(3).setCellValue(contact.dateOfBirth);
      row.createCell(4).setCellValue(df.format(contact.hellyeah.doubleValue()));
    }

    // Resize all columns to fit the content size
    for (int i = 0; i < columns.length; i++) {
      sheet.autoSizeColumn(i);
    }

    // Write the output to a file
    FileOutputStream fileOut = new FileOutputStream("contacts.xlsx");
    workbook.write(fileOut);
    fileOut.close();
  }

}