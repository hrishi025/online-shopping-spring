package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.dao.UsersRepository;
import com.app.dto.EditProfileDTO;
import com.app.pojos.Role;
import com.app.pojos.Users;

@Service
@Transactional
public class UsersServiceImpl implements IUsersService {

	@Autowired
	UsersRepository repo;

	@Override
	public Users userSignin(String u) {
//		return repo.authenticate(u.getUser_email(), u.getUser_password());
		return repo.findByUserEmail(u);
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
		
		if (u.getUser_name() != "") {
			old.setUserName(u.getUser_name());
		}
		if (u.getUser_password() != "") {
			old.setUserPassword(u.getUser_password());
		}
		if (u.getUser_phone() != "") {
			old.setUserPhone(u.getUser_phone());
		}

		// BeanUtils.copyProperties(u, old);
		return repo.save(old);
	}

	@Override
	public String applySeller(int id) {
		Users u = repo.findById(id).get();
		u.setUserRole(Role.CUSTSELL);
		repo.save(u);
		return "apply seller request success";
	}
	
	public Users getUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return repo.findByUserName(username);
	}
	
}
