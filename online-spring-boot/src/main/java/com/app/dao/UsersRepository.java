package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
//	@Query("select u from Users u where u.user_email=:em and u.user_password=:pw")
//	Users authenticate(@Param("em") String email, @Param("pw") String password);
	
	Users findByUserEmailAndUserPassword(String email, String password);

//	@Modifying
//	@Query("UPDATE Users u SET u.user_role='CUSTSELL' where u.user_id=:id")
//	void applySeller(@Param("id") int id);
}