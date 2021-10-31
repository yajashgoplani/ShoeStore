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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.model.Purchase;
import com.model.Shoe;
import com.model.User;
import com.repository.PurchaseRepository;
import com.repository.ShoeRepository;
import com.repository.UserRepository;



@Service(value = "shoesService")
public class ShoesService {

	@Autowired
	private ShoeRepository  shoesDao;

	@Autowired
	private PurchaseRepository orderDao;
	@Autowired
	private UserRepository userDao;

	public List<Shoe> getMensShoeData() {

		List<Shoe> mensData= (List)shoesDao.findByCategory(1);
		System.out.println(mensData);
		return mensData;
	}

	public List<Shoe> getWomensShoeData() {

		List<Shoe> womensData= (List)shoesDao.findByCategory(2);
		System.out.println(womensData);
		return womensData;
	}

	public List<Shoe> getBoysShoeData() {

		List<Shoe> boysData= (List)shoesDao.findByCategory(3);

		return boysData;
	}
	public List<Shoe> getGirlsShoeData() {

		List<Shoe> girlsData= (List)shoesDao.findByCategory(4);

		return girlsData;
	}


	public List<Shoe> getShoeDatabyCategory(int categoryid) {

		List<Shoe> shoesDatabyCategory= (List)shoesDao.findByCategory(categoryid);

		return shoesDatabyCategory;
	}

	public Shoe  getshoesDataByIdService(int seletedShoeId)
	{

		Shoe  selectedShoesData=  shoesDao.getshoesDataById(seletedShoeId);
		System.out.println(selectedShoesData);
		return selectedShoesData;
	}

	public boolean  insertNewProductService(Shoe s)
	{
		boolean isInsertedNewProduct = false;
		try {	
			Shoe count= shoesDao.save(s);
			isInsertedNewProduct = true;
			return isInsertedNewProduct;
		} catch (Exception e) {
			System.out.println("Exception at insertNewProductService(int category,double price,String name,String imagelink) " + e.getMessage());
			return false;
		}
	}


	public  boolean  deleteProductwithIdService(int id) {
		int count=0;
		boolean isdeleted=false;
		count=  shoesDao.deleteProductwithId(id);

		if(count>0)
		{
			isdeleted=true;
		}
		return isdeleted;
	}

}
