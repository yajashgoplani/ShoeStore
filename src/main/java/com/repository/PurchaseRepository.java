package com.repository;

/////////////////////////////////////////////////////////////////////////////
//CAL-TECH FULL STACK DEVELOPMENT COURSE -- SPOPRTY SHOES ASSESSMENT ---
//
//DEVELOPER/STUDENT:   Kevin Casey
//ORIGINATION DATE:  20 JULY
//LAST UPDATED  ON:  20 JULY
/////////////////////////////////////////////////////////////////////////////

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Purchase;

@Repository
public interface PurchaseRepository  extends CrudRepository<Purchase, Integer>{
	 @Query("from Purchase where category=:categoryId and date=:date")
	 public List<Purchase> getRequiredCompleteTransactionsData(int categoryId,Date date);	 
}
