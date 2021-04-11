package com.app.service;

import com.app.dto.EditProfileDTO;
import com.app.dto.SigninDTO;
import com.app.pojos.Users;

public interface IUsersService {
	Users userSignin(SigninDTO u);
	Users userSignup(Users u);
	Users getProfile(int id);
	Users userUpdate(int id, EditProfileDTO u);
//	String applySeller(int id);
}
