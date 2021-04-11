package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UsersRepository;
import com.app.dto.EditProfileDTO;
import com.app.dto.SigninDTO;
import com.app.pojos.Role;
import com.app.pojos.Users;

@Service
@Transactional
public class UsersServiceImpl implements IUsersService {
	
	@Autowired
	UsersRepository repo;

	@Override
	public Users userSignin(SigninDTO u) {
//		return repo.authenticate(u.getUser_email(), u.getUser_password());
		return repo.findByUserEmailAndUserPassword(u.getUser_email(), u.getUser_password());
	}

	@Override
	public Users userSignup(Users u) {
		u.setUserRole(Role.CUSTOMER);
		u.setUserStatus(0);
		return repo.save(u);
	}

	@Override
	public Users getProfile(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Users userUpdate(int id, EditProfileDTO u) {
		Users old = repo.findById(id).get(); 
		BeanUtils.copyProperties(u, old);
		return repo.save(old);
	}

//	@Override
//	public String applySeller(int id) {
//		repo.applySeller(id);
//		return "apply seller request success";
//	}

}
