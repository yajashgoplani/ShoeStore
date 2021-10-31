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
import org.springframework.stereotype.Service;

import com.model.Purchase;
import com.model.Shoe;
import com.model.User;
import com.repository.PurchaseRepository;
import com.repository.UserRepository;

@Service(value = "usersService")
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	
	
	public List<User> getUserDataService(int id) {
		
		 List<User> usersList= (List)userRepository.getUserDatabyRollid(id);
	        
	       return usersList;
	    }
	
	
	
	public  User  isCorrectPassword_or_NotService(String password) {
		
		  User  usersList=  userRepository.isCorrectPassword_or_Not(password);
	        
	       return usersList;
	    }
	
 
	public void insertUserDataService(User u)
	{
		userRepository.save(u);
	}
	
	
	 public List<User> getRequiredCompleteTransactionsDataService(String firstname,String lastname)
	 {
		 List<User> orderedUserList= (List)userRepository.getRequiredCompleteTransactionsData(firstname, lastname);
	     return orderedUserList;
		 
	 }
}
