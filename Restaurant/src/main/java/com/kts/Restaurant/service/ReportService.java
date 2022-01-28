package com.kts.Restaurant.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.util.PDFReportGeneratorUtil;

@Service
public class ReportService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SalaryService salaryService;
	
	
	public void createTotalSalaryPayoutByUserReport() throws ParseException, FileNotFoundException, DocumentException {
		List<User> employees = userService.getAllPinBasedUsers();
		String fileName = "Salary Payout Report";
		 List<String> columnNames = new ArrayList<String>();
		 columnNames.add("NAME");
		 columnNames.add("TOTAL SALARY PAYOUT");
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(".\\src\\main\\resources\\pdf\\report\\" + fileName + ".pdf"));
		document.open();
		PDFReportGeneratorUtil.addDocTitle(document, fileName);
		PdfPTable table = PDFReportGeneratorUtil.createTable(document, 2,columnNames);
		for(User employee : employees) {
			double totalSalary = salaryService.salaryReport(employee.getId(), Optional.empty(), Optional.empty()).keySet().iterator().next();
			table.addCell(new Phrase(employee.getFirstname() + " " + employee.getLastname()));
			table.addCell(new Phrase(Double.toString(totalSalary)));
		}
		document.add(table);
		document.close();
	}

}
