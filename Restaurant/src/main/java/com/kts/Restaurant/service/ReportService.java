package com.kts.Restaurant.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.util.PDFReportGeneratorUtil;

@Service
public class ReportService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SalaryService salaryService;
	
	
	public void createTotalSalaryPayoutByUserReport() throws ParseException, FileNotFoundException, DocumentException {
		List<UserDTO> employees = userService.getAll();
		String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_'Time'_hh'h'_mm'm'"));
		String fileName = "SalaryPayoutReport_" + localDateString;
		//String fileName = "SalaryPayoutReportAA";
		//String fileName = localDateString + "SalaryPayoutReport";
		 List<String> columnNames = new ArrayList<String>();
		 System.out.println(fileName);
		 String path = ".\\src\\main\\resources\\pdf\\report\\" + fileName + ".pdf";
		 System.out.println(path);
		 columnNames.add("NAME");
		 columnNames.add("TOTAL SALARY PAYOUT");
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(path));
		//PdfWriter.getInstance(document, new FileOutputStream(".\\src\\main\\resources\\pdf\\report\\" + fileName + ".pdf"));
		document.open();
		PDFReportGeneratorUtil.addDocTitle(document, fileName, localDateString);
		PdfPTable table = PDFReportGeneratorUtil.createTable(document, 2,columnNames);
		for(UserDTO employee : employees) {
			double totalSalary = salaryService.salaryReport(employee.getId(), Optional.empty(), Optional.empty()).keySet().iterator().next();
			table.addCell(new Phrase(employee.getFirstname() + " " + employee.getLastname()));
			table.addCell(new Phrase(Double.toString(totalSalary)));
		}
		document.add(table);
		document.close();
	}
	
	public List<String> getReportLinks(){
		List<String> reportLinks = new ArrayList<String>();
		File folder = new File(".\\src\\main\\resources\\pdf\\report\\");
		String basePath = "http://localhost:8080/api/report/pdf/";
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  reportLinks.add((basePath +listOfFiles[i].getName()));
		    System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		return reportLinks;
	}

}
