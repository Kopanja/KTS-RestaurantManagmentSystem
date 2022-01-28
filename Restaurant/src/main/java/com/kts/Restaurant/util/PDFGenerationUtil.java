package com.kts.Restaurant.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;

import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.kts.Restaurant.model.Item;

public class PDFGenerationUtil {

	
	private static Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
	private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
	private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

	private static Font HELVETICA_CATEGORY_NAME = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	private static Font HELVETICA_TITLE = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
	private static Font HELVETICA_ITEM_NAME_PRICE = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	private static Font HELVETICA_ITEM_DESCRIPTION = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
	private static Font HELVETICA_ITEM_PREPTIME_ALERGENS = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);

	private static String itemImgsBasePath = "C:\\Users\\kopan\\Documents\\GitHub\\KTS-RestaurantManagmentSystem\\Restaurant\\src\\main\\resources\\images\\items";



	public static void leaveEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public static void drawLine(Document document) {
		Chunk linebreak = new Chunk("___________________________________________________________________________");
		try {
			document.add(linebreak);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public static void emptySpace(Document document) {
		Chunk linebreak = new Chunk(new DottedLineSeparator());
		try {
			document.add(linebreak);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	
	
	public static void addFoodTitle(Document document) {
		String titleStr = "FOOD MENU";
		Paragraph title = new Paragraph();
		//BaseFont base = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.WINANSI, false);
		//Font font = new Font(base, 11f, Font.BOLD);
		title.setFont(HELVETICA_TITLE);
		title.setAlignment(Element.ALIGN_LEFT);
		title.add(titleStr);
		try {
			document.add(title);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addDrinkTitle(Document document) {
		String titleStr = "Drink MENU";
		Paragraph title = new Paragraph();
		//BaseFont base = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.WINANSI, false);
		//Font font = new Font(base, 11f, Font.BOLD);
		title.setFont(HELVETICA_TITLE);
		title.setAlignment(Element.ALIGN_LEFT);
		title.add(titleStr);
		try {
			document.add(title);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addItem(Document document, Item item) {
		PdfPTable table = new PdfPTable(new float[] { 25, 75 });
		table.getDefaultCell().setBorder(0);
		table.setWidthPercentage(100);

		Image img = null;
		try {

			img = Image.getInstance(".\\src\\main\\resources\\images\\items\\ClassicBurger.jpg");
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		table.addCell(img);

		PdfPTable itemDetails = new PdfPTable(1);
		itemDetails.getDefaultCell().setBorder(0);

		addItemNameAndPrice(item.getName(), Integer.toString(item.getPrice()), itemDetails);
		addDescription(item.getDescription(), itemDetails);
		//addPrepTime(item.getPrepTime(), itemDetails);
		addPrepTime("45 min", itemDetails);
		//addAlergens(item.getAlergens(), itemDetails);
		addAlergens("susam, pavlaka kecap sir luk", itemDetails);
		table.addCell(itemDetails);

		try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}


	public static void addCategory(String category, Document document) {
		
		Paragraph name = new Paragraph();
		leaveEmptyLine(name, 2);
		name.setFont(HELVETICA_CATEGORY_NAME);
		name.setAlignment(Element.ALIGN_LEFT);
		name.add(category);
		try {
			document.add(name);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		drawLine(document);
	}

	private static void addDescription(String description, PdfPTable itemDetails) {
		Paragraph name = new Paragraph();
		name.setFont(HELVETICA_ITEM_DESCRIPTION);
		name.setAlignment(Element.ALIGN_LEFT);
		name.add(description);
		itemDetails.addCell(name);

	}

	private static void addPrepTime(String prepTime, PdfPTable itemDetails) {
		Paragraph name = new Paragraph();
		name.setFont(HELVETICA_ITEM_PREPTIME_ALERGENS);
		name.setAlignment(Element.ALIGN_LEFT);
		name.add("Time: " + prepTime);
		itemDetails.addCell(name);

	}

	private static void addAlergens(String alergens, PdfPTable itemDetails) {
		Paragraph name = new Paragraph();
		name.setFont(HELVETICA_ITEM_PREPTIME_ALERGENS);
		name.setAlignment(Element.ALIGN_LEFT);
		name.add("Alergens: " + alergens);
		itemDetails.addCell(name);

	}

	private static void addItemNameAndPrice(String itemName, String itemPrice, PdfPTable table) {
		PdfPTable nameAndPriceTable = new PdfPTable(new float[] { 90, 10 });
		nameAndPriceTable.getDefaultCell().setBorder(0);
		Paragraph name = new Paragraph();
		name.setFont(HELVETICA_ITEM_NAME_PRICE);
		name.setAlignment(Element.ALIGN_LEFT);
		name.add(itemName);

		Paragraph price = new Paragraph();
		price.setAlignment(Element.ALIGN_RIGHT);
		price.setFont(HELVETICA_ITEM_NAME_PRICE);
		price.add(itemPrice);

		nameAndPriceTable.addCell(name);
		nameAndPriceTable.addCell(price);
		table.addCell(nameAndPriceTable);
	}

	public void addFooter(Document document, String fileName) throws DocumentException {
		Paragraph p2 = new Paragraph();
		leaveEmptyLine(p2, 3);
		p2.setAlignment(Element.ALIGN_MIDDLE);
		p2.add(new Paragraph("------------------------End Of " + fileName + "------------------------",
				COURIER_SMALL_FOOTER));

		document.add(p2);
	}


}
