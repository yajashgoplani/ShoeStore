package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User where id=:id")
    public  User  getUserDatabyRollid(int id);
	 
	
	 @Query("from User where password=:password")
	    public  User  isCorrectPassword_or_Not(String password);
  	 
	 @Query("from User where firstname=:username and lastname=:lastname")
     public  List<User> getRequiredCompleteTransactionsData(String username, String lastname );
	 
	 
}
