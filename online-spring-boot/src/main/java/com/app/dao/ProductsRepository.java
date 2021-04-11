package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

//	@Query("select p from Products p where p.users=:id")
//	List<Products> productListSeller(@Param("id")int user_id);

//	@Modifying
//	@Query("UPDATE Products p SET p.prod_qty=:qty where p.prod_id=:id")
//	Products updateProductQuantity(@Param("id") int prod_id,@Param("qty") float prod_qty);

//	@Modifying
//	@Query("UPDATE Products p SET p.prod_price=:pr where p.prod_id=:id")
//	Products updateProductPrice(@Param("id") int prod_id,@Param("pr") float prod_price);
	
}
