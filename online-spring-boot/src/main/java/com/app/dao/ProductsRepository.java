package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Products;
import com.app.pojos.Users;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

	//to get all products of a particular seller
	List<Products> findAllByUser(Users user);
	
//	@Query("select p from Products p where p.users=:id")
//	List<Products> productListSeller(@Param("id")int user_id);

	
}
