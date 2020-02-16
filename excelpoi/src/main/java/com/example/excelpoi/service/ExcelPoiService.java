package com.example.excelpoi.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("excelPoiService")
public class ExcelPoiService {

	public void compose() {
		/*
		 * HttpHeaders header = new HttpHeaders();
		 * header.add(HttpHeaders.CONTENT_DISPOSITION,
		 * "attachment; filename=Extract.xlsx");
		 * 
		 * Path path = Paths.get(file.getAbsolutePath()); ByteArrayResource resource =
		 * new ByteArrayResource(Files.readAllBytes(path));
		 * 
		 * return ResponseEntity.ok() .headers(header) .contentLength(file.length())
		 * .contentType(MediaType.parseMediaType("application/octet-stream"))
		 * .body(resource);
		 */
	}
	
	
	public void oldSchool() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Sylvain", "Saurel",
			      "sylvain.saurel@gmail.com", "17/01/1980", new BigDecimal(2).setScale(2, RoundingMode.CEILING)));
			    contacts.add(new Contact("Albert", "Dupond",
			      "sylvain.saurel@gmail.com", "17/08/1989", new BigDecimal(45.5).setScale(2, RoundingMode.CEILING)));
			    contacts.add(new Contact("Pierre", "Dupont",
			      "sylvain.saurel@gmail.com", "17/07/1956", new BigDecimal(7.00).setScale(2, RoundingMode.CEILING)));
			    contacts.add(new Contact("Mariano", "Diaz", "sylvain.saurel@gmail.com",
			      "17/05/1988", new BigDecimal(1.52).setScale(2, RoundingMode.CEILING)));
			    
			    
	}
}
