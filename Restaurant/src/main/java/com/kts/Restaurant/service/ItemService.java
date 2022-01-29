package com.kts.Restaurant.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.kts.Restaurant.exceptions.*;
import com.kts.Restaurant.model.*;
import com.kts.Restaurant.repository.BillRepository;
import com.kts.Restaurant.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.kts.Restaurant.dto.ItemDTO;
import com.kts.Restaurant.repository.ItemRepository;
import com.kts.Restaurant.util.PDFGenerationUtil;
import com.kts.Restaurant.util.mapper.ItemMapper;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepo;

	@Autowired
	BillRepository billRepo;

	@Autowired
	ItemCategoryRepository itemCatRepository;

	public ItemDTO create(ItemDTO itemDTO) {
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()) == null) {
			throw new ItemCategoryNameDoesntExists();
		}
		if (itemRepo.findByName(itemDTO.getName()) != null) {
			throw new ItemWithNameAlreadyExistsException();
		}
		Item newItem = null;
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType().equals("Food")) {
			newItem = new FoodItem();
		} else if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType()
				.equals("Drink")) {
			newItem = new DrinkItem();
		}

		newItem.setName(itemDTO.getName());
		newItem.setActive(true);
		newItem.setCategory(itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()));
		newItem.setCost(itemDTO.getCost());
		newItem.setPrice(itemDTO.getPrice());
		newItem.setDescription(itemDTO.getDescription());
		itemRepo.save(newItem);
		ItemMapper itemMapper = new ItemMapper();
		return itemMapper.toDto(newItem);
	}

	public ItemDTO update(String oldName, ItemDTO itemDTO) {
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()) == null) {
			throw new ItemCategoryNameDoesntExists();
		}
		if (itemRepo.findByName(oldName) == null) {
			throw new ItemWithNameDoesntExists();
		}
		// obrisi stari item postavljajuci ga na false
		Item itemToDelete = itemRepo.findByName(oldName);
		itemToDelete.setActive(false);
		itemRepo.save(itemToDelete);

		// pravi nov
		Item newUpdatedItem = null;
		if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType().equals("Food")) {
			newUpdatedItem = new FoodItem();
		} else if (itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()).getType()
				.equals("Dring")) {
			newUpdatedItem = new DrinkItem();
		}

		newUpdatedItem.setActive(true);
		newUpdatedItem.setName(itemDTO.getName());
		newUpdatedItem.setPrice(itemDTO.getPrice());
		newUpdatedItem.setCost(itemDTO.getCost());
		newUpdatedItem.setCategory(itemCatRepository.findItemCategoryByCategoryName(itemDTO.getItemCategoryName()));
		newUpdatedItem.setDescription(itemDTO.getDescription());
		itemRepo.save(newUpdatedItem);
		ItemMapper itemMapper = new ItemMapper();
		return itemMapper.toDto(newUpdatedItem);

	}

	public ItemDTO toDto(Item item) {
		ItemMapper mapper = new ItemMapper();
		return mapper.toDto(item);
	}

	public Item toEntity(ItemDTO dto) {
		return itemRepo.findByName(dto.getName());
	}

	public List<ItemDTO> getAll() {
		List<ItemDTO> dtos = new ArrayList<>();
		ItemMapper mapper = new ItemMapper();
		for (Item i : itemRepo.findAll()) {
			dtos.add(mapper.toDto(i));
		}
		return dtos;
	}

	public List<ItemDTO> getItemsByCategoryName(String categoryName) {
		List<ItemDTO> dtos = new ArrayList<>();
		ItemMapper mapper = new ItemMapper();
		for (Item i : itemRepo.findByCategoryName(categoryName)) {
			dtos.add(mapper.toDto(i));
		}
		return dtos;
	}

	public void createFoodMenuPdf() throws FileNotFoundException, DocumentException {
		Rectangle layout = new Rectangle(PageSize.A4);
	    layout.setBackgroundColor(new BaseColor(0xFF, 0xFF, 0xDE));
		Document document = new Document(layout);
		List<ItemCategory> categories = itemCatRepository.getFoodCategories();
		List<Item> items = null;
		PdfWriter.getInstance(document, new FileOutputStream(".\\src\\main\\resources\\pdf\\food-menu.pdf"));
		document.open();
		PDFGenerationUtil.addFoodTitle(document);
		
		for(ItemCategory cat : categories) {
			PDFGenerationUtil.addCategory(cat.getCategoryName(), document);
			items = itemRepo.findByCategoryName(cat.getCategoryName());
			for(Item i : items) {
				PDFGenerationUtil.addItem(document, i);
				PDFGenerationUtil.emptySpace(document);
			}
			document.newPage();
			
		}
	
		document.close();

	}
	
	public void createDrinkMenuPdf() throws FileNotFoundException, DocumentException {
		Rectangle layout = new Rectangle(PageSize.A4);
	    layout.setBackgroundColor(new BaseColor(0xFF, 0xFF, 0xDE));
		Document document = new Document(layout);
		List<ItemCategory> categories = itemCatRepository.getDrinkCategories();
		List<Item> items = null;
		PdfWriter.getInstance(document, new FileOutputStream(".\\src\\main\\resources\\pdf\\drink-menu.pdf"));
		document.open();
		PDFGenerationUtil.addDrinkTitle(document);
		
		for(ItemCategory cat : categories) {
			PDFGenerationUtil.addCategory(cat.getCategoryName(), document);
			items = itemRepo.findByCategoryName(cat.getCategoryName());
			for(Item i : items) {
				PDFGenerationUtil.addItem(document, i);
				PDFGenerationUtil.emptySpace(document);
			}
			document.newPage();
		}
	
		document.close();

	}
	
	public List<String> getMenuLinks(){
		List<String> reportLinks = new ArrayList<String>();
		File folder = new File(".\\src\\main\\resources\\pdf\\menu\\");
		File[] listOfFiles = folder.listFiles();
		String basePath = "http://localhost:8080/api/item/pdf/";
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

	public Item getMostSoldItem() {
		List<Item> items = itemRepo.findAll();
		List<Bill> bills = billRepo.findAll();

		// TODO: prolazis kroz sve billove i bill iteme od tih billova i napravis hash
		// mapu sa <Item, int> i svaki put kad naidjes na taj billITem(item) ti povecas
		// counter za 1
		// na kragu vratis sve iteme i broj prodatih tih itema
		// ako hoces sabiraj i profite i stavljaj isto

		return null;
	}
}
