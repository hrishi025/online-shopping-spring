package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
//	@Query("select u from Users u where u.user_email=:em and u.user_password=:pw")
//	Users authenticate(@Param("em") String email, @Param("pw") String password);
	
	Users findByUserName(String username);
	
	Users findByUserEmailAndUserPassword(String email, String password);

	Users findByUserEmail(String username);

//	@Modifying
//	@Query("UPDATE Users u SET u.user_role='CUSTSELL' where u.user_id=:id")
//	void applySeller(@Param("id") int id);
}