package com.service;

/////////////////////////////////////////////////////////////////////////////
//CAL-TECH FULL STACK DEVELOPMENT COURSE -- SPOPRTY SHOES ASSESSMENT ---
//
//DEVELOPER/STUDENT:   Kevin Casey
//ORIGINATION DATE:  20 JULY
//LAST UPDATED  ON:  20 JULY
/////////////////////////////////////////////////////////////////////////////

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Purchase;
import com.repository.*;

@Service(value = "purchaseService")
public class PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public void insertBookingInfoService(Purchase p)
	{
		purchaseRepository.save(p);
		
	}



	public List<Purchase> getCompleteTransactionsDataService() {

		List<Purchase> completeOrdersData= (List)purchaseRepository.findAll();
		return completeOrdersData;
	}

	public List<Purchase> getRequiredCompleteTransactionsDataService(int categoryId,Date date)
	{
		List<Purchase> orderedShoeList= (List)purchaseRepository.getRequiredCompleteTransactionsData(categoryId,date);
		return orderedShoeList;
	}

}
