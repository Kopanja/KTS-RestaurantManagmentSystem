package com.kts.Restaurant.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PDFReportGeneratorUtil {

	
	private static Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
	private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
	private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

	
	public static void addDocTitle(Document document, String reportFileName) throws DocumentException {
		String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Paragraph p1 = new Paragraph();
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph(reportFileName, COURIER));
		p1.setAlignment(Element.ALIGN_CENTER);
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph("Report generated on " + localDateString, COURIER_SMALL));

		document.add(p1);

	}
	
	
	private static void leaveEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
	
	public static PdfPTable createTable(Document document, int noOfColumns, List<String> columnNames) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		leaveEmptyLine(paragraph, 3);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(noOfColumns);
		
		for(int i=0; i<noOfColumns; i++) {
			PdfPCell cell = new PdfPCell(new Phrase(columnNames.get(i)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(BaseColor.CYAN);
			table.addCell(cell);
		}

		table.setHeaderRows(1);
		return table;
	}
}
