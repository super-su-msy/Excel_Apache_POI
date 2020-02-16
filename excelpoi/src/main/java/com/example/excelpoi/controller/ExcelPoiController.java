package com.example.excelpoi.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelPoiController {

	@GetMapping(path = "generateExcel")
	public void generateExcel(HttpServletResponse response) {
		
	}

}
