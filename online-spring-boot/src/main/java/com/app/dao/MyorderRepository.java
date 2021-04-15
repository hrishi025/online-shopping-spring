package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Myorder;

public interface MyorderRepository extends JpaRepository<Myorder, Integer>{

	@Query("Select m from Myorder m left outer join fetch m.orderDetails where m.user.userId= :u ")
	List<Myorder> getMyOrderWithOrderDetais(@Param("u") Integer userId);
	
}
