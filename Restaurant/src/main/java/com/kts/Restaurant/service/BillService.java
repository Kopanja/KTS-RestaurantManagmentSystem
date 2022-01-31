package com.kts.Restaurant.service;

import com.kts.Restaurant.dto.BillCreateDTO;
import com.kts.Restaurant.dto.BillWaiterStatisticsDTO;
import com.kts.Restaurant.dto.ItemReportDTO;
import com.kts.Restaurant.dto.WaiterReportDTO;
import com.kts.Restaurant.model.Bill;
import com.kts.Restaurant.model.BilledItem;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.OrderedItem;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.BillRepository;
import com.kts.Restaurant.util.mapper.BillCreateMapper;
import com.kts.Restaurant.util.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BillService {

    @Autowired
    BillRepository billRepo;

    @Autowired
    BilledItemService billedItemService;

	public Bill createBillFromOrder(Order order){
		ArrayList<BilledItem> items = new ArrayList<BilledItem>();
		double price = 0;
		double cost = 0;
		Date date = new Date();
		for(OrderedItem oi : order.getItems()) {
			Item item = oi.getItem();
			BilledItem billedItem = billedItemService.save(new BilledItem(null,item));
			items.add(billedItem);
			price += item.getPrice();
			cost += item.getCost();
		}
		Bill bill = new Bill(null, price, cost,date, items, order.getUser());
		bill = billRepo.save(bill);
		return bill;
	}

    public List<BillWaiterStatisticsDTO> getAllBills() {
        List<BillWaiterStatisticsDTO> dtos = new ArrayList<>();
        List<Bill> bills = billRepo.findAll();

        if (bills.size() == 0) {
            return null;
        }
        BillMapper billMapper = new BillMapper();
        for (Bill bill : bills) {
            dtos.add(billMapper.toDto(bill));
        }

        return dtos;
    }

    public BillCreateDTO save(BillCreateDTO billDTO) {
        BillCreateMapper billCreateMapper = new BillCreateMapper();
        Bill bill = billCreateMapper.toEntity(billDTO);
        bill = billRepo.save(bill);

        BillCreateDTO billCreated = billCreateMapper.toDto(bill);

        return billCreated;
    }

    public List<ItemReportDTO> billReport(Optional<String> from, Optional<String> to) throws ParseException {
        List<Bill> bills = billRepo.findAll();
        Map<Long, ItemReportDTO> itemReportDTOMap = new HashMap<>();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = from.isPresent() ? sf.parse(from.get()) : new Date(0);
        Date toDate = to.isPresent() ? sf.parse(to.get()) : new Date(System.currentTimeMillis());

        for (Bill b : bills) {
            if (b.getDate().after(fromDate) &&  b.getDate().before(toDate)) {
                for (BilledItem bi : b.getItems()) {
                    ItemReportDTO temp = itemReportDTOMap.get(bi.getItem().getId());
					ItemReportDTO itemReportDTO = new ItemReportDTO();
                    if (temp == null) {
                        itemReportDTO.setName(bi.getItem().getName());
                        itemReportDTO.setAmount(1);
                        itemReportDTO.setPrice((double) bi.getItem().getPrice());
                        itemReportDTO.setCost((double) bi.getItem().getCost());
                        itemReportDTO.setProfit(itemReportDTO.getPrice() - itemReportDTO.getCost());
                    } else {
                        itemReportDTO.setAmount(temp.getAmount() + 1);
                        itemReportDTO.setName(temp.getName());
                        itemReportDTO.setPrice(temp.getPrice() + bi.getItem().getPrice());
                        itemReportDTO.setCost(temp.getCost() + bi.getItem().getCost());
                        itemReportDTO.setProfit(itemReportDTO.getPrice() - itemReportDTO.getCost());
                    }

					itemReportDTOMap.put(bi.getItem().getId(), itemReportDTO);

                }
            }
        }

		List<ItemReportDTO> retVal = new ArrayList<ItemReportDTO>(itemReportDTOMap.values());
		return retVal;

    }


    public List<WaiterReportDTO> billReportWaiter(Optional<String> from, Optional<String > to) throws ParseException {

        Map<User, List<Item>> mapa = new HashMap<>();
        List<Bill> allBills = billRepo.findAll();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = from.isPresent() ? sf.parse(from.get()) : new Date(0);
        Date toDate = to.isPresent() ? sf.parse(to.get()) : new Date(System.currentTimeMillis());

        // punim mapu: Id usera, Lista svih Itema  za datog konobara
        for (Bill bill : allBills) {
            if (bill.getDate().after(fromDate) &&  bill.getDate().before(toDate)) {
                List<Item> itemsPerBill = new ArrayList<>();
                for (BilledItem billedItem : bill.getItems()) {
                    itemsPerBill.add(billedItem.getItem());
                }
                mapa.put(bill.getWaiter(), itemsPerBill);
            }
        }

        List<WaiterReportDTO> retValue = new ArrayList<>();
        for (User u : mapa.keySet()) {
            WaiterReportDTO newDto = new WaiterReportDTO();
            newDto.setFirstname(u.getFirstname());
            newDto.setLastname(u.getLastname());
            Map<Double, Double> profitAndTotalBill = this.totalProfitPerWaiter(mapa.get(u));
            newDto.setProfit(profitAndTotalBill.keySet().stream().findFirst().get());
            newDto.setSumOfBills(profitAndTotalBill.get(newDto.getProfit()));
            List<Item> items = mapa.get(u);

            Map<Long, ItemReportDTO> itemReportDTOMap = new HashMap<>();

            for (Item i :items) {
                ItemReportDTO temp = itemReportDTOMap.get(i.getId());
                ItemReportDTO itemReportDTO = new ItemReportDTO();
                if (temp == null) {
                    itemReportDTO.setName(i.getName());
                    itemReportDTO.setAmount(1);
                    itemReportDTO.setPrice((double) i.getPrice());
                    itemReportDTO.setCost((double) i.getCost());
                    itemReportDTO.setProfit(itemReportDTO.getPrice() - itemReportDTO.getCost());
                } else {
                    itemReportDTO.setAmount(temp.getAmount() + 1);
                    itemReportDTO.setName(temp.getName());
                    itemReportDTO.setPrice(temp.getPrice() + i.getPrice());
                    itemReportDTO.setCost(temp.getCost() + i.getCost());
                    itemReportDTO.setProfit(itemReportDTO.getPrice() - itemReportDTO.getCost());
                }

                itemReportDTOMap.put(i.getId(), itemReportDTO);
            }
            List<ItemReportDTO> itemReportDTOS = new ArrayList<ItemReportDTO>(itemReportDTOMap.values());
            newDto.setItemReportDTOMap(itemReportDTOS);
            retValue.add(newDto);
        }
        return retValue;

    }

    private Map<Double, Double> totalProfitPerWaiter(List<Item> items) {
        double profit = 0.0;
        double totalBills = 0.0;
        for (Item i : items) {
            profit += i.getPrice() - i.getCost();
            totalBills += i.getPrice();
        }
        Map<Double, Double> profitTotalBils = new HashMap<>();
        profitTotalBils.put(profit,totalBills);
        return profitTotalBils;


    }


//	public List<ItemReportDTO> billReportWaiter(Optional<String> from, Optional<String> to) throws ParseException {
//		List<Bill> bills = billRepo.findAll();
//		Map<Long, Map<Long,ItemReportDTO>> itemReportDTOMapWaiter = new HashMap<>();
//        Map<Long,ItemReportDTO> waiterTemps = new HashMap<>();
//		Map<Long, WaiterReportDTO> waiterReportDTOMap = new HashMap<>();
//
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		Date fromDate = from.isPresent() ? sf.parse(from.get()) : new Date(0);
//		Date toDate = to.isPresent() ? sf.parse(to.get()) : new Date(System.currentTimeMillis());
//
//		for (Bill b : bills) {
//			if (b.getDate().after(fromDate) &&  b.getDate().before(toDate)) {
//				//WaiterReportDTO waiterTemp = waiterReportDTOMap.get(b.getWaiter().getId());
//                waiterTemps = itemReportDTOMapWaiter.get(b.getWaiter().getId());
//				for (BilledItem bi : b.getItems()) {
//					itemReportDTOMapWaiter.put
//
//				}
//			}
//		}
//		List<ItemReportDTO> retVal = new ArrayList<ItemReportDTO>(itemReportDTOMap.values());
//		return retVal;
//
//	}
}
