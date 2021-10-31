package com.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Shoe;


@Repository
public interface ShoeRepository extends CrudRepository<Shoe, Integer> {

	@Modifying
	@Transactional
	@Query("delete from Shoe where id=:id")
	public int deleteProductwithId(@Param("id") int id);
	
	@Query("from Shoe where category=:category")
	public Iterable<Shoe> findByCategory(int category);
	
	@Query("from Shoe where id=:seletedShoeId")
	public  Shoe  getshoesDataById(int seletedShoeId);
}
